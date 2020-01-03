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
@Table(name="sub_almacen")
public class SubAlmacen implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional=false)
	@Column (name="ID_SUB_ALM")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID_SUB_ALM;
	@Column (name="NOM_SUB_ALM")
	private String NOM_SUB_ALM;
	@Column (name="DIR_SUB_ALM")
	private String DIR_SUB_ALM;
	@Column (name="ESTATUS")
	private String ESTATUS;
	@JoinColumn (name = "ID_ALM", referencedColumnName = "ID_ALM")
	@ManyToOne (optional=false)
	private Almacen ID_ALM;
	
	public SubAlmacen() {
	}
	public SubAlmacen(Integer iD_SUB_ALM, String nOM_SUB_ALM, String dIR_SUB_ALM, String eSTATUS, Almacen iD_ALM) {
		ID_SUB_ALM = iD_SUB_ALM;
		NOM_SUB_ALM = nOM_SUB_ALM;
		DIR_SUB_ALM = dIR_SUB_ALM;
		ESTATUS = eSTATUS;
		ID_ALM = iD_ALM;
	}
	public Integer getID_SUB_ALM() {
		return ID_SUB_ALM;
	}
	public void setID_SUB_ALM(Integer iD_SUB_ALM) {
		ID_SUB_ALM = iD_SUB_ALM;
	}
	public String getNOM_SUB_ALM() {
		return NOM_SUB_ALM;
	}
	public void setNOM_SUB_ALM(String nOM_SUB_ALM) {
		NOM_SUB_ALM = nOM_SUB_ALM;
	}
	public String getDIR_SUB_ALM() {
		return DIR_SUB_ALM;
	}
	public void setDIR_SUB_ALM(String dIR_SUB_ALM) {
		DIR_SUB_ALM = dIR_SUB_ALM;
	}
	public String getESTATUS() {
		return ESTATUS;
	}
	public void setESTATUS(String eSTATUS) {
		ESTATUS = eSTATUS;
	}
	public Almacen getID_ALM() {
		return ID_ALM;
	}
	public void setID_ALM(Almacen iD_ALM) {
		ID_ALM = iD_ALM;
	}
	
	@Override
	public int hashCode() {
	    int hash = 0;
	    hash += (ID_SUB_ALM != null ? ID_SUB_ALM.hashCode() : 0);
	    return hash;
	}

	@Override
	public boolean equals(Object object) {
	    // TODO: Warning - this method won't work in the case the id fields are not set
	    if (!(object instanceof SubAlmacen)) {
	        return false;
	    }
	    SubAlmacen other = (SubAlmacen) object;
	    if ((this.ID_SUB_ALM == null && other.ID_SUB_ALM != null) || (this.ID_SUB_ALM != null && !this.ID_SUB_ALM.equals(other.ID_SUB_ALM))) {
	        return false;
	    }
	    return true;
	}

	@Override
	public String toString() {
	    return NOM_SUB_ALM;
	}


}
