package com.revature.jsonio.service;

import com.revature.jsonio.dao.StudentJSONDAO;
import com.revature.jsonio.model.Student;
import java.io.File;
import java.util.List;
import java.util.Optional;

public class StudentService implements ExampleService<Student> {
    private final StudentJSONDAO studentManager;

    public StudentService() {
        this.studentManager = new StudentJSONDAO();
    }

    public StudentService(File file) {
        this.studentManager = new StudentJSONDAO(file);
    }

    @Override
    public List<Student> getAll() {
        return studentManager.getAll();
    }

    @Override
    public Optional<Student> get(int id) {
        return studentManager.get(id);
    }

    @Override
    public void save(Student obj) {
        studentManager.save(obj);
    }
}
