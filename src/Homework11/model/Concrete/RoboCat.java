package Homework11.model.Concrete;

import Homework11.model.Abstract.AbstractPet;
import Homework11.model.Enums.AnimalSpecies;

import java.util.Set;

public class RoboCat extends AbstractPet {
    public RoboCat() {}
    public RoboCat(String nickname) {
        super(nickname);
        this.species = AnimalSpecies.ROBOCAT;
    }
    public RoboCat(String nickName, int age,
                   int trickLevel, Set<String> habits) {
        super(nickName, age, trickLevel, habits);
        this.species = AnimalSpecies.ROBOCAT;
    }
    @Override
    public void respond() {
        System.out.println("I am a RoboCat and I am responding");
    }
}

