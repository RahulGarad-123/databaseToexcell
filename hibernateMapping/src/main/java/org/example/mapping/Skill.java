package org.example.mapping;
import jakarta.persistence.*;

@Entity
public class Skill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String skillName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
