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

import idat.edu.pe.daa2.jpa.modelo.TipoPersona;
import idat.edu.pe.daa2.jpa.modelo.TipoPersonaEMP;
import idat.edu.pe.daa2.jpa.modelo.TipoPersonaJRD;
import idat.edu.pe.daa2.jpa.servicios.TipoPersonaEMPServicio;
import idat.edu.pe.daa2.jpa.servicios.TipoPersonaJRDServicio;
import idat.edu.pe.daa2.jpa.servicios.TipoPersonaServicio;


@Controller
@RequestMapping("/tipopersona")
public class TipoPersonaWebController {
	
	@Autowired
	private TipoPersonaServicio servicio;
	
	@Autowired
	private TipoPersonaJRDServicio servicioJRD;
	
	@Autowired
	private TipoPersonaEMPServicio servicioEMP; 
	
	
	@RequestMapping("/listarTodo")
	public String listarTipoPersona(Model model) {
		List<TipoPersona> listarTipoPersona = servicio.buscarTodo();
		List<TipoPersonaJRD> listarTipoPersonaJRD = servicioJRD.buscarTodo();
		List<TipoPersonaEMP> listarTipoPersonaEMP = servicioEMP.buscarTodo();
		model.addAttribute("listarTipoPersonaEMP", listarTipoPersonaEMP);
		model.addAttribute("listarTipoPersonaJRD", listarTipoPersonaJRD);
		model.addAttribute("listarTipoPersona", listarTipoPersona);
		return "/moduloAdministrativo/listaPropPersonas";
	}
	
	@RequestMapping("/nuevo")
	public String nuevaTipoPersona(Model model) {
		TipoPersona tipopersona = new TipoPersona();
		model.addAttribute("tipopersona", tipopersona);
		return "/moduloAdministrativo/nuevaTipoPersona";
	}
	 
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearTipoPersona(@ModelAttribute("tipopersona") TipoPersona tipopersona) {
		servicio.crear(tipopersona);
	    return "redirect:/tipopersona/listarTodo";
	}
	
	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarTipoPersona(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloAdministrativo/editarTipoPersona");
	    TipoPersona tipopersona = servicio.buscarPorID(id);
	    mav.addObject("tipopersona", tipopersona);
	     
	    return mav;
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarTipoPersona(@PathVariable(name = "id") int id) {
		servicio.borrarPorID(id);;
	    return "redirect:/tipopersona/listarTodo";       
	}


}
