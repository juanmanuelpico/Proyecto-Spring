package com.unla.grupo8.models;



 
public class LugarModelo {
	
	private int id;
	
	private String nombreLugar;
	
	private boolean lugarLibre;
	

	private DispositivoEstacionamientoModelo dispositivoEstacionamiento;
	

	private PlayaEstacionamientoModelo playaEstacionamientoModelo;

	public LugarModelo(int id, String nombreLugar, boolean lugarLibre, PlayaEstacionamientoModelo playaEstacionamientoModelo) {
		super();
		this.id = id;
		this.nombreLugar = nombreLugar;
		this.lugarLibre = lugarLibre;
		this.playaEstacionamientoModelo = playaEstacionamientoModelo;
	}

	public LugarModelo(String nombreLugar, boolean lugarLibre, PlayaEstacionamientoModelo
			playaEstacionamientoModelo) {
		super();
		this.nombreLugar = nombreLugar;
		this.lugarLibre = lugarLibre;
		this.playaEstacionamientoModelo = playaEstacionamientoModelo;
	}

	public LugarModelo(String nombreLugar, boolean lugarLibre) {
		super();
		this.nombreLugar = nombreLugar;
		this.lugarLibre = lugarLibre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreLugar() {
		return nombreLugar;
	}

	public void setNombreLugar(String nombreLugar) {
		this.nombreLugar = nombreLugar;
	}

	public boolean isLugarLibre() {
		return lugarLibre;
	}

	public void setLugarLibre(boolean lugarLibre) {
		this.lugarLibre = lugarLibre;
	}

	public DispositivoEstacionamientoModelo getDispositivoEstacionamiento() {
		return dispositivoEstacionamiento;
	}

	public void setDispositivoEstacionamiento(DispositivoEstacionamientoModelo dispositivoEstacionamiento) {
		this.dispositivoEstacionamiento = dispositivoEstacionamiento;
	}

	public PlayaEstacionamientoModelo getPlayaEstacionamientoModelo() {
		return playaEstacionamientoModelo;
	}

	public void setPlayaEstacionamientoModelo(PlayaEstacionamientoModelo playaEstacionamientoModelo) {
		this.playaEstacionamientoModelo = playaEstacionamientoModelo;
	}
 
	
	
	
	

}
