import java.sql.*;
import java.util.Random;


public class JBDCDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String username = "root";
        String password = "";
        String sql = "INSERT INTO customer (id, name, surname, age) VALUES (?, ?, ?, ?)";

        String[] firstNames = {"Adam", "Adrian", "Aleksander", "Andrzej", "Antoni", "Bartłomiej", "Bartosz", "Błażej", "Bogdan", "Brunon", "Cezary", "Cyprian", "Damian", "Daniel", "Dariusz", "Dawid", "Dominik", "Edward", "Eliasz", "Emil", "Eryk", "Eugeniusz", "Fabian", "Feliks", "Filip", "Franciszek", "Fryderyk", "Gabriel", "Grzegorz", "Gustaw", "Hubert", "Ignacy", "Igor", "Ireneusz", "Jacek", "Jakub", "Jan", "Janusz", "Jarosław", "Jerzy", "Joachim", "Józef", "Julian", "Juliusz", "Kacper", "Kajetan", "Kamil", "Karol", "Kazimierz", "Konrad", "Kornel", "Krzysztof", "Lech", "Leon", "Leszek", "Łukasz", "Maciej", "Maksymilian", "Marcel", "Marcin", "Marek", "Mariusz", "Mateusz", "Maurycy", "Michał", "Mieczysław", "Mikołaj", "Mirosław", "Napoleon", "Nikodem", "Norbert", "Oktawian", "Olek", "Oliwier", "Oskar", "Patryk", "Paweł", "Piotr", "Przemysław", "Radosław", "Rafał", "Remigiusz", "Robert", "Roman", "Ryszard", "Sebastian", "Seweryn", "Sławomir", "Stanisław", "Stefan", "Sylwester", "Szymon", "Tadeusz", "Tomasz", "Wacław", "Waldemar", "Wiktor", "Witold", "Władysław", "Włodzimierz", "Zbigniew", "Zdzisław", "Zenon", "Zygmunt"};

        String[] lastNames = {"Adamski", "Andrzejewski", "Augustyniak", "Bąk", "Banach", "Baran", "Bartosz", "Bednarek", "Białek", "Bielawski", "Bilski", "Borkowski", "Brożek", "Brzeziński", "Budziński", "Burzyński", "Chmielewski", "Cieślak", "Czarnecki", "Czerniak", "Dąbrowski", "Domański", "Drzewiecki", "Dudek", "Duszyński", "Fabiański", "Falkowski", "Filipiak", "Flis", "Franczak", "Frączek", "Gałązka", "Gawlik", "Głowacki", "Gołębiowski", "Górski", "Graczyk", "Grzelak", "Guzik", "Herman", "Ignaczak", "Jackowski", "Janicki", "Janiszewski", "Jankowski", "Jarosz", "Jaworski", "Jędrzejewski", "Jóźwiak", "Kaczmarek", "Kalinowski", "Kamiński", "Karpiński", "Kasprzak", "Kędzierski", "Kisiel", "Kłosiński", "Kobus", "Kopeć", "Kostrzewa", "Kot", "Kozłowski", "Kożuchowski", "Krawczyk", "Król", "Krzemiński", "Książek", "Kuczyński", "Kulesza", "Kunicki", "Kwaśniewski", "Laskowski", "Leszczyński", "Lewandowski", "Lis", "Łapiński", "Łukaszewski", "Maj", "Majchrzak", "Makowski", "Malinowski", "Małecki", "Marcinkowski", "Marszałek", "Matuszewski", "Mazurek", "Mazurkiewicz", "Mikulski", "Misiak", "Młynarczyk", "Morawski", "Mróz", "Muszyński", "Nawrocki", "Nowak", "Nowicki", "Olczyk", "Olszewski", "Orłowski", "Osowski", "Ostrowski", "Pająk", "Pawlak", "Piasecki", "Piotrowski", "Piątek", "Piekarski", "Pietrzak", "Piwowarczyk", "Pluta", "Podgórski", "Porębski", "Przybysz", "Raczyński", "Radomski", "Rogowski", "Rybak", "Rybicki", "Rzepka", "Sadowski", "Sawicki", "Sikorski", "Skała", "Skowroński", "Sławiński", "Sobczak", "Sobolewski", "Sokołowski", "Stachowiak", "Stankiewicz", "Stefaniak", "Stolarczyk", "Sulej", "Szewczyk", "Szulc", "Śliwa", "Świercz", "Tomczyk", "Trzciński", "Urban", "Urbański", "Wachowiak", "Wasilewski", "Wieczorek", "Wierzbicki", "Wilczyński", "Wilk", "Witkowski", "Włodarczyk", "Wojsa", "Wolski", "Wróbel", "Zabłocki", "Zalewski", "Zarzycki", "Zawada", "Zawadzki", "Zięba", "Ziółkowski", "Zych"};

        Random random = new Random();

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            for (int i = 1; i <= 100000; i++) {
                String firstName = firstNames[random.nextInt(firstNames.length)];
                String lastName = lastNames[random.nextInt(lastNames.length)];
                int age = random.nextInt(60) + 18; // Wiek między 18 a 77 lat

                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, firstName);
                preparedStatement.setString(3, lastName);
                preparedStatement.setInt(4, age);
                preparedStatement.addBatch();

                if (i % 1000 == 0) {
                    preparedStatement.executeBatch();
                    System.out.println("Wstawiono " + i + " rekordów...");
                }
            }
            preparedStatement.executeBatch();
            System.out.println("Wstawiono wszystkich 100 000 klientów!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}