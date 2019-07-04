package model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Competition {

    private List<Score> scores = new ArrayList<>();

    public boolean addScore(Score score) {
        return scores.add(score);
    }

}
