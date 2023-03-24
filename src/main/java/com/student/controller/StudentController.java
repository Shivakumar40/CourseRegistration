package com.student.controller;
import java.io.ByteArrayInputStream;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.student.domain.Student;
import com.student.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
    private StudentService service;
	
	
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		List<Student> liststudent=service.listAll();
		model.addAttribute("liststudent",liststudent);
		System.out.println("Get/");
		return "index";
	}
	
	@GetMapping("/new")
	public String add(Model model)
	{
		model.addAttribute("student",new Student());
		return "new";
	}
//	@GetMapping("/students")
//	public List<Student> getStudents()
//	{
//	return this.service.getAllStudent();
//	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student std)
	{
		service.save(std);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
public ModelAndView showEditStudentPage(@PathVariable(name="id")long id)
{
	ModelAndView mav=new ModelAndView("new");
	Optional<Student> std= service.get(id);
	mav.addObject("student",std);
	return mav;
	
}
	 @RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable(name="id") long id)
	{
		service.delete(id);
		return "redirect:/";
	}
	
}
