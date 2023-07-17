package com.unla.grupo8.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unla.grupo8.entities.DispositivoEstacionamiento;
import com.unla.grupo8.models.DispositivoEstacionamientoModelo;


@Service("dispositivoEstacionamientoService")
public interface IDispositivoEstacionamientoService {
	
   public List<DispositivoEstacionamiento> getAll();
   
   public DispositivoEstacionamientoModelo traerPorId(int id);
   
   public DispositivoEstacionamientoModelo insertOrUpdate(DispositivoEstacionamientoModelo dispositivo);
   
   public boolean remove(int id); 
   
   public boolean baja(int id);  
   
   public DispositivoEstacionamiento traerEntidad(int id);
   
}
