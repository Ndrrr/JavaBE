package Homework7.Concrete;

import Homework7.Abstract.AbstractHuman;

public final class Woman extends AbstractHuman {
    //region Constructors
    public Woman() {
    }

    public Woman(String name, String surname, int birthYear) {
        super(name, surname, birthYear);
    }

    public Woman(String name, String surname, int birthYear, int iq) {
        super(name, surname, birthYear, iq);
    }

    public Woman(String name, String surname, int birthYear, int iq, String[][] schedule) {
        super(name, surname, birthYear, iq, schedule);
    }

    public Woman(String name, String surname, int birthYear, int iq, Family family) {
        super(name, surname, birthYear, iq, family);
    }

    public Woman(String name, String surname, int birthYear, int iq, Family family, String[][] schedule) {
        super(name, surname, birthYear, iq, family, schedule);
    }
    //endregion

    @Override
    public void greetPet(){
        if(family.getPet()==null){
            System.out.println("I have no pet :(((");
            return;
        }
        System.out.println("Helloooo, " + family.getPet().getNickName() + "!\nHow are you today?\nYou look so cute!");
    }

    public void makeup(){
        System.out.println("I'm doing makeup!");
    }
}
