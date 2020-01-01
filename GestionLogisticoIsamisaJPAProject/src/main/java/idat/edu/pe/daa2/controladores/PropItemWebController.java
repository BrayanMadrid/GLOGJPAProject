package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import idat.edu.pe.daa2.jpa.modelo.Validacion;
import idat.edu.pe.daa2.jpa.modelo.Clase;
import idat.edu.pe.daa2.jpa.modelo.Unmed;
import idat.edu.pe.daa2.jpa.modelo.SubFamiliaItem;
import idat.edu.pe.daa2.jpa.modelo.FamiliaItem;
import idat.edu.pe.daa2.jpa.servicios.ClaseServicio;
import idat.edu.pe.daa2.jpa.servicios.FamiliaItemServicio;
import idat.edu.pe.daa2.jpa.servicios.SubFamiliaItemServicio;
import idat.edu.pe.daa2.jpa.servicios.UnmedServicio;
import idat.edu.pe.daa2.jpa.servicios.ValidacionServicio;

@Controller
@RequestMapping("/propitem")
public class PropItemWebController {
	
	@Autowired
	private ValidacionServicio servicioValidacion;
	
	@Autowired
	private ClaseServicio servicioClase;
	
	@Autowired
	private UnmedServicio servicioUnmed;
	
	@Autowired
	private SubFamiliaItemServicio servicioSubFamiliaItem;
	
	@Autowired
	private FamiliaItemServicio servicioFamiliaItem;
	
	@RequestMapping("/listarTodo")
	public String listarPropItem (Model model) {
		List<Validacion> listarValidacion = servicioValidacion.buscarTodo();
		List<Clase> listarClase = servicioClase.buscarTodo();
		List<Unmed> listarUnmed = servicioUnmed.buscarTodo();
		List<SubFamiliaItem> listarSubFamiliaItem = servicioSubFamiliaItem.buscarTodo();
		List<FamiliaItem> listarFamiliaItem = servicioFamiliaItem.buscarTodo();
		model.addAttribute("listarValidacion", listarValidacion);
		model.addAttribute("listarClase", listarClase);
		model.addAttribute("listarUnmed", listarUnmed);
		model.addAttribute("listarSubFamiliaItem", listarSubFamiliaItem);
		model.addAttribute("listarFamiliaItem", listarFamiliaItem);
		return "/moduloAdministrativo/listaPropItem";
	}

}
