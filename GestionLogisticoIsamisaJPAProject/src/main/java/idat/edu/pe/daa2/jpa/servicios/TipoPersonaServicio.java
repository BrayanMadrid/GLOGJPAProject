package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.TipoPersona;
import idat.edu.pe.daa2.jpa.repositorios.TipoPersonaRepositorio;


@Service
@Transactional
public class TipoPersonaServicio {
	@Autowired
	private TipoPersonaRepositorio repositorio;

	public TipoPersonaServicio() {
		// TODO Auto-generated constructor stub
	}
	
	public List<TipoPersona> buscarTodo(){
		return (List<TipoPersona>) repositorio.findAll();
	}
	
	public TipoPersona crear(TipoPersona tipopersona) {
		return repositorio.save(tipopersona);
	}
	
	public TipoPersona actualizar(TipoPersona tipopersonaActualizar) {
		TipoPersona tipopersonaActual = repositorio.findById(tipopersonaActualizar.getID_TIPO_PERSONA()).get();
		tipopersonaActual.setDESC_TIPO_PERSONA(tipopersonaActualizar.getDESC_TIPO_PERSONA());
		tipopersonaActual.setID_TIPO_PERSONA(tipopersonaActualizar.getID_TIPO_PERSONA());
		TipoPersona tipopersonaActualizado = repositorio.save(tipopersonaActual);
		return tipopersonaActualizado;
	}

	public TipoPersona buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}


}
