import java.util.*;

class UserManager {
    // Mapa przechowująca użytkowników, gdzie kluczem jest nazwa użytkownika, a wartością obiekt klasy User
    private Map<String, User> users = new HashMap<>();

    /**
     * Metoda do rejestracji nowego użytkownika.
     *
     * @param username       Nazwa użytkownika.
     * @param password       Hasło użytkownika.
     * @param initialBalance Początkowe saldo użytkownika.
     * @return true, jeśli rejestracja zakończyła się sukcesem; false, jeśli użytkownik o podanej nazwie już istnieje.
     */
    public boolean register(String username, String password, double initialBalance) {
        if (users.containsKey(username)) { // Sprawdzenie, czy użytkownik już istnieje
            return false; // Rejestracja nie powiodła się
        }
        // Dodanie nowego użytkownika do mapy
        users.put(username, new User(username, password, initialBalance));
        return true; // Rejestracja zakończona sukcesem
    }

    /**
     * Metoda do logowania użytkownika.
     *
     * @param username Nazwa użytkownika.
     * @param password Hasło użytkownika.
     * @return Obiekt klasy User, jeśli dane logowania są poprawne; null, jeśli są niepoprawne.
     */
    public User login(String username, String password) {
        User user = users.get(username); // Pobranie użytkownika z mapy na podstawie nazwy użytkownika
        if (user != null && user.checkPassword(password)) { // Sprawdzenie, czy hasło jest poprawne
            return user; // Logowanie zakończone sukcesem
        }
        return null; // Niepoprawne dane logowania
    }
}