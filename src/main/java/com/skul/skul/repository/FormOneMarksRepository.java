package com.skul.skul.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.skul.skul.model.FormOneMarks;

@Repository
public interface FormOneMarksRepository extends JpaRepository<FormOneMarks, Long>{

	}
