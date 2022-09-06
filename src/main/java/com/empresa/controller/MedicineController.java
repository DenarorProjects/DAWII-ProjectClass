package com.empresa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping
	@ResponseBody
	public ResponseEntity<?> insert(@Valid @RequestBody Medicine obj, Errors errors) {
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
		Medicine objSalida = service.registerUpdateMedicine(obj);

		if (objSalida == null) {

			out.put("mensaje", "Error en el registro");

		} else {

			out.put("mensaje", "Se registró el medicamento ==> " + objSalida.getId());

		}

		return ResponseEntity.ok(out);

	}
}
