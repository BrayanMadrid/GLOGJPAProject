package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.TipoPersonaEMP;
import idat.edu.pe.daa2.jpa.repositorios.TipoPersonaEMPRepositorio;

@Service
@Transactional
public class TipoPersonaEMPServicio {
	
	@Autowired
	private TipoPersonaEMPRepositorio repositorio;
	
	public TipoPersonaEMPServicio() {
		// TODO Auto-generated constructor stub
	}
	
	public List<TipoPersonaEMP> buscarTodo(){
		return (List<TipoPersonaEMP>) repositorio.findAll();
	}
	
	public TipoPersonaEMP crear(TipoPersonaEMP tipopersonaEMP) {
		return repositorio.save(tipopersonaEMP);
	}
	
	public TipoPersonaEMP actualizar(TipoPersonaEMP tipopersonaEMPActualizar) {
		TipoPersonaEMP tipopersonaEMPActual = repositorio.findById(tipopersonaEMPActualizar.getID_TIPO_PERSONA_EMP()).get();
		tipopersonaEMPActual.setDESC_TIPO_PERSONA_EMP(tipopersonaEMPActualizar.getDESC_TIPO_PERSONA_EMP());
		tipopersonaEMPActual.setID_TIPO_PERSONA_EMP(tipopersonaEMPActualizar.getID_TIPO_PERSONA_EMP());
		TipoPersonaEMP tipopersonaEMPActualizado = repositorio.save(tipopersonaEMPActual);
		return tipopersonaEMPActualizado;
	}

	public TipoPersonaEMP buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}

}
