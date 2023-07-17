package com.unla.grupo8.models;

import java.time.LocalDateTime;
import java.util.Objects;



public class EventoModelo {

    private int id;
	
	private int idDispositivo;
	
	private String descripcionEvento;
	
	private LocalDateTime fechaHoraRegistro;
	
	public EventoModelo() {}

	public EventoModelo(int id, int idDispositivo, String descripcionEvento,
			LocalDateTime fechaHoraRegistro) {
		super();
		this.id = id;
		this.idDispositivo = idDispositivo;
		this.descripcionEvento = descripcionEvento;
		this.fechaHoraRegistro = fechaHoraRegistro;
	}
	
	public EventoModelo(int idDispositivo, String descripcionEvento,
			LocalDateTime fechaHoraRegistro) {
		super();
		this.idDispositivo = idDispositivo;
		this.descripcionEvento = descripcionEvento;
		this.fechaHoraRegistro = fechaHoraRegistro;
	}
	
	
	
	public EventoModelo(int idDispositivo,
			LocalDateTime fechaHoraRegistro) {
		super();
		
		this.idDispositivo = idDispositivo;
		this.fechaHoraRegistro = fechaHoraRegistro;
	}

	public EventoModelo(String descripcionEvento, LocalDateTime fechaHoraRegistro) {
		super();
		
		this.descripcionEvento = descripcionEvento;
		this.fechaHoraRegistro = fechaHoraRegistro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public int getIdDispositivo() { 
		return idDispositivo;
	}

	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public String getDescripcionEvento() {
		return descripcionEvento;
	}

	public void setDescripcionEvento(String descripcionEvento) {
		this.descripcionEvento = descripcionEvento;
	}

	public LocalDateTime getFechaHoraRegistro() {
		return fechaHoraRegistro;
	}

	public void setFechaHoraRegistro(LocalDateTime fechaHoraRegistro) {
		this.fechaHoraRegistro = fechaHoraRegistro;
	}

	
}