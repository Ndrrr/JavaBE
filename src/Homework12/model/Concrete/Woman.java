package Homework12.model.Concrete;

import Homework12.model.Abstract.AbstractHuman;
import Homework12.model.Enums.DayOfWeek;

import java.util.Map;

public final class Woman extends AbstractHuman {
    //region Constructors
    public Woman() {
    }

    public Woman(String name, String surname, long birthYear) {
        super(name, surname, birthYear);
    }

    public Woman(String name, String surname, long birthYear, int iq) {
        super(name, surname, birthYear, iq);
    }

    public Woman(String name, String surname, long birthYear, int iq, Map<DayOfWeek,String> schedule) {
        super(name, surname, birthYear, iq, schedule);
    }
    public Woman(String name, String surname, String birthDate, int iq){
        super(name, surname, birthDate, iq);
    }
    public Woman(String name, String surname, long birthYear, int iq, Family family) {
        super(name, surname, birthYear, iq, family);
    }

    public Woman(String name, String surname, long birthYear, int iq, Family family, Map<DayOfWeek,String > schedule) {
        super(name, surname, birthYear, iq, family, schedule);
    }
    //endregion

    @Override
    public void greetPets(){
        if(family.getPets()==null){
            System.out.println("I have no pet :(((");
            return;
        }
        family.getPets().forEach((p)-> {
            System.out.println("Hellooo, " + p.getNickName() + "!\nHow are you today?\nYou look so cute!!");
        });
    }

    public void makeup(){
        System.out.println("I'm doing makeup!");
    }
}
