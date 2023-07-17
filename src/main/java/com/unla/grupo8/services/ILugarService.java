package com.unla.grupo8.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unla.grupo8.entities.Lugar;
import com.unla.grupo8.models.LugarModelo;

@Service("lugarService")
public interface ILugarService {
	
	public List<Lugar> getAll();
	
	public LugarModelo traerPorId(int id);
 
	 public LugarModelo insertOrUpdate(LugarModelo lugarModelo);
	   
} 
