package Homework7.Concrete;

import Homework7.Abstract.AbstractPet;
import Homework7.Enums.AnimalSpecies;

public class Fish extends AbstractPet{
    public Fish(){}
    public Fish(String nickname){
        super(nickname);
        this.species = AnimalSpecies.FISH;
    }
    public Fish(String nickName, int age,
                int trickLevel, String[] habits) {
        super(nickName,age,trickLevel,habits);
        this.species = AnimalSpecies.FISH;
    }


    @Override
    public void respond() {
        System.out.println("I am a fish and I am responding");
    }
}
