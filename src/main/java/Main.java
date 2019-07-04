import comparator.FirstNameComparator;
import comparator.LastNameComparator;
import comparator.ScoreComparator;
import model.Competition;
import model.Person;
import model.Score;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //1 wczytywanie userów az do STOP lub wczytywanie z pliku.
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

        while (true) {
            System.out.println("wybierz opcje sortowania");
            System.out.println(" 1 - imie");
            System.out.println(" 2 - nazwisko");
            System.out.println(" 3 - wynik");
            System.out.println(" 0 - wyjście");
            value = sc.nextLine();
            if (value.equals("1")) {
                Collections.sort(competition.getScores(), new FirstNameComparator());
            } else if (value.equals("2")) {
                Collections.sort(competition.getScores(), new LastNameComparator());
            } else if (value.equals("3")) {
                Collections.sort(competition.getScores(), new ScoreComparator());
            } else {
                System.out.println("nie rozpoznano opcji - przerywam działanie");
                break;
            }


        }
        while (true) {
            System.out.println("1 - wyświetl");
            System.out.println("2 - zapisz do pliku");
            value = sc.nextLine();
            if (value.equals("1")) {
                for (Score score : competition.getScores()) {
                    System.out.println(score.toString());
                }

            }
            if (value.equals("2")) {
                writeCompetitionToFile(competition);
            }
            break;
        }

        //3 wybierz co ma robić: zapis do pliku; wyświetl odpowiednio posortowane; zamknij plik i przejście do kroku 1
    }

    static void writeCompetitionToFile(Competition competition) throws IOException {
        System.out.println("Program has finished");
        if (!competition.getScores().isEmpty()) {
            BufferedWriter writer = new BufferedWriter(new FileWriter("competition.txt"));
            for (Score score : competition.getScores()) {
                writer.write(score.toString());
                writer.newLine();
            }
            writer.close();
        }
    }
}
