import comparator.FirstNameComparator;
import comparator.LastNameComparator;
import comparator.ScoreComparator;
import helper.Helper;
import model.Competition;
import model.Person;
import model.Score;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        Competition competition = new Competition();
        Person tempPerson;
        String value;

        while (true) {
            System.out.println("podaj Imie, Nazwisko oraz Wynik");
            value = sc.nextLine();

            if (value.equals("STOP")) {
                break;
            }

            String[] values = value.split("\\s+");
            tempPerson = new Person(values[0], values[1]);
            competition.addScore(new Score(tempPerson, Integer.parseInt(values[2])));
        }

        System.out.println("wybierz opcje sortowania");
        System.out.println(" 1 - imie");
        System.out.println(" 2 - nazwisko");
        System.out.println(" 3 - wynik");

        value = sc.nextLine();
        switch (value) {
            case "1":
                Collections.sort(competition.getScores(), new FirstNameComparator());
                break;
            case "2":
                Collections.sort(competition.getScores(), new LastNameComparator());
                break;
            case "3":
                Collections.sort(competition.getScores(), new ScoreComparator());
                break;
        }

        System.out.println("1 - wyświetl");
        System.out.println("2 - zapisz do pliku");
        value = sc.nextLine();
        if (value.equals("1")) {
            Helper.printScores(competition);
        }
        if (value.equals("2")) {
            Helper.writeCompetitionToFile(competition);
        }

    }

}
