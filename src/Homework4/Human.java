package Homework4;

import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private int birthYear;
    private int iq;
    private Pet pet;
    private Human Mother;
    private Human Father;
    private String[][] schedule;

    //region Constructors
    public Human(){}

    public Human(String name, String surname, int birthYear){
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
    }

    public Human(String name, String surname, int birthYear,
                 Human father, Human mother){
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.Father = father;
        this.Mother = mother;
    }
    public Human(String name, String surname, int birthYear,
                 int iq, Pet pet, Human father, Human mother,
                 String[][] schedule){
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.Father = father;
        this.Mother = mother;
        this.pet = pet;
        this.iq = iq;
        this.schedule = schedule.clone();
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
    public Pet getPet() {
        return pet;
    }
    public Human getMother() {
        return Mother;
    }
    public Human getFather() {
        return Father;
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
    public void setPet(Pet pet) {
        this.pet = pet;
    }
    public void setMother(Human mother) {
        this.Mother = mother;
    }
    public void setFather(Human father) {
        this.Father = father;
    }
    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }
    public void setSchedule(int day, String[] schedule) {
        this.schedule[day] = schedule;
    }
    //endregion

    public void greetPet() {
        System.out.println("Hello, " + pet.getNickName() + "!");
    }
    public void describePet(){
        System.out.println("I have a " + pet.getSpecies() + ", he is " + pet.getAge()
                + " years old, he is " + (pet.getTrickLevel() > 50 ? "very" : "almost not")
                + " sly.");
    }

    @Override
    public String toString(){
        return "Human{" +
                "name='" + name +
                "', surname='" + surname +
                "', birthYear=" + birthYear +
                ", iq=" + iq +
                ", Mother=" + (Mother != null ? Mother.name + " " + Mother.surname : "null") +
                ", Father=" + (Father != null ? Father.name + " " + Father.surname : "null") +
                ", pet=" + (pet != null  ? this.pet.toString() : "null") +
                '}';
    }

    public boolean feedPet(boolean isHungry){
        if(isHungry || pet.getTrickLevel() > (new Random()).nextInt(100)){
            System.out.println("Hm... I will feed " + pet.getNickName() + ".");
            return true;
        }
        System.out.println("I think " + pet.getNickName() + "is not hungry.");
        return false;
    }

}
