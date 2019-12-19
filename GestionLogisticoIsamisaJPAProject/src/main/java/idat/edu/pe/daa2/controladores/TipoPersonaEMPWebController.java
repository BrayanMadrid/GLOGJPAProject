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

import idat.edu.pe.daa2.jpa.modelo.TipoPersonaEMP;
import idat.edu.pe.daa2.jpa.servicios.TipoPersonaEMPServicio;

@Controller
@RequestMapping("/tipopersonaEMP")
public class TipoPersonaEMPWebController {
	
	@Autowired
	private TipoPersonaEMPServicio servicio;
	
	@RequestMapping("/listarTodo")
	public String listarTipoPersonaEMP(Model model) {
		List<TipoPersonaEMP> listarTipoPersonaEMP = servicio.buscarTodo();
		model.addAttribute("listarTipoPersonaEMP", listarTipoPersonaEMP);
		return "/moduloAdministrativo/listaGeneral";
	}
	
	@RequestMapping("/nuevo")
	public String nuevaTipoPersonaEMP(Model model) {
		TipoPersonaEMP tipopersonaEMP = new TipoPersonaEMP();
		model.addAttribute("tipopersonaEMP", tipopersonaEMP);
		return "/moduloAdministrativo/nuevaTipoPersonaEMP";
	}
	
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearTipoPersonaEMP(@ModelAttribute("tipopersonaEMP") TipoPersonaEMP tipopersonaEMP) {
		servicio.crear(tipopersonaEMP);
	    return "redirect:/tipopersona/listarTodo";
	}
	
	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarTipoPersonaEMP(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloAdministrativo/editarTipoPersonaEMP");
	    TipoPersonaEMP tipopersonaEMP = servicio.buscarPorID(id);
	    mav.addObject("tipopersonaEMP", tipopersonaEMP);
	     
	    return mav;
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarTipoPersonaEMP(@PathVariable(name = "id") int id) {
		servicio.borrarPorID(id);;
	    return "redirect:/tipopersona/listarTodo";       
	}

}
