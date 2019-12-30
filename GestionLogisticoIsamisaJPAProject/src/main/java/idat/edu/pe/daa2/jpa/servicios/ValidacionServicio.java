package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Validacion;
import idat.edu.pe.daa2.jpa.repositorios.ValidacionRepositorio;

@Service
@Transactional
public class ValidacionServicio {
	
	@Autowired
	private ValidacionRepositorio repositorio;
	
	public ValidacionServicio() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Validacion> buscarTodo(){
		return (List<Validacion>) repositorio.findAll();
	}
	
	public Validacion crear(Validacion validacion) {
		return repositorio.save(validacion);
	}
	
	public Validacion actualizar(Validacion validacionActualizar) {
		Validacion validacionActual = repositorio.findById(validacionActualizar.getCOD_VAL()).get();
		validacionActual.setDESC_VAL(validacionActualizar.getDESC_VAL());
		Validacion validacionActualizado = repositorio.save(validacionActual);
		return validacionActualizado;
	}

	public Validacion buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}

}
