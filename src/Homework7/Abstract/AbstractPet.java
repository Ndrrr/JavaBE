package Homework7.Abstract;

import Homework7.Enums.AnimalSpecies;

import java.util.Arrays;
import java.util.Objects;

public abstract class AbstractPet {
    protected AnimalSpecies species;
    protected String nickName;
    protected int age;
    protected int trickLevel;
    protected String[] habits;

    static {
        System.out.println("Pet class loaded");
    }
    {
        System.out.println("Pet object created");
    }
    //region Constructors
    public AbstractPet(){}
    public AbstractPet(String nickname){
        this.nickName = nickname;
    }
    public AbstractPet(String nickName, int age,
                       int trickLevel, String[] habits) {
        this.nickName = nickName;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits.clone();
    }
    //endregion

    //region Getters and Setters
    public AnimalSpecies getSpecies() {
        return species;
    }
    public String getNickName() {
        return nickName;
    }
    public int getAge() {
        return age;
    }
    public int getTrickLevel() {
        return trickLevel;
    }
    public String[] getHabits() {
        if(habits == null){
            return null;
        }
        return habits.clone();
    }
    public void setSpecies(AnimalSpecies species) {
        this.species = species;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setTrickLevel(int trickLevel) {
        if(trickLevel < 1 || trickLevel > 100) {
            throw new IllegalArgumentException("Trick level must be between 1 and 100");
        }
        this.trickLevel = trickLevel;
    }
    public void setHabits(String[] habits) {
        this.habits = habits;
    }
    public void setHabit(int index, String habit) {
        if(index < 0 || index >= habits.length) {
            throw new IllegalArgumentException("Index must be between 0 and " + (habits.length - 1));
        }
        this.habits[index] = habit;
    }
    //endregion

    public void eat() {
        System.out.println("I am eating!");
    }
    public abstract void respond();

    @Override
    public String toString(){
        return this.species.toString() +
                "{nickname='" + this.nickName +
                "', age=" + this.age +
                ", trickLevel=" + this.trickLevel +
                ", habits=" + Arrays.toString(this.getHabits()) +
                "}";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPet abstractPet = (AbstractPet) o;
        return getAge() == abstractPet.getAge() && getSpecies() == abstractPet.getSpecies() &&
                getNickName().equals(abstractPet.getNickName());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getSpecies(), getNickName(), getAge());
        return result;
    }

    @Override
    protected void finalize(){
        System.out.printf("Pet object %s is being garbage collected\n", this.nickName);
    }
}
