package Homework7.Concrete;

import Homework7.Abstract.AbstractPet;
import Homework7.Abstract.Fouler;
import Homework7.Enums.AnimalSpecies;

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

