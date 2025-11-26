package com.revature.jsonio.service;

import java.util.List;
import java.util.Optional;

public interface ExampleService<T> {
    List<T> getAll();
    Optional<T> get(int id);
    void save(T obj);
}
