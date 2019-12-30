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
@Table(name="clase")
public class Clase implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@Basic(optional=false)
@Column (name="ID_CLASE")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer ID_CLASE;
@Column (name="DESC_CLASE")
private String DESC_CLASE;
@OneToMany(mappedBy = "ID_CLASE",fetch=FetchType.LAZY)
private List<Item> itemList;

public Clase() {
}

public Clase(Integer iD_CLASE, String dESC_CLASE) {
	ID_CLASE = iD_CLASE;
	DESC_CLASE = dESC_CLASE;
}

public Integer getID_CLASE() {
	return ID_CLASE;
}

public void setID_CLASE(Integer iD_CLASE) {
	ID_CLASE = iD_CLASE;
}

public String getDESC_CLASE() {
	return DESC_CLASE;
}

public void setDESC_CLASE(String dESC_CLASE) {
	DESC_CLASE = dESC_CLASE;
}

public List<Item> getItemList() {
	return itemList;
}

public void setItemList(List<Item> itemList) {
	this.itemList = itemList;
}

@Override
public int hashCode() {
    int hash = 0;
    hash += (ID_CLASE != null ? ID_CLASE.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Clase)) {
        return false;
    }
    Clase other = (Clase) object;
    if ((this.ID_CLASE == null && other.ID_CLASE != null) || (this.ID_CLASE != null && !this.ID_CLASE.equals(other.ID_CLASE))) {
        return false;
    }
    return true;
}

@Override
public String toString() {
    return DESC_CLASE;
}

}
