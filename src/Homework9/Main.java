package Homework9;


import Homework9.controller.FamilyController;
import Homework9.dao.Concrete.CollectionFamilyDao;
import Homework9.model.Concrete.Dog;
import Homework9.model.Concrete.Family;
import Homework9.model.Concrete.Man;
import Homework9.model.Concrete.Woman;
import Homework9.service.FamilyService;

public class Main {
    public static void main(String[] args) {
        run();
    }

    static void run(){
        // create FamilyController and call all methods
        FamilyController familyController = new FamilyController(new FamilyService(new CollectionFamilyDao()));
        familyController.createNewFamily(getTestFamily("Jane", "John"));
        familyController.createNewFamily(getTestFamily("Jane2", "John2"));
        familyController.createNewFamily(getTestFamily("Jane3", "John3"));
        Family fam0 = familyController.getFamilyById(0);
        familyController.bornChild(fam0, "Alex", "Elizabeth");
        Family fam1 = familyController.getFamilyById(1);
        familyController.adoptChild(fam1,new Man("Harry", "Brown",2019));
        familyController.displayAllFamilies();
        fam1.addPet(new Dog("dog"));
        consoleLineSeparator();
        System.out.println(familyController.getAllFamilies());
        consoleLineSeparator();
        System.out.println(familyController.getFamiliesBiggerThan(3));
        consoleLineSeparator();
        System.out.println(familyController.getFamiliesLessThan(4));
        consoleLineSeparator();
        System.out.println(familyController.countFamiliesWithMemberNumber(2));
        consoleLineSeparator();
        System.out.println(familyController.deleteFamilyByIndex(2));
        consoleLineSeparator();
        familyController.deleteAllChildrenOlderThen(2);
        consoleLineSeparator();
        System.out.println(familyController.count());
        consoleLineSeparator();
        System.out.println(familyController.getPets(0));

    }

    static Family getTestFamily(String motherName, String fatherName){
        Family family = new Family(new Woman(motherName, "Doe", 1990), new Man(fatherName, "Doe", 1990));
        return family;
    }
    static void consoleLineSeparator(){
        System.out.println("----------------------------------------------------");
    }
}
