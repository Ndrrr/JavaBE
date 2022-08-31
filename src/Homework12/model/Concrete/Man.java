package Homework12.model.Concrete;

import Homework12.model.Abstract.AbstractHuman;
import Homework12.model.Enums.DayOfWeek;

import java.util.Map;

public final class Man extends AbstractHuman {
    //region Constructors
    public Man() {
    }

    public Man(String name, String surname, long birthYear) {
        super(name, surname, birthYear);
    }

    public Man(String name, String surname, long birthYear, int iq) {
        super(name, surname, birthYear, iq);
    }
    public Man(String name, String surname, String birthDate, int iq){
        super(name, surname, birthDate, iq);
    }
    public Man(String name, String surname, long birthYear, int iq, Map<DayOfWeek,String> schedule) {
        super(name, surname, birthYear, iq, schedule);
    }

    public Man(String name, String surname, long birthYear,int iq, Family family) {
        super(name, surname, birthYear,iq, family);
    }

    public Man(String name, String surname, long birthYear, int iq, Family family, Map<DayOfWeek,String> schedule) {
        super(name, surname, birthYear, iq, family, schedule);
    }
    //endregion

    @Override
    public void greetPets(){
        if(family.getPets()==null){
            System.out.println("I have no pet ");
            return;
        }
        family.getPets().forEach((p)-> {
            System.out.println("Hi, " + p.getNickName() + "!");
        });
    }

    public void watchFootball(){
        System.out.println("I'm watching football!");
    }

}
