package Homework8.Concrete;

import Homework8.Abstract.AbstractPet;
import Homework8.Abstract.Fouler;
import Homework8.Enums.AnimalSpecies;

import java.util.Set;

public class Dog extends AbstractPet implements Fouler {
    public Dog() {}
    public Dog(String nickname) {
        super(nickname);
        this.species = AnimalSpecies.DOG;
    }
    public Dog(AnimalSpecies species, String nickName, int age,
               int trickLevel, Set<String> habits) {
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

