package com.unla.grupo8.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo8.entities.PlayaEstacionamiento;
import com.unla.grupo8.helpers.ViewRouteHelpers;
import com.unla.grupo8.models.DispositivoEstacionamientoModelo;
import com.unla.grupo8.repositories.IEspacioRepository;
import com.unla.grupo8.repositories.ILugarRepository;
import com.unla.grupo8.repositories.IPlayaEstacionamientoRepository;
import com.unla.grupo8.services.implementations.DispositivoEstacionamientoService;
import com.unla.grupo8.services.implementations.LugarService;

import jakarta.validation.Valid;

import com.unla.grupo8.entities.DispositivoEstacionamiento;
import com.unla.grupo8.entities.Lugar;


@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/estacionamiento")
public class DispositivoEstacionamientoController {
	
    @Autowired
    @Qualifier("lugarService")
	private LugarService lugarService;
	
	
	@Autowired
	@Qualifier("dispositivoEstacionamientoService")
	private DispositivoEstacionamientoService dispositivoEstacionamientoService;
	
	@Autowired
	@Qualifier("espacioRepository")
	private IEspacioRepository espacioRepository;
	
	
	
	
	
	
	@GetMapping("") 
	public ModelAndView mostrarTablaDispositivosEstacionamiento() {
		
	    ModelAndView mV = new ModelAndView(ViewRouteHelpers.LISTA_DISPO_ESTACIONAMIENTO);
	    mV.addObject("dispositivos", dispositivoEstacionamientoService.getAll());
	    return mV;
	} 
	
	@GetMapping("/creardispositivo")
	public ModelAndView crearDispositivoAlumbrado(Model model) {
		
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelpers.FORM_DISPO_ESTACIONAMIENTO);
		model.addAttribute("espacios", espacioRepository.findAll());
		model.addAttribute("lugares", lugarService.traerLugaresSinDispositivo());
		model.addAttribute("dispositivo", new DispositivoEstacionamientoModelo());
		
		return modelAndView;
	}
	
	@PostMapping("/nuevodispositivo")
	public ModelAndView agregarDispositivo(@Validated @ModelAttribute("dispositivo") DispositivoEstacionamientoModelo dispositivo,
			BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName(ViewRouteHelpers.FORM_DISPO_ESTACIONAMIENTO);
//			modelAndView.addObject("espacios", espacioRepository.findAll());
			modelAndView.addObject("lugares", lugarService.traerLugaresSinDispositivo());
			return modelAndView;
		} 

		dispositivoEstacionamientoService.insertOrUpdate(dispositivo);
		return mostrarTablaDispositivosEstacionamiento();
	}
	
	@GetMapping("/eliminar/{id}")
	public ModelAndView eliminarDispositivo(@PathVariable("id")int id) {	
		
		dispositivoEstacionamientoService.remove(id);
			   
		return mostrarTablaDispositivosEstacionamiento();	
	}
	
	
	@GetMapping("/baja/{id}")
	public ModelAndView bajaDispositivoLucesAutomaticas (@PathVariable("id")int id) {
		dispositivoEstacionamientoService.baja(id);
		return mostrarTablaDispositivosEstacionamiento();
	}
	
	@GetMapping("/editarDispositivo/{id}") 
	public ModelAndView editarDispositivo(@PathVariable("id")int id, Model model) {	
		ModelAndView mv = new ModelAndView(ViewRouteHelpers.FORM_DISPO_ESTACIONAMIENTO_EDITAR);
		mv.addObject("dispositivo",  dispositivoEstacionamientoService.traerPorId(id));
		mv.addObject("lugares", lugarService.traerLugaresSinDispositivo());
//		DispositivoEstacionamientoModelo dispositivoEstacionamientoModelo = dispositivoEstacionamientoService.traerPorId(id);
//		model.addAttribute("dispositivo", dispositivoEstacionamientoModelo);
//		model.addAttribute("lugares", lugarService.traerLugaresSinDispositivo());	
		return mv;
	} 
	
	
	@PostMapping("/editado") 
	public ModelAndView dispositivoEditado(@Valid @ModelAttribute("dispositivo") DispositivoEstacionamientoModelo dispositivoEstacionamientoModelo, 
			BindingResult b) {
		DispositivoEstacionamiento dispositivo = new DispositivoEstacionamiento();
		ModelAndView mV = new ModelAndView();
		if(b.hasErrors()) {
			mV.setViewName(ViewRouteHelpers.FORM_DISPO_ESTACIONAMIENTO_EDITAR);
		}else {

			DispositivoEstacionamiento dispositivoViejo = dispositivoEstacionamientoService.traerEntidad(dispositivoEstacionamientoModelo.getId());
			dispositivo.setNombre(dispositivoViejo.getNombre());
			dispositivo.setLugar(dispositivoViejo.getLugar());
			
		}
		dispositivoEstacionamientoService.insertOrUpdate(dispositivoEstacionamientoModelo);
		return mostrarTablaDispositivosEstacionamiento();
	}
	 
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	@GetMapping("")
//	public ModelAndView listaPlayasEstacionamiento() {
//		
//	    ModelAndView mV = new ModelAndView(ViewRouteHelpers.PRUEBA);
//	    mV.addObject("lista", playaEstacionamientoRepository.findById(1).getLugares());
//	    return mV;
//	}
// 
//	@GetMapping("/lugares/{id}")
//	public ModelAndView lugaresPlaya(@PathVariable("id")int id, Model model) {
//		List<Lugar> lugares = lugarRepository.findByPlayaEstacionamiento(id);
//		
//		model.addAttribute("lista", lugares);
//		 ModelAndView mV = new ModelAndView(ViewRouteHelpers.LUGARES_PLAYA);
//	
//		  
//		
//		    return mV;
//	}
//	
//	@GetMapping("")
//	public ModelAndView listaPlayasEstacionamiento() {
//		 
//	    ModelAndView mV = new ModelAndView(ViewRouteHelpers.LISTA_PLAYAS);
//	    mV.addObject("lista", playaEstacionamientoRepository.findAll());
//	    return mV;
//	}
}
