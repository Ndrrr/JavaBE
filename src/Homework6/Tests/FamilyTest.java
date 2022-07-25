package Homework6.Tests;

import Homework6.Concrete.Dog;
import Homework6.Concrete.Family;
import Homework6.Concrete.Man;
import Homework6.Concrete.Woman;
import Homework6.Abstract.AbstractHuman;
import Homework6.Abstract.AbstractPet;

import Homework6.Enums.AnimalSpecies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyTest {
    Family family;
    @BeforeEach
    public void setup(){
        family = new Family(new Woman("Jane", "Doe", 1990), new Man("John", "Doe", 1990));
        family.addChild(new Man("Anton", "Doe", 2011));
        family.setPet(new Dog("Pet"));
    }

    @Test
    public void testFamilyEquals(){
        Family family1 = new Family(new Woman("Jane", "Doe", 1990), new Man("John", "Doe", 1990));
        assertEquals(this.family,family1);
    }

    @Test
    public void testFamilyNotEquals(){
        Family family1 = new Family(new Woman("Jane", "Doe", 1990), new Man("John", "Doeee", 1990));
        family1.addChild(new Man("Anton", "Doe", 2013));
        family1.setPet(new Dog("Pet"));
        assertNotEquals(this.family,family1);
    }

    @Test
    public void testDeleteChildByIndex(){
        family.addChild(new Woman("Child2", "Doe", 2013));
        family.deleteChild(0);
        assertEquals(family.getChildren().length,1);
    }

    @Test
    public void testDeleteChildByFakeIndex(){
        family.addChild(new Woman("Child2", "Doe", 2013));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> family.deleteChild(5));
        String expectedMessage = "Index is out of range";
        assertEquals(exception.getMessage(),expectedMessage);
    }

    @Test
    public void testDeleteChildByReference(){
        Man newChild = new Man("Child2", "Surname", 2013);
        family.addChild(newChild);
        family.deleteChild(newChild);
        assertEquals(family.getChildren().length,1);
    }

    @Test
    public void testDeleteChildByFakeReference(){
        Man newChild = new Man("Child2", "Surname", 2013);
        family.addChild(newChild);
        family.deleteChild(new Man("Child3", "Surname", 2013));
        assertEquals(family.getChildren().length,2);
    }

    @Test
    public void testDeleteChildByFakeButEqualObject(){
        Man newChild = new Man("Child2", "Surname", 2013);
        family.addChild(newChild);
        family.deleteChild(new Man("Child2", "Surname", 2013));
        assertEquals(family.getChildren().length,1);
    }

    @Test
    public void testAddChild(){
        family.addChild(new Woman("Child2", "Surname", 2013));
        assertEquals(family.getChild(1),new Woman("Child2", "Surname", 2013));
        assertEquals(family.getChildren().length,2);
    }

    @Test
    public void testFamilyCount(){
        assertEquals(family.countFamily(),3);
    }

}
