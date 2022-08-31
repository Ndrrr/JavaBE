package Homework12.dao.Concrete;

import Homework12.dao.Abstract.FamilyDao;
import Homework12.model.Concrete.Family;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    private List<Family> families;
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
        return true;
    }
    @Override
    public boolean deleteFamily(Family family) {
        int index = families.indexOf(family);
        if(index == -1)
            return false;
        return this.deleteFamily(index);
    }
    @Override
    public void saveFamily(Family family) {
        int index = families.indexOf(family);
        if(index == -1){
            families.add(family);
        }
        else {
            families.set(index, family);
        }
    }
    @Override
    public boolean updateFamily(int index, Family family){
        if(index < 0 || index >= families.size()) return false;
        families.set(index, family);
        return true;
    }
}
