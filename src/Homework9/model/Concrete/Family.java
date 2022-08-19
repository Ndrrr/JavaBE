package Homework9.model.Concrete;

import Homework9.model.Abstract.AbstractHuman;
import Homework9.model.Abstract.AbstractPet;
import Homework9.model.Abstract.HumanCreator;
import Homework9.Utils;

import java.time.LocalDate;
import java.util.*;


public class Family implements HumanCreator {
    private AbstractHuman mother;
    private AbstractHuman father;
    private List<AbstractHuman> children;
    private Set<AbstractPet> pets;

//    static {
//        System.out.println("Family class loaded");
//    }
//    {
//        System.out.println("Family object created");
//    }
//    public Family(Human mother, Human father, Human[] children, Pet pet) {
//        this.mother = mother;
//        this.father = father;
//        this.children = children;
//        this.pet = pet;
//    }
//    public Family(Human mother, Human father, Human[] children) {
//        this.mother = mother;
//        this.father = father;
//        this.children = children;
//    }
    public Family(AbstractHuman mother, AbstractHuman father) {
        this.mother = mother;
        mother.setFamily(this);
        this.father = father;
        father.setFamily(this);
        this.children=new ArrayList<>();
        this.pets = new HashSet<>();
    }

    // region Getters and Setters
    public AbstractHuman getMother() {
        return mother;
    }
    public AbstractHuman getFather() {
        return father;
    }
    public List<AbstractHuman> getChildren() {
        return children;
    }
    public AbstractHuman getChild(int index){
        if(index>=children.size() || index < 0){
            throw new IllegalArgumentException("Index out of range");
        }
        return children.get(index);
    }
    public void setChildren(List<AbstractHuman> children) {
        this.children = children;
    }
    public void setChild(AbstractHuman child, int index) {
        this.children.set(index, child);
    }
    public void addPet(AbstractPet pet) {
        this.pets.add(pet);
    }
    public void removePet(AbstractPet pet) {
        this.pets.remove(pet);
    }
    public void setPets(Set <AbstractPet> pets){
        this.pets = pets;
    }
    public Set<AbstractPet> getPets() {
        return pets;
    }
    //endregion

    public boolean deleteChild(int index) {
        if(index < 0 || index >= children.size()) {
            return false;
            //throw new IllegalArgumentException("Index is out of range");
        }
        this.children.remove(index);
        return true;
    }
    public boolean deleteChild(AbstractHuman child){
        return this.children.remove(child);
    }
    public void addChild(AbstractHuman child) {
        this.children.add(child);
    }
    public int countFamily() {
        return 2 + this.children.size() + this.pets.size();
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother.toString() +
                ", father=" + father.toString() +
                ", children=" + children.toString() +
                ", pets=" + pets.toString() +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return getMother().equals(family.getMother())
                && getFather().equals(family.getFather());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMother(), getFather());
    }

    @Override
    protected void finalize(){
        System.out.printf("Family object of %s and %s is being garbage collected\n", mother.getName(), father.getName());
    }


    @Override
    public AbstractHuman bornChild() {
        boolean gender = (new Random()).nextBoolean();
        AbstractHuman child;
        if(gender){
             child = new Man(Utils.getRandomName('m',true),
                    this.father.getSurname(),
                    LocalDate.now().getYear(),
                    (this.father.getIq()+this.mother.getIq())/2,
                    this);
        }
        else{
            child = new Woman(Utils.getRandomName('f',true),
                    this.father.getSurname(),
                    LocalDate.now().getYear(),
                    (this.father.getIq()+this.mother.getIq())/2,
                    this);
        }
        return child;
    }

}
