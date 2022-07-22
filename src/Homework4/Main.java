package Homework4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // test features in Pet class
        Pet pet = new Pet("cat", "Molly");
        System.out.println(pet.toString());
        pet.eat();
        pet.respond();
        pet.foul();

        printPetFields(pet);

        pet.setSpecies("dog");
        pet.setNickName("Bobby");
        pet.setAge(2);
        pet.setTrickLevel(50);
        pet.setHabits(new String[]{"eat", "sleep", "play"});

        printPetFields(pet);

        Pet pet1 = new Pet("dog", "Rock", 5, 75,  new String[]{"eat", "drink", "sleep"});

        printPetFields(pet1);
        // test features in Human class



        Human Vito = new Human("Vito", "Karleone",1950);
        Human Rita = new Human("Jane", "Karleone",1950);
        Human Michael = new Human("Michael", "Karleone",1977,90
                ,pet1,Vito,Rita,new String[][]{{"eat"},{"drink"}, {"sleep"}});

        System.out.println(Michael.toString());
        System.out.println(Vito.toString());
        System.out.println(Rita.toString());
        System.out.println("----------------------------------------------------");

        Human father = new Human("John", "Smith", 1975, null,null );
        Human mother = new Human("Jane", "Smith", 1977);
        Human child = new Human("Jack", "Smith", 2000, 50,
                pet, mother, father, new String[][]{{"eat"},{"sleep"}, {"play"}});

        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child.toString());
        child.greetPet();
        child.describePet();
        child.feedPet(false);

        printHumanFields(child);

        child.setName("Jack");
        child.setSurname("Doe");
        child.setBirthYear(2000);
        child.setPet(pet);
        child.setMother(mother);
        child.setFather(father);
        child.setSchedule(new String[][]{{"eat"}, {"sleep"}, {"play"}});

        printHumanFields(child);


    }

    private static void printHumanFields(Human child) {
        System.out.println("----------------------------------------------------");
        System.out.println(child.getName());
        System.out.println(child.getSurname());
        System.out.println(child.getBirthYear());
        System.out.println(child.getPet());
        System.out.println(child.getMother());
        System.out.println(child.getFather());
        System.out.println(Arrays.deepToString(child.getSchedule()));
        System.out.println("----------------------------------------------------");
    }
    private static void printPetFields(Pet pet){
        System.out.println("----------------------------------------------------");
        System.out.println(pet.getSpecies());
        System.out.println(pet.getNickName());
        System.out.println(pet.getAge());
        System.out.println(pet.getTrickLevel());
        System.out.println(Arrays.deepToString(pet.getHabits()));
        System.out.println("----------------------------------------------------");
    }
}
