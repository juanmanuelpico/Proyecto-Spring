package com.unla.grupo8.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo8.helpers.ViewRouteHelpers;
import com.unla.grupo8.services.implementations.EventoEstacionamientoService;

@Controller
@PreAuthorize("hasRole('ROLE_AUDITOR')")
@RequestMapping("eventoestacionamiento")
public class EventoAuditorEstacionamientoController {
	@Autowired
	@Qualifier("eventoService")
	private EventoEstacionamientoService estacionamientoService;
	
	@GetMapping("/listaEventos/{id}")  
	public ModelAndView mostrarTablaEventos(@PathVariable("id")int id) {
		
	    ModelAndView mV = new ModelAndView(ViewRouteHelpers.LISTA_DISPO_ESTACIONAMIENTO_AUDITOR);
	    mV.addObject("eventos", estacionamientoService.traerEventosIdDispositivo(id));  
	    return mV; 
	}  
	 

}
