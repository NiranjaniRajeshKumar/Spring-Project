package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Teacher;


//whenevr i interact with db // @REPOSITORY
@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Integer> {
	

}
