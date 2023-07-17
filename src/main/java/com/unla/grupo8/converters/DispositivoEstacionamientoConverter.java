package com.unla.grupo8.converters;

import org.hibernate.Hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.grupo8.entities.DispositivoEstacionamiento;
import com.unla.grupo8.entities.Lugar;
import com.unla.grupo8.models.DispositivoEstacionamientoModelo;
import com.unla.grupo8.repositories.IEspacioRepository;
import com.unla.grupo8.repositories.ILugarRepository;
import com.unla.grupo8.services.implementations.LugarService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


//int id, String nombre, Espacio espacio, Lugar lugar
@Component("dispositivoEstacionamientoConverter")
public class DispositivoEstacionamientoConverter {
	@Autowired
	@Qualifier("lugarConverter") 
	private LugarConverter lugarConverter;
	
	@Autowired
	@Qualifier("espacioConverter")
	private EspacioConverter espacioConverter;
	
	@Autowired
	@Qualifier("espacioRepository")
	private IEspacioRepository espacioRepository;
	
	@Autowired
	@Qualifier("lugarRepository")
	private ILugarRepository lugarRepository;
	
	@Autowired
	@Qualifier("lugarService")
	private LugarService lugarService;
	
	@PersistenceContext
	 private EntityManager entityManager;
	
	public DispositivoEstacionamiento modelToEntity(DispositivoEstacionamientoModelo dispo) {
		DispositivoEstacionamiento dispositivoEstacionamiento =  new DispositivoEstacionamiento(dispo.getId(), dispo.getNombre());
        Lugar lugar = lugarRepository.findById(dispo.getIdLugar()); 
        dispositivoEstacionamiento.setLugar(entityManager.merge(lugar));
		return dispositivoEstacionamiento; 
	}  
	
	public DispositivoEstacionamientoModelo entityToModel(DispositivoEstacionamiento dispo) {
		return new DispositivoEstacionamientoModelo(dispo.getId(), dispo.getNombre(), dispo.getEspacio().getId(), dispo.getLugar().getId());
	} 
   
	
} 
  