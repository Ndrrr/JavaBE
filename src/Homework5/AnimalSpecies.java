package Homework5;

public enum AnimalSpecies {
    DOG(false,4,true),
    CAT(false,4,true),
    FISH(false,0,false),
    TURTLE(false,4,false),
    BIRD(false,2,true);

    boolean canFly;
    int numberOfLegs;
    boolean hasFur;

    AnimalSpecies(boolean canFly, int numberOfLegs, boolean hasFur) {
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }

    @Override
    public String toString() {
        return this.name()+"{" +
                "canFly=" + canFly +
                ", numberOfLegs=" + numberOfLegs +
                ", hasFur=" + hasFur +
                '}';
    }
}

