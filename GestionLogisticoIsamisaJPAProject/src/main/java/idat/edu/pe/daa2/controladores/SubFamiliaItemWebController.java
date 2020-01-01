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

import idat.edu.pe.daa2.jpa.modelo.SubFamiliaItem;
import idat.edu.pe.daa2.jpa.modelo.FamiliaItem;
import idat.edu.pe.daa2.jpa.servicios.FamiliaItemServicio;
import idat.edu.pe.daa2.jpa.servicios.SubFamiliaItemServicio;

@Controller
@RequestMapping("/subfamiliaitem")
public class SubFamiliaItemWebController {
	
	@Autowired
	private SubFamiliaItemServicio servicioSubFamiliaItem;
	
	@Autowired
	private FamiliaItemServicio servicioFamiliaItem;
	
	@RequestMapping("/nuevo")
	public String nuevaSubFamiliaItem(Model model) {
		SubFamiliaItem subfamiliaitem = new SubFamiliaItem();
		List<FamiliaItem> listFamiliaItem = servicioFamiliaItem.buscarTodo();
		model.addAttribute("subfamiliaitem", subfamiliaitem);
		model.addAttribute("familiaitem",listFamiliaItem);
		return "/moduloAdministrativo/nuevaSubFamiliaItem";
	}
	 
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearSubFamiliaItem(@ModelAttribute("subfamiliaitem") SubFamiliaItem subfamiliaitem) {
		servicioSubFamiliaItem.crear(subfamiliaitem);
	    return "redirect:/propitem/listarTodo";
	}
	
	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarSubFamiliaItem(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloAdministrativo/editarSubFamiliaItem");
	    SubFamiliaItem subfamiliaitem = servicioSubFamiliaItem.buscarPorID(id);
	    List<FamiliaItem> listFamiliaItem = servicioFamiliaItem.buscarTodo();
	    mav.addObject("subfamiliaitem", subfamiliaitem);
	    mav.addObject("familiaitem", listFamiliaItem);
	    return mav;
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarSubFamiliaItem
	(@PathVariable(name = "id") int id) {
		servicioSubFamiliaItem.borrarPorID(id);;
	    return "redirect:/propitem/listarTodo";       
	}

}
