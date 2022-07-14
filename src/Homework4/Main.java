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
        // Test of getters and setters

//        System.out.println(pet.getSpecies());
//        System.out.println(pet.getNickName());
//        System.out.println(pet.getAge());
//        System.out.println(pet.getTrickLevel());
//        System.out.println(Arrays.toString(pet.getHabits()));
//        pet.setSpecies("dog");
//        pet.setNickName("Bobby");
//        pet.setAge(2);
//        pet.setTrickLevel(50);
//        pet.setHabits(new String[]{"eat", "sleep", "play"});
//        System.out.println(pet.getSpecies());
//        System.out.println(pet.getNickName());
//        System.out.println(pet.getAge());
//        System.out.println(pet.getTrickLevel());


        // test features in Human class
        Human father = new Human("John", "Smith", 1975 );
        Human mother = new Human("Jane", "Smith", 1977);
        Human child = new Human("Jack", "Smith", 2000, 50,pet, mother, father, new String[][]{{"eat"},{"sleep"}, {"play"}});
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child.toString());
        child.greetPet();
        child.describePet();
        child.feedPet(false);


    }
}
