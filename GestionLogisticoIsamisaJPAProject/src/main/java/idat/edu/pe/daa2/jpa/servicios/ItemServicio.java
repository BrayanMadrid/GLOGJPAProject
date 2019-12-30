package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Item;
import idat.edu.pe.daa2.jpa.repositorios.ItemRepositorio;

@Service
@Transactional
public class ItemServicio {
	
	@Autowired
	private ItemRepositorio repositorio;
	
	public ItemServicio() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Item> buscarTodo(){
		return (List<Item>) repositorio.findAll();
	}
	
	public Item crear(Item item) {
		return repositorio.save(item);
	}
	
	public Item actualizar(Item itemActualizar) {
		Item itemActual = repositorio.findById(itemActualizar.getCOD_ITEM()).get();
		itemActual.setDESC_ITEM(itemActualizar.getDESC_ITEM());
		itemActual.setPREC_ITEM(itemActualizar.getPREC_ITEM());
		itemActual.setCOD_SUB_FAM_ITEM(itemActualizar.getCOD_SUB_FAM_ITEM());
		itemActual.setID_CLASE(itemActualizar.getID_CLASE());
		itemActual.setID_UNMED(itemActualizar.getID_UNMED());
		itemActual.setCOD_VAL(itemActualizar.getCOD_VAL());
		itemActual.setCOM_ITEM(itemActualizar.getCOM_ITEM());
		Item itemActualizado = repositorio.save(itemActual);
		return itemActualizado;
	}

	public Item buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}

}
