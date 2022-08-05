package Homework8.Concrete;

import Homework8.Abstract.AbstractPet;
import Homework8.Enums.AnimalSpecies;

import java.util.Set;

public class Fish extends AbstractPet {
    public Fish(){}
    public Fish(String nickname){
        super(nickname);
        this.species = AnimalSpecies.FISH;
    }
    public Fish(String nickName, int age,
                int trickLevel, Set<String> habits) {
        super(nickName,age,trickLevel,habits);
        this.species = AnimalSpecies.FISH;
    }


    @Override
    public void respond() {
        System.out.println("I am a fish and I am responding");
    }
}
