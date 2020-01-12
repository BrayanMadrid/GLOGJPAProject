package idat.edu.pe.daa2.jpa.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.Persona;

public interface PersonaRepositorio extends CrudRepository<Persona, Integer> {


	
	 
	@Query("SELECT p FROM Persona p WHERE p.ID_TIPO_PERSONA_EMP.ID_TIPO_PERSONA_EMP = ?1")
	public List<Persona> filtrarPersonasPorTipo (Integer idTipoPersona);
	
	  
}
