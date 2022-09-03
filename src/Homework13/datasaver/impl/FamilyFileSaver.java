package Homework13.datasaver.impl;

import Homework13.datasaver.FamilyDataSaver;
import Homework13.log.Logger;
import Homework13.model.Concrete.Family;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FamilyFileSaver implements FamilyDataSaver {
    private final String path = "family.txt";
    private Logger logger = Logger.getInstance();


    @Override
    public void save(List<Family> t) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(t);
        } catch (IOException e) {
            logger.error("Error while saving data");
            e.printStackTrace();
        }
    }

    @Override
    public Optional<List<Family>> load() {
        File file = new File(path);
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = reader.readObject();
            if (obj instanceof List
                    && ((List) obj).stream().allMatch(o -> o instanceof Family)) {

                return Optional.of(new ArrayList<>((List<Family>) obj));
            }
        }catch (Exception e){
            logger.error("Error while loading data from file");
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
