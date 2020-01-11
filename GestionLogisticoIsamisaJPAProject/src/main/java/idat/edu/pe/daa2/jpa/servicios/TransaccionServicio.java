package idat.edu.pe.daa2.jpa.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Transaccion;
import idat.edu.pe.daa2.jpa.repositorios.TransaccionRepositorio;

@Service
@Transactional
public class TransaccionServicio {
	
	@Autowired
	private TransaccionRepositorio repositorioTransaccion;

		public TransaccionServicio() {
			// TODO Auto-generated constructor stub
		}
		
		public List<Transaccion> buscarTodo(){
			return (ArrayList<Transaccion>) repositorioTransaccion.findAll();
		}
		
		public Transaccion crear(Transaccion transaccion) {
			return repositorioTransaccion.save(transaccion);
		}
		
		public Transaccion actualizar(Transaccion transaccionActualizar) {
			Transaccion transaccionActual = repositorioTransaccion.findById(transaccionActualizar.getID_TRANSACCION()).get();
			transaccionActual.setID_SUB_ALM(transaccionActualizar.getID_SUB_ALM());
			transaccionActual.setAPLICACION(transaccionActualizar.getAPLICACION());
			transaccionActual.setID_TIPO_TRANS(transaccionActualizar.getID_TIPO_TRANS());
			transaccionActual.setDOC_SERIE(transaccionActualizar.getDOC_SERIE());
			transaccionActual.setDOC_NO(transaccionActualizar.getDOC_NO());
			transaccionActual.setFEC_REG_TRANS(transaccionActualizar.getFEC_REG_TRANS());
			transaccionActual.setFEC_ANL_TRANS(transaccionActualizar.getFEC_ANL_TRANS());
			transaccionActual.setID_SUB_ALM_DEST(transaccionActualizar.getID_SUB_ALM_DEST());
			transaccionActual.setID_RESPONSABLE(transaccionActualizar.getID_RESPONSABLE());
			transaccionActual.setID_PROVEEDOR(transaccionActualizar.getID_PROVEEDOR());
			transaccionActual.setDOC_GR_REF(transaccionActualizar.getDOC_GR_REF());
			transaccionActual.setABR_DOC_COMP_REF(transaccionActualizar.getABR_DOC_COMP_REF());
			transaccionActual.setSER_DOC_COMP_REF(transaccionActualizar.getSER_DOC_COMP_REF());
			transaccionActual.setNO_DOC_COMP_REF(transaccionActualizar.getNO_DOC_COMP_REF());
			transaccionActual.setNO_OC(transaccionActualizar.getNO_OC());
			transaccionActual.setESTATUS(transaccionActualizar.getESTATUS());
			Transaccion transaccionActualizado = repositorioTransaccion.save(transaccionActual);
			return transaccionActualizado;
		}

		public Transaccion buscarPorID(Integer id) {
			return repositorioTransaccion.findById(id).get();
		}

		public void borrarPorID(Integer id) {
			repositorioTransaccion.deleteById(id);
		}

}
