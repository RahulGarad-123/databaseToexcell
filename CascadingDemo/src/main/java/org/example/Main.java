package org.example;

import org.example.entity.*;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // Create Department
        Department dept = new Department("IT");

        // Create Employees
        Employee e1 = new Employee("Rahul");
        Employee e2 = new Employee("Raju");

        // Add employees to department
        dept.addEmployee(e1);
        dept.addEmployee(e2);

        // Save only department (CascadeType.ALL will save employees)
        session.save(dept);

        tx.commit();
        session.close();

        System.out.println("✅ Department and employees saved successfully via cascading!");
    }
}
