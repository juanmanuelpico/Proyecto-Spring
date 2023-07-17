package com.unla.grupo8.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unla.grupo8.entities.Espacio;
import com.unla.grupo8.models.EspacioModelo;



@Service("espacioService")
public interface IEspacioService {
	public List<Espacio>getAll();
	public EspacioModelo traerPorId(int id);
	public EspacioModelo insertOrUpdate(EspacioModelo espacioModelo);
	 
}
