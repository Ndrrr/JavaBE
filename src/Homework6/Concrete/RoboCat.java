package Homework6.Concrete;

import Homework6.Abstract.AbstractPet;
import Homework6.Enums.AnimalSpecies;

public class RoboCat extends AbstractPet {
    public RoboCat() {}
    public RoboCat(String nickname) {
        super(nickname);
        this.species = AnimalSpecies.ROBOCAT;
    }
    public RoboCat(String nickName, int age,
                   int trickLevel, String[] habits) {
        super(nickName, age, trickLevel, habits);
        this.species = AnimalSpecies.ROBOCAT;
    }
    @Override
    public void respond() {
        System.out.println("I am a RoboCat and I am responding");
    }
}

