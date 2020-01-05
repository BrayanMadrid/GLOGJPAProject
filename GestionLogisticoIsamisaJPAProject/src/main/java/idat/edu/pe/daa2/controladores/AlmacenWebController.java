package idat.edu.pe.daa2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import idat.edu.pe.daa2.jpa.modelo.Almacen;
import idat.edu.pe.daa2.jpa.servicios.AlmacenServicio;

@Controller
@RequestMapping("/almacen")
public class AlmacenWebController {
	
	@Autowired
	private AlmacenServicio servicioAlmacen;
	
	@RequestMapping("/nuevo")
	public String nuevaAlmacen(Model model) {
		Almacen almacen = new Almacen();
		model.addAttribute("almacen", almacen);
		return "/moduloAdministrativo/nuevaAlmacen";
	}
	 
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearAlmacen(@ModelAttribute("almacen") Almacen almacen) {
		servicioAlmacen.crear(almacen);
	    return "redirect:/proptrans/listarTodo";
	}
	
	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarAlmacen(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloAdministrativo/editarAlmacen");
	    Almacen almacen = servicioAlmacen.buscarPorID(id);
	    mav.addObject("almacen", almacen);
	     
	    return mav;
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarAlmacen
	(@PathVariable(name = "id") int id) {
		servicioAlmacen.borrarPorID(id);;
	    return "redirect:/proptrans/listarTodo";       
	}

}

