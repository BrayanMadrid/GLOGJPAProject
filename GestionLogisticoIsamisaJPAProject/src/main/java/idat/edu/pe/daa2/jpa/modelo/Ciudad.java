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
@Table(name="ciudad")
public class Ciudad implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional=false)
	@Column (name="ID_CIUDAD")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID_CIUDAD;
	@Column (name="DESC_CIUDAD")
	private String DESC_CIUDAD;
	@JoinColumn (name = "ID_DEP", referencedColumnName = "ID_DEP")
	@ManyToOne (optional=false)
	private Departamento ID_DEP;
		
	public Ciudad() {
		// TODO Auto-generated constructor stub
	}
	
	public Ciudad(Integer iD_CIUDAD, String dESC_CIUDAD, Departamento iD_DEP) {
		ID_CIUDAD = iD_CIUDAD;
		DESC_CIUDAD = dESC_CIUDAD;
		ID_DEP = iD_DEP;
	}

	public Ciudad(String dESC_CIUDAD) {
		DESC_CIUDAD = dESC_CIUDAD;
	}

	public Integer getID_CIUDAD() {
		return ID_CIUDAD;
	}

	public void setID_CIUDAD(Integer iD_CIUDAD) {
		ID_CIUDAD = iD_CIUDAD;
	}

	public String getDESC_CIUDAD() {
		return DESC_CIUDAD;
	}

	public void setDESC_CIUDAD(String dESC_CIUDAD) {
		DESC_CIUDAD = dESC_CIUDAD;
	}

	public Departamento getID_DEP() {
		return ID_DEP;
	}

	public void setID_DEP(Departamento iD_DEP) {
		ID_DEP = iD_DEP;
	}
	
	@Override
	public int hashCode() {
	    int hash = 0;
	    hash += (ID_CIUDAD != null ? ID_CIUDAD.hashCode() : 0);
	    return hash;
	}

	@Override
	public boolean equals(Object object) {
	    // TODO: Warning - this method won't work in the case the id fields are not set
	    if (!(object instanceof Pais)) {
	        return false;
	    }
	    Ciudad other = (Ciudad) object;
	    if ((this.ID_CIUDAD == null && other.ID_CIUDAD != null) || (this.ID_CIUDAD != null && !this.ID_CIUDAD.equals(other.ID_CIUDAD))) {
	        return false;
	    }
	    return true;
	}
	
    @Override
    public String toString() {
        return DESC_CIUDAD;
    }

}
