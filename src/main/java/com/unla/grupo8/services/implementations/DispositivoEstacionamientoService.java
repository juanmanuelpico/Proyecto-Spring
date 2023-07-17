package com.unla.grupo8.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo8.converters.DispositivoEstacionamientoConverter;
import com.unla.grupo8.entities.DispositivoEstacionamiento;
import com.unla.grupo8.models.DispositivoEstacionamientoModelo;
import com.unla.grupo8.repositories.IDispositivoEstacionamientoRepository;
import com.unla.grupo8.repositories.IEspacioRepository;
import com.unla.grupo8.services.IDispositivoEstacionamientoService;

import jakarta.transaction.Transactional;

@Service("dispositivoEstacionamientoService")
public class DispositivoEstacionamientoService implements IDispositivoEstacionamientoService{
	
	@Autowired
	@Qualifier("dispositivoEstacionamientoConverter")
	private DispositivoEstacionamientoConverter dispositivoEstacionamientoConverter;
	 
	@Autowired 
	@Qualifier("dispositivoEstacionamientoRepository")
	private IDispositivoEstacionamientoRepository dispositivoEstacionamientoRepository;
	
	@Autowired
	@Qualifier("espacioRepository")
	private IEspacioRepository espacioRepository;

	@Override
	public List<DispositivoEstacionamiento> getAll() {
		// TODO Auto-generated method stub
		return dispositivoEstacionamientoRepository.findAll();
	} 

	@Override
	public DispositivoEstacionamientoModelo traerPorId(int id) { 
		// TODO Auto-generated method stub
		return dispositivoEstacionamientoConverter.entityToModel(dispositivoEstacionamientoRepository.findDispositivoEstacionamientoWithEspacioAndLugar(id));
	}

	@Override
	@Transactional 
	public DispositivoEstacionamientoModelo insertOrUpdate(DispositivoEstacionamientoModelo dispositivo) {
		DispositivoEstacionamiento dispositivoEstacionamiento = dispositivoEstacionamientoConverter.modelToEntity(dispositivo);
		dispositivoEstacionamiento.setEspacio(espacioRepository.findByNombre(dispositivoEstacionamiento.getLugar().getPlayaEstacionamiento().getEspacio()));
		dispositivoEstacionamientoRepository.save(dispositivoEstacionamiento);
		return dispositivoEstacionamientoConverter.entityToModel(dispositivoEstacionamiento); 
	}  

	@Override
	public boolean remove(int id) {
		
		try {  
			dispositivoEstacionamientoRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		} 
	} 

	@Override 
	public boolean baja(int id) {
		 
		boolean aux = true;
		
		DispositivoEstacionamiento dispositivoEstacionamiento = dispositivoEstacionamientoRepository.findById(id);
     
		if(dispositivoEstacionamiento.isEnAlta() == true) {
			dispositivoEstacionamiento.setEnAlta(false);
			dispositivoEstacionamientoRepository.save(dispositivoEstacionamiento);
        }else {
        	dispositivoEstacionamiento.setEnAlta(true);
        	dispositivoEstacionamientoRepository.save(dispositivoEstacionamiento);
        }

		return aux;
	}

	@Override
	public DispositivoEstacionamiento traerEntidad(int id) {
		// TODO Auto-generated method stub
		return dispositivoEstacionamientoRepository.findById(id); 
	}


	

	
	

}
 