package com.unla.grupo8.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@PrimaryKeyJoinColumn(referencedColumnName="id")
@Table(name = "medicion_estacionamiento") 
public class MedicionEstacionamiento extends Medicion{
	private String patente;
	private boolean presenciaVehiculo;
	
	public MedicionEstacionamiento() {}
	
	public MedicionEstacionamiento(int id, Dispositivo dispositivo, LocalDateTime fechaHoraRegistro, String patente, boolean presenciaVehiculo) {
		super(id, dispositivo, fechaHoraRegistro);
		this.patente = patente;
		this.presenciaVehiculo = presenciaVehiculo;
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
