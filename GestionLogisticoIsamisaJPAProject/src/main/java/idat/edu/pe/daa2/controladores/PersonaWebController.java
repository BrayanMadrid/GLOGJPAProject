package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import idat.edu.pe.daa2.jpa.modelo.Ciudad;
import idat.edu.pe.daa2.jpa.modelo.Persona;
import idat.edu.pe.daa2.jpa.modelo.TipoPersona;
import idat.edu.pe.daa2.jpa.modelo.TipoPersonaEMP;
import idat.edu.pe.daa2.jpa.modelo.TipoPersonaJRD;
import idat.edu.pe.daa2.jpa.servicios.CiudadServicio;
import idat.edu.pe.daa2.jpa.servicios.PersonaServicio;
import idat.edu.pe.daa2.jpa.servicios.TipoPersonaEMPServicio;
import idat.edu.pe.daa2.jpa.servicios.TipoPersonaJRDServicio;
import idat.edu.pe.daa2.jpa.servicios.TipoPersonaServicio;

@Controller
@RequestMapping("/persona")
public class PersonaWebController {
	
	@Autowired 
	private PersonaServicio servicio;
	
	@Autowired 
	private CiudadServicio servicioCiudad;
	
	@Autowired 
	private TipoPersonaServicio servicioTipoPersona;
	
	@Autowired 
	private TipoPersonaJRDServicio servicioTipoPersonaJRD;
	
	@Autowired 
	private TipoPersonaEMPServicio servicioTipoPersonaEMP;
	
	@RequestMapping("/listarTodo")
	public String listarPersona(Model model) {
		List<Persona> listarPersona = servicio.buscarTodo();
		model.addAttribute("listarPersona", listarPersona);
		return "/moduloPersonas/listarTodo";
	}
	
	@RequestMapping("/nuevo")
	public String nuevaPersona(Model model) {
		Persona persona = new Persona();
		List<Ciudad> listCiudad = servicioCiudad.buscarTodo();
		List<TipoPersona> listTipoPersona = servicioTipoPersona.buscarTodo();
		List<TipoPersonaJRD> listTipoPersonaJRD = servicioTipoPersonaJRD.buscarTodo();
		List<TipoPersonaEMP> listTipoPersonaEMP = servicioTipoPersonaEMP.buscarTodo();
		model.addAttribute("persona", persona);
		model.addAttribute("ciudades", listCiudad);
		model.addAttribute("tipopersona", listTipoPersona);
		model.addAttribute("tipopersonajrd", listTipoPersonaJRD);
		model.addAttribute("tipopersonaemp", listTipoPersonaEMP);
		return "/moduloPersonas/nuevaPersona";
	}
	
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearPersona(@ModelAttribute("persona") Persona persona) {
		servicio.crear(persona);
	    return "redirect:/persona/listarTodo";
	}
	
	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarPersona(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloPersonas/editarPersona");
	    Persona persona = servicio.buscarPorID(id);
		List<Ciudad> listCiudad = servicioCiudad.buscarTodo();
		List<TipoPersona> listTipoPersona = servicioTipoPersona.buscarTodo();
		List<TipoPersonaJRD> listTipoPersonaJRD = servicioTipoPersonaJRD.buscarTodo();
		List<TipoPersonaEMP> listTipoPersonaEMP = servicioTipoPersonaEMP.buscarTodo();
	    mav.addObject("persona", persona);
		mav.addObject("ciudades", listCiudad);
		mav.addObject("tipopersona", listTipoPersona);
		mav.addObject("tipopersonajrd", listTipoPersonaJRD);
		mav.addObject("tipopersonaemp", listTipoPersonaEMP);
	    return mav;
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarPersona(@PathVariable(name = "id") int id) {
		servicio.borrarPorID(id);;
	    return "redirect:/persona/listarTodo";       
	}
	
	@RequestMapping ("/login")
	public String login(Model model) {
		return "/index";
	}
	
}
