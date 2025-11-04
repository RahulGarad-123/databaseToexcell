package org.example.controller;


import org.example.model.Employee;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Employee> getAllEmployees() {
        return List.of(
                new Employee(1L, "Rahul", "IT", 50000.0),
                new Employee(2L, "Priya", "HR", 40000.0),
                new Employee(3L, "Amit", "Finance", 45000.0)
        );
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Employee getEmployeeById(@PathVariable Long id) {
        return new Employee(id, "Test User", "IT", 60000.0);
    }
}

