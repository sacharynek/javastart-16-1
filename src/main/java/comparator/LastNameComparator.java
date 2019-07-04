package comparator;

import model.Score;

import java.util.Comparator;

public class LastNameComparator implements Comparator<Score> {

    @Override
    public int compare(Score score1, Score score2) {
        return score1.getPerson().getLName().compareTo(score2.getPerson().getLName());
    }
}
