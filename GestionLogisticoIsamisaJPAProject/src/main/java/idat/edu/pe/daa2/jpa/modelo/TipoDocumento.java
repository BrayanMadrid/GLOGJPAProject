package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipo_documento")
public class TipoDocumento implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional=false)
	@Column (name="ID_TIPO_DOC")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID_TIPO_DOC;
	@Column (name="APLICACION")
	private String APLICACION;
	@Column (name="NOM_TIPO_DOC")
	private String NOM_TIPO_DOC;
	@Column (name="ABR_TIPO_DOC")
	private String ABR_TIPO_DOC;
	@Column (name="ESTATUS")
	private String ESTATUS;
	@OneToMany(mappedBy = "ID_TIPO_DOC",fetch=FetchType.LAZY)
	private List<TipoTransaccion> tipotransaccionList;
	
	public TipoDocumento() {
	}

	public TipoDocumento(Integer iD_TIPO_DOC, String aPLICACION, String nOM_TIPO_DOC, String aBR_TIPO_DOC,
			String eSTATUS) {
		super();
		ID_TIPO_DOC = iD_TIPO_DOC;
		APLICACION = aPLICACION;
		NOM_TIPO_DOC = nOM_TIPO_DOC;
		ABR_TIPO_DOC = aBR_TIPO_DOC;
		ESTATUS = eSTATUS;
	}

	public Integer getID_TIPO_DOC() {
		return ID_TIPO_DOC;
	}

	public void setID_TIPO_DOC(Integer iD_TIPO_DOC) {
		ID_TIPO_DOC = iD_TIPO_DOC;
	}

	public String getAPLICACION() {
		return APLICACION;
	}

	public void setAPLICACION(String aPLICACION) {
		APLICACION = aPLICACION;
	}

	public String getNOM_TIPO_DOC() {
		return NOM_TIPO_DOC;
	}

	public void setNOM_TIPO_DOC(String nOM_TIPO_DOC) {
		NOM_TIPO_DOC = nOM_TIPO_DOC;
	}

	public String getABR_TIPO_DOC() {
		return ABR_TIPO_DOC;
	}

	public void setABR_TIPO_DOC(String aBR_TIPO_DOC) {
		ABR_TIPO_DOC = aBR_TIPO_DOC;
	}

	public String getESTATUS() {
		return ESTATUS;
	}

	public void setESTATUS(String eSTATUS) {
		ESTATUS = eSTATUS;
	}

	public List<TipoTransaccion> getTipotransaccionList() {
		return tipotransaccionList;
	}

	public void setTipotransaccionList(List<TipoTransaccion> tipotransaccionList) {
		this.tipotransaccionList = tipotransaccionList;
	}
	
	@Override
	public int hashCode() {
	    int hash = 0;
	    hash += (ID_TIPO_DOC != null ? ID_TIPO_DOC.hashCode() : 0);
	    return hash;
	}

	@Override
	public boolean equals(Object object) {
	    // TODO: Warning - this method won't work in the case the id fields are not set
	    if (!(object instanceof TipoDocumento)) {
	        return false;
	    }
	    TipoDocumento other = (TipoDocumento) object;
	    if ((this.ID_TIPO_DOC == null && other.ID_TIPO_DOC != null) || (this.ID_TIPO_DOC != null && !this.ID_TIPO_DOC.equals(other.ID_TIPO_DOC))) {
	        return false;
	    }
	    return true;
	}

	@Override
	public String toString() {
	    return NOM_TIPO_DOC;
	}

}
