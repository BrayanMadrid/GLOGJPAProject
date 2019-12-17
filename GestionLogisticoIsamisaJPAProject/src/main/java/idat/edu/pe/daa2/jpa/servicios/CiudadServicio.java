package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Ciudad;
import idat.edu.pe.daa2.jpa.repositorios.CiudadRepositorio;

@Service
@Transactional
public class CiudadServicio {

	@Autowired
	private CiudadRepositorio repositorio;
	
	public CiudadServicio() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Ciudad> buscarTodo(){
		return (List<Ciudad>) repositorio.findAll();
	}
	
	public Ciudad crear(Ciudad ciudad) {
		return repositorio.save(ciudad);
	}
	
	public Ciudad actualizar(Ciudad ciudadActualizar) {
		Ciudad ciudadActual = repositorio.findById(ciudadActualizar.getID_CIUDAD()).get();
		ciudadActual.setDESC_CIUDAD(ciudadActualizar.getDESC_CIUDAD());
		ciudadActual.setID_DEP(ciudadActualizar.getID_DEP());
		Ciudad ciudadActualizado = repositorio.save(ciudadActual);
		return ciudadActualizado;
	}

	public Ciudad buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}

}

