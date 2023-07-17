package com.unla.grupo8.models;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.unla.grupo8.entities.Dispositivo;
import com.unla.grupo8.entities.Medicion;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public abstract class MedicionModelo {
	
	
	private int id;
	 
	
	private LocalDateTime fechaHoraRegistro;
	
	private EventoModelo eventoModelo;
	
	private int idDispositivo;
	
	public MedicionModelo() {} 

	public MedicionModelo(int id, LocalDateTime fechaHoraRegistro, EventoModelo eventoModelo, int idDispositivo) {
		super();
		this.id = id;
	    this.eventoModelo = eventoModelo;
		this.fechaHoraRegistro = fechaHoraRegistro;
		this.idDispositivo = idDispositivo;
	}
	
	 
	  
	

	public MedicionModelo(int id, LocalDateTime fechaHoraRegistro, int idDispositivo) {
		super();
		this.id = id;
		this.fechaHoraRegistro = fechaHoraRegistro;
		this.idDispositivo = idDispositivo;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	


	
	
	

	public EventoModelo getEventoModelo() {
		return eventoModelo;
	}

	public void setEventoModelo(EventoModelo eventoModelo) {
		this.eventoModelo = eventoModelo;
	}

	
	 


	public int getIdDispositivo() {
		return idDispositivo;
	}

	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}



	public LocalDateTime getFechaHoraRegistro() {
		return fechaHoraRegistro;
	}

	public void setFechaHoraRegistro(LocalDateTime fechaHoraRegistro) {
		this.fechaHoraRegistro = fechaHoraRegistro;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

 
	

	 
 


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicionModelo other = (MedicionModelo) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "MedicionModelo [id=" + id + ", idDispositivo=" + idDispositivo + ", fechaHoraRegistro="
				+ fechaHoraRegistro + "]";
	}
 

}

