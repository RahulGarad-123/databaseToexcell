package org.example.entity;



import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee() {}
    public Employee(String name) {
        this.name = name;
    }

    // getters and setters
    public int getId() { return id; }
    public String getName() { return name; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}

