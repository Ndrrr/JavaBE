package Homework13.Tests;

import Homework13.model.Abstract.AbstractHuman;
import Homework13.model.Concrete.Dog;
import Homework13.model.Concrete.Family;
import Homework13.model.Concrete.Man;
import Homework13.model.Concrete.Woman;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void testFeedPetTrue(){
        Man human1 = getDefaultHumanWithFamily();
        human1.getFamily().addPet(new Dog( "Pet"));
        assertTrue(human1.feedPets(true));
    }

    @Test
    public void testFeedPetFalse(){
        Man human1 = getDefaultHumanWithFamily();
        human1.getFamily().addPet(new Dog("Pet"));
        assertFalse(human1.feedPets(false));
    }
}
