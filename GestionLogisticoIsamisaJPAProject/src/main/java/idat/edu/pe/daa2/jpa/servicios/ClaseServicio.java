package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Clase;
import idat.edu.pe.daa2.jpa.repositorios.ClaseRepositorio;

@Service
@Transactional
public class ClaseServicio {
	
	@Autowired
	private ClaseRepositorio repositorio;
	
	public ClaseServicio() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Clase> buscarTodo(){
		return (List<Clase>) repositorio.findAll();
	}
	
	public Clase crear(Clase clase) {
		return repositorio.save(clase);
	}
	
	public Clase actualizar(Clase claseActualizar) {
		Clase claseActual = repositorio.findById(claseActualizar.getID_CLASE()).get();
		claseActual.setDESC_CLASE(claseActualizar.getDESC_CLASE());
		Clase claseActualizado = repositorio.save(claseActual);
		return claseActualizado;
	}

	public Clase buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}


}
