package Homework5_6.Tests;

import Homework5_6.AnimalSpecies;
import Homework5_6.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PetTest {
    Pet pet;
    @BeforeEach
    public void setup(){
        pet = new Pet(AnimalSpecies.DOG, "Pet");
    }

    @Test
    public void testPetEquals() {
        Pet pet2 = new Pet(AnimalSpecies.DOG, "Pet");
        assertEquals(pet, pet2);
    }

    @Test
    public void testPetNotEquals(){
        Pet pet2 = new Pet(AnimalSpecies.DOG, "Pet",10, 50, new String[]{});
        assertNotEquals(pet,pet2);
    }

    @Test
    public void testPetToString(){
        System.out.println(pet.toString());
        assertEquals("DOG{canFly=false, numberOfLegs=4, hasFur=true}{nickname='Pet', age=0, trickLevel=0, habits=null}",
                pet.toString());
    }

}
