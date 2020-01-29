package com.skul.skul;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.skul.skul.dao.StudentDao;
import com.skul.skul.model.Student;
import com.skul.skul.repository.StudentRepository;
import com.skul.skul.service.StudentService;
import com.skul.skul.service.impl.StudentServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class Form2marksTest {

	@Mock
	private StudentRepository studentRepository;
	
	@InjectMocks
	private StudentServiceImpl studentService;
	
	@Mock
	StudentDao studentDao;
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void whenFindAll_thenReturnStudents() {
		 
		// given
		//Form2Marks marks = Form2Marks
		List<Student> marks = new ArrayList<Student>();
		Student mark = new Student("AGRICULTURE", "BIOLOGY", "BUSINESS", "CHEMISTRY", "COMPUTER", "CRE","ENGLISH", "ENOCK", "FOUR", "MALE", "GEOGRAPHY", "HISTORY", "HOMESCIENCE","", "", "", "", "", "","", "", "NORTH", "", "");
		Student mark1 = new Student("AGRICULTURE", "BIOLOGY", "BUSINESS", "CHEMISTRY", "COMPUTER", "CRE","ENGLISH", "KELVIN", "FOUR", "MALE", "GEOGRAPHY", "HISTORY", "HOMESCIENCE","", "", "", "", "", "","", "", "EAST", "", "");
		Student mark2 = new Student("AGRICULTURE", "BIOLOGY", "BUSINESS", "CHEMISTRY", "COMPUTER", "CRE","ENGLISH", "MBOYA", "FOUR", "MALE", "GEOGRAPHY", "HISTORY", "HOMESCIENCE","", "", "", "", "", "","", "", "WEST", "", "");
		
		marks.add(mark);
		marks.add(mark1);
		marks.add(mark2);
		when(studentRepository.findAll()).thenReturn(marks);
		
		//TEST
		List<Student> std = studentService.findAll();
		assertEquals(3, std.size());
		verify(studentRepository,times(1)).findAll();
	}
	@Test
	public void whenFindAllByStream_thenReturnSizeOfStream() {
		//
		List<Student> marks = new ArrayList<Student>();
		Student mark = new Student("AGRICULTURE", "BIOLOGY", "BUSINESS", "CHEMISTRY", "COMPUTER", "CRE","ENGLISH", "ENOCK", "ONE", "MALE", "GEOGRAPHY", "HISTORY", "HOMESCIENCE","", "", "", "", "", "","", "", "NORTH", "", "");
		Student mark3 = new Student("AGRICULTURE", "BIOLOGY", "BUSINESS", "CHEMISTRY", "COMPUTER", "CRE","ENGLISH", "ENOCK", "ONE", "MALE", "GEOGRAPHY", "HISTORY", "HOMESCIENCE","", "", "", "", "", "","", "", "NORTH", "", "");
		
		marks.add(mark);
		marks.add(mark3);
		//when
		when(studentDao.selectAll_north_students("NORTH", "ONE")).thenReturn(marks);
		
		//then
		List<Student> selStud = studentService.selectAll_north_students("NORTH", "ONE");
		assertEquals(2,selStud.size());
		verify(studentDao,times(1)).selectAll_north_students("NORTH", "ONE");
	}
	@Test
	public void whenFindStudentById_thenReturnStudent() {
		//when(studentRepository.findById(100)).thenReturn(new Student(100, "AGRICULTURE", "BIOLOGY", "BUSINESS", "CHEMISTRY", "COMPUTER", "CRE","ENGLISH", "ENOCK", "ONE", "MALE", "GEOGRAPHY", "HISTORY", "HOMESCIENCE","", "", "", "", "", "","", "", "NORTH", "", ""));
		when(studentRepository.getOne((long) 100)).thenReturn(new Student((long) 100, "ENOCK", "", "ONE", "NORTH", "2020", "MALE","", "ENGLISH", "KISWAHILI", "MATHEMATICS", "BIOLOGY", "CHEMISTRY" ,"PHYSICS","GEOGRAPHY", "HISTORY", "CRE", "AGRICULTURE", "BUSINESS","COMPUTER", "HOMESCIENCE", "", "237", "", ""));
		
		Student student_one = studentService.findById((long) 100);		
		//test
		assertEquals("NORTH", student_one.getStream());
		assertEquals("ENOCK", student_one.getFname());
	}
}
