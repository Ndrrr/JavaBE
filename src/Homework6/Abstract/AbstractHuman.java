package Homework6.Abstract;

import Homework6.Concrete.Family;

import java.util.Objects;
import java.util.Random;

public abstract class AbstractHuman {
    protected String name;
    protected String surname;
    protected int birthYear;
    protected int iq;
    protected Family family;
    protected String[][] schedule;

    static {
        System.out.println("Human class loaded");
    }
    {
        System.out.println("Human object created");
    }
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
                         String[][] schedule){
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.iq = iq;
        this.schedule = schedule.clone();
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
                         int iq, Family family, String[][] schedule){
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.family = family;
        this.iq = iq;
        this.schedule = schedule.clone();
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
    public String[][] getSchedule() {
        return schedule.clone();
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
    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }
    public void setSchedule(int day, String[] schedule) {
        this.schedule[day] = schedule;
    }
    //endregion

    public void greetPet() {
        if(family.getPet()==null){
            System.out.println("I have no pet");
            return;
        }
        System.out.println("Hello, " + family.getPet().getNickName() + "!");
    }
    public void describePet(){
        AbstractPet abstractPet = family.getPet();
        if(abstractPet == null){
            System.out.println("I have no pet");
            return;
        }
        System.out.println("I have a " + abstractPet.getSpecies() + ", he is " + abstractPet.getAge()
                + " years old, he is " + (abstractPet.getTrickLevel() > 50 ? "very" : "almost not")
                + " sly.");
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

    public boolean feedPet(boolean isHungry){
        AbstractPet pet = family.getPet();
        if(pet == null){
            System.out.println("I have no pet");
            return false;
        }
        if(isHungry || pet.getTrickLevel() > (new Random()).nextInt(100)){
            System.out.println("Hm... I will feed " + pet.getNickName() + ".");
            return true;
        }
        System.out.println("I think " + pet.getNickName() + "is not hungry.");
        return false;
    }

    private String scheduleToString(){
        if(schedule == null) return "null";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < schedule.length; i++){
            sb.append("[Day " + (i+1) + ": ");
            if(schedule[i]==null){
                sb.append("null");
            }
            else {
                for(int j = 0; j < schedule[i].length; j++){
                    sb.append(schedule[i][j] + " ");
                }
            }
            sb.append("]");
            if(i != schedule.length-1) sb.append(", ");
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
