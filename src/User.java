import java.util.*;

class User {
    // Prywatne pola klasy przechowujące dane użytkownika
    private String username; // Nazwa użytkownika
    private String password; // Hasło użytkownika
    private double balance;  // Saldo użytkownika

    // Konstruktor klasy User - inicjalizuje nazwę użytkownika, hasło i początkowe saldo
    public User(String username, String password, double initialBalance) {
        this.username = username; // Ustawienie nazwy użytkownika
        this.password = password; // Ustawienie hasła
        this.balance = initialBalance; // Ustawienie początkowego salda
    }

    // Getter do uzyskania nazwy użytkownika
    public String getUsername() {
        return username;
    }

    // Metoda do sprawdzania poprawności hasła
    public boolean checkPassword(String password) {
        return this.password.equals(password); // Porównanie hasła podanego z zapisanym
    }

    // Getter do uzyskania aktualnego salda użytkownika
    public double getBalance() {
        return balance;
    }

    // Metoda do zwiększania salda użytkownika
    public void deposit(double amount) {
        balance += amount; // Dodanie podanej kwoty do aktualnego salda
    }

    // Metoda do zmniejszania salda użytkownika (np. przy wypłacie lub zakładzie)
    public boolean withdraw(double amount) {
        if (amount <= balance) { // Sprawdzenie, czy użytkownik ma wystarczające środki
            balance -= amount; // Odjęcie kwoty od salda
            return true; // Zwrócenie informacji o sukcesie
        }
        return false; // Zwrócenie informacji o niepowodzeniu (niewystarczające środki)
    }
}
