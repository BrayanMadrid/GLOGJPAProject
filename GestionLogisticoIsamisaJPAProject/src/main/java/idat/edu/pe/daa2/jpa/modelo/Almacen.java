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
@Table(name="almacen")
public class Almacen implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional=false)
	@Column (name="ID_ALM")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID_ALM;
	@Column (name="DESC_ALM")
	private String DESC_ALM;
	@Column (name="DIR_ALM")
	private String DIR_ALM;
	@Column (name="ESTATUS")
	private String ESTATUS;
	@OneToMany(mappedBy = "ID_ALM",fetch=FetchType.LAZY)
	private List<SubAlmacen> subalmacenList;
	
	public Almacen() {
	}

	public Almacen(Integer iD_ALM, String dESC_ALM, String dIR_ALM, String eSTATUS) {
		ID_ALM = iD_ALM;
		DESC_ALM = dESC_ALM;
		DIR_ALM = dIR_ALM;
		ESTATUS = eSTATUS;
	}

	public Integer getID_ALM() {
		return ID_ALM;
	}

	public void setID_ALM(Integer iD_ALM) {
		ID_ALM = iD_ALM;
	}

	public String getDESC_ALM() {
		return DESC_ALM;
	}

	public void setDESC_ALM(String dESC_ALM) {
		DESC_ALM = dESC_ALM;
	}

	public String getDIR_ALM() {
		return DIR_ALM;
	}

	public void setDIR_ALM(String dIR_ALM) {
		DIR_ALM = dIR_ALM;
	}

	public String getESTATUS() {
		return ESTATUS;
	}

	public void setESTATUS(String eSTATUS) {
		ESTATUS = eSTATUS;
	}

	public List<SubAlmacen> getSubalmacenList() {
		return subalmacenList;
	}

	public void setSubalmacenList(List<SubAlmacen> subalmacenList) {
		this.subalmacenList = subalmacenList;
	}
	

@Override
public int hashCode() {
    int hash = 0;
    hash += (ID_ALM != null ? ID_ALM.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Almacen)) {
        return false;
    }
    Almacen other = (Almacen) object;
    if ((this.ID_ALM == null && other.ID_ALM != null) || (this.ID_ALM != null && !this.ID_ALM.equals(other.ID_ALM))) {
        return false;
    }
    return true;
}

@Override
public String toString() {
    return DESC_ALM;
}

}
