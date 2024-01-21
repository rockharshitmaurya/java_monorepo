package com.crudWithAllDb.allDb.mongodb.repo;

import com.crudWithAllDb.allDb.mongodb.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student,Integer> {
}
