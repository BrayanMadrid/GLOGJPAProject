package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import idat.edu.pe.daa2.jpa.modelo.Almacen;
import idat.edu.pe.daa2.jpa.modelo.SubAlmacen;
import idat.edu.pe.daa2.jpa.modelo.TipoDocumento;
import idat.edu.pe.daa2.jpa.modelo.TipoTransaccion;
import idat.edu.pe.daa2.jpa.servicios.AlmacenServicio;
import idat.edu.pe.daa2.jpa.servicios.SubAlmacenServicio;
import idat.edu.pe.daa2.jpa.servicios.TipoDocumentoServicio;
import idat.edu.pe.daa2.jpa.servicios.TipoTransaccionServicio;

@Controller
@RequestMapping("/proptrans")
public class PropTransWebController {
	
	@Autowired
	private AlmacenServicio servicioAlmacen;
	
	@Autowired
	private SubAlmacenServicio servicioSubAlmacen;
	
	@Autowired
	private TipoDocumentoServicio servicioTipoDocumento;
	
	@Autowired
	private TipoTransaccionServicio servicioTipoTransaccion;
	
	@RequestMapping("/listarTodo")
	public String listarPropTrans (Model model) {
		List<Almacen> listarAlmacen = servicioAlmacen.buscarTodo();
		List<SubAlmacen> listarSubAlmacen = servicioSubAlmacen.buscarTodo();
		List<TipoDocumento> listarTipoDocumento = servicioTipoDocumento.buscarTodo();
		List<TipoTransaccion> listarTipoTransaccion = servicioTipoTransaccion.buscarTodo();
		model.addAttribute("listarAlmacen", listarAlmacen);
		model.addAttribute("listarSubAlmacen", listarSubAlmacen);
		model.addAttribute("listarTipoDocumento", listarTipoDocumento);
		model.addAttribute("listarTipoTransaccion", listarTipoTransaccion);
		return "/moduloAdministrativo/listaPropTrans";
	}


}
