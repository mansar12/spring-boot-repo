package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.model.Shipwreck;

public interface ShipwreckRepository  extends JpaRepository<Shipwreck, Long>{
	@SuppressWarnings("rawtypes")
	@Query("select u from Shipwreck u ")
	 public List loadAllValue();
	 
}
