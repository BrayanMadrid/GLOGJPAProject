package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import idat.edu.pe.daa2.jpa.modelo.Persona;
import idat.edu.pe.daa2.jpa.servicios.PersonaServicio;

@Controller
@RequestMapping("/proveedor")
public class ProveedorWebController {
	
	@Autowired 
	private PersonaServicio servicio;
	
	@RequestMapping("/listarTodo")
	public String listarProveedor(Model model) {
		List<Persona> listarProveedor = servicio.buscarPersonaPorTipo(2);
		model.addAttribute("listarProveedor", listarProveedor);
		return "/moduloProveedores/listarTodo";
	}

}
