package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Student;
import com.empresa.service.StudentService;

@RestController
@RequestMapping("/rest/student")
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Student>> list() {
		List<Student> out = service.listAll();
		return ResponseEntity.ok(out);
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<?> insert(@RequestBody Student obj) {
		HashMap<String, Object> out = new HashMap<String, Object>();

		Student studentObj = service.registerUpdateStudent(obj);
		out.put("message", studentObj == null ? "Error al Registrar" : "Se registró el alumno " + studentObj.getId());

		return ResponseEntity.ok(out);
	}

	@PutMapping
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody Student obj) {
		HashMap<String, Object> out = new HashMap<String, Object>();
		Optional<Student> studentObj = service.searchStudent(obj.getId());
		if (studentObj.isPresent()) {
			out.put("message", "No existe el alumno => " + obj.getId());
		} else {
			Student newStudentObj = service.registerUpdateStudent(obj);
			out.put("message", "Se actualizó el alumno " + newStudentObj.getId());
		}
		return ResponseEntity.ok(out);
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		HashMap<String, Object> out = new HashMap<String, Object>();

		Optional<Student> studentObj = service.searchStudent(id);
		if (studentObj.isPresent()) {
			service.deleteStudent(id);
			out.put("message", "Se eliminó el alumno " + id);
		} else {
			out.put("message", "No existe el alumno con id " + id);
		}
		return ResponseEntity.ok(out);
	}
}
