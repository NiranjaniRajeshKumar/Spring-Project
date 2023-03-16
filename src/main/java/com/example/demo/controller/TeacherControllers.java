package com.example.demo.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Teacher;
import com.example.demo.service.TeacherServImpl;

@RestController

public class TeacherControllers {

	//no need to add autowired annotation
	//whenever there is only one attr injection is performed without annotation
	//perofermed injection here is CI
	public TeacherServImpl empServ;
	
	
	
	public TeacherControllers(TeacherServImpl empServ) {
		this.empServ = empServ;
	}



	@PostMapping("/saveTeacher")
	/*@requestBody --> {
	   "firstName" : "janani",
	   "lastName" : "viswa",
	   "email" : "janani@123"
	}   --> emp*/
	public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher tec){
		return new ResponseEntity<Teacher>(empServ.saveTeacher(tec), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/updateTeacher/{teacherId}")
	public ResponseEntity<Teacher> updateTeacherDetailsById(@PathVariable("teacherId") int teacher_id,
			@RequestBody Teacher tec){
		return new ResponseEntity<Teacher>(empServ.updateTeacherDetails(tec, teacher_id), HttpStatus.OK);
		
	}
	@GetMapping("/readAllTeacher")
	public List<Teacher> getAllTeacher(){
		return empServ.getTeachersFromDb();
	}
	
	//localhost:8080/readEmp/5
	@GetMapping("/readTeacher/{teacher_id}")
	public ResponseEntity<Teacher>  getTeacherById(@PathVariable("teacher_id")  int teacherId){
		return new ResponseEntity<Teacher>(empServ.getTeacherById(teacherId), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteTeacher/{teacher_id}")
	public ResponseEntity<String> deleteTeacherById(@PathVariable("teacher_id")  int teacherId){
		empServ.deleteTeacherById(teacherId);
		return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
	}
}
