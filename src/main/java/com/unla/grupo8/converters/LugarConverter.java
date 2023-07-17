package com.unla.grupo8.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.grupo8.entities.Lugar;
import com.unla.grupo8.models.LugarModelo;

@Component("lugarConverter")
public class LugarConverter {
	@Autowired
	@Qualifier("playaEstacionamientoConverter")
	private PlayaEstacionamientoConverter playaConverter;
	
	public Lugar modelToEntity(LugarModelo lugar) {
		return new Lugar(lugar.getId(), lugar.getNombreLugar(), lugar.isLugarLibre(), playaConverter.modelToEntity(lugar.getPlayaEstacionamientoModelo()));
	}
	
	public LugarModelo entityToModel(Lugar lugar) {
		return new LugarModelo(lugar.getId(), lugar.getNombreLugar(), lugar.isLugarLibre(), playaConverter.entityToModel(lugar.getPlayaEstacionamiento()));
	}
}
  