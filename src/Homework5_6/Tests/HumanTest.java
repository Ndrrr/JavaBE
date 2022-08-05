package Homework5_6.Tests;

import Homework5_6.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HumanTest {
    private Human getDefaultHuman(){
        return new Human("Name", "Surname", 1990);
    }
    private Human getDefaultHumanWithFamily(){
        Human human = getDefaultHuman();
        human.setFamily(new Family(new Human("Mother", "Surname", 1990), new Human("Father", "Surname", 1990)));
        return human;
    }
    @Test
    public void testHumanEquals(){
        Human human1 = getDefaultHuman();
        Human human2 = getDefaultHuman();
        assertTrue(human1.equals(human2));
        Human human3 = new Human("Name", "Surname", 1991, new Family(new Human("Mother", "Surname", 1990), new Human("Father", "Surname", 1990)));
        Human human4 = new Human("Name", "Surname", 1991, new Family(new Human("Mother", "Surname", 1990), new Human("Father", "Surname", 1990)));
        assertEquals(human3, human4);
    }
    @Test
    public void testHumanNotEquals(){
        Human human1 = getDefaultHuman();
        Human human2 = new Human("Name", "Suname", 1990);
        assertFalse(human1.equals(human2));
    }

    @Test
    public void testHumanToString(){
        String[][] schedule = new String[7][];
        schedule[DayOfWeek.MONDAY.ordinal()] = new String[]{"1", "2", "3"};
        schedule[DayOfWeek.TUESDAY.ordinal()] = new String[]{"4", "5", "6"};

        Human human1 = new Human("Name", "Surname", 1990, 666, schedule);

        assertEquals(
                "Human{name='Name', surname='Surname', birthYear=1990, iq=666, schedule=[[Day 1: null], [Day 2: 1 2 3 ], [Day 3: 4 5 6 ], [Day 4: null], [Day 5: null], [Day 6: null], [Day 7: null]]}",
                human1.toString());
    }

    @Test
    public void testFeedPetTrue(){
        Human human1 = getDefaultHumanWithFamily();
        human1.getFamily().setPet(new Pet(AnimalSpecies.DOG, "Pet"));
        assertTrue(human1.feedPet(true));
    }

    @Test
    public void testFeedPetFalse(){
        Human human1 = getDefaultHumanWithFamily();
        human1.getFamily().setPet(new Pet(AnimalSpecies.DOG, "Pet"));
        assertFalse(human1.feedPet(false));
    }
}
