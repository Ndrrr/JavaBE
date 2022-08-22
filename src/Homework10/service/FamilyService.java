package Homework10.service;

import Homework10.dao.Abstract.FamilyDao;
import Homework10.model.Abstract.AbstractHuman;
import Homework10.model.Abstract.AbstractPet;
import Homework10.model.Concrete.Family;
import Homework10.model.Concrete.Man;

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
        for(int i = 0; i < families.size(); i++){
            System.out.println(i + ": " +families.get(i));
        }
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
        List<Integer> childrenForRemoval = new ArrayList<>();

        for(Family family : families){
            childrenForRemoval.clear();
            for(int i = 0; i < family.getChildren().size(); i++){
                if(currentYear-family.getChildren().get(i).getBirthDate() > age){
                    childrenForRemoval.add(i);
                }
            }
            for(int i = childrenForRemoval.size()-1; i >= 0; i--){
                family.deleteChild(childrenForRemoval.get(i));
            }
            familyDao.saveFamily(family);
        }
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
}
