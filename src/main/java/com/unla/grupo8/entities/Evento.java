package com.unla.grupo8.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn( name = "dispositivo_id")
	@JsonBackReference
	private Dispositivo dispositivo;
	
	private String descripcionEvento;
	
	private LocalDateTime fechaHoraRegistro;
	
	public Evento() {}

	public Evento(int id, Dispositivo dispositivo, String descripcionEvento) {
		super();
		this.id = id;
		this.dispositivo = dispositivo;
		this.descripcionEvento = descripcionEvento;
	}

	public Evento(int id, Dispositivo dispositivo, String descripcionEvento, LocalDateTime fechaHoraRegistro) {
		super();
		this.id = id;
		this.dispositivo = dispositivo;
		this.descripcionEvento = descripcionEvento;
		this.fechaHoraRegistro = fechaHoraRegistro;
	}
	
	public Evento(Dispositivo dispositivo, String descripcionEvento, LocalDateTime fechaHoraRegistro) {
		super(); 
		this.dispositivo = dispositivo;
		this.descripcionEvento = descripcionEvento;
		this.fechaHoraRegistro = fechaHoraRegistro;
	}
	
	public Evento(int id, String descripcionEvento, LocalDateTime fechaHoraRegistro) {
		super();
		this.id = id;
		this.descripcionEvento = descripcionEvento;
		this.fechaHoraRegistro = LocalDateTime.now();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
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

	@Override
	public String toString() {
		return "Evento [id=" + id + ", dispositivo=" + dispositivo + ", descripcionEvento=" + descripcionEvento
				+ ", fechaHoraRegistro=" + fechaHoraRegistro + "]";
	}
	
	 

}