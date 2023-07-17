package com.unla.grupo8.converters;

import org.hibernate.boot.model.source.spi.PluralAttributeElementSourceAssociation;
import org.springframework.stereotype.Component;

import com.unla.grupo8.entities.PlayaEstacionamiento;
import com.unla.grupo8.models.PlayaEstacionamientoModelo;

@Component("playaEstacionamientoConverter")
public class PlayaEstacionamientoConverter {
	
	public PlayaEstacionamiento modelToEntity(PlayaEstacionamientoModelo playa) {
		return new PlayaEstacionamiento(playa.getId(), playa.getNombre(), playa.isPlayaLlena(), playa.getEspacio());
	}
	 
	public PlayaEstacionamientoModelo entityToModel(PlayaEstacionamiento playa) {
		return new PlayaEstacionamientoModelo(playa.getId(), playa.getNombre(), playa.isPlayaLlena(), playa.getEspacio());
	}
 
	
	

}
