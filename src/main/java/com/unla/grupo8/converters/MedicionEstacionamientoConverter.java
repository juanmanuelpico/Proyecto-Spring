package com.unla.grupo8.converters;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.stereotype.Component;

import com.unla.grupo8.entities.Dispositivo;
import com.unla.grupo8.entities.MedicionEstacionamiento;
import com.unla.grupo8.models.MedicionEstacionamientoModelo;
import com.unla.grupo8.repositories.IDispositivoEstacionamientoRepository;

@Component("medicionEstacionamientoConverter") 
public class MedicionEstacionamientoConverter {
	
	@Autowired
	@Qualifier("dispositivoEstacionamientoRepository") 
	private IDispositivoEstacionamientoRepository dispositivoEstacionamientoRepository;
	
//	int id, Dispositivo dispositivo, LocalDateTime fechaHoraRegistro, String patente, boolean presenciaVehiculo
	
	public MedicionEstacionamiento modelToEntity(MedicionEstacionamientoModelo medicionEstacionamientoModelo) {
		return new MedicionEstacionamiento(medicionEstacionamientoModelo.getId(), dispositivoEstacionamientoRepository.findById(medicionEstacionamientoModelo.getIdDispositivo()), 
				medicionEstacionamientoModelo.getFechaHoraRegistro(), medicionEstacionamientoModelo.getPatente(), medicionEstacionamientoModelo.isPresenciaVehiculo());
	}
	
	public MedicionEstacionamientoModelo entityToModel(MedicionEstacionamiento medicionEstacionamiento) {
		return new MedicionEstacionamientoModelo(medicionEstacionamiento.getId(),
				medicionEstacionamiento.getFechaHoraRegistro(), medicionEstacionamiento.getPatente(), medicionEstacionamiento.isPresenciaVehiculo(), medicionEstacionamiento.getDispositivo().getId());
	}
 
}
