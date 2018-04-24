package com.example.employeeApi.controller;


import com.example.employeeApi.model.Employee;
import com.example.employeeApi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

//    @RequestMapping(value = "/employees",produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/employees")
    @ResponseBody
    List<Employee> getEmployees(Model model) {
        return employeeRepository.getAllEmployees();
    }

    @GetMapping("/employeesById/{id}")
    ResponseEntity getEmployeeById(@PathVariable("id") int id) {
        return new ResponseEntity<>(employeeRepository.getEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping("/employeesByName/{name}")
    ResponseEntity getEmployeeByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(employeeRepository.getEmployeeByName(name), HttpStatus.OK);
    }
}
