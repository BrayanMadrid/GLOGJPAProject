package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="transaccion")
public class Transaccion implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional=false)
	@Column (name="ID_TRANSACCION")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID_TRANSACCION;
	@Column (name="APLICACION")
	private String APLICACION;
	@Column (name="DOC_SERIE")
	private String DOC_SERIE;
	@Column (name="DOC_NO")
	private Integer DOC_NO;
	@Column (name="FEC_REG_TRANS")
	private Date FEC_REG_TRANS;
	@Column (name="FEC_ANL_TRANS")
	private Date FEC_ANL_TRANS;
	@Column (name="DOC_GR_REF")
	private String DOC_GR_REF;
	@Column (name="ABR_DOC_COMP_REF")
	private String ABR_DOC_COMP_REF;
	@Column (name="SER_DOC_COMP_REF")
	private String SER_DOC_COMP_REF;
	@Column (name="NO_DOC_COMP_REF")
	private String NO_DOC_COMP_REF;
	@Column (name="NO_OC")
	private String NO_OC;
	@Column (name="ESTATUS")
	private String ESTATUS;
	
	@JoinColumn (name = "ID_SUB_ALM", referencedColumnName = "ID_SUB_ALM")
	@ManyToOne (optional=false)
	private SubAlmacen ID_SUB_ALM;
	
	@JoinColumn (name = "ID_TIPO_TRANS", referencedColumnName = "ID_TIPO_TRANS")
	@ManyToOne (optional=false)
	private TipoTransaccion ID_TIPO_TRANS;
	
	@JoinColumn (name = "ID_SUB_ALM_DEST", referencedColumnName = "ID_SUB_ALM")
	@ManyToOne (optional=false)
	private SubAlmacen ID_SUB_ALM_DEST;
	
	@JoinColumn (name = "ID_RESPONSABLE", referencedColumnName = "ID_PERSONA")
	@ManyToOne (optional=false)
	private Persona ID_RESPONSABLE;
	
	@JoinColumn (name = "ID_PROVEEDOR", referencedColumnName = "ID_PERSONA")
	@ManyToOne (optional=false)
	private Persona ID_PROVEEDOR;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ID_TRANSACCION",fetch=FetchType.LAZY)
	private List<DetTransaccion> dettransaccionList;

	public Transaccion() {
	}

	public Transaccion(Integer iD_TRANSACCION, String aPLICACION, String dOC_SERIE, Integer dOC_NO, Date fEC_REG_TRANS,
			Date fEC_ANL_TRANS, String dOC_GR_REF, String aBR_DOC_COMP_REF, String sER_DOC_COMP_REF,
			String nO_DOC_COMP_REF, String nO_OC, String eSTATUS, SubAlmacen iD_SUB_ALM, TipoTransaccion iD_TIPO_TRANS,
			SubAlmacen iD_SUB_ALM_DEST, Persona iD_RESPONSABLE, Persona iD_PROVEEDOR) {
		ID_TRANSACCION = iD_TRANSACCION;
		APLICACION = aPLICACION;
		DOC_SERIE = dOC_SERIE;
		DOC_NO = dOC_NO;
		FEC_REG_TRANS = fEC_REG_TRANS;
		FEC_ANL_TRANS = fEC_ANL_TRANS;
		DOC_GR_REF = dOC_GR_REF;
		ABR_DOC_COMP_REF = aBR_DOC_COMP_REF;
		SER_DOC_COMP_REF = sER_DOC_COMP_REF;
		NO_DOC_COMP_REF = nO_DOC_COMP_REF;
		NO_OC = nO_OC;
		ESTATUS = eSTATUS;
		ID_SUB_ALM = iD_SUB_ALM;
		ID_TIPO_TRANS = iD_TIPO_TRANS;
		ID_SUB_ALM_DEST = iD_SUB_ALM_DEST;
		ID_RESPONSABLE = iD_RESPONSABLE;
		ID_PROVEEDOR = iD_PROVEEDOR;
	}



	public Integer getID_TRANSACCION() {
		return ID_TRANSACCION;
	}

	public void setID_TRANSACCION(Integer iD_TRANSACCION) {
		ID_TRANSACCION = iD_TRANSACCION;
	}

	public String getAPLICACION() {
		return APLICACION;
	}

	public void setAPLICACION(String aPLICACION) {
		APLICACION = aPLICACION;
	}

	public String getDOC_SERIE() {
		return DOC_SERIE;
	}

	public void setDOC_SERIE(String dOC_SERIE) {
		DOC_SERIE = dOC_SERIE;
	}

	public Integer getDOC_NO() {
		return DOC_NO;
	}

	public void setDOC_NO(Integer dOC_NO) {
		DOC_NO = dOC_NO;
	}

	public Date getFEC_REG_TRANS() {
		return FEC_REG_TRANS;
	}

	public void setFEC_REG_TRANS(Date fEC_REG_TRANS) {
		FEC_REG_TRANS = fEC_REG_TRANS;
	}

	public Date getFEC_ANL_TRANS() {
		return FEC_ANL_TRANS;
	}

	public void setFEC_ANL_TRANS(Date fEC_ANL_TRANS) {
		FEC_ANL_TRANS = fEC_ANL_TRANS;
	}

	public String getDOC_GR_REF() {
		return DOC_GR_REF;
	}

	public void setDOC_GR_REF(String dOC_GR_REF) {
		DOC_GR_REF = dOC_GR_REF;
	}

	public String getABR_DOC_COMP_REF() {
		return ABR_DOC_COMP_REF;
	}

	public void setABR_DOC_COMP_REF(String aBR_DOC_COMP_REF) {
		ABR_DOC_COMP_REF = aBR_DOC_COMP_REF;
	}

	public String getSER_DOC_COMP_REF() {
		return SER_DOC_COMP_REF;
	}

	public void setSER_DOC_COMP_REF(String sER_DOC_COMP_REF) {
		SER_DOC_COMP_REF = sER_DOC_COMP_REF;
	}

	public String getNO_DOC_COMP_REF() {
		return NO_DOC_COMP_REF;
	}

	public void setNO_DOC_COMP_REF(String nO_DOC_COMP_REF) {
		NO_DOC_COMP_REF = nO_DOC_COMP_REF;
	}

	public String getNO_OC() {
		return NO_OC;
	}

	public void setNO_OC(String nO_OC) {
		NO_OC = nO_OC;
	}

	public String getESTATUS() {
		return ESTATUS;
	}

	public void setESTATUS(String eSTATUS) {
		ESTATUS = eSTATUS;
	}
	
	public SubAlmacen getID_SUB_ALM() {
		return ID_SUB_ALM;
	}

	public void setID_SUB_ALM(SubAlmacen iD_SUB_ALM) {
		ID_SUB_ALM = iD_SUB_ALM;
	}

	public TipoTransaccion getID_TIPO_TRANS() {
		return ID_TIPO_TRANS;
	}

	public void setID_TIPO_TRANS(TipoTransaccion iD_TIPO_TRANS) {
		ID_TIPO_TRANS = iD_TIPO_TRANS;
	}

	public SubAlmacen getID_SUB_ALM_DEST() {
		return ID_SUB_ALM_DEST;
	}

	public void setID_SUB_ALM_DEST(SubAlmacen iD_SUB_ALM_DEST) {
		ID_SUB_ALM_DEST = iD_SUB_ALM_DEST;
	}

	public Persona getID_RESPONSABLE() {
		return ID_RESPONSABLE;
	}

	public void setID_RESPONSABLE(Persona iD_RESPONSABLE) {
		ID_RESPONSABLE = iD_RESPONSABLE;
	}

	public Persona getID_PROVEEDOR() {
		return ID_PROVEEDOR;
	}

	public void setID_PROVEEDOR(Persona iD_PROVEEDOR) {
		ID_PROVEEDOR = iD_PROVEEDOR;
	}

	public List<DetTransaccion> getDettransaccionList() {
		return dettransaccionList;
	}

	public void setDettransaccionList(List<DetTransaccion> dettransaccionList) {
		this.dettransaccionList = dettransaccionList;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (ID_TRANSACCION != null ? ID_TRANSACCION.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.ID_TRANSACCION == null && other.ID_TRANSACCION != null) || (this.ID_TRANSACCION != null && !this.ID_TRANSACCION.equals(other.ID_TRANSACCION))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Transaccion[ ID_TRANSACCION=" + ID_TRANSACCION + " ]";
    }
	
	

}
