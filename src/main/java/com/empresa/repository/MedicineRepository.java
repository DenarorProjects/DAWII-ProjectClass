package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

}
