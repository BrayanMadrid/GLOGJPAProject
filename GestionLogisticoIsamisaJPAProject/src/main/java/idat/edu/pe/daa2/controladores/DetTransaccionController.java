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

import idat.edu.pe.daa2.jpa.modelo.Transaccion;
import idat.edu.pe.daa2.jpa.modelo.DetTransaccion;
import idat.edu.pe.daa2.jpa.modelo.Item;
import idat.edu.pe.daa2.jpa.servicios.TransaccionServicio;
import idat.edu.pe.daa2.jpa.servicios.DetTransaccionServicio;
import idat.edu.pe.daa2.jpa.servicios.ItemServicio;

@Controller
@RequestMapping("/dettransaccion")
public class DetTransaccionController {
	
	@Autowired
	private TransaccionServicio servicioTransaccion;
	
	@Autowired
	private DetTransaccionServicio servicioDetTransaccion;
	
	@Autowired
	private ItemServicio servicioItem;
	
	
	@RequestMapping("/nuevo")
	public String nuevaDetTransaccion(Model model) {
		DetTransaccion dettransaccion = new DetTransaccion();
		model.addAttribute("dettransaccion", dettransaccion);
		List<Transaccion> listTransaccion = servicioTransaccion.buscarTodo();
		model.addAttribute("transaccion",listTransaccion);
		List<Item> listItem = servicioItem.buscarTodo();
		model.addAttribute("item",listItem);
		return "/moduloTransacciones/nuevaTransaccion";
	}
	 
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearDetTransaccion(@ModelAttribute("dettransaccion") DetTransaccion dettransaccion) {
		servicioDetTransaccion.crear(dettransaccion);
	    return "redirect:/moduloTransacciones/listarTodo";
	}
	
	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarDetTransaccion(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloTransacciones/editarTransaccion");
	    DetTransaccion dettransaccion = servicioDetTransaccion.buscarPorID(id);
	    mav.addObject("dettransaccion", dettransaccion);
	     
	    return mav;
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarDetTransaccion
	(@PathVariable(name = "id") int id) {
		servicioDetTransaccion.borrarPorID(id);;
	    return "redirect:/moduloTransaccion/listarTodo";       
	}

}
