package Homework7.Concrete;

import Homework7.Utils;
import Homework7.Abstract.AbstractPet;
import Homework7.Abstract.AbstractHuman;
import Homework7.Abstract.HumanCreator;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;


public class Family implements HumanCreator {
    private AbstractHuman mother;
    private AbstractHuman father;
    private AbstractHuman[] children;
    private AbstractPet pet;

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
        this.children=new AbstractHuman[0];
    }

    // region Getters and Setters
    public AbstractHuman getMother() {
        return mother;
    }
    public AbstractHuman getFather() {
        return father;
    }
    public AbstractHuman[] getChildren() {
        return children;
    }
    public AbstractHuman getChild(int index){
        if(index>=children.length || index < 0){
            throw new IllegalArgumentException("Index out of range");
        }
        return children[index];
    }
    public void setChildren(AbstractHuman[] children) {
        this.children = children;
    }
    public void setChild(AbstractHuman child, int index) {
        this.children[index] = child;
    }
    public void setPet(AbstractPet pet) {
        this.pet = pet;
    }
    public AbstractPet getPet() {
        return pet;
    }
    //endregion

    public boolean deleteChild(int index) {
        if(index < 0 || index >= children.length) {
            return false;
            //throw new IllegalArgumentException("Index is out of range");
        }
        this.children[index] = null;
        AbstractHuman[] tmpArr = new AbstractHuman[this.children.length - 1];
        index = 0;
        for (int i = 0; i < this.children.length; i++) {
            if(this.children[i] != null)
                tmpArr[index++] = this.children[i];
        }
        this.children = tmpArr;
        return true;
    }
    public boolean deleteChild(AbstractHuman child){
        boolean res = false;
        for (int i = 0; i < this.children.length; i++) {
            if(this.children[i].equals(child))
                res = deleteChild(i);
        }
        return res;
    }
    public void addChild(AbstractHuman child) {
        AbstractHuman[] tmpArr = new AbstractHuman[this.children.length + 1];
        for (int i = 0; i < this.children.length; i++) {
            tmpArr[i] = this.children[i];
        }
        tmpArr[tmpArr.length - 1] = child;
        this.children = tmpArr;
    }
    public int countFamily() {
        return 2 + this.children.length + (this.pet != null ? 1 : 0);
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother.toString() +
                ", father=" + father.toString() +
                ", children=" + Arrays.toString(children) +
                ", pet=" + (pet !=null ? pet.toString() : "null") +
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
        if(gender){
            return new Man(Utils.getRandomName('m',true),
                    this.father.getSurname(),
                    LocalDate.now().getYear(),
                    (this.father.getIq()+this.mother.getIq())/2,
                    this);
        }
        else{
            return new Woman(Utils.getRandomName('f',true),
                    this.father.getSurname(),
                    LocalDate.now().getYear(),
                    (this.father.getIq()+this.mother.getIq())/2,
                    this);
        }
    }
}
