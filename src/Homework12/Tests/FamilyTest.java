package Homework12.Tests;

import Homework12.model.Concrete.Dog;
import Homework12.model.Concrete.Family;
import Homework12.model.Concrete.Man;
import Homework12.model.Concrete.Woman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FamilyTest {
    Family family;
    @BeforeEach
    public void setup(){
        family = new Family(new Woman("Jane", "Doe", 1990), new Man("John", "Doe", 1990));
        family.addChild(new Man("Anton", "Doe", 2011));
        family.addPet(new Dog("Pet"));
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
        family1.addPet(new Dog("Pet"));
        assertNotEquals(this.family,family1);
    }

    @Test
    public void testDeleteChildByIndex(){
        family.addChild(new Woman("Child2", "Doe", 2013));
        family.deleteChild(0);
        assertEquals(family.getChildren().size(),1);
    }

    @Test
    public void testDeleteChildByFakeIndex(){
        family.addChild(new Woman("Child2", "Doe", 2013));
        boolean res = family.deleteChild(5);
        assertEquals(res, false);
    }

    @Test
    public void testDeleteChildByReference(){
        Man newChild = new Man("Child2", "Surname", 2013);
        family.addChild(newChild);
        family.deleteChild(newChild);
        assertEquals(family.getChildren().size(),1);
    }

    @Test
    public void testDeleteChildByFakeReference(){
        Man newChild = new Man("Child2", "Surname", 2013);
        family.addChild(newChild);
        family.deleteChild(new Man("Child3", "Surname", 2013));
        assertEquals(family.getChildren().size(),2);
    }

    @Test
    public void testDeleteChildByFakeButEqualObject(){
        Man newChild = new Man("Child2", "Surname", 2013);
        family.addChild(newChild);
        family.deleteChild(new Man("Child2", "Surname", 2013));
        assertEquals(family.getChildren().size(),1);
    }

    @Test
    public void testAddChild(){
        family.addChild(new Woman("Child2", "Surname", 2013));
        assertEquals(family.getChild(1),new Woman("Child2", "Surname", 2013));
        assertEquals(family.getChildren().size(),2);
    }

    @Test
    public void testFamilyCount(){
        assertEquals(family.countFamily(),4);
    }

}
