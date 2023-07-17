package com.unla.grupo8.models;

public class DispositivoEstacionamientoModelo extends DispositivoModelo{
	
	private int idLugar;
	 
	public DispositivoEstacionamientoModelo() {}

	public DispositivoEstacionamientoModelo(int id,String nombre, int idLugar, int idEspacio) {
		super(id, nombre, idEspacio); 
		this.idLugar = idLugar; 
	}
	
	
	
	
	
	

	public int getIdLugar() {
		return idLugar;
	} 

	public void setIdLugar(int idLugar) {
		this.idLugar = idLugar;
	}

	

	
	    
	
	

}
