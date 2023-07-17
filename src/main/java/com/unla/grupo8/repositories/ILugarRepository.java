package com.unla.grupo8.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.grupo8.entities.Lugar;
import com.unla.grupo8.models.DispositivoEstacionamientoModelo;
import com.unla.grupo8.models.LugarModelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;


@Repository("lugarRepository")
public interface ILugarRepository extends JpaRepository<Lugar, Serializable>{

	
	public abstract Lugar findById(int id);
	
	 @Query("SELECT l FROM Lugar l JOIN FETCH l.playaEstacionamiento p WHERE l.id = (:id)")
	 public abstract Lugar findLugarWithPlayaEstacionamiento(@Param("id") int id);
	
	 @Query("SELECT l FROM Lugar l WHERE l.playaEstacionamiento = :idPlayaEstacionamiento")
	  public abstract  List<Lugar> findByPlayaEstacionamiento(int idPlayaEstacionamiento);
	

}
