package Homework13;


import Homework13.datasaver.impl.FamilyFileSaver;
import Homework13.model.Concrete.Dog;
import Homework13.model.Concrete.Family;
import Homework13.model.Concrete.Man;
import Homework13.model.Concrete.Woman;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        run();
    }

    static void run(){
        Family family = new Family(new Woman("Jane", "Doe", 1990), new Man("John", "Doe", 1031656317000L));
        family.addChild(new Man("Anton", "Doe", 2011));
        family.addPet(new Dog("Pet"));
        FamilyFileSaver ffs = new FamilyFileSaver();
        Optional<List<Family>> families = ffs.load();
        if(families.isPresent()) System.out.println(families.get().get(0));
        System.out.println(family.getFather().describeAge());
        System.out.println(Calendar.getInstance().get(Calendar.YEAR));
    }
}
