package idat.edu.pe.daa2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import idat.edu.pe.daa2.jpa.modelo.FamiliaItem;
import idat.edu.pe.daa2.jpa.servicios.FamiliaItemServicio;

@Controller
@RequestMapping("/familiaitem")
public class FamiliaWebController {
	

	@Autowired
	private FamiliaItemServicio servicioFamiliaItem;
	
	@RequestMapping("/nuevo")
	public String nuevaFamiliaItem(Model model) {
		FamiliaItem familiaitem = new FamiliaItem();
		model.addAttribute("familiaitem", familiaitem);
		return "/moduloAdministrativo/nuevaFamiliaItem";
	}
	 
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearFamiliaItem(@ModelAttribute("familiaitem") FamiliaItem familiaitem) {
		servicioFamiliaItem.crear(familiaitem);
	    return "redirect:/propitem/listarTodo";
	}
	
	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarFamiliaItem(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloAdministrativo/editarFamiliaItem");
	    FamiliaItem familiaitem = servicioFamiliaItem.buscarPorID(id);
	    mav.addObject("familiaitem", familiaitem);
	     
	    return mav;
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarFamiliaItem
	(@PathVariable(name = "id") int id) {
		servicioFamiliaItem.borrarPorID(id);;
	    return "redirect:/propitem/listarTodo";       
	}

}
