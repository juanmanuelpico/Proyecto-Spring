package com.unla.grupo8.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.parser.Part.IgnoreCaseType;
import org.springframework.stereotype.Service;

import com.unla.grupo8.converters.EventoEstacionamientoConverter;
import com.unla.grupo8.entities.Evento;
import com.unla.grupo8.entities.MedicionEstacionamiento;
import com.unla.grupo8.models.EventoModelo;
import com.unla.grupo8.repositories.IEventoRepository;
import com.unla.grupo8.services.IEventoEstacionamientoService;

@Service("eventoService") 
public class EventoEstacionamientoService implements IEventoEstacionamientoService{
	
	@Autowired 
	@Qualifier("eventoRepository")
	private IEventoRepository eventoRepository;
	
	@Autowired
	@Qualifier("eventoConverter")
	private EventoEstacionamientoConverter eventoConverter;
	

	

	@Override
	public List<Evento> getAll() {
		// TODO Auto-generated method stub
		return eventoRepository.findAll();
	}
	
	public List<Evento> traerEventosIdDispositivo(int idDispositivo) {
		 List<Evento> eventos = new ArrayList<Evento>();
		 for(Evento e : getAll()) {
			 if(e.getDispositivo().getId() == idDispositivo) {
				 eventos.add(e);
			 }
		 } 
		return eventos; 
	}



	@Override
	public EventoModelo insertOrUpdate(EventoModelo eventoModelo) {
		Evento evento = eventoRepository.save(eventoConverter.modelToEntityEstacionamiento(eventoModelo));

		return eventoConverter.entityToModelEstacionamiento(evento);
	}
	
	

	@Override
	public EventoModelo traerPorId(int id) {
		// TODO Auto-generated method stub
		return eventoConverter.entityToModelEstacionamiento(eventoRepository.findById(id));
	} 
	
  
}
