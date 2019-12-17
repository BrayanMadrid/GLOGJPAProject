package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departamento")
public class Departamento implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@Basic(optional=false)
@Column (name="ID_DEP")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer ID_DEP;
@Column (name="DESC_DEP")
private String DESC_DEP;
@JoinColumn (name = "ID_PAIS", referencedColumnName = "ID_PAIS")
@ManyToOne (optional=false)
private Pais ID_PAIS;
@OneToMany(cascade = CascadeType.ALL, mappedBy = "ID_DEP")
private List<Ciudad> ciudadList;

public Departamento() {
}

public Departamento(String dESC_DEP) {
	DESC_DEP = dESC_DEP;
}

public Integer getID_DEP() {
	return ID_DEP;
}

public void setID_DEP(Integer iD_DEP) {
	ID_DEP = iD_DEP;
}

public String getDESC_DEP() {
	return DESC_DEP;
}

public void setDESC_DEP(String dESC_DEP) {
	DESC_DEP = dESC_DEP;
}

public Pais getID_PAIS() {
	return ID_PAIS;
}

public void setID_PAIS(Pais iD_PAIS) {
	ID_PAIS = iD_PAIS;
}

public List<Ciudad> getCiudadList() {
	return ciudadList;
}

public void setCiudadList(List<Ciudad> ciudadList) {
	this.ciudadList = ciudadList;
}

@Override
public int hashCode() {
    int hash = 0;
    hash += (ID_DEP != null ? ID_DEP.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Pais)) {
        return false;
    }
    Departamento other = (Departamento) object;
    if ((this.ID_DEP == null && other.ID_DEP != null) || (this.ID_DEP != null && !this.ID_DEP.equals(other.ID_DEP))) {
        return false;
    }
    return true;
}



}

