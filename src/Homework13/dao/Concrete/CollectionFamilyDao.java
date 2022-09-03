package Homework13.dao.Concrete;

import Homework13.Context;
import Homework13.dao.Abstract.FamilyDao;
import Homework13.datasaver.FamilyDataSaver;
import Homework13.log.Logger;
import Homework13.model.Concrete.Family;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    private List<Family> families;
    private Logger logger = Logger.getInstance();
    private final FamilyDataSaver familyDataSaver = Context.getInstance().getFamilyDataSaver();
    public CollectionFamilyDao() {
        this.families = new ArrayList<>();
    }

    public CollectionFamilyDao(List<Family> families) {
        this.families = families;
    }

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }
    @Override
    public Family getFamilyByIndex(int index) {
        return families.get(index);
    }
    @Override
    public boolean deleteFamily(int index) {
        if(index>=families.size() || index < 0){
            return false;
        }
        families.remove(index);
        logger.info("Family with index " + index + " was deleted");
        return true;
    }
    @Override
    public boolean deleteFamily(Family family) {
        int index = families.indexOf(family);
        if(index == -1)
            return false;
        logger.info("Family with index " + index + " was deleted");
        return this.deleteFamily(index);
    }
    @Override
    public void saveFamily(Family family) {
        int index = families.indexOf(family);
        if(index == -1){
            families.add(family);
            logger.info("Family was added");
        }
        else {
            families.set(index, family);
            logger.info("Family with index " + index + " was updated");
        }
    }
    @Override
    public boolean updateFamily(int index, Family family){
        if(index < 0 || index >= families.size()) return false;
        families.set(index, family);
        logger.info("Family with index " + index + " was updated");
        return true;
    }
    @Override
    public void loadData(){
        logger.info("Loading data from file");
        families =  familyDataSaver.load().orElse(new ArrayList<>());
    }
    @Override
    public void saveData(){
        logger.info("Saving data to file");
        familyDataSaver.save(families);
    }
}
