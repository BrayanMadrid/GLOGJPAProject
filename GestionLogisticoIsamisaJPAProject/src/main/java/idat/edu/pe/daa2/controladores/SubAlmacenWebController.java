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

import idat.edu.pe.daa2.jpa.modelo.SubAlmacen;
import idat.edu.pe.daa2.jpa.modelo.Almacen;
import idat.edu.pe.daa2.jpa.servicios.AlmacenServicio;
import idat.edu.pe.daa2.jpa.servicios.SubAlmacenServicio;

@Controller
@RequestMapping("/subalmacen")
public class SubAlmacenWebController {
	
	@Autowired
	private SubAlmacenServicio servicioSubAlmacen;
	
	@Autowired
	private AlmacenServicio servicioAlmacen;
	
	@RequestMapping("/nuevo")
	public String nuevaSubAlmacen(Model model) {
		SubAlmacen subalmacen = new SubAlmacen();
		model.addAttribute("subalmacen", subalmacen);
		List<Almacen> listAlmacen = servicioAlmacen.buscarTodo();
		model.addAttribute("almacen",listAlmacen);
		return "/moduloAdministrativo/nuevaSubAlmacen";
	}
	 
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearSubAlmacen(@ModelAttribute("subalmacen") SubAlmacen subalmacen) {
		servicioSubAlmacen.crear(subalmacen);
	    return "redirect:/proptrans/listarTodo";
	}
	
	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarSubAlmacen(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloAdministrativo/editarSubAlmacen");
	    SubAlmacen subalmacen = servicioSubAlmacen.buscarPorID(id);
	    List<Almacen> listAlmacen = servicioAlmacen.buscarTodo();
		mav.addObject("almacen",listAlmacen);
	    mav.addObject("subalmacen", subalmacen);
	     
	    return mav;
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarSubAlmacen
	(@PathVariable(name = "id") int id) {
		servicioSubAlmacen.borrarPorID(id);;
	    return "redirect:/proptrans/listarTodo";       
	}

}
