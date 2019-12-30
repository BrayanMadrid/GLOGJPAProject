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
@Table(name="validacion")
public class Validacion implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@Basic(optional=false)
@Column (name="COD_VAL")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer COD_VAL;
@Column (name="DESC_VAL")
private String DESC_VAL;
@OneToMany(mappedBy = "COD_VAL",fetch=FetchType.LAZY)
private List<Item> itemList;

public Validacion() {
}

public Validacion(Integer cOD_VAL, String dESC_VAL) {
	COD_VAL = cOD_VAL;
	DESC_VAL = dESC_VAL;
}

public Integer getCOD_VAL() {
	return COD_VAL;
}

public void setCOD_VAL(Integer cOD_VAL) {
	COD_VAL = cOD_VAL;
}

public String getDESC_VAL() {
	return DESC_VAL;
}

public void setDESC_VAL(String dESC_VAL) {
	DESC_VAL = dESC_VAL;
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
    hash += (COD_VAL != null ? COD_VAL.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Validacion)) {
        return false;
    }
    Validacion other = (Validacion) object;
    if ((this.COD_VAL == null && other.COD_VAL != null) || (this.COD_VAL != null && !this.COD_VAL.equals(other.COD_VAL))) {
        return false;
    }
    return true;
}

@Override
public String toString() {
    return DESC_VAL;
}


}
