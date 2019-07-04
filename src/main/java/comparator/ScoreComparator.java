package comparator;

import model.Score;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Score> {

    @Override
    public int compare(Score score1, Score score2) {
        return Integer.compare(score1.getScore(), score2.getScore());
    }
}
