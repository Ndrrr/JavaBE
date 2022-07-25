package Homework6.Tests;

import Homework6.Abstract.*;
import Homework6.Concrete.*;
import Homework6.Enums.DayOfWeek;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HumanTest {
    private AbstractHuman getDefaultHuman(){
        return new Man("Jin", "Kazama", 1990);
    }
    private Man getDefaultHumanWithFamily(){
        Man human = (Man) getDefaultHuman();
        human.setFamily(new Family(new Woman("Jun", "Kazama", 1970), new Man("Kazuya", "Mishima", 1970)));
        return human;
    }
    @Test
    public void testHumanEquals(){
        AbstractHuman human1 = getDefaultHuman();
        AbstractHuman human2 = getDefaultHuman();
        assertTrue(human1.equals(human2));
    }
    @Test
    public void testHumanNotEquals(){
        AbstractHuman human1 = getDefaultHuman();
        AbstractHuman human2 = new Man("Jhin", "Kazama", 1990);
        assertFalse(human1.equals(human2));
    }

    @Test
    public void testHumanToString(){
        String[][] schedule = new String[7][];
        schedule[DayOfWeek.MONDAY.ordinal()] = new String[]{"1", "2", "3"};
        schedule[DayOfWeek.TUESDAY.ordinal()] = new String[]{"4", "5", "6"};

        Woman human1 = new Woman("Name", "Surname", 1990, 666, schedule);

        assertEquals(human1.toString(),
                "Human{name='Name', surname='Surname', birthYear=1990, iq=666, schedule=[[Day 1: null], [Day 2: 1 2 3 ], [Day 3: 4 5 6 ], [Day 4: null], [Day 5: null], [Day 6: null], [Day 7: null]]}");
    }

    @Test
    public void testFeedPetTrue(){
        Man human1 = getDefaultHumanWithFamily();
        human1.getFamily().setPet(new Dog( "Pet"));
        assertTrue(human1.feedPet(true));
    }

    @Test
    public void testFeedPetFalse(){
        Man human1 = getDefaultHumanWithFamily();
        human1.getFamily().setPet(new Dog("Pet"));
        assertFalse(human1.feedPet(false));
    }
}
