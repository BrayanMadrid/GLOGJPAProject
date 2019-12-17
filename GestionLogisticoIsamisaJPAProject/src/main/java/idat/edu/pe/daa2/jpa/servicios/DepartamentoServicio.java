package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Departamento;
import idat.edu.pe.daa2.jpa.repositorios.DepartamentoRepositorio;

@Service
@Transactional
public class DepartamentoServicio {
	
	

	@Autowired
	private DepartamentoRepositorio repositorio;

	public DepartamentoServicio() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Departamento> buscarTodo(){
		return (List<Departamento>) repositorio.findAll();
	}
	
	public Departamento crear(Departamento departamento) {
		return repositorio.save(departamento);
	}
	
	public Departamento actualizar(Departamento departamentoActualizar) {
		Departamento departamentoActual = repositorio.findById(departamentoActualizar.getID_DEP()).get();
		departamentoActual.setDESC_DEP(departamentoActualizar.getDESC_DEP());
		departamentoActual.setID_PAIS(departamentoActualizar.getID_PAIS());
		Departamento departamentoActualizado = repositorio.save(departamentoActual);
		return departamentoActualizado;
	}

	public Departamento buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}

}
