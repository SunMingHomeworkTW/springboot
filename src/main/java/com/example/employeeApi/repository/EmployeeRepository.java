package com.example.employeeApi.repository;

import com.example.employeeApi.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee createEmployee(Employee employee) throws Exception;
    Employee deleteEmployee(int id) throws Exception;
    Employee updateEmployee(int id, Employee employee) throws Exception;
    Employee getEmployeeById(int id);
    Employee getEmployeeByName(String name);
    List<Employee> getAllEmployees();
}
