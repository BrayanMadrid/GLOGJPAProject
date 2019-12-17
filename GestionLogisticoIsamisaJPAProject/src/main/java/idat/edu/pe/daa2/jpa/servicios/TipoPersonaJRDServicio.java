package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.TipoPersonaJRD;
import idat.edu.pe.daa2.jpa.repositorios.TipoPersonaJRDRepositorio;

@Service
@Transactional
public class TipoPersonaJRDServicio {
	
	@Autowired
	private TipoPersonaJRDRepositorio repositorio;
	
	public TipoPersonaJRDServicio() {
		// TODO Auto-generated constructor stub
	}
	
	public List<TipoPersonaJRD> buscarTodo(){
		return (List<TipoPersonaJRD>) repositorio.findAll();
	}
	
	public TipoPersonaJRD crear(TipoPersonaJRD tipopersonaJRD) {
		return repositorio.save(tipopersonaJRD);
	}
	
	public TipoPersonaJRD actualizar(TipoPersonaJRD tipopersonaJRDActualizar) {
		TipoPersonaJRD tipopersonaJRDActual = repositorio.findById(tipopersonaJRDActualizar.getID_TIPO_PERSONA_JRD()).get();
		tipopersonaJRDActual.setDESC_TIPO_PERSONA_JRD(tipopersonaJRDActualizar.getDESC_TIPO_PERSONA_JRD());
		tipopersonaJRDActual.setID_TIPO_PERSONA_JRD(tipopersonaJRDActualizar.getID_TIPO_PERSONA_JRD());
		TipoPersonaJRD tipopersonaJRDActualizado = repositorio.save(tipopersonaJRDActual);
		return tipopersonaJRDActualizado;
	}

	public TipoPersonaJRD buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}

}
