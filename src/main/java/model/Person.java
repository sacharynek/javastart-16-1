package model;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Person {

    private String fName, lName;

    @Override
    public String toString(){
        return this.getFName()+" "+this.getLName();
    }


}
