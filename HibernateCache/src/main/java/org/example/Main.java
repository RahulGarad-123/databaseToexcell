package org.example;

import org.example.entity.Student;
import org.example.util.hibernateutil;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class Main {
    public static void main(String[] args) {
        Session session1 = hibernateutil.getSessionFactory().openSession();
        Transaction tx1 = session1.beginTransaction();

        // Save a new Student
        Student s = new Student("Rahul", "Java");
        session1.save(s);

        tx1.commit();
        session1.close();

        System.out.println("\n---- First Session Closed ----");

        // Reopen session and fetch same entity (should use 2nd level cache)
        Session session2 = hibernateutil.getSessionFactory().openSession();
        Student cachedStudent = session2.get(Student.class, s.getId()); // First fetch from DB
        System.out.println("Fetched: " + cachedStudent);

        session2.close();

        System.out.println("\n---- Second Session Closed ----");

        // Third session: should fetch from 2nd-level cache, no SQL query
        Session session3 = hibernateutil.getSessionFactory().openSession();
        Student cachedAgain = session3.get(Student.class, s.getId()); // Should come from cache
        System.out.println("Fetched again: " + cachedAgain);

        session3.close();

        hibernateutil.getSessionFactory().close();
    }
}
