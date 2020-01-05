package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tipo_transaccion")
public class TipoTransaccion implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional=false)
	@Column (name="ID_TIPO_TRANS")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID_TIPO_TRANS;
	@Column (name="NOM_TIPO_TRANS")
	private String NOM_TIPO_TRANS;
	@Column (name="FLAG_TIPO_TRANS")
	private String FLAG_TIPO_TRANS;
	@Column (name="ESTATUS")
	private String ESTATUS;
	@JoinColumn (name = "ID_TIPO_DOC", referencedColumnName = "ID_TIPO_DOC")
	@ManyToOne (optional=false)
	private TipoDocumento ID_TIPO_DOC;
	
	public TipoTransaccion() {
	}

	public TipoTransaccion(Integer iD_TIPO_TRANS, String nOM_TIPO_TRANS, String fLAG_TIPO_TRANS, String eSTATUS,
			TipoDocumento iD_TIPO_DOC) {
		ID_TIPO_TRANS = iD_TIPO_TRANS;
		NOM_TIPO_TRANS = nOM_TIPO_TRANS;
		FLAG_TIPO_TRANS = fLAG_TIPO_TRANS;
		ESTATUS = eSTATUS;
		ID_TIPO_DOC = iD_TIPO_DOC;
	}

	public Integer getID_TIPO_TRANS() {
		return ID_TIPO_TRANS;
	}

	public void setID_TIPO_TRANS(Integer iD_TIPO_TRANS) {
		ID_TIPO_TRANS = iD_TIPO_TRANS;
	}

	public String getNOM_TIPO_TRANS() {
		return NOM_TIPO_TRANS;
	}

	public void setNOM_TIPO_TRANS(String nOM_TIPO_TRANS) {
		NOM_TIPO_TRANS = nOM_TIPO_TRANS;
	}

	public String getFLAG_TIPO_TRANS() {
		return FLAG_TIPO_TRANS;
	}

	public void setFLAG_TIPO_TRANS(String fLAG_TIPO_TRANS) {
		FLAG_TIPO_TRANS = fLAG_TIPO_TRANS;
	}

	public String getESTATUS() {
		return ESTATUS;
	}

	public void setESTATUS(String eSTATUS) {
		ESTATUS = eSTATUS;
	}

	public TipoDocumento getID_TIPO_DOC() {
		return ID_TIPO_DOC;
	}

	public void setID_TIPO_DOC(TipoDocumento iD_TIPO_DOC) {
		ID_TIPO_DOC = iD_TIPO_DOC;
	}
	
	@Override
	public int hashCode() {
	    int hash = 0;
	    hash += (ID_TIPO_TRANS != null ? ID_TIPO_TRANS.hashCode() : 0);
	    return hash;
	}

	@Override
	public boolean equals(Object object) {
	    // TODO: Warning - this method won't work in the case the id fields are not set
	    if (!(object instanceof TipoTransaccion)) {
	        return false;
	    }
	    TipoTransaccion other = (TipoTransaccion) object;
	    if ((this.ID_TIPO_TRANS == null && other.ID_TIPO_TRANS != null) || (this.ID_TIPO_TRANS != null && !this.ID_TIPO_TRANS.equals(other.ID_TIPO_TRANS))) {
	        return false;
	    }
	    return true;
	}

	@Override
	public String toString() {
	    return NOM_TIPO_TRANS;
	}


}
