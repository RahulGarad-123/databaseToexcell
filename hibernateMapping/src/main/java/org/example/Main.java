package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.example.mapping.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        Address addr = new Address();
        addr.setCity("Pune");
        addr.setState("MH");
        addr.setPincode("411001");

        Department dept = new Department();
        dept.setName("IT");

        Skill skill = new Skill();
        skill.setSkillName("Java");

        Projects project = new Projects();
        project.setProjectName("Banking App");

        Employee emp = new Employee();
        emp.setName("Rahul");
        emp.setSalary(80000);
        emp.setAddress(addr);
        emp.setDepartment(dept);
        emp.setSkill(skill);
        emp.setProjects(Arrays.asList(project));

        Car car = new Car();
        car.setBrand("Honda");
        car.setSpeed(180);

        Bike bike = new Bike();
        bike.setBrand("Yamaha");
        bike.setType("Sport");

        session.persist(dept);
        session.persist(project);
        session.persist(emp);
        session.persist(car);
        session.persist(bike);

        session.getTransaction().commit();
        session.close();
        factory.close();

        System.out.println("✅ Data saved successfully!");
    }
}
