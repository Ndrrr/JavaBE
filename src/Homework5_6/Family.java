package Homework5_6;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    static {
        System.out.println("Family class loaded");
    }
    {
        System.out.println("Family object created");
    }
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
    public Family(Human mother, Human father) {
        this.mother = mother;
        mother.setFamily(this);
        this.father = father;
        father.setFamily(this);
        this.children=new Human[0];
    }

    // region Getters and Setters
    public Human getMother() {
        return mother;
    }
    public Human getFather() {
        return father;
    }
    public Human[] getChildren() {
        return children;
    }
    public Human getChild(int index){
        if(index>=children.length || index < 0){
            throw new IllegalArgumentException("Index out of range");
        }
        return children[index];
    }
    public void setChildren(Human[] children) {
        this.children = children;
    }
    public void setChild(Human child, int index) {
        this.children[index] = child;
    }
    public void setPet(Pet pet) {
        this.pet = pet;
    }
    public Pet getPet() {
        return pet;
    }
    //endregion

    public boolean deleteChild(int index) {
        if(index < 0 || index >= children.length) {
            //throw new IllegalArgumentException("Index is out of range");
            return false;
        }
        this.children[index] = null;
        Human[] tmpArr = new Human[this.children.length - 1];
        index = 0;
        for (int i = 0; i < this.children.length; i++) {
            if(this.children[i] != null)
                tmpArr[index++] = this.children[i];
        }
        this.children = tmpArr;
        return true;
    }
    public boolean deleteChild(Human child){
        boolean res = false;
        for (int i = 0; i < this.children.length; i++) {
            if(this.children[i].equals(child))
                res = deleteChild(i);
        }
        return res;
    }
    public void addChild(Human child) {
        Human[] tmpArr = new Human[this.children.length + 1];
        for (int i = 0; i < this.children.length; i++) {
            tmpArr[i] = this.children[i];
        }
        tmpArr[tmpArr.length - 1] = child;
        this.children = tmpArr;
    }
    public int countFamily() {
        return 2 + this.children.length;
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother.toString() +
                ", father=" + father.toString() +
                ", children=" + Arrays.toString(children) +
                ", pet=" + (pet!=null ? pet.toString() : "null") +
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

}
