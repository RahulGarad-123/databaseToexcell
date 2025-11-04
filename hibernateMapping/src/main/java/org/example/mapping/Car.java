package org.example.mapping;
import jakarta.persistence.Entity;

@Entity
public class Car extends Vehicle {
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private int speed;
}
