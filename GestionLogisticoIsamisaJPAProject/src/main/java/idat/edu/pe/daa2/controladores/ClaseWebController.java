package idat.edu.pe.daa2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import idat.edu.pe.daa2.jpa.modelo.Clase;
import idat.edu.pe.daa2.jpa.servicios.ClaseServicio;

@Controller
@RequestMapping("/clase")
public class ClaseWebController {
	
	
	@Autowired
	private ClaseServicio servicioClase;
	
	@RequestMapping("/nuevo")
	public String nuevaClase(Model model) {
		Clase clase = new Clase();
		model.addAttribute("clase", clase);
		return "/moduloAdministrativo/nuevaClase";
	}
	 
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearClase(@ModelAttribute("clase") Clase clase) {
		servicioClase.crear(clase);
	    return "redirect:/propitem/listarTodo";
	}
	
	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarClase(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloAdministrativo/editarClase");
	    Clase clase = servicioClase.buscarPorID(id);
	    mav.addObject("clase", clase);
	     
	    return mav;
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarClase
	(@PathVariable(name = "id") int id) {
		servicioClase.borrarPorID(id);;
	    return "redirect:/propitem/listarTodo";       
	}

}
