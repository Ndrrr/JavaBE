package Homework5_6.Tests;

import Homework5_6.AnimalSpecies;
import Homework5_6.Family;
import Homework5_6.Human;
import Homework5_6.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyTest {
    Family family;
    @BeforeEach
    public void setup(){
        family = new Family(new Human("Mother", "Surname", 1990), new Human("Father", "Surname", 1990));
        family.addChild(new Human("Child1", "Surname", 2011));
        family.setPet(new Pet(AnimalSpecies.DOG, "Pet"));
    }

    @Test
    public void testFamilyEquals(){
        Family family1 = new Family(new Human("Mother", "Surname", 1990), new Human("Father", "Surname", 1990));
        assertEquals(this.family,family1);
    }

    @Test
    public void testFamilyNotEquals(){
        Family family1 = new Family(new Human("Mother", "Surname", 1990), new Human("Father", "Suname", 1990));
        family1.addChild(new Human("Child1", "Surname", 2013));
        family1.setPet(new Pet(AnimalSpecies.DOG, "Pet"));
        assertNotEquals(this.family,family1);
    }

    @Test
    public void testDeleteChildByIndex(){
        family.addChild(new Human("Child2", "Surname", 2013));
        family.deleteChild(0);
        assertEquals(family.getChildren().length,1);
    }

    @Test
    public void testDeleteChildByFakeIndex(){
        family.addChild(new Human("Child2", "Surname", 2013));
        boolean res = family.deleteChild(5);
        assertEquals(res,false);
    }

    @Test
    public void testDeleteChildByReference(){
        Human newChild = new Human("Child2", "Surname", 2013);
        family.addChild(newChild);
        family.deleteChild(newChild);
        assertEquals(family.getChildren().length,1);
    }

    @Test
    public void testDeleteChildByFakeReference(){
        Human newChild = new Human("Child2", "Surname", 2013);
        family.addChild(newChild);
        family.deleteChild(new Human("Child3", "Surname", 2013));
        assertEquals(family.getChildren().length,2);
    }

    @Test
    public void testDeleteChildByFakeButEqualObject(){
        Human newChild = new Human("Child2", "Surname", 2013);
        family.addChild(newChild);
        family.deleteChild(new Human("Child2", "Surname", 2013));
        assertEquals(family.getChildren().length,1);
    }

    @Test
    public void testAddChild(){
        family.addChild(new Human("Child2", "Surname", 2013));
        assertEquals(family.getChild(1),new Human("Child2", "Surname", 2013));
        assertEquals(family.getChildren().length,2);
    }

    @Test
    public void testFamilyCount(){
        assertEquals(family.countFamily(),3);
    }

}
