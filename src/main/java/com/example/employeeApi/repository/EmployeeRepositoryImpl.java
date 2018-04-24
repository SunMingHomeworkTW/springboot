package com.example.employeeApi.repository;

import com.example.employeeApi.model.Employee;
import com.example.employeeApi.repository.provider.EmployeeDataProvider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository{
    private EmployeeDataProvider employeeDataProvider = new EmployeeDataProvider();

    @Override
    public Employee createEmployee(Employee employee) throws Exception {
        return employeeDataProvider.createEmployee(employee);
    }

    @Override
    public Employee deleteEmployee(int id) throws Exception {
        return employeeDataProvider.deleteEmployee(id);
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) throws Exception {
        return employeeDataProvider.updateEmployee(id,employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDataProvider.getEmployeeById(id);
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return employeeDataProvider.getEmployeeByName(name);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDataProvider.getEmployeeList();
    }
}
