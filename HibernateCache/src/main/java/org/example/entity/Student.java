package org.example.entity;



import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String course;

    public Student() {}
    public Student(String name, String course) {
        this.name = name;
        this.course = course;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public void setName(String name) { this.name = name; }
    public void setCourse(String course) { this.course = course; }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', course='" + course + "'}";
    }
}

