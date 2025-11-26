package com.revature.jsonio.dao;

import java.util.List;
import java.util.Optional;

public interface ExampleDAO<T> {
    List<T> getAll();
    Optional<T> get(int id);
    void save(T obj);
}
