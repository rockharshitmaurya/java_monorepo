package com.spring.crudjpa.dao;

import com.spring.crudjpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{


    //define field for entity manager
    private EntityManager entityManager;


    //inject intity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implment save method
    @Override
    @Transactional
    public void save(Student student){
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> query=entityManager.createQuery("FROM Student",Student.class);

        List<Student> result=query.getResultList();

        return result;
    }

    @Override
    public List<Student> findByLastName(String str) {
        TypedQuery<Student> query=entityManager.createQuery("FROM Student where last_name=:lastName",Student.class);
        query.setParameter("lastName",str);
        List<Student> result=query.getResultList();
        return result;
    }

    @Override
    @Transactional
    public boolean updateStudentById(Integer id) {

        Student student=entityManager.find(Student.class,2);

        student.setLast_name("Kumar");

        Student updatedStudent=entityManager.merge(student);

        return updatedStudent!=null;
    }

    @Override
    @Transactional
    public boolean updateStudentByQueryLastName(String lastname) {
        Query query=entityManager.createQuery("UPDATE Student set last_name=:lastName");
        query.setParameter("lastName",lastname);
        Integer updatedRows=query.executeUpdate();
        return updatedRows!=0;
    }

    @Override
    @Transactional
    public void deleteStudentById(Integer id) {
        Student student=entityManager.find(Student.class,id);
        entityManager.remove(student);
        if(student!=null){
            System.out.println("Stdent With Id "+id+" is Deleted");
        }else{
            System.out.println("Student with id "+id+" is Deleted");
        }
    }

    @Override
    @Transactional
    public void deleteStudentByLastName(String last_name) {
        Query query=entityManager.createQuery("DELETE from Student where last_name=:lastName");
        query.setParameter("lastName",last_name);
        int rowsAffected=query.executeUpdate();
        if(rowsAffected!=0){
            System.out.println("Matching Rows Deleted");
        }else {
            System.out.println("No Matching Rows Found");
        }
    }
}
