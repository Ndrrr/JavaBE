package Homework10;


import Homework10.controller.FamilyController;
import Homework10.dao.Concrete.CollectionFamilyDao;
import Homework10.model.Abstract.AbstractHuman;
import Homework10.model.Concrete.Dog;
import Homework10.model.Concrete.Family;
import Homework10.model.Concrete.Man;
import Homework10.model.Concrete.Woman;
import Homework10.service.FamilyService;

public class Main {
    public static void main(String[] args) {
        run();
    }

    static void run(){
        Man human = new Man("Name", "Surname", "12/10/2003", 32);
        System.out.println(human);

    }


}
