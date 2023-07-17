package com.unla.grupo8.services;

import java.util.List;
import java.util.function.IntToDoubleFunction;

import org.springframework.stereotype.Service;

import com.unla.grupo8.entities.MedicionEstacionamiento;
import com.unla.grupo8.models.MedicionEstacionamientoModelo;

@Service("medicionEstacionamientoService")
public interface IMedicionEstacionamientoService {
	
	public MedicionEstacionamientoModelo traerPorId(int id);
	
	public List<MedicionEstacionamiento> getAll();
	
	public MedicionEstacionamientoModelo insertOrUpdate(MedicionEstacionamientoModelo medicionEstacionamientoModelo);
 
}
