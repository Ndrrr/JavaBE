package Homework9.model.Abstract;

import Homework9.model.Concrete.Family;
import Homework9.model.Enums.DayOfWeek;

import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public abstract class AbstractHuman {
    protected String name;
    protected String surname;
    protected int birthYear;
    protected int iq;
    protected Family family;
    protected Map<DayOfWeek, String> schedule;

//    static {
//        System.out.println("Human class loaded");
//    }
//    {
//        System.out.println("Human object created");
//    }
    //region Constructors
    public AbstractHuman(){}


    public AbstractHuman(String name, String surname, int birthYear){
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
    }
    public AbstractHuman(String name, String surname, int birthYear, int iq){
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.iq = iq;
    }
    public AbstractHuman(String name, String surname, int birthYear, int iq,
                         Map<DayOfWeek,String> schedule){
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.iq = iq;
        this.schedule = schedule;
    }
    public AbstractHuman(String name, String surname, int birthYear, int iq,
                         Family family){
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.iq = iq;
        this.family = family;
        family.addChild(this);
    }
    public AbstractHuman(String name, String surname, int birthYear,
                         int iq, Family family,
                         Map<DayOfWeek, String> schedule){
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.family = family;
        this.iq = iq;
        this.schedule = schedule;
        family.addChild(this);
    }
    //endregion

    //region Getters and Setters
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getBirthYear() {
        return birthYear;
    }
    public int getIq() {
        return iq;
    }
    public Family getFamily() {
        return family;
    }
    public Map<DayOfWeek, String> getSchedule() {
        return schedule;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
    public void setIq(int iq) {
        if(iq < 0 || iq > 100) {
            throw new IllegalArgumentException("IQ must be between 0 and 100");
        }
        this.iq = iq;
    }
    public void setFamily(Family family) {
        this.family = family;
    }
    public void setSchedule(Map<DayOfWeek, String> schedule) {
        this.schedule = schedule;
    }
    public void setSchedule(DayOfWeek day, String task) {
        this.schedule.put(day, task);
    }
    //endregion

    public void greetPets() {
        if(family.getPets()==null){
            System.out.println("I have no pet");
            return;
        }
        family.getPets().forEach((p)-> {
            System.out.println("Hello, " + p.getNickName() + "!");
        });
    }
    public void describePet(){
        Set<AbstractPet> pets = family.getPets();
        if(pets == null){
            System.out.println("I have no pet");
            return;
        }
        pets.forEach((p)-> {
            System.out.println("I have a " + p.getSpecies() + ", he is " + p.getAge()
                    + " years old, he is " + (p.getTrickLevel() > 50 ? "very" : "almost not")
                    + " sly.");
        });
    }

    @Override
    public String toString(){
        return "Human{" +
                "name='" + name +
                "', surname='" + surname +
                "', birthYear=" + birthYear +
                ", iq=" + iq +
                ", schedule=" + scheduleToString() +
                '}';
    }

    public boolean feedPets(boolean isHungry){
        Set<AbstractPet> pets = family.getPets();
        if(pets == null){
            System.out.println("I have no pet");
            return false;
        }
        boolean isFed = false;
        for(AbstractPet pet : pets){
            if(isHungry || pet.getTrickLevel() > (new Random()).nextInt(100)){
                System.out.println("Hm... I will feed " + pet.getNickName() + ".");
                isFed = true;
            }
            System.out.println("I think " + pet.getNickName() + "is not hungry.");
        };
        return isFed;
    }

    private String scheduleToString(){
        if(schedule == null) return "null";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(DayOfWeek day : DayOfWeek.values()){
            sb.append("[Day " + day.name() + ": ");
            if(schedule.get(day)==null){
                sb.append("null");
            }
            else {
                sb.append(schedule.get(day) + " ");
            }
            sb.append("]");
            if(day != DayOfWeek.SATURDAY) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractHuman human = (AbstractHuman) o;
        return getBirthYear() == human.getBirthYear() &&
                getName().equals(human.getName()) &&
                getSurname().equals(human.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getBirthYear());
    }

    @Override
    protected void finalize(){
        System.out.printf("Human object %s is being garbage collected\n", this.name + this.surname);
    }


}
