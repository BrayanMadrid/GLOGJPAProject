package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.Almacen;
import idat.edu.pe.daa2.jpa.repositorios.AlmacenRepositorio;

@Service
@Transactional
public class AlmacenServicio {
	
	@Autowired
	private AlmacenRepositorio repositorioAlmacen;
	
	public AlmacenServicio() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Almacen> buscarTodo(){
		return (List<Almacen>) repositorioAlmacen.findAll();
	}
	
	public Almacen crear(Almacen almacen) {
		return repositorioAlmacen .save(almacen);
	}
	
	public Almacen actualizar(Almacen almacenActualizar) {
		Almacen almacenActual = repositorioAlmacen.findById(almacenActualizar.getID_ALM()).get();
		almacenActual.setDESC_ALM(almacenActualizar.getDESC_ALM());
		almacenActual.setDIR_ALM(almacenActualizar.getDIR_ALM());
		almacenActual.setESTATUS(almacenActualizar.getESTATUS());
		Almacen almacenActualizado = repositorioAlmacen.save(almacenActual);
		return almacenActualizado;
	}

	public Almacen buscarPorID(Integer id) {
		return repositorioAlmacen.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorioAlmacen.deleteById(id);
	}


}
