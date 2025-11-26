package com.revature.jsonio.dao;

import com.revature.jsonio.model.Employee;
import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.ObjectWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeJSONDAO implements ExampleDAO<Employee> {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
    private File file;

    public EmployeeJSONDAO() {
        file = new File("example.json");
    }

    public EmployeeJSONDAO(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> emps;
        try {
            if (file.exists() && file.length() > 0) {
                emps = objectMapper.readValue(file, new TypeReference<List<Employee>>() {});
            } else {
                emps = new ArrayList<>();
            }
        } catch (JacksonException e) {
            throw new RuntimeException(e);
        }
        return emps;
    }

    @Override
    public Optional<Employee> get(int id) {
        List<Employee> emps = getAll();
        return emps.stream().filter(employee -> employee.getId() == id).findFirst();
    }

    @Override
    public void save(Employee obj) {
        List<Employee> emps = getAll();
        emps.add(obj);
        try {
            objectWriter.writeValue(file, emps);
        } catch (JacksonException e) {
            throw new RuntimeException(e);
        }
    }
}
