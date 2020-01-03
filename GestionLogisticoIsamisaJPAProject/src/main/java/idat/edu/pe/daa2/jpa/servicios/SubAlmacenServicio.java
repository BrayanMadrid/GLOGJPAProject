package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.SubAlmacen;
import idat.edu.pe.daa2.jpa.repositorios.SubAlmacenRepositorio;

@Service
@Transactional
public class SubAlmacenServicio {
	
	@Autowired
	private SubAlmacenRepositorio repositorioSubAlmacen;
	
	public SubAlmacenServicio() {
		// TODO Auto-generated constructor stub
	}
	
	public List<SubAlmacen> buscarTodo(){
		return (List<SubAlmacen>) repositorioSubAlmacen.findAll();
	}
	
	public SubAlmacen crear(SubAlmacen almacen) {
		return repositorioSubAlmacen .save(almacen);
	}
	
	public SubAlmacen actualizar(SubAlmacen subalmacenActualizar) {
		SubAlmacen subalmacenActual = repositorioSubAlmacen.findById(subalmacenActualizar.getID_SUB_ALM()).get();
		subalmacenActual.setNOM_SUB_ALM(subalmacenActual.getNOM_SUB_ALM());
		subalmacenActual.setDIR_SUB_ALM(subalmacenActual.getDIR_SUB_ALM());
		subalmacenActual.setESTATUS(subalmacenActual.getESTATUS());
		subalmacenActual.setID_ALM(subalmacenActual.getID_ALM());
		SubAlmacen subalmacenActualizado = repositorioSubAlmacen.save(subalmacenActual);
		return subalmacenActualizado;
	}

	public SubAlmacen buscarPorID(Integer id) {
		return repositorioSubAlmacen.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorioSubAlmacen.deleteById(id);
	}

}
