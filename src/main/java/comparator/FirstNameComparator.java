package comparator;

import model.Score;

import java.util.Comparator;

public class FirstNameComparator implements Comparator<Score> {

    @Override
    public int compare(Score score1, Score score2) {
        return score1.getPerson().getFName().compareTo(score2.getPerson().getFName());
    }
}
