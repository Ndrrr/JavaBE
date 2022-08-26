package Homework11.model.Concrete;

import Homework11.model.Abstract.AbstractPet;
import Homework11.model.Abstract.Fouler;
import Homework11.model.Enums.AnimalSpecies;

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

