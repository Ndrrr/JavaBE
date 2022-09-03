package Homework13.controller;

import Homework13.exception.FamilyOverflowException;
import Homework13.model.Abstract.AbstractHuman;
import Homework13.model.Abstract.AbstractPet;
import Homework13.model.Concrete.Family;
import Homework13.service.FamilyService;

import java.util.List;

public class FamilyController {
    private final int MAX_FAMILY_SIZE = 6;

    private final FamilyService familyService;

    public FamilyController(FamilyService familyService){
        this.familyService = familyService;
    }
    public List<Family> getAllFamilies(){
        return familyService.getAllFamilies();
    }
    public void displayAllFamilies(){
        familyService.displayAllFamilies();
    }
    public List<Family> getFamiliesBiggerThan(int count){
        return familyService.getFamiliesBiggerThan(count);
    }
    public List<Family> getFamiliesLessThan(int count){
        return familyService.getFamiliesLessThan(count);
    }
    public int countFamiliesWithMemberNumber(int count){
        return familyService.countFamiliesWithMemberNumber(count);
    }
    public Family createNewFamily(Family family){
        return familyService.createNewFamily(family.getMother(), family.getFather());
    }
    public Family createNewFamily(AbstractHuman mother, AbstractHuman father){
        return familyService.createNewFamily(mother, father);
    }
    public boolean updateFamily(int id, Family family){
        return familyService.updateFamily(id, family);
    }
    public boolean deleteFamilyByIndex(int index){
        return familyService.deleteFamilyByIndex(index);
    }
    public Family bornChild(Family family, String maleName, String femaleName){
        if(count()>=MAX_FAMILY_SIZE) throw new FamilyOverflowException("Family size is too much");
        return familyService.bornChild(family, maleName, femaleName);
    }
    public Family adoptChild(Family family, AbstractHuman child){
        if(count()>=MAX_FAMILY_SIZE) throw new FamilyOverflowException("Family size is too much");
        return familyService.adoptChild(family, child);
    }
    public void deleteAllChildrenOlderThen(int age){
        familyService.deleteAllChildrenOlderThan(age);
    }
    public int count(){
        return familyService.count();
    }
    public Family getFamilyById(int id){
        return familyService.getFamilyById(id);
    }
    public List<AbstractPet> getPets(int id){
        return familyService.getPets(id);
    }
    public void addPet(int id, AbstractPet pet){
        familyService.addPet(id, pet);
    }
    public void loadData(){
        familyService.loadData();
    }
    public void saveData(){
        familyService.saveData();
    }
}
