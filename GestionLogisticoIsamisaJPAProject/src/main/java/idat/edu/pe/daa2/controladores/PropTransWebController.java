package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import idat.edu.pe.daa2.jpa.modelo.Almacen;
import idat.edu.pe.daa2.jpa.modelo.SubAlmacen;
import idat.edu.pe.daa2.jpa.servicios.AlmacenServicio;
import idat.edu.pe.daa2.jpa.servicios.SubAlmacenServicio;

@Controller
@RequestMapping("/proptrans")
public class PropTransWebController {
	
	@Autowired
	private AlmacenServicio servicioAlmacen;
	
	@Autowired
	private SubAlmacenServicio servicioSubAlmacen;
	
	@RequestMapping("/listarTodo")
	public String listarPropTrans (Model model) {
		List<Almacen> listarAlmacen = servicioAlmacen.buscarTodo();
		List<SubAlmacen> listarSubAlmacen = servicioSubAlmacen.buscarTodo();
		model.addAttribute("listarAlmacen", listarAlmacen);
		model.addAttribute("listarSubAlmacen", listarSubAlmacen);
		return "/moduloAdministrativo/listaPropTrans";
	}


}
