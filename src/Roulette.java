import java.util.*;

class Roulette implements CasinoGame {
    // Obiekt klasy Random używany do generowania losowych wyników ruletki
    private Random random = new Random();

    /**
     * Metoda implementująca grę w ruletkę.
     *
     * @param user Obiekt klasy User reprezentujący aktualnego użytkownika grającego w ruletkę.
     */
    @Override
    public void play(User user) {
        Scanner scanner = new Scanner(System.in); // Tworzenie obiektu Scanner do odczytu danych od użytkownika

        // Użytkownik wybiera liczbę, na którą chce postawić
        System.out.println("Wybierz liczbę od 0 do 36: ");
        int chosenNumber = scanner.nextInt();

        // Użytkownik wprowadza kwotę zakładu
        System.out.println("Postaw kwotę: ");
        double bet = scanner.nextDouble();

        // Sprawdzenie, czy użytkownik ma wystarczające środki na zakład
        if (user.withdraw(bet)) {
            // Generowanie losowego wyniku ruletki (liczba od 0 do 36)
            int result = random.nextInt(37);
            System.out.println("Wynik ruletki: " + result);

            // Sprawdzenie, czy użytkownik trafił w wylosowaną liczbę
            if (result == chosenNumber) {
                // Wygrana - użytkownik otrzymuje 35-krotność postawionej kwoty
                double winnings = bet * 35;
                user.deposit(winnings);
                System.out.println("Wygrałeś " + winnings + "!");
            } else {
                // Przegrana - użytkownik traci postawioną kwotę
                System.out.println("Przegrałeś. Powodzenia następnym razem!");
            }
        } else {
            // Brak wystarczających środków na koncie użytkownika
            System.out.println("Niewystarczające środki!");
        }
    }
}