package Homework11;


import Homework11.model.Concrete.Man;

public class Main {
    public static void main(String[] args) {
        run();
    }

    static void run(){
        Man human = new Man("Name", "Surname", "12/10/2003", 32);
        System.out.println(human);

    }


}
