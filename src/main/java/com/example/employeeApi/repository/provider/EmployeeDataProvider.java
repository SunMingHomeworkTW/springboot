package com.example.employeeApi.repository.provider;

import com.example.employeeApi.model.Employee;

import java.util.Arrays;
import java.util.List;

public class EmployeeDataProvider {
    private List<Employee> employeeList = Arrays.asList(
            new Employee(0, "小明", 20, "男"),
            new Employee(1, "小红", 19, "女"),
            new Employee(2, "小智", 15, "男"),
            new Employee(3, "小刚", 16, "男"),
            new Employee(4, "小霞", 15, "女")
    );

    public List<Employee> getEmployeeList(){
        return employeeList;
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public Employee getEmployeeByName(String name) {
        for (Employee employee : employeeList) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public Employee createEmployee(Employee employee) throws Exception {
        if (getEmployeeById((int) employee.getId())!=null||employee.getAge() == 0 || employee.getName() == null || employee.getGender() == null) {
            throw new Exception("Invalid Employee!");
        }
        employeeList.add(employee);
        return employee;
    }

    public Employee deleteEmployee(int id) throws Exception {
        for(Employee employee:employeeList){
            if(employee.getId()==id){
                employeeList.remove(employee);
                return employee;
            }
        }

        throw new Exception("Employee not found by id: " + id);
    }

    public Employee updateEmployee(int id, Employee employee) throws Exception {
        if (employee.getAge() == 0 || employee.getName() == null || employee.getGender() == null) {
            throw new Exception("Invalid Employee!");
        }

        for(Employee originalEmployee:employeeList){
            if(employee.getId()==id){
                originalEmployee.setName(employee.getName());
                originalEmployee .setAge(employee.getAge());
                originalEmployee .setGender(employee.getGender());
                return originalEmployee;
            }
        }
        throw new Exception("Invalid Employee!");
    }
}
