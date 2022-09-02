package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Medicine;
import com.empresa.service.MedicineService;

@RestController
@RequestMapping("/rest/medicine")
public class MedicineController {

	@Autowired
	private MedicineService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Medicine>> list() {
		List<Medicine> out = service.listAllt();
		return ResponseEntity.ok(out);
	}
}
