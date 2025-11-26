package com.revature.jsonio.dao;

import com.revature.jsonio.model.Student;
import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.ObjectWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentJSONDAO implements ExampleDAO<Student> {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();

    private File file;

    public StudentJSONDAO() {
        this.file = new File("example.json");
    }

    public StudentJSONDAO(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public List<Student> getAll() {
        List<Student> students;
        try {
            if (file.exists() && file.length() > 0) {
                students = objectMapper.readValue(file, new TypeReference<>() {});
            } else {
                students = new ArrayList<>();
            }
        } catch (JacksonException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public Optional<Student> get(int id) {
        List<Student> students = getAll();
        return students.stream().filter(student -> student.getId() == id).findFirst();
    }

    @Override
    public void save(Student obj) {
        List<Student> students = getAll();
        students.add(obj);
        try {
            objectWriter.writeValue(file, students);
        } catch (JacksonException e) {
            throw new RuntimeException(e);
        }
    }
}
