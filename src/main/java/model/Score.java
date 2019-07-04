package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Score {

    private Person person;
    private int score;

    @Override
    public String toString(){
        return getPerson().toString()+" "+getScore()+"\n";
    }


}
