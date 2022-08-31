package Homework12.dao.Abstract;

import Homework12.model.Concrete.Family;

import java.util.List;

public interface FamilyDao {
    List<Family> getAllFamilies();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family family);
    void saveFamily(Family family);
    boolean updateFamily(int index, Family family);
}
