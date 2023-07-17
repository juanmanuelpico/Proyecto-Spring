package com.unla.grupo8.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unla.grupo8.entities.PlayaEstacionamiento;
import com.unla.grupo8.models.PlayaEstacionamientoModelo;

@Service("playaEstacionamientoService")
public interface IPlayaEstacionamientoService {
	
	public List<PlayaEstacionamiento> getAll();
	
	public PlayaEstacionamientoModelo traerPorId(int id);
	
	public PlayaEstacionamientoModelo insertOrUpdate(PlayaEstacionamientoModelo playaEstacionamientoModelo);

} 
 