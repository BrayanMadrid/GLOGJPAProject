package idat.edu.pe.daa2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import idat.edu.pe.daa2.jpa.modelo.Validacion;
import idat.edu.pe.daa2.jpa.servicios.ValidacionServicio;

@Controller
@RequestMapping("/validacion")
public class ValidacionWebController {
	
	@Autowired
	private ValidacionServicio servicioValidacion;
	
	@RequestMapping("/nuevo")
	public String nuevaValidacion(Model model) {
		Validacion validacion = new Validacion();
		model.addAttribute("validacion", validacion);
		return "/moduloAdministrativo/nuevaValidacion";
	}
	 
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearValidacion(@ModelAttribute("validacion") Validacion validacion) {
		servicioValidacion.crear(validacion);
	    return "redirect:/propitem/listarTodo";
	}
	
	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarValidacion(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloAdministrativo/editarValidacion");
	    Validacion validacion = servicioValidacion.buscarPorID(id);
	    mav.addObject("validacion", validacion);
	     
	    return mav;
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarValidacion(@PathVariable(name = "id") int id) {
		servicioValidacion.borrarPorID(id);;
	    return "redirect:/propitem/listarTodo";       
	}

}
