package Homework13.dao.Abstract;

import Homework13.model.Concrete.Family;

import java.util.List;

public interface FamilyDao {
    List<Family> getAllFamilies();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family family);
    void saveFamily(Family family);
    boolean updateFamily(int index, Family family);
    void loadData();
    void saveData();
}
