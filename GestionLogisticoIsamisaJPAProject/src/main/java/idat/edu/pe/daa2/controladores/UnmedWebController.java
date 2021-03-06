package idat.edu.pe.daa2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import idat.edu.pe.daa2.jpa.modelo.Unmed;
import idat.edu.pe.daa2.jpa.servicios.UnmedServicio;

@Controller
@RequestMapping("/unmed")
public class UnmedWebController {
	
	@Autowired
	private UnmedServicio servicioUnmed;
	
	@RequestMapping("/nuevo")
	public String nuevaUnmed(Model model) {
		Unmed unmed = new Unmed();
		model.addAttribute("unmed", unmed);
		return "/moduloAdministrativo/nuevaUnmed";
	}
	 
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearUnmed(@ModelAttribute("unmed") Unmed unmed) {
		servicioUnmed.crear(unmed);
	    return "redirect:/propitem/listarTodo";
	}
	
	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarUnmed(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloAdministrativo/editarUnmed");
	    Unmed unmed = servicioUnmed.buscarPorID(id);
	    mav.addObject("unmed", unmed);
	     
	    return mav;
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarUnmed(@PathVariable(name = "id") int id) {
		servicioUnmed.borrarPorID(id);;
	    return "redirect:/propitem/listarTodo";       
	}

}
