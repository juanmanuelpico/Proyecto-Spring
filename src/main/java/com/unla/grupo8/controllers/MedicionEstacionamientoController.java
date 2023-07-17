package com.unla.grupo8.controllers;

import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo8.converters.MedicionEstacionamientoConverter;
import com.unla.grupo8.entities.DispositivoEstacionamiento;
import com.unla.grupo8.entities.MedicionEstacionamiento;
import com.unla.grupo8.helpers.ViewRouteHelpers;
import com.unla.grupo8.models.DispositivoEstacionamientoModelo;
import com.unla.grupo8.models.EventoModelo;
import com.unla.grupo8.models.MedicionEstacionamientoModelo;
import com.unla.grupo8.models.MedicionModelo;
import com.unla.grupo8.repositories.IDispositivoEstacionamientoRepository;
import com.unla.grupo8.services.implementations.DispositivoEstacionamientoService;
import com.unla.grupo8.services.implementations.EventoEstacionamientoService;
import com.unla.grupo8.services.implementations.MedicionEstacionamientoService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/medicion")
public class MedicionEstacionamientoController { 
	
	@Autowired
	@Qualifier("dispositivoEstacionamientoService")
	private DispositivoEstacionamientoService dispositivoEstacionamientoService;
 
	@Autowired
	@Qualifier("medicionEstacionamientoService") 
	private MedicionEstacionamientoService medicionEstacionamientoService;
	
	@Autowired 
	@Qualifier("eventoService") 
	private EventoEstacionamientoService eventoService;
	
	@Autowired
	@Qualifier("medicionEstacionamientoConverter")  
	private MedicionEstacionamientoConverter medicionEstacionamientoConverter;
	
	@Autowired
	@Qualifier("dispositivoEstacionamientoRepository")   
	private IDispositivoEstacionamientoRepository dispositivoEstacionamientoRepository;
	  
	@GetMapping("/tablamediciones") 
	public ModelAndView mostrarTablaMediciones() {
		
	    ModelAndView mV = new ModelAndView(ViewRouteHelpers.LISTA_MEDICION_ESTACIONAMIENTO);
	    mV.addObject("mediciones", medicionEstacionamientoService.getAll()); 
	    return mV;
	} 
	
	
	@GetMapping("/crearmedicion") 
	public ModelAndView crearDispositivoAlumbrado(Model model) {
		
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelpers.CREAR_MEDICION_ESTACIONAMIENTO);
		model.addAttribute("medicion", new MedicionEstacionamientoModelo());
		model.addAttribute("dispositivos", dispositivoEstacionamientoService.getAll()); 
		
		return modelAndView;
	}
	
	@PostMapping("/nuevamedicion")
	public ModelAndView agregarDispositivo(@Validated @ModelAttribute("medicion") MedicionEstacionamientoModelo medicion,
			BindingResult bindingResult) {
		 
		    DispositivoEstacionamiento dispositivo =  dispositivoEstacionamientoRepository.findById(medicion.getIdDispositivo());
		    
		     medicion.setFechaHoraRegistro(LocalDateTime.now());
		    medicion.setPresenciaVehiculo(!dispositivo.getLugar().isLugarLibre()); 
		    
		    medicionEstacionamientoService.insertOrUpdate(medicion);
		    
		    String mensaje = "";
		    if(medicion.isPresenciaVehiculo() == true) { 
		    	mensaje = "Lugar ocupado";
		    }else {
		    	mensaje = "Lugar vacio"; 
		    } 
		     
		    EventoModelo evento = new EventoModelo(medicion.getIdDispositivo(), mensaje, LocalDateTime.now());
       
         eventoService.insertOrUpdate(evento); 
		return mostrarTablaMediciones();
	}
	
	@GetMapping("/listaEventos/{id}")  
	public ModelAndView mostrarTablaEventos(@PathVariable("id")int id) {
		
	    ModelAndView mV = new ModelAndView(ViewRouteHelpers.LISTA_EVENTOS_ESTACIONAMIENTO);
	    mV.addObject("eventos", eventoService.traerEventosIdDispositivo(id));  
	    return mV; 
	} 

	
	
} 
	 
	