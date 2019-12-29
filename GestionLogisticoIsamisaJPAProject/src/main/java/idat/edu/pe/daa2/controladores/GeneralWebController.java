package idat.edu.pe.daa2.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/principal")
public class GeneralWebController {
	
	@RequestMapping("/inicio")
	public String inicio(Model model) {
		return "/home";
	}
	
	@RequestMapping("/general")
	public String General(Model model) {
		return "/moduloAdministrativo/listaGeneral";
	}
	

}
