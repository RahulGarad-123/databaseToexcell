package org.example.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Salary cannot be null")
    @Min(value = 10000, message = "Salary must be at least 10000")
    private Double salary;

    @Size(min = 2, max = 30, message = "Department must be between 2 and 30 characters")
    private String department;

    // Getters & Setters
}

