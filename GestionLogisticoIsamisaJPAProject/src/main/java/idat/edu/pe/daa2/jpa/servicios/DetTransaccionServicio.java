package idat.edu.pe.daa2.jpa.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.DetTransaccion;
import idat.edu.pe.daa2.jpa.repositorios.DetTransaccionRepositorio;

@Service
@Transactional
public class DetTransaccionServicio {
	
	@Autowired
	private DetTransaccionRepositorio repositorioDetTransaccion;

		public DetTransaccionServicio() {
			// TODO Auto-generated constructor stub
		}
		
		public List<DetTransaccion> buscarTodo(){
			return (ArrayList<DetTransaccion>) repositorioDetTransaccion.findAll();
		}
		
		public DetTransaccion crear(DetTransaccion dettransaccion) {
			return repositorioDetTransaccion.save(dettransaccion);
		}	
		
		public DetTransaccion actualizar(DetTransaccion dettransaccionActualizar) {
			DetTransaccion dettransaccionActual = repositorioDetTransaccion.findById(dettransaccionActualizar.getID_DET_TRANSACCION()).get();
			dettransaccionActual.setID_TRANSACCION(dettransaccionActualizar.getID_TRANSACCION());
			dettransaccionActual.setLINE(dettransaccionActualizar.getLINE());
			dettransaccionActual.setID_ITEM(dettransaccionActualizar.getID_ITEM());
			dettransaccionActual.setCANTIDAD(dettransaccionActualizar.getCANTIDAD());
			DetTransaccion dettransaccionActualizado = repositorioDetTransaccion.save(dettransaccionActual);
			return dettransaccionActualizado;
		}
		
		
		public DetTransaccion buscarPorID(Integer id) {
			return repositorioDetTransaccion.findById(id).get();
		}

		public void borrarPorID(Integer id) {
			repositorioDetTransaccion.deleteById(id);
		}


}
