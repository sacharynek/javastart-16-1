package helper;

import model.Competition;
import model.Score;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Helper {


    public static void writeCompetitionToFile(Competition competition) throws IOException {
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

    public static void printScores(Competition competition) {
        for (Score score : competition.getScores()) {
            System.out.println(score.toString());
        }
    }

}
