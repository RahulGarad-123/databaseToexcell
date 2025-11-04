package org.example.mapping;
import jakarta.persistence.Entity;

@Entity
public class Bike extends Vehicle {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
