package org.example.mapping;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Projects {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String projectName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees;
}
