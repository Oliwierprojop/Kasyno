import java.util.*;
class DiceGame implements CasinoGame { // Definicja klasy DiceGame, która implementuje interfejs CasinoGame.
    private Random random = new Random(); // Tworzy instancję klasy Random do generowania liczb losowych.

    @Override // Implementacja metody play z interfejsu CasinoGame. Przyjmuje obiekt User jako argument.
    public void play(User user) {
        Scanner scanner = new Scanner(System.in); // Tworzy obiekt Scanner do odczytu danych wejściowych od użytkownika.
        System.out.println("Postaw kwotę: "); // Wyświetla komunikat, aby użytkownik wprowadził kwotę zakładu.
        double bet = scanner.nextDouble(); // Pobiera kwotę zakładu od użytkownika.

        if (user.withdraw(bet)) {   // Sprawdza, czy użytkownik ma wystarczające środki na zakład.
            int dice1 = random.nextInt(6) + 1; // Generuje losową wartość (1-6) dla pierwszej kostki.
            int dice2 = random.nextInt(6) + 1; // Generuje losową wartość (1-6) dla drugiej kostki.
            int sum = dice1 + dice2; // Oblicza sumę oczek wyrzuconych na obu kostkach.
            System.out.println("Wynik rzutu: " + dice1 + " i " + dice2 + " (suma: " + sum + ")");  // Wyświetla wynik rzutu kostkami oraz ich sumę.

            if (sum == 7 || sum == 11) {    // Sprawdza, czy suma oczek to 7 lub 11 (warunek wygranej).
                double winnings = bet * 5; // Oblicza wygraną jako 5-krotność zakładu.
                user.deposit(winnings); // Dodaje wygraną do salda użytkownika.
                System.out.println("Wygrałeś " + winnings + "!"); // Wyświetla komunikat o wygranej.
            } else {
                System.out.println("Przegrałeś. Powodzenia następnym razem!"); // Informuje użytkownika o przegranej.
            }
        } else {
            System.out.println("Niewystarczające środki!"); // Wyświetla komunikat, gdy użytkownik nie ma wystarczających środków.
        }
    }
}