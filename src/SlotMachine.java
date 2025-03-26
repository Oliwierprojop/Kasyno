import java.util.*;

class SlotMachine implements CasinoGame { // Definicja klasy SlotMachine, która implementuje interfejs CasinoGame.
    private Random random = new Random(); // Tworzy instancję klasy Random do generowania liczb losowych.

    @Override     // Implementacja metody play z interfejsu CasinoGame. Przyjmuje obiekt User jako argument.
    public void play(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Postaw kwotę: ");
        double bet = scanner.nextDouble();

        if (user.withdraw(bet)) {  // Sprawdza, czy użytkownik może wypłacić kwotę zakładu.
            // Generuje trzy losowe liczby w zakresie 0-9, reprezentujące bębny maszyny.
            int[] reels = {random.nextInt(10), random.nextInt(10), random.nextInt(10)};
            System.out.println("Wynik: " + Arrays.toString(reels));
            // Sprawdza, czy wszystkie trzy liczby są identyczne (Jackpot).
            if (reels[0] == reels[1] && reels[1] == reels[2]) {
                double winnings = bet * 10;
                user.deposit(winnings);
                System.out.println("Jackpot! Wygrałeś " + winnings + "!"); // Wyświetla komunikat o wygranej.
            } else {
                System.out.println("Przegrałeś. Spróbuj ponownie!"); // Informuje użytkownika o przegranej.
            }
        } else {
            System.out.println("Niewystarczające środki!"); // Wyświetla komunikat, gdy użytkownik nie ma wystarczających środków.
        }
    }
}