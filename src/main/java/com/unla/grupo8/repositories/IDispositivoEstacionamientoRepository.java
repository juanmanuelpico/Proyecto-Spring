package com.unla.grupo8.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.grupo8.entities.DispositivoEstacionamiento;
import java.util.List;


@Repository("dispositivoEstacionamientoRepository")
public interface IDispositivoEstacionamientoRepository extends JpaRepository<DispositivoEstacionamiento, Serializable>{
	
	public abstract DispositivoEstacionamiento findById(int id);
	
	 @Query("SELECT d FROM DispositivoEstacionamiento d JOIN FETCH d.espacio e JOIN FETCH d.lugar l WHERE d.id = :id")
	  public abstract DispositivoEstacionamiento findDispositivoEstacionamientoWithEspacioAndLugar(@Param("id") int id);
	 
	}  
 


