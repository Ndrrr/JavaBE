package Homework13.model.Concrete;

import Homework13.model.Abstract.AbstractPet;
import Homework13.model.Abstract.Fouler;
import Homework13.model.Enums.AnimalSpecies;

import java.util.Set;

public class DomesticCat extends AbstractPet implements Fouler {

    public DomesticCat(){}
    public DomesticCat(String nickname){
        super(nickname);
        this.species = AnimalSpecies.DOMESTIC_CAT;
    }
    public DomesticCat(String nickName, int age,
                       int trickLevel, Set<String> habits) {
        super(nickName,age,trickLevel,habits);
        this.species = AnimalSpecies.DOMESTIC_CAT;
    }

    @Override
    public void respond() {
        System.out.println("I am a domestic cat and I am responding");
    }

    @Override
    public void foul() {
        System.out.println("I am a domestic cat and I am fouling");
    }
}

