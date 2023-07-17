package com.unla.grupo8.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.unla.grupo8.converters.EspacioConverter;

import com.unla.grupo8.entities.Espacio;
import com.unla.grupo8.entities.Lugar;
import com.unla.grupo8.models.EspacioModelo;
import com.unla.grupo8.models.LugarModelo;
import com.unla.grupo8.repositories.IEspacioRepository;
import com.unla.grupo8.services.IEspacioService;


public class EspacioService implements IEspacioService{
	@Autowired 
	@Qualifier("espacioRepository")
	private IEspacioRepository espacioRepository;
	 
	@Autowired
	@Qualifier("espacioConverter")
	private EspacioConverter espacioConverter;

	@Override
	public List<Espacio> getAll() {
		// TODO Auto-generated method stub
		return espacioRepository.findAll();
	} 

	@Override
	public EspacioModelo traerPorId(int id) {
		// TODO Auto-generated method stub
		return espacioConverter.entityToModel(espacioRepository.findById(id));
	}

	@Override
	public EspacioModelo insertOrUpdate(EspacioModelo espacioModelo) {
		Espacio espacio = espacioRepository.save(espacioConverter.modelToEntity(espacioModelo));
		return espacioConverter.entityToModel(espacio);
	}
	
	
}
