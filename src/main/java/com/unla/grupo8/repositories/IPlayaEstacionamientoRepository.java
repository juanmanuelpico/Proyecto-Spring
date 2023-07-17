package com.unla.grupo8.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo8.entities.PlayaEstacionamiento;
import java.util.List;


@Repository("playaEstacionamientoRepository")
public interface IPlayaEstacionamientoRepository extends JpaRepository<PlayaEstacionamiento, Serializable>{
	
	public abstract PlayaEstacionamiento findById(int id);

}
  