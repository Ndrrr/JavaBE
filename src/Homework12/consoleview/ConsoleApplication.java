package Homework12.consoleview;

import Homework12.Context;
import Homework12.controller.FamilyController;
import Homework12.exception.FamilyOverflowException;
import Homework12.model.Abstract.AbstractHuman;
import Homework12.model.Concrete.Dog;
import Homework12.model.Concrete.Family;
import Homework12.model.Concrete.Man;
import Homework12.model.Concrete.Woman;

import java.util.Scanner;

public class ConsoleApplication {

    private final Context context = Context.getInstance();
    private final FamilyController familyController = context.getFamilyController();
    private final String lineDelimiter = "<<<---------------------------------------------------->>>\n";
    private final String commandList = "Available Commands: \n" +
            "- 0. Exit\n" +
            "- 1. Fill with test data\n" +
            "- 2. Display the entire list of families\n" +
            "- 3. Display a list of families where the number of people is greater than the specified number\n" +
            "- 4. Display a list of families where the number of people is less than the specified number\n" +
            "- 5. Calculate the number of families where the number of members is equal to the specified number\n" +
            "- 6. Create a new family\n" +
            "- 7. Delete a family\n" +
            "- 8. Edit a family by its index in the general list\n" +
            "- 9. Remove all children over the specified age\n"
            + lineDelimiter;

    public static void main(String[] args) {
        ConsoleApplication consoleApplication = new ConsoleApplication();
        consoleApplication.run();
    }
    public void run(){
        Scanner sc = context.getScanner();
        boolean isFinished = false;
        while(!isFinished){
            int command = getCommand(commandList);
            switch (command){
                case 0 -> isFinished = true;
                case 1 -> initDummyDataCommand();
                case 2 -> displayAllFamiliesCommand();
                case 3 -> displayBiggerThanCommand();
                case 4 -> displayLessThanCommand();
                case 5 -> displayNumberOfFamiliesEqualToCommand();
                case 6 -> createNewFamilyCommand();
                case 7 -> deleteFamilyCommand();
                case 8 -> updateFamilyCommand();
                case 9 -> removeAllChildrenOverGivenAgeCommand();
                default -> System.out.println("Incorrect Command.");
            }
            if(isFinished) {
                System.out.println("See you.");
                break;
            }
            System.out.println("Press `Enter` to continue.");
            sc.nextLine();
        }
    }

    private int getCommand(String commandList){
        System.out.println(commandList);
        System.out.print("Command: ");
        return ConsoleUtils.getCorrectInt();
    }

    private void displayLessThanCommand(){
        int value = ConsoleUtils.askSingleInt();
        printInsideLineDelimiters(
                Family.toPrettyFormat(
                        familyController.getFamiliesLessThan(value)));
    }

    private void displayBiggerThanCommand(){
        int value = ConsoleUtils.askSingleInt();
        printInsideLineDelimiters(
                Family.toPrettyFormat(
                        familyController.getFamiliesBiggerThan(value)));

    }

    private void displayAllFamiliesCommand(){
        printInsideLineDelimiters(
                Family.toPrettyFormat(familyController.getAllFamilies())
        );
    }

    private void displayNumberOfFamiliesEqualToCommand(){
        int value = ConsoleUtils.askSingleInt();
        printInsideLineDelimiters(familyController.countFamiliesWithMemberNumber(value));
    }
    private void createNewFamilyCommand(){
        System.out.println("Creating Mother...");
        AbstractHuman mother = ConsoleUtils.askHumanData(true);
        System.out.println("Creating Father...");
        AbstractHuman father = ConsoleUtils.askHumanData(false);
        familyController.createNewFamily(mother, father);
    }

    private void deleteFamilyCommand(){
        int familyCount = familyController.count();
        System.out.println("Enter id for deleting family");
        int id = ConsoleUtils.getCorrectInt(_id -> _id >= 0 && _id < familyCount, "Index out of bound");
        familyController.deleteFamilyByIndex(id);
        outSuccessMessage();
    }
    private void updateFamilyCommand(){
        Scanner sc = context.getScanner();
        String commandList = "- 1. Give birth to a baby\n" +
                "- 2. Adopt a child\n" +
                "- 3. Back to main menu.\n";
        boolean isFinished = false;
        while(!isFinished){
            int command = getCommand(commandList);
            switch (command){
                case 1 -> giveBirthCommand();
                case 2 -> adoptChildCommand();
                case 3 -> isFinished = true;
                default -> System.out.println("Incorrect command.");
            }
            if(isFinished) {
                break;
            }
            System.out.println("Press `Enter` to continue.");
            sc.nextLine();
        }
    }
    private void giveBirthCommand(){
        Scanner sc = context.getScanner();
        System.out.print("Please enter family id: ");
        int familyCount = familyController.count();
        int id = ConsoleUtils.getCorrectInt(_id -> _id >= 0 && _id < familyCount, "Index out of bound");
        System.out.print("Please enter male name: ");
        String maleName = sc.nextLine();
        System.out.print("Please enter female name: ");
        String femaleName = sc.nextLine();
        try {
            familyController.bornChild(familyController.getFamilyById(id), maleName, femaleName);
        }catch (FamilyOverflowException exception){
            System.out.println(exception.getMessage());
        }
    }
    private void adoptChildCommand(){
        System.out.print("Please enter family id: ");
        int familyCount = familyController.count();
        int id = ConsoleUtils.getCorrectInt(_id -> _id >= 0 && _id < familyCount, "Index out of bound");
        AbstractHuman child = ConsoleUtils.askHumanData(true);
        try {
            familyController.adoptChild(familyController.getFamilyById(id), child);
        }catch (FamilyOverflowException exception){
            System.out.println(exception.getMessage());
        }
    }


    private void removeAllChildrenOverGivenAgeCommand(){
        System.out.print("Enter age: ");
        int age = ConsoleUtils.getCorrectInt();
        familyController.deleteAllChildrenOlderThen(age);
        outSuccessMessage();
    }


    private void outFailMessage(){
        System.out.println("Failed!!!");
    }

    private void outSuccessMessage(){
        System.out.println("Successfully Done!!!");
    }

    private void printInsideLineDelimiters(Object obj){
        System.out.println(lineDelimiter);
        System.out.println(obj);
        System.out.println(lineDelimiter);
    }
    private void initDummyDataCommand(){
        AbstractHuman woman1 = new Woman("Jane", "Doe", 1990);
        AbstractHuman woman2 = new Woman("Jane2", "Doe2", 1990);
        AbstractHuman woman3 = new Woman("Jane2", "Doe2", 1990);

        AbstractHuman man1 = new Man("John", "Doe", 1990);
        AbstractHuman man2 = new Man("John2", "Doe2", 1990);
        AbstractHuman man3 = new Man("John3", "Doe3", 1990);

        familyController.createNewFamily(woman1, man1);
        familyController.createNewFamily(woman2, man2);
        familyController.createNewFamily(woman3, man3);
        Family fam0 = familyController.getFamilyById(0);
        familyController.bornChild(fam0, "Alex", "Elizabeth");
        Family fam1 = familyController.getFamilyById(1);
        familyController.adoptChild(fam1,new Man("Harry", "Brown",2018));
        fam1.addPet(new Dog("dog"));
        outSuccessMessage();
    }
}
