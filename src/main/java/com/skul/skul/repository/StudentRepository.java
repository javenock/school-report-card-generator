package com.skul.skul.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skul.skul.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	@Query(value = "SELECT * FROM student WHERE form = ?1 ",
			countQuery = "Select count(*) FROM student WHERE form = ?1 ",
			nativeQuery = true)
	List<Student> findByForm_one(String form);

	@Query(value = "SELECT * FROM student WHERE form = ?1 ",
			countQuery = "Select count(*) FROM student WHERE form = ?1 ",
			nativeQuery = true)
	List<Student> findByForm(String form);
	
	
}
