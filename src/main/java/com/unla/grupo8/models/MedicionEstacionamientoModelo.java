package com.unla.grupo8.models;

import java.time.LocalDateTime;

public class MedicionEstacionamientoModelo extends MedicionModelo{
	private String patente;
	private boolean presenciaVehiculo;
	
	public MedicionEstacionamientoModelo() {}
	
	
	public MedicionEstacionamientoModelo(int id, LocalDateTime fechaHoraRegistro, String patente, boolean presenciaVehiculo, int idDispositivo) {
		super(id, fechaHoraRegistro, idDispositivo);
		this.patente = patente;
		this.presenciaVehiculo = presenciaVehiculo;
	}  
  
	
	
	public MedicionEstacionamientoModelo(String patente) {
		super();
		this.patente = patente;
	}
 

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente; 
	}

	public boolean isPresenciaVehiculo() {
		return presenciaVehiculo;
	}

	public void setPresenciaVehiculo(boolean presenciaVehiculo) {
		this.presenciaVehiculo = presenciaVehiculo;
	}
	
	
	 
	

}
