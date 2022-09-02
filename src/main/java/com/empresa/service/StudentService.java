package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Student;

public interface StudentService {
	
	public abstract List<Student> listAll();

	public abstract Student registerUpdateStudent(Student obj);

	public abstract void deleteStudent(int id);

	public abstract Optional<Student> searchStudent(int id);

}
