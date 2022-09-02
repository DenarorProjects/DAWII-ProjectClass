package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Medicine;
import com.empresa.repository.MedicineRepository;

@Service
public class MedicineServiceImplement implements MedicineService {

	@Autowired
	private MedicineRepository repository;

	@Override
	public List<Medicine> listAllt() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
}