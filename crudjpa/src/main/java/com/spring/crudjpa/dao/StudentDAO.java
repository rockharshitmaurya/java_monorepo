package com.spring.crudjpa.dao;

import com.spring.crudjpa.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
    List<Student> findAll();

    List<Student> findByLastName(String str); //JP QL Version

    boolean updateStudentById(Integer id);

    boolean updateStudentByQueryLastName(String lastname);

    void deleteStudentById(Integer id);
    void deleteStudentByLastName(String last_name);
}
