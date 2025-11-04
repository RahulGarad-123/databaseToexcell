package org.example.entity;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    // One-to-Many relationship with Cascade
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees = new ArrayList<>();

    public Department() {}
    public Department(String name) {
        this.name = name;
    }

    // helper methods
    public void addEmployee(Employee emp) {
        employees.add(emp);
        emp.setDepartment(this);
    }

    public void removeEmployee(Employee emp) {
        employees.remove(emp);
        emp.setDepartment(null);
    }

    // getters and setters
    public int getId() { return id; }
    public String getName() { return name; }
    public List<Employee> getEmployees() { return employees; }
    public void setName(String name) { this.name = name; }
}

