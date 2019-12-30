package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.FamiliaItem;
import idat.edu.pe.daa2.jpa.repositorios.FamiliaItemRepositorio;

@Service
@Transactional
public class FamiliaItemServicio {
	
	@Autowired
	private FamiliaItemRepositorio repositorio;
	
	public FamiliaItemServicio() {
		// TODO Auto-generated constructor stub
	}
	
	public List<FamiliaItem> buscarTodo(){
		return (List<FamiliaItem>) repositorio.findAll();
	}
	
	public FamiliaItem crear(FamiliaItem familiaitem) {
		return repositorio.save(familiaitem);
	}
	
	public FamiliaItem actualizar(FamiliaItem familiaitemActualizar) {
		FamiliaItem familiaitemActual = repositorio.findById(familiaitemActualizar.getCOD_FAM_ITEM()).get();
		familiaitemActual.setDESC_FAM_ITEM(familiaitemActualizar.getDESC_FAM_ITEM());
		FamiliaItem familiaitemActualizado = repositorio.save(familiaitemActual);
		return familiaitemActualizado;
	}

	public FamiliaItem buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}


}
