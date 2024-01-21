package com.crudWithAllDb.allDb.postgreSQl.controller;


import com.crudWithAllDb.allDb.postgreSQl.entity.Student;
import com.crudWithAllDb.allDb.postgreSQl.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class PostgreSQLController {

    @Autowired
    StudentDao studentDao;

    @GetMapping("/create-table")
    int createTable(){
        return studentDao.createTable();
    }

    @GetMapping("/insert-data")
    int insertData(@RequestBody Student data){
        return studentDao.inserData(data.getId(),data.getName(),data.getCity());
    }

    @GetMapping("/get-data")
    List<Student> getData(){
        return studentDao.getData();
    }

    @DeleteMapping("/delete")
    int deleteStudent(@RequestBody HashMap<String,Integer> data){
        return studentDao.deleteStudent(data.get("id"));
    }

    @PutMapping("/update")
    int updateData(@RequestBody HashMap<String,String> data){
        return this.studentDao.updateByID(Integer.parseInt(data.get("id")),data.get("name"),data.get("city"));
    }

}

