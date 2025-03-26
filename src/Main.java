import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Obiekt do odczytu danych od użytkownika
        UserManager userManager = new UserManager(); // Zarządzanie rejestracją i logowaniem użytkowników

        System.out.println("Witaj w kasynie!");

        // Główna pętla aplikacji
        while (true) {
            System.out.println("1. Zarejestruj się\n2. Zaloguj się\n3. Wyjdź"); // Menu główne
            int choice = scanner.nextInt(); // Pobranie wyboru użytkownika

            // Opcja rejestracji
            if (choice == 1) {
                System.out.println("Podaj nazwę użytkownika: ");
                String username = scanner.next(); // Pobranie nazwy użytkownika
                System.out.println("Podaj hasło: ");
                String password = scanner.next(); // Pobranie hasła
                System.out.println("Podaj początkowy depozyt: ");
                double deposit = scanner.nextDouble(); // Pobranie początkowego depozytu

                // Próba rejestracji użytkownika
                if (userManager.register(username, password, deposit)) {
                    System.out.println("Rejestracja zakończona sukcesem!");
                } else {
                    System.out.println("Użytkownik już istnieje!"); // Komunikat w przypadku duplikatu nazwy
                }

                // Opcja logowania
            } else if (choice == 2) {
                System.out.println("Podaj nazwę użytkownika: ");
                String username = scanner.next(); // Pobranie nazwy użytkownika
                System.out.println("Podaj hasło: ");
                String password = scanner.next(); // Pobranie hasła

                User user = userManager.login(username, password); // Próba logowania użytkownika
                if (user != null) { // Sprawdzenie, czy logowanie się powiodło
                    System.out.println("Zalogowano jako " + user.getUsername());

                    // Pętla menu dla zalogowanego użytkownika
                    while (true) {
                        System.out.println("1. Ruletka\n2. Jednoręki bandyta\n3. Gra w kości\n4. Wyloguj się");
                        int gameChoice = scanner.nextInt(); // Pobranie wyboru gry

                        // Gra w ruletkę
                        if (gameChoice == 1) {
                            new Roulette().play(user); // Rozpoczęcie gry w ruletkę
                            // Gra w jednorękiego bandytę
                        } else if (gameChoice == 2) {
                            new SlotMachine().play(user); // Rozpoczęcie gry w jednorękiego bandytę
                            // Gra w kości
                        } else if (gameChoice == 3) {
                            new DiceGame().play(user); // Rozpoczęcie gry w kości
                            // Wylogowanie
                        } else if (gameChoice == 4) {
                            break; // Wyjście z pętli gier i powrót do menu głównego
                        } else {
                            System.out.println("Nieznana opcja."); // Obsługa błędnego wyboru
                        }
                    }

                } else {
                    System.out.println("Niepoprawne dane logowania."); // Komunikat o błędnym logowaniu
                }

                // Opcja wyjścia z aplikacji
            } else if (choice == 3) {
                System.out.println("Do zobaczenia!");
                break; // Wyjście z pętli głównej i zakończenie programu
            } else {
                System.out.println("Nieznana opcja."); // Obsługa błędnego wyboru w menu głównym
            }
        }


        scanner.close(); // Zamknięcie obiektu Scanner po zakończeniu programu
    }
}