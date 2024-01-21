package com.spring.crudjpa;

import com.spring.crudjpa.dao.StudentDAO;
import com.spring.crudjpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudjpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
//			 createStudent(studentDAO);
//			 readStudentByid(studentDAO);
//			 readAll(studentDAO);
//			 readByLastName(studentDAO);
//			 updateStudent(studentDAO);
//			 updateStudentByQuery(studentDAO);
//			 removeStudentById(studentDAO);
//			 removeStudentByLastNameQuery(studentDAO);
		};
	}

	private void removeStudentByLastNameQuery(StudentDAO studentDAO) {
		studentDAO.deleteStudentByLastName("Maurya");
	}

	private void removeStudentById(StudentDAO studentDAO) {
		studentDAO.deleteStudentById(1);
	}

	private void updateStudentByQuery(StudentDAO studentDAO) {
		boolean status=studentDAO.updateStudentByQueryLastName("Kumar");
		if(status){
			System.out.println("All Rows Updated Who's lastName is Matched");
		}else{
			System.out.println("No Rows foud with the lastName provided");
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		boolean status=false;

		status=studentDAO.updateStudentById(2);
		if(status){
			System.out.println("Student with the id : 2 is Updated");
		}else{
			System.out.println("Student Not Found With ID");
		}
	}

	private void readByLastName(StudentDAO studentDAO) {
		System.out.println("List of Student who's last name is : Maurya");
		List<Student> result=studentDAO.findByLastName("Maurya");
		for(Student student:result){
			System.out.println(student);
		}
	}

	private void readAll(StudentDAO studentDAO) {
		System.out.println("List Of All Students :");
		List<Student> result=studentDAO.findAll();
		for(Student student:result){
			System.out.println(student);
		}
	}

	private void readStudentByid(StudentDAO studentDAO) {
		System.out.println("Data Found At : "+studentDAO.findById(1));
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object....");
		Student tempStudent=new Student("Bipul","Kumar","bipulkumar.cse@gmail.com");

		//save the student object
		System.out.println("Saving the student object....");
		studentDAO.save(tempStudent);

		//display id of the saved object
		System.out.println("Saved Student Genrated Id:"+tempStudent.getId());
	}
}
