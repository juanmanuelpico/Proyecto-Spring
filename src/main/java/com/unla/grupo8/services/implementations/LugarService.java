package com.unla.grupo8.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo8.converters.LugarConverter;
import com.unla.grupo8.entities.Lugar;
import com.unla.grupo8.models.LugarModelo;
import com.unla.grupo8.repositories.ILugarRepository;
import com.unla.grupo8.services.ILugarService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service("lugarService")
public class LugarService implements ILugarService{
	
	 
	
	@Autowired
	@Qualifier("lugarRepository")
	private ILugarRepository lugarRepository; 
	
	@Autowired
	@Qualifier("lugarConverter")
	private LugarConverter lugarConverter;

	@Override 
	public List<Lugar> getAll() {
		// TODO Auto-generated method stub
		return lugarRepository.findAll(); 
	}
 
	@Override 
	public LugarModelo traerPorId(int id) {
		// TODO Auto-generated method stub 
		return lugarConverter.entityToModel(lugarRepository.findLugarWithPlayaEstacionamiento(id));
	}
 
	public List<Lugar> traerLugaresSinDispositivo() {
		List<Lugar> lugares = new ArrayList<>();
		for(Lugar lugar : getAll()) {
			if(lugar.getDispositivoEstacionamiento() == null) {
				lugares.add(lugar);
			} 
		}
		return lugares; 
	}

	@Override
	public LugarModelo insertOrUpdate(LugarModelo lugarModelo) {
		// TODO Auto-generated method stub
		Lugar lugar = lugarRepository.save(lugarConverter.modelToEntity(lugarModelo));
		return lugarConverter.entityToModel(lugar);
	}

	 
	
	
}
