package idat.edu.pe.daa2.jpa.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Persona;
import idat.edu.pe.daa2.jpa.repositorios.PersonaRepositorio;


@Service
@Transactional
public class PersonaServicio {
@Autowired
private PersonaRepositorio repositorio;

	public PersonaServicio() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Persona> buscarTodo(){
		return (ArrayList<Persona>) repositorio.findAll();
	}
	
	public List<Persona> buscarPersonaPorTipo(Integer idTipoPersona){
		return (ArrayList<Persona>) repositorio.filtrarPersonasPorTipo(idTipoPersona);
	}
	
	public Persona crear(Persona persona) {
		return repositorio.save(persona);
	}
	
	public Persona actualizar(Persona personaActualizar) {
		Persona personaActual = repositorio.findById(personaActualizar.getID_PERSONA()).get();
		personaActual.setNOM1_PERSONA(personaActualizar.getNOM1_PERSONA());
		personaActual.setNOM2_PERSONA(personaActualizar.getNOM2_PERSONA());
		personaActual.setAPE_PAT_PERSONA(personaActualizar.getAPE_PAT_PERSONA());
		personaActual.setAPE_MAT_PERSONA(personaActualizar.getAPE_MAT_PERSONA());
		personaActual.setDNI_PERSONA(personaActualizar.getDNI_PERSONA());
		personaActual.setRUC_PERSONA(personaActualizar.getRUC_PERSONA());
		personaActual.setID_CIUDAD(personaActualizar.getID_CIUDAD());
		personaActual.setID_TIPO_PERSONA(personaActualizar.getID_TIPO_PERSONA());
		Persona personaActualizado = repositorio.save(personaActual);
		return personaActualizado;
	}

	public Persona buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}

}
