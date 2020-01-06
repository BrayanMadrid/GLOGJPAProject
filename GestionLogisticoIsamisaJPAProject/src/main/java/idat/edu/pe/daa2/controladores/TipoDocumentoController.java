package idat.edu.pe.daa2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import idat.edu.pe.daa2.jpa.modelo.TipoDocumento;
import idat.edu.pe.daa2.jpa.servicios.TipoDocumentoServicio;

@Controller
@RequestMapping("/tipodocumento")
public class TipoDocumentoController {
	
	@Autowired
	private TipoDocumentoServicio servicioTipoDocumento;
	
	@RequestMapping("/nuevo")
	public String nuevaTipoDocumento(Model model) {
		TipoDocumento tipodocumento = new TipoDocumento();
		model.addAttribute("tipodocumento", tipodocumento);
		return "/moduloAdministrativo/nuevaTipoDocumento";
	}
	 
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearTipoDocumento(@ModelAttribute("tipodocumento") TipoDocumento tipodocumento) {
		servicioTipoDocumento.crear(tipodocumento);
	    return "redirect:/proptrans/listarTodo";
	}
	
	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarTipoDocumento(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloAdministrativo/editarTipoDocumento");
	    TipoDocumento tipodocumento = servicioTipoDocumento.buscarPorID(id);
	    mav.addObject("tipodocumento", tipodocumento);
	     
	    return mav;
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarTipoDocumento
	(@PathVariable(name = "id") int id) {
		servicioTipoDocumento.borrarPorID(id);;
	    return "redirect:/proptrans/listarTodo";       
	}

}
