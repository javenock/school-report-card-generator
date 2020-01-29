package com.skul.skul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skul.skul.model.Message;
import com.skul.skul.model.Student;
import com.skul.skul.repository.MessageRepository;
import com.skul.skul.repository.StudentRepository;
import com.skul.skul.service.StudentService;

@Controller
public class MainController {

	@Autowired
    private StudentService studentService;
	
	@Autowired
    private MessageRepository messageRepository;

	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("msgs", messageRepository.findAll());
        return "index1";
    }

    @PostMapping("/messages")
    public String saveMessage(Message message) {
        messageRepository.save(message);
        return "redirect:/home";
    }
    
	@GetMapping("/hom")
    public String root() {
        return "index1";
    }

   
	@GetMapping("/formOneLanguages")
	public String formOneLang(Model model) {
		
		return "formOneLanguages";
	}

   @GetMapping("/show")
    public String findStudents(Model model) {

    	List<Student> std = studentService.findAll();

        model.addAttribute("std", std);

        return "showall";
    }
    

    
    @GetMapping("/findOne")
    @ResponseBody
    public Student findOne(Long id) {
    	
    	return studentService.findById(id);
    }
    
    @PostMapping("/save1")
    public String save(Student s) {
    	studentRepository.save(s);
    	
    	return "redirect:/show";
    }
   
}
