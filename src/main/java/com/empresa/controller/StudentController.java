package com.empresa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
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
	public ResponseEntity<?> insert(@Validated @RequestBody Student obj, Errors errors) {
		HashMap<String, Object> out = new HashMap<String, Object>();

		List<ObjectError> lstErrors = errors.getAllErrors();
		List<String> lstMensajes = new ArrayList<String>();
		for (ObjectError objectError : lstErrors) {
			objectError.getDefaultMessage();
			lstMensajes.add(objectError.getDefaultMessage());
		}
		if (!CollectionUtils.isEmpty(lstMensajes)) {
			out.put("errores", lstMensajes);
			return ResponseEntity.ok(out);
		}

		List<Student> lstStudent = service.listStudentByDni(obj.getDni());
		if (!CollectionUtils.isEmpty(lstStudent)) {
			out.put("mensaje", "Ya existe un atudent con DNI ==> " + obj.getDni());
			return ResponseEntity.ok(out);
		}
		lstStudent = service.listStudentByEmail(obj.getEmail());
		if (!CollectionUtils.isEmpty(lstStudent)) {
			out.put("mensaje", "Ya existe un atudent con correo ==> " + obj.getEmail());
			return ResponseEntity.ok(out);
		}
		Student objSalida = service.registerUpdateStudent(obj);
		if (objSalida == null) {
			out.put("mensaje", "Error en el registro");
		} else {
			out.put("mensaje", "Se registró el atudent ==> " + objSalida.getId());
		}
		return ResponseEntity.ok(out);
	}

	@PutMapping
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody Student obj) {
		HashMap<String, Object> out = new HashMap<String, Object>();
		Optional<Student> optStudent = service.searchStudent(obj.getId());
		if (optStudent.isPresent()) {
			Student objSalida = service.registerUpdateStudent(obj);
			if (objSalida == null) {
				out.put("mensaje", "Error al actualizar");
			} else {
				out.put("mensaje", "Se actualizó el alumno ==> " + objSalida.getId());
			}
		} else {
			out.put("mensaje", "No existe el alumno de ID ==> " + obj.getId());
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
			out.put("message", "Se eliminó el atudent " + id);
		} else {
			out.put("message", "No existe el atudent con id " + id);
		}
		return ResponseEntity.ok(out);
	}
}
