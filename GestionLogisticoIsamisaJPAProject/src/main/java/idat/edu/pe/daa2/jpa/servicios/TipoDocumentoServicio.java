package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.TipoDocumento;
import idat.edu.pe.daa2.jpa.repositorios.TipoDocumentoRepositorio;

@Service
@Transactional
public class TipoDocumentoServicio {
	
	@Autowired
	private TipoDocumentoRepositorio repositorioTipoDocumento;
	
	public TipoDocumentoServicio() {
		// TODO Auto-generated constructor stub
	}
	
	public List<TipoDocumento> buscarTodo(){
		return (List<TipoDocumento>) repositorioTipoDocumento.findAll();
	}
	
	public TipoDocumento crear(TipoDocumento tipodocumento) {
		return repositorioTipoDocumento .save(tipodocumento);
	}
	
	public TipoDocumento actualizar(TipoDocumento tipodocumentoActualizar) {
		TipoDocumento tipodocumentoActual = repositorioTipoDocumento.findById(tipodocumentoActualizar.getID_TIPO_DOC()).get();
		tipodocumentoActual.setAPLICACION(tipodocumentoActualizar.getAPLICACION());
		tipodocumentoActual.setNOM_TIPO_DOC(tipodocumentoActualizar.getNOM_TIPO_DOC());
		tipodocumentoActual.setABR_TIPO_DOC(tipodocumentoActualizar.getABR_TIPO_DOC());
		tipodocumentoActual.setESTATUS(tipodocumentoActualizar.getESTATUS());
		TipoDocumento tipodocumentoActualizado = repositorioTipoDocumento.save(tipodocumentoActual);
		return tipodocumentoActualizado;
	}

	public TipoDocumento buscarPorID(Integer id) {
		return repositorioTipoDocumento.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorioTipoDocumento.deleteById(id);
	}

}
