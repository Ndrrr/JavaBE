package Homework6.Enums;

public enum AnimalSpecies {
    DOG(false,4,true),
    DOMESTIC_CAT(false,4,true),
    FISH(false,0,false),
    ROBOCAT(true,4,false),
    UNKNOWN(false,0,false);

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

