package Homework13;

import Homework13.controller.FamilyController;
import Homework13.dao.Abstract.FamilyDao;
import Homework13.dao.Concrete.CollectionFamilyDao;
import Homework13.datasaver.FamilyDataSaver;
import Homework13.datasaver.impl.FamilyFileSaver;
import Homework13.log.Logger;
import Homework13.service.FamilyService;

import java.util.Scanner;

public class Context {
    private static Context instance;
    private FamilyDao familyDao;
    private FamilyService familyService;
    private FamilyController familyController;
    private Scanner scanner;
    private FamilyDataSaver familyDataSaver;

    private Context(){
    }

    public static Context getInstance(){
        if(instance == null){
            instance = new Context();
        }
        return instance;
    }

    public FamilyDao getFamilyDao(){
        if(familyDao == null)
            familyDao = new CollectionFamilyDao();

        return familyDao;
    }
    public FamilyService getFamilyService(){
        if(familyService == null){
            familyService = new FamilyService(getFamilyDao());
        }
        return familyService;
    }
    public FamilyController getFamilyController(){
        if(familyController == null){
            familyController = new FamilyController(getFamilyService());
        }
        return familyController;
    }
    public Scanner getScanner(){
        if(scanner == null)
            scanner = new Scanner(System.in);
        return scanner;
    }
    public FamilyDataSaver getFamilyDataSaver(){
        if(familyDataSaver == null)
            familyDataSaver = new FamilyFileSaver();
        return familyDataSaver;
    }
}
