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

import idat.edu.pe.daa2.jpa.modelo.Clase;
import idat.edu.pe.daa2.jpa.modelo.FamiliaItem;
import idat.edu.pe.daa2.jpa.modelo.Item;
import idat.edu.pe.daa2.jpa.modelo.SubFamiliaItem;
import idat.edu.pe.daa2.jpa.modelo.Unmed;
import idat.edu.pe.daa2.jpa.modelo.Validacion;
import idat.edu.pe.daa2.jpa.servicios.ClaseServicio;
import idat.edu.pe.daa2.jpa.servicios.FamiliaItemServicio;
import idat.edu.pe.daa2.jpa.servicios.ItemServicio;
import idat.edu.pe.daa2.jpa.servicios.SubFamiliaItemServicio;
import idat.edu.pe.daa2.jpa.servicios.UnmedServicio;
import idat.edu.pe.daa2.jpa.servicios.ValidacionServicio;

@Controller
@RequestMapping("/item")
public class ItemWebController {

	@Autowired
	private ItemServicio servicioItem;
	
	@Autowired
	private FamiliaItemServicio servicioFamiliaItem;
	
	@Autowired
	private SubFamiliaItemServicio servicioSubFamiliaItem;
	
	@Autowired
	private ValidacionServicio servicioValidacion;
	
	@Autowired
	private ClaseServicio servicioClase;
	
	@Autowired
	private UnmedServicio servicioUnmed;
	
	@RequestMapping("/listarTodo")
	public String listarItem(Model model) {
		List<Item> listarItem = servicioItem.buscarTodo();
		model.addAttribute("listarItem", listarItem);
		return "/moduloArticulos/listarArticulo";
	}
	
	@RequestMapping("/nuevo")
	public String nuevaItem(Model model) {
		Item item = new Item();
		List<Clase> listClase = servicioClase.buscarTodo();
		List<Validacion> listValidacion = servicioValidacion.buscarTodo();
		List<Unmed> listUnmed = servicioUnmed.buscarTodo();
		List<SubFamiliaItem> listSubFamiliaItem = servicioSubFamiliaItem.buscarTodo();
		List<FamiliaItem> listFamiliaItem = servicioFamiliaItem.buscarTodo();
		model.addAttribute("item", item);
		model.addAttribute("clase", listClase);
		model.addAttribute("validacion", listValidacion);
		model.addAttribute("unmed", listUnmed);
		model.addAttribute("subfamiliaitem", listSubFamiliaItem);
		model.addAttribute("familiaitem", listFamiliaItem);
		return "/moduloArticulos/nuevoArticulo";
	}
	
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearItem(@ModelAttribute("item") Item item) {
		servicioItem.crear(item);
	    return "redirect:/item/listarTodo";
	}
	
	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarItem(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloArticulos/editarArticulo");
	    Item item = servicioItem.buscarPorID(id);
	    List<Clase> listClase = servicioClase.buscarTodo();
		List<Validacion> listValidacion = servicioValidacion.buscarTodo();
		List<Unmed> listUnmed = servicioUnmed.buscarTodo();
		List<SubFamiliaItem> listSubFamiliaItem = servicioSubFamiliaItem.buscarTodo();
		List<FamiliaItem> listFamiliaItem = servicioFamiliaItem.buscarTodo();
	    mav.addObject("item", item);
	    mav.addObject("clase", listClase);
	    mav.addObject("validacion", listValidacion);
	    mav.addObject("unmed", listUnmed);
	    mav.addObject("subfamiliaitem", listSubFamiliaItem);
	    mav.addObject("familiaitem", listFamiliaItem);
	    return mav;
	}

	@RequestMapping("/eliminar/{id}")
	public String eliminarItem(@PathVariable(name = "id") int id) {
		servicioItem.borrarPorID(id);;
	    return "redirect:/item/listarTodo";       
	}
	
	
	@RequestMapping ("/login")
	public String login(Model model) {
		return "/index";
	}

}
