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

import idat.edu.pe.daa2.jpa.modelo.TipoDocumento;
import idat.edu.pe.daa2.jpa.modelo.TipoTransaccion;
import idat.edu.pe.daa2.jpa.servicios.TipoDocumentoServicio;
import idat.edu.pe.daa2.jpa.servicios.TipoTransaccionServicio;

@Controller
@RequestMapping("/tipotransaccion")
public class TipoTransaccionController {
	
	@Autowired
	private TipoTransaccionServicio servicioTipoTransaccion;
	
	@Autowired
	private TipoDocumentoServicio servicioTipoDocumento;
	
	@RequestMapping("/nuevo")
	public String nuevaTipoTransaccion(Model model) {
		TipoTransaccion tipotransaccion = new TipoTransaccion();
		model.addAttribute("tipotransaccion", tipotransaccion);
		List<TipoDocumento> listTipoDocumento = servicioTipoDocumento.buscarTodo();
		model.addAttribute("tipodocumento",listTipoDocumento);
		return "/moduloAdministrativo/nuevaTipoTransaccion";
	}
	 
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearTipoTransaccion(@ModelAttribute("tipotransaccion") TipoTransaccion tipotransaccion) {
		servicioTipoTransaccion.crear(tipotransaccion);
	    return "redirect:/proptrans/listarTodo";
	}
	
	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarTipoTransaccion(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloAdministrativo/editarTipoTransaccion");
	    TipoTransaccion tipotransaccion = servicioTipoTransaccion.buscarPorID(id);
	    List<TipoDocumento> listTipoDocumento = servicioTipoDocumento.buscarTodo();
		mav.addObject("tipodocumento",listTipoDocumento);
	    mav.addObject("tipotransaccion", tipotransaccion);
	     
	    return mav;
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarTipoTransaccion
	(@PathVariable(name = "id") int id) {
		servicioTipoTransaccion.borrarPorID(id);;
	    return "redirect:/proptrans/listarTodo";       
	}


}
