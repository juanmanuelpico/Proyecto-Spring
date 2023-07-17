package com.unla.grupo8.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo8.entities.MedicionEstacionamiento;

@Repository("medicionEstacionamientoRepository")
public interface IMedicionEstacionamientoRepository extends JpaRepository<MedicionEstacionamiento, Serializable>{
 
	public abstract MedicionEstacionamiento findById(int id); 
}
