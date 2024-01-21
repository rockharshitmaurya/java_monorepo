package com.crudWithAllDb.allDb.postgreSQl.dao;


import com.crudWithAllDb.allDb.postgreSQl.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createTable(){
        var query="CREATE TABLE student(id SERIAL PRIMARY KEY, name varchar(255) NOT NULL,city VARCHAR(255))";
        int update=jdbcTemplate.update(query);
        return update;
    }

    public int inserData(Integer id,String name,String city){
        String query="INSERT INTO Student(id,name,city) values(?,?,?)";
        int update=this.jdbcTemplate.update(query,id,name,city);
        return update;
    }

    public List<Student> getData(){
        String query="SELECT * FROM Student";
        List<Student> list=this.jdbcTemplate.query(query,(resultSet,index)->{
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setCity(resultSet.getString("city"));
            return student;
        });
        return list;
    }
    public int deleteStudent(Integer id){
        int row=0;

        String query="DELETE From Student where id=?";
        row=this.jdbcTemplate.update(query,id);
        return row;
    }

    public int updateByID(Integer id,String name,String city){
        String query="UPDATE Student SET name=?,city=? WHERE id=?";

        return this.jdbcTemplate.update(query,name,city,id);
    }
}
