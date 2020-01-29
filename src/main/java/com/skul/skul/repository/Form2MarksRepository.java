package com.skul.skul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skul.skul.model.Form2Marks;

@Repository
public interface Form2MarksRepository extends JpaRepository<Form2Marks, Long>{

	}
