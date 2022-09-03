package Homework13.model.Concrete;

import Homework13.model.Abstract.AbstractPet;
import Homework13.model.Abstract.Fouler;
import Homework13.model.Enums.AnimalSpecies;

import java.util.Set;

public class Dog extends AbstractPet implements Fouler {
    public Dog() {}
    public Dog(String nickname) {
        super(nickname);
        this.species = AnimalSpecies.DOG;
    }
    public Dog(String nickName, int age,
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

