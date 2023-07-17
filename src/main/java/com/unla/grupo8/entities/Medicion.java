package com.unla.grupo8.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "medicion")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Medicion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	@ManyToOne()
	@JoinColumn( name = "dispositivo_id")
	@JsonBackReference
	protected Dispositivo dispositivo;
	
	protected LocalDateTime fechaHoraRegistro;
	
	public Medicion() {}

	public Medicion(int id, Dispositivo dispositivo, LocalDateTime fechaHoraRegistro) {
		super();
		this.id = id;
		this.dispositivo = dispositivo;
		this.fechaHoraRegistro = fechaHoraRegistro;
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
		Medicion other = (Medicion) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Medicion [id=" + id + ", dispositivo=" + dispositivo + ", fechaHoraRegistro=" + fechaHoraRegistro + "]";
	}

} 