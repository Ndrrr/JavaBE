package Homework12;

import Homework12.controller.FamilyController;
import Homework12.dao.Abstract.FamilyDao;
import Homework12.dao.Concrete.CollectionFamilyDao;
import Homework12.service.FamilyService;

import java.util.Scanner;

public class Context {
    private static Context instance;
    private FamilyDao familyDao;
    private FamilyService familyService;
    private FamilyController familyController;
    private Scanner scanner;


    private Context(){
        familyDao = new CollectionFamilyDao();
        familyService = new FamilyService(familyDao);
        familyController = new FamilyController(familyService);
        scanner = new Scanner(System.in);
    }

    public static Context getInstance(){
        if(instance == null){
            instance = new Context();
        }
        return instance;
    }

    public FamilyDao getFamilyDao(){
        return familyDao;
    }
    public FamilyService getFamilyService(){return familyService;}
    public FamilyController getFamilyController(){return familyController;}
    public Scanner getScanner(){return scanner;}
}
