package Homework13.model.Concrete;

import Homework13.model.Abstract.AbstractPet;
import Homework13.model.Enums.AnimalSpecies;

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
