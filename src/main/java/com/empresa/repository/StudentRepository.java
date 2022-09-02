package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
