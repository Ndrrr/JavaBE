package Homework13.service;

import Homework13.dao.Abstract.FamilyDao;
import Homework13.model.Abstract.AbstractHuman;
import Homework13.model.Abstract.AbstractPet;
import Homework13.model.Concrete.Family;
import Homework13.model.Concrete.Man;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyService {
    private final FamilyDao familyDao;
    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }
    public Family createNewFamily(AbstractHuman mother, AbstractHuman father) {
        Family family = new Family(mother, father);
        familyDao.saveFamily(family);
        return family;
    }
    public boolean updateFamily(int index, Family family){
        return familyDao.updateFamily(index, family);
    }
    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String maleName, String femaleName) {
        AbstractHuman child = family.bornChild();
        if(child instanceof Man){
            child.setName(maleName);
        }else{
            child.setName(femaleName);
        }
        familyDao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Family family, AbstractHuman child){
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }
    public void displayAllFamilies(){
        List<Family> families = getAllFamilies();
        int[] index = {0};
        families.stream().forEach(family -> System.out.println("["+ index[0]++ + "]" + family.prettyFormat()));
    }

    public List<Family> getFamiliesBiggerThan(int count){
        List<Family> families = getAllFamilies();
        return families.stream()
                .filter(family -> family.countFamily() > count)
                .collect(Collectors.toList());
    }
    public List<Family> getFamiliesLessThan(int count){
        List<Family> families = getAllFamilies();
        return families.stream()
                .filter(family -> family.countFamily() < count)
                .collect(Collectors.toList());
    }
    public int countFamiliesWithMemberNumber(int count){
        List<Family> families = getAllFamilies();
        return families.stream()
                .filter(family -> family.countFamily() == count)
                .toList().size();
    }

    public void deleteAllChildrenOlderThan(int age){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        List<Family> families = getAllFamilies();
        families.stream()
                .forEach(family -> {
                    List<AbstractHuman> children = family.getChildren();
                    List<AbstractHuman> deletedChildren = new ArrayList<>();
                    children.stream()
                            .filter(child -> child.getAge() > age)
                            .forEach(deletedChildren::add);
                    // for avoiding concurrent modification exception
                    deletedChildren.stream().forEach(family::deleteChild);
                    familyDao.saveFamily(family);
                });

    }
    public int count(){
        List<Family> families = getAllFamilies();
        return families.size();
    }
    public Family getFamilyById(int id){
        List<Family> families = getAllFamilies();
        if(id >= families.size() || id < 0){
            return null;
        }
        return families.get(id);
    }
    public List<AbstractPet> getPets(int index){
        List<Family> families = getAllFamilies();
        if(index >= families.size() || index < 0){
            return null;
        }
        return families.get(index).getPets().stream().toList();
    }
    public void addPet(int index, AbstractPet pet){
        List<Family> families = getAllFamilies();
        if(index >= families.size() || index < 0){
            return;
        }
        families.get(index).addPet(pet);
    }

    public void loadData(){
        familyDao.loadData();
    }
    public void saveData(){
        familyDao.saveData();
    }

}
