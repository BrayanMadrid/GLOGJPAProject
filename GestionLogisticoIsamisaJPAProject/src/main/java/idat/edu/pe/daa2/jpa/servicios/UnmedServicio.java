package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Unmed;
import idat.edu.pe.daa2.jpa.repositorios.UnmedRepositorio;

@Service
@Transactional
public class UnmedServicio {

	@Autowired
	private UnmedRepositorio repositorio;
	
	public UnmedServicio() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Unmed> buscarTodo(){
		return (List<Unmed>) repositorio.findAll();
	}
	
	public Unmed crear(Unmed unmed) {
		return repositorio.save(unmed);
	}
	
	public Unmed actualizar(Unmed unmedActualizar) {
		Unmed unmedActual = repositorio.findById(unmedActualizar.getID_UNMED()).get();
		unmedActual.setDESC_UNMED(unmedActualizar.getDESC_UNMED());
		Unmed unmedActualizado = repositorio.save(unmedActual);
		return unmedActualizado;
	}

	public Unmed buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}


}
