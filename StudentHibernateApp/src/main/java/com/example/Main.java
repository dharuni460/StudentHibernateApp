package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {

        // Create Student object
        Student student = new Student(
                1,
                "Dharuni",
                "dharuni@gmail.com",
                "AI & DS"
        );

        // INSERT student into database
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(student);

        transaction.commit();
        session.close();

        System.out.println("Student inserted successfully!");

        // VERIFY INSERT
        session = HibernateUtil.getSessionFactory().openSession();

        Student insertedStudent = session.get(Student.class, 1);

        System.out.println("Inserted Student:");
        System.out.println(insertedStudent);

        session.close();

        // UPDATE student
        session = HibernateUtil.getSessionFactory().openSession();

        transaction = session.beginTransaction();

        Student studentToUpdate = session.get(Student.class, 1);

        studentToUpdate.setCourse("Data Science");

        transaction.commit();
        session.close();

        System.out.println("Student updated successfully!");

        // VERIFY UPDATE
        session = HibernateUtil.getSessionFactory().openSession();

        Student updatedStudent = session.get(Student.class, 1);

        System.out.println("Updated Student:");
        System.out.println(updatedStudent);

        session.close();

        HibernateUtil.getSessionFactory().close();
    }
}