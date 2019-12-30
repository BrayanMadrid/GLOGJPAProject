package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.SubFamiliaItem;
import idat.edu.pe.daa2.jpa.repositorios.SubFamiliaItemRepositorio;

@Service
@Transactional
public class SubFamiliaItemServicio {
	
	@Autowired
	private SubFamiliaItemRepositorio repositorio;
	
	public SubFamiliaItemServicio() {
		// TODO Auto-generated constructor stub
	}
	
	public List<SubFamiliaItem> buscarTodo(){
		return (List<SubFamiliaItem>) repositorio.findAll();
	}
	
	public SubFamiliaItem crear(SubFamiliaItem subfamiliaitem) {
		return repositorio.save(subfamiliaitem);
	}
	
	public SubFamiliaItem actualizar(SubFamiliaItem subfamiliaitemActualizar) {
		SubFamiliaItem subfamiliaitemActual = repositorio.findById(subfamiliaitemActualizar.getCOD_SUB_FAM_ITEM()).get();
		subfamiliaitemActual.setDESC_SUB_FAM_ITEM(subfamiliaitemActualizar.getDESC_SUB_FAM_ITEM());
		subfamiliaitemActual.setCOD_FAM_ITEM(subfamiliaitemActualizar.getCOD_FAM_ITEM());
		SubFamiliaItem subfamiliaitemActualizado = repositorio.save(subfamiliaitemActual);
		return subfamiliaitemActualizado;
	}

	public SubFamiliaItem buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}

}
