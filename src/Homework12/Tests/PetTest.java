package Homework12.Tests;

import Homework12.model.Abstract.AbstractPet;
import Homework12.model.Concrete.Dog;
import Homework12.model.Concrete.DomesticCat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PetTest {
    AbstractPet pet;
    @BeforeEach
    public void setup(){

        pet = new Dog("Pet");
    }

    @Test
    public void testPetEquals() {
        Dog pet2 = new Dog("Pet");
        assertEquals(pet, pet2);
    }

    @Test
    public void testPetNotEquals(){
        DomesticCat pet2 = new DomesticCat("Pet",10, 50, new HashSet<String>());
        assertNotEquals(pet,pet2);
    }

    @Test
    public void testPetToString(){
        System.out.println(pet.toString());
        assertEquals(pet.toString(),"DOG{canFly=false, numberOfLegs=4, hasFur=true}{nickname='Pet', age=0, trickLevel=0, habits=null}");
    }

}
