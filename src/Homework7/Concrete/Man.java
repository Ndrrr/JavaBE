package Homework7.Concrete;

import Homework7.Abstract.AbstractHuman;

public final class Man extends AbstractHuman {
    //region Constructors
    public Man() {
    }

    public Man(String name, String surname, int birthYear) {
        super(name, surname, birthYear);
    }

    public Man(String name, String surname, int birthYear, int iq) {
        super(name, surname, birthYear, iq);
    }

    public Man(String name, String surname, int birthYear, int iq, String[][] schedule) {
        super(name, surname, birthYear, iq, schedule);
    }

    public Man(String name, String surname, int birthYear,int iq, Family family) {
        super(name, surname, birthYear,iq, family);
    }

    public Man(String name, String surname, int birthYear, int iq, Family family, String[][] schedule) {
        super(name, surname, birthYear, iq, family, schedule);
    }
    //endregion

    @Override
    public void greetPet(){
        if(family.getPet()==null){
            System.out.println("I have no pet ");
            return;
        }
        System.out.println("Hi, " + family.getPet().getNickName() + "!");
    }

    public void watchFootball(){
        System.out.println("I'm watching football!");
    }
}
