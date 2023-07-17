package com.unla.grupo8.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.unla.grupo8.converters.PlayaEstacionamientoConverter;
import com.unla.grupo8.entities.PlayaEstacionamiento;
import com.unla.grupo8.models.PlayaEstacionamientoModelo;
import com.unla.grupo8.repositories.IPlayaEstacionamientoRepository;
import com.unla.grupo8.services.IPlayaEstacionamientoService;

public class PlayaEstacionamientoService implements IPlayaEstacionamientoService{
	
	@Autowired
	@Qualifier("playaEstacionamientoRepository")
	private IPlayaEstacionamientoRepository playaEstacionamientoRepository;
	
	@Autowired
	@Qualifier("playaEstacionamientoConverter")
	private PlayaEstacionamientoConverter playaEstacionamientoConverter;

	@Override
	public List<PlayaEstacionamiento> getAll() {
		// TODO Auto-generated method stub
		return playaEstacionamientoRepository.findAll();
	}

	@Override
	public PlayaEstacionamientoModelo traerPorId(int id) {
		// TODO Auto-generated method stub
		return playaEstacionamientoConverter.entityToModel(playaEstacionamientoRepository.findById(id));
	}

	@Override
	public PlayaEstacionamientoModelo insertOrUpdate(PlayaEstacionamientoModelo playaEstacionamientoModelo) {
		// TODO Auto-generated method stub
		PlayaEstacionamiento playaEstacionamiento = playaEstacionamientoRepository.save(playaEstacionamientoConverter.modelToEntity(playaEstacionamientoModelo));
		return playaEstacionamientoConverter.entityToModel(playaEstacionamiento);
	}
 
} 
