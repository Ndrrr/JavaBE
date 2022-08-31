package Homework12.Tests;

import Homework12.dao.Concrete.CollectionFamilyDao;
import Homework12.model.Abstract.AbstractHuman;
import Homework12.model.Concrete.Dog;
import Homework12.model.Concrete.Family;
import Homework12.model.Concrete.Man;
import Homework12.model.Concrete.Woman;
import Homework12.service.FamilyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FamilyServiceTest {
    private FamilyService familyService;
    @BeforeEach
    public void init(){
        familyService = new FamilyService(new CollectionFamilyDao());
        AbstractHuman woman1 = new Woman("Jane", "Doe", 1990);
        AbstractHuman woman2 = new Woman("Jane2", "Doe2", 1990);
        AbstractHuman woman3 = new Woman("Jane2", "Doe2", 1990);

        AbstractHuman man1 = new Man("John", "Doe", 1990);
        AbstractHuman man2 = new Man("John2", "Doe2", 1990);
        AbstractHuman man3 = new Man("John3", "Doe3", 1990);

        familyService.createNewFamily(woman1, man1);
        familyService.createNewFamily(woman2, man2);
        familyService.createNewFamily(woman3, man3);
        Family fam0 = familyService.getFamilyById(0);
        familyService.bornChild(fam0, "Alex", "Elizabeth");
        Family fam1 = familyService.getFamilyById(1);
        familyService.adoptChild(fam1,new Man("Harry", "Brown",2018));
        fam1.addPet(new Dog("dog"));

    }

    @Test
    public void testCreateFamily(){
        AbstractHuman woman4 = new Woman("Jane4", "Doe4", 1990);
        AbstractHuman man4 = new Man("John4", "Doe4", 1990);
        familyService.createNewFamily(woman4, man4);
        familyService.displayAllFamilies();
        int expected = 4;
        assertEquals(4, familyService.count());
    }

    @Test
    public void testGetFamiliesBiggerThan() {
        int actual = familyService.getFamiliesBiggerThan(3).size();
        assertEquals(1, actual);
    }

    @Test
    public void testGetFamiliesLessThan() {
        int actual = familyService.getFamiliesLessThan(4).size();
        assertEquals(2, actual);
    }

    @Test
    public void testCountFamiliesWithMemberNumber(){
        int actual = familyService.countFamiliesWithMemberNumber(2);
        assertEquals(1, actual);
    }

    @Test
    public void testDeleteFamilyByIndex(){
        familyService.deleteFamilyByIndex(1);
        int actual = familyService.count();
        assertEquals(2, actual);
    }

    @Test
    public void testDeleteFamilyByFakeIndex(){
        familyService.deleteFamilyByIndex(10);
        int actual = familyService.count();
        assertEquals(3, actual);
    }

    @Test
    public void testDeleteAllChildrenOlderThen(){
        familyService.deleteAllChildrenOlderThan(2);
        int actual = familyService.getFamilyById(1).countFamily();
        assertEquals(3, actual);
    }

    @Test
    public void testBornChildNaming(){
        Family fam0 = familyService.getFamilyById(0);
        familyService.bornChild(fam0, "Steve", "Anna");
        AbstractHuman child = fam0.getChild(1);
        String expected = "Steve";
        if(child instanceof Woman){
            expected = "Anna";
        }

        assertEquals(expected, child.getName());
    }

    @Test
    public void testCount(){
        assertEquals(3, familyService.count());
    }

    @Test
    public void testGetPets(){
        int actual = familyService.getPets(1).size();
        assertEquals(1, actual);
    }

    @Test
    public void testAdoptChild(){
        AbstractHuman child = new Man("Jack", "Kline", 2010);
        Family fam0 = familyService.getFamilyById(0);
        familyService.adoptChild(fam0, child);
        int actual = familyService.getFamilyById(0).countFamily();
        assertEquals(4, actual);
    }
}
