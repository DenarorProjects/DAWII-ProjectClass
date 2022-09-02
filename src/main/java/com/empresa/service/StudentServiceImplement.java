package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Student;
import com.empresa.repository.StudentRepository;

@Service
public class StudentServiceImplement implements StudentService {

	@Autowired
	private StudentRepository repository;

	@Override
	public List<Student> listAll() {
		return repository.findAll();
	}

	@Override
	public Student registerUpdateStudent(Student obj) {
		return repository.save(obj);
	}

	@Override
	public void deleteStudent(int id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<Student> searchStudent(int id) {
		return repository.findById(id);
	}
}
