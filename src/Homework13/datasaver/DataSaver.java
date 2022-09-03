package Homework13.datasaver;

import java.util.List;
import java.util.Optional;

public interface DataSaver<T> {
    void save(List<T> t);
    Optional<List<T>> load();
}
