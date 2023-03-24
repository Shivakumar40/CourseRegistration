package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.domain.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public List<Student> listAll()
	{
		return repo.findAll();
	}
	
	public void save(Student std)
	{
		repo.save(std);
	}
	public void delete(long id)
	{
		repo.deleteById(id);
	}

	public Optional<Student> get(long id) {
		return repo.findById(id);
	}

	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
