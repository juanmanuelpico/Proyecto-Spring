package com.unla.grupo8.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo8.entities.Espacio;
import java.util.List;


@Repository("espacioRepository")
public interface IEspacioRepository extends JpaRepository<Espacio,Serializable> {
	public abstract Espacio findById(int id);
	
	public abstract Espacio findByNombre(String nombre); 
}
