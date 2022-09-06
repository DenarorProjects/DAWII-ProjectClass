package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

  @Query("select x from Student x where x.dni = ?1")
  public List<Student> listByDni(String dni);

  @Query("select x from Student x where x.email = ?1")
  public List<Student> listByEmail(String correo);
}
