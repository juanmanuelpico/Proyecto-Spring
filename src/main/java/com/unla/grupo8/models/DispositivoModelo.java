package com.unla.grupo8.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.unla.grupo8.entities.Espacio;
import com.unla.grupo8.entities.Evento;
import com.unla.grupo8.entities.Medicion;



public abstract class DispositivoModelo {
	
	
	protected int id;
	
	protected String nombre;

	protected boolean enAlta;
	
	protected int idEspacio;
	
	
	private Set<Medicion> mediciones = new HashSet<>();
	
	private Set<Evento> eventos = new HashSet<>();
	
	public DispositivoModelo() {}

	public DispositivoModelo(int id, String nombre, boolean enAlta, int idEspacio, Set<Medicion> mediciones,
			Set<Evento> eventos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.enAlta = enAlta;
		this.idEspacio = idEspacio;
		this.mediciones = mediciones;
		this.eventos = eventos;
	}
	

	public DispositivoModelo(int id, String nombre, int idEspacio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.enAlta = true;
		this.idEspacio = idEspacio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isEnAlta() {
		return enAlta;
	}

	public void setEnAlta(boolean enAlta) {
		this.enAlta = enAlta;
	}
	public Set<Medicion> getMediciones() {
		return mediciones;
	}

	public void setMediciones(Set<Medicion> mediciones) {
		this.mediciones = mediciones;
	}

	public Set<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}

	public int getIdEspacio() {
		return idEspacio;
	}

	public void setIdEspacio(int idEspacio) {
		this.idEspacio = idEspacio;
	}
	
	
}
