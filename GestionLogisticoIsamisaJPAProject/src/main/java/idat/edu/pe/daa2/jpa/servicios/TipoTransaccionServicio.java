package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.TipoTransaccion;
import idat.edu.pe.daa2.jpa.repositorios.TipoTransaccionRepositorio;

@Service
@Transactional
public class TipoTransaccionServicio {
	
	@Autowired
	private TipoTransaccionRepositorio repositorioTipoTransaccion;
	
	public TipoTransaccionServicio() {
		// TODO Auto-generated constructor stub
	}
	
	public List<TipoTransaccion> buscarTodo(){
		return (List<TipoTransaccion>) repositorioTipoTransaccion.findAll();
	}
	
	public TipoTransaccion crear(TipoTransaccion tipotransaccion) {
		return repositorioTipoTransaccion .save(tipotransaccion);
	}
	
	public TipoTransaccion actualizar(TipoTransaccion tipotransaccionActualizar) {
		TipoTransaccion tipotransaccionActual = repositorioTipoTransaccion.findById(tipotransaccionActualizar.getID_TIPO_TRANS()).get();
		tipotransaccionActual.setID_TIPO_DOC(tipotransaccionActual.getID_TIPO_DOC());
		tipotransaccionActual.setNOM_TIPO_TRANS(tipotransaccionActual.getNOM_TIPO_TRANS());
		tipotransaccionActual.setFLAG_TIPO_TRANS(tipotransaccionActual.getFLAG_TIPO_TRANS());
		tipotransaccionActual.setESTATUS(tipotransaccionActual.getESTATUS());
		TipoTransaccion tipotransaccionActualizado = repositorioTipoTransaccion.save(tipotransaccionActual);
		return tipotransaccionActualizado;
	}

	public TipoTransaccion buscarPorID(Integer id) {
		return repositorioTipoTransaccion.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorioTipoTransaccion.deleteById(id);
	}


}
