package com.crudWithAllDb.allDb.mongodb.controller;


import com.crudWithAllDb.allDb.mongodb.models.Student;
import com.crudWithAllDb.allDb.mongodb.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    @Autowired
    StudentRepo studentRepo;
    @GetMapping("/")
    ResponseEntity<?> hello(){
        return ResponseEntity.ok("Welcome to the API");
    }

    @GetMapping("/add")
    ResponseEntity<?> addStudent(@RequestBody Student student){
        System.out.println(student);
        Student save=studentRepo.save(student);

        return ResponseEntity.ok(save);
    }

    @GetMapping("/students")
    ResponseEntity<?> findStudent(){
        return ResponseEntity.ok(studentRepo.findAll());
    }

    @GetMapping("/student/{studentId}")
    ResponseEntity<?> findById(@PathVariable Integer studentId){
        return ResponseEntity.ok(studentRepo.findById(studentId));
    }

    @PutMapping("/student/{id}")
    ResponseEntity<?> updateStudent(@PathVariable Integer id, @RequestBody Student updatedStudent) {
        if (studentRepo.existsById(id)) {
            System.out.println(updatedStudent);
            updatedStudent.setId(id);
            Student save = studentRepo.save(updatedStudent);
            return ResponseEntity.ok(save);
        } else {
            return ResponseEntity.badRequest().body("Student with id " + id + " not found");
        }
    }

    @DeleteMapping("/student/{studentId}")
    ResponseEntity<?> deleteById(@PathVariable Integer studentId){
        if(studentRepo.existsById(studentId))
            return ResponseEntity.ok("Student with id " + studentId + " deleted successfully");
        else
            return ResponseEntity.badRequest().body("Student with id " + studentId + " not found");

    }




}
