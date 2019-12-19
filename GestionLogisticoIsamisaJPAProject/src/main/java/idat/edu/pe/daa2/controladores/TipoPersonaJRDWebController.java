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

import idat.edu.pe.daa2.jpa.modelo.TipoPersonaJRD;
import idat.edu.pe.daa2.jpa.servicios.TipoPersonaJRDServicio;

@Controller
@RequestMapping("/tipopersonaJRD")
public class TipoPersonaJRDWebController {
	
	@Autowired
	private TipoPersonaJRDServicio servicio;
	
	@RequestMapping("/listarTodoJRD")
	public String listarTipoPersonaJRD(Model model) {
		List<TipoPersonaJRD> listarTipoPersonaJRD = servicio.buscarTodo();
		model.addAttribute("listarTipoPersonaJRD", listarTipoPersonaJRD);
		return "/moduloAdministrativo/listaGeneral";
	}
	
	@RequestMapping("/nuevo")
	public String nuevaTipoPersonaJRD(Model model) {
		TipoPersonaJRD tipopersonaJRD = new TipoPersonaJRD();
		model.addAttribute("tipopersonaJRD", tipopersonaJRD);
		return "/moduloAdministrativo/nuevaTipoPersonaJRD";
	}
	
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearTipoPersonaJRD(@ModelAttribute("tipopersonaJRD") TipoPersonaJRD tipopersonaJRD) {
		servicio.crear(tipopersonaJRD);
	    return "redirect:/tipopersona/listarTodo";
	}
	
	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarTipoPersonaJRD(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloAdministrativo/editarTipoPersonaJRD");
	    TipoPersonaJRD tipopersonaJRD = servicio.buscarPorID(id);
	    mav.addObject("tipopersonaJRD", tipopersonaJRD);
	     
	    return mav;
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarTipoPersonaJRD(@PathVariable(name = "id") int id) {
		servicio.borrarPorID(id);;
	    return "redirect:/tipopersona/listarTodo";       
	}

}
