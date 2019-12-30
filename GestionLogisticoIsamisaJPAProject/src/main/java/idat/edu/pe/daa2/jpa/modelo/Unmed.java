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
@Table(name="unmed")
public class Unmed implements Serializable {
	
private static final long serialVersionUID = 1L;

@Id
@Basic(optional=false)
@Column (name="ID_UNMED")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer ID_UNMED;
@Column (name="DESC_UNMED")
private String DESC_UNMED;
@OneToMany(mappedBy = "ID_UNMED",fetch=FetchType.LAZY)
private List<Item> itemList;

public Unmed() {
}

public Unmed(Integer iD_UNMED, String dESC_UNMED, List<Item> itemList) {
	ID_UNMED = iD_UNMED;
	DESC_UNMED = dESC_UNMED;
	this.itemList = itemList;
}

public Integer getID_UNMED() {
	return ID_UNMED;
}

public void setID_UNMED(Integer iD_UNMED) {
	ID_UNMED = iD_UNMED;
}

public String getDESC_UNMED() {
	return DESC_UNMED;
}

public void setDESC_UNMED(String dESC_UNMED) {
	DESC_UNMED = dESC_UNMED;
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
    hash += (ID_UNMED != null ? ID_UNMED.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Unmed)) {
        return false;
    }
    Unmed other = (Unmed) object;
    if ((this.ID_UNMED == null && other.ID_UNMED != null) || (this.ID_UNMED != null && !this.ID_UNMED.equals(other.ID_UNMED))) {
        return false;
    }
    return true;
}

@Override
public String toString() {
    return DESC_UNMED;
}



}
