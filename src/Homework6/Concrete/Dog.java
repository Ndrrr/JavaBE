package Homework6.Concrete;

import Homework6.Abstract.AbstractPet;
import Homework6.Abstract.Fouler;
import Homework6.Enums.AnimalSpecies;

public class Dog extends AbstractPet implements Fouler {
    public Dog() {}
    public Dog(String nickname) {
        super(nickname);
        this.species = AnimalSpecies.DOG;
    }
    public Dog(AnimalSpecies species, String nickName, int age,
               int trickLevel, String[] habits) {
        super(nickName, age, trickLevel, habits);
        this.species = AnimalSpecies.DOG;
    }
    @Override
    public void respond() {
        System.out.println("I am a dog and I am responding");
    }
    @Override
    public void foul() {
        System.out.println("I am a dog and I am fouling");
    }
}

