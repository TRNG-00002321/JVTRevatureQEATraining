package com.revature.jsonio.service;

import com.revature.jsonio.dao.EmployeeJSONDAO;
import com.revature.jsonio.model.Employee;
import java.io.File;
import java.util.List;
import java.util.Optional;

public class EmployeeService implements ExampleService<Employee> {
    private EmployeeJSONDAO empManager;

    public EmployeeService() {
        empManager = new EmployeeJSONDAO();
    }

    public EmployeeService(File file) {
        empManager = new EmployeeJSONDAO(file);
    }

    @Override
    public List<Employee> getAll() {
        return empManager.getAll();
    }

    @Override
    public Optional<Employee> get(int id) {
        return empManager.get(id);
    }

    @Override
    public void save(Employee obj) {
        empManager.save(obj);
    }
}
