package Homework6.Concrete;

import Homework6.Abstract.AbstractPet;
import Homework6.Abstract.Fouler;
import Homework6.Enums.AnimalSpecies;

public class DomesticCat extends AbstractPet implements Fouler {

    public DomesticCat(){}
    public DomesticCat(String nickname){
        super(nickname);
        this.species = AnimalSpecies.DOMESTIC_CAT;
    }
    public DomesticCat(String nickName, int age,
                       int trickLevel, String[] habits) {
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

