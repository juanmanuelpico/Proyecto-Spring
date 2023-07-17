package com.unla.grupo8.converters;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.beans.factory.annotation.Qualifier; 
import org.springframework.stereotype.Component;

import com.unla.grupo8.entities.Evento; 
import com.unla.grupo8.models.EventoModelo;
import com.unla.grupo8.repositories.IDispositivoEstacionamientoRepository;

@Component("eventoConverter")
public class EventoEstacionamientoConverter {
	
	@Autowired
	@Qualifier("dispositivoEstacionamientoRepository") 
	private IDispositivoEstacionamientoRepository dispositivoEstacionamientoRepository;
	
 
	public Evento modelToEntityEstacionamiento(EventoModelo eventoModelo) {
		return new Evento(dispositivoEstacionamientoRepository.findById(eventoModelo.getIdDispositivo()) ,eventoModelo.getDescripcionEvento(), eventoModelo.getFechaHoraRegistro());
	}
	
	public EventoModelo entityToModelEstacionamiento(Evento evento) {
		return new EventoModelo(evento.getId(),evento.getDispositivo().getId(), evento.getDescripcionEvento(), evento.getFechaHoraRegistro());
	}  
} 
	
	

