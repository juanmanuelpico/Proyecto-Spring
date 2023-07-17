package com.unla.grupo8.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.grupo8.entities.Usuario;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<Usuario, Serializable> {
	
	@Query("SELECT u FROM Usuario u JOIN FETCH u.userRoles WHERE u.username = (:username)")
	public abstract Usuario findByUsernameAndFetchUserRolesEagerly(@Param("username") String username);

}