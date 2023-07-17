package com.unla.grupo8.models;

import java.util.Set;


import com.unla.grupo8.entities.Lugar;


public class PlayaEstacionamientoModelo {
private int id;
	
	private String nombre;
	
	private boolean playaLlena;
	
	private String espacio;	
	
    private Set<LugarModelo> lugares;

	public PlayaEstacionamientoModelo(int id, String nombreString, boolean playaLlena, String espacio) {
		super();
		this.id = id;
		this.nombre = nombreString;
		this.playaLlena = playaLlena;
		this.espacio = espacio;
	}

	public PlayaEstacionamientoModelo(String nombreString, boolean playaLlena) {
		super();
		this.nombre = nombreString;
		this.playaLlena = playaLlena;
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

	public void setNombre(String nombreString) {
		this.nombre = nombreString;
	}

	public boolean isPlayaLlena() {
		return playaLlena;
	}

	public void setPlayaLlena(boolean playaLlena) {
		this.playaLlena = playaLlena;
	}
	
	

	

	public String getEspacio() {
		return espacio;
	}

	public void setEspacio(String espacio) {
		this.espacio = espacio;
	}

	public Set<LugarModelo> getLugares() {
		return lugares;
	}

	public void setLugares(Set<LugarModelo> lugares) {
		this.lugares = lugares;
	}
	
	

}
