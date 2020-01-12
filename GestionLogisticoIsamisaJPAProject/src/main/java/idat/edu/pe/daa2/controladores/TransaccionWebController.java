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

import idat.edu.pe.daa2.jpa.modelo.DetTransaccion;
import idat.edu.pe.daa2.jpa.modelo.Item;
import idat.edu.pe.daa2.jpa.modelo.Persona;
import idat.edu.pe.daa2.jpa.modelo.SubAlmacen;
import idat.edu.pe.daa2.jpa.modelo.TipoTransaccion;
import idat.edu.pe.daa2.jpa.modelo.Transaccion;
import idat.edu.pe.daa2.jpa.servicios.ItemServicio;
import idat.edu.pe.daa2.jpa.servicios.PersonaServicio;
import idat.edu.pe.daa2.jpa.servicios.SubAlmacenServicio;
import idat.edu.pe.daa2.jpa.servicios.TipoTransaccionServicio;
import idat.edu.pe.daa2.jpa.servicios.TransaccionServicio;

@Controller
@RequestMapping("/transaccion")
public class TransaccionWebController {
	
	@Autowired
	private TransaccionServicio servicioTransaccion;
	
	@Autowired
	private SubAlmacenServicio servicioSubAlmacen;
	
	@Autowired
	private PersonaServicio servicioPersona;
	
	@Autowired
	private TipoTransaccionServicio servicioTipoTransaccion;
	
	@Autowired
	private ItemServicio servicioItem;
	
	@RequestMapping("/nuevo")
	public String nuevaTransaccion(Model model) {
		Transaccion transaccion = new Transaccion();
		model.addAttribute("transaccion", transaccion);
		DetTransaccion dettransaccion =  new DetTransaccion();
		model.addAttribute("dettransaccion",dettransaccion);
		List<Item> listItem = servicioItem.buscarTodo();
		System.out.println("lista : " + listItem.size());
		model.addAttribute("item",listItem);
		List<SubAlmacen> listSubAlmacen = servicioSubAlmacen.buscarTodo();
		model.addAttribute("subalmacen",listSubAlmacen);
		List<Persona> listPersona = servicioPersona.buscarTodo();
		model.addAttribute("persona",listPersona);
		List<TipoTransaccion> listTipoTransaccion = servicioTipoTransaccion.buscarTodo();
		model.addAttribute("tipotransaccion",listTipoTransaccion);
		return "/moduloTransacciones/nuevaTransaccion";
	}
	 
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearTransaccion(@ModelAttribute("transaccion") Transaccion transaccion) {
		servicioTransaccion.crear(transaccion);
	    return "redirect:/moduloTransacciones/listarTodo";
	}
	
	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarTransaccion(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloTransacciones/editarTransaccion");
	    Transaccion transaccion = servicioTransaccion.buscarPorID(id);
	    mav.addObject("transaccion", transaccion);
	     
	    return mav;
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarTransaccion
	(@PathVariable(name = "id") int id) {
		servicioTransaccion.borrarPorID(id);;
	    return "redirect:/moduloTransaccion/listarTodo";       
	}

}
