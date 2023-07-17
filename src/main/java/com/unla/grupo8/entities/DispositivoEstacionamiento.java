package com.unla.grupo8.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@PrimaryKeyJoinColumn(referencedColumnName="id")
@Table(name = "dispositivo_estacionamiento")
public class DispositivoEstacionamiento extends Dispositivo {
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lugar_id")
	private Lugar lugar;
	
	public DispositivoEstacionamiento() {}

	public DispositivoEstacionamiento(int id, String nombre, Espacio espacio, Lugar lugar) {
		super(id, nombre, espacio);
		this.lugar = lugar;
	}
	
	public DispositivoEstacionamiento(int id, String nombre) {
		super(id, nombre);
		this.setEspacio(getEspacio());
	} 
	 

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	} 
	
	
	
	

}
