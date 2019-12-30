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
@Table(name="fam_item")
public class FamiliaItem implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@Basic(optional=false)
@Column (name="COD_FAM_ITEM")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer COD_FAM_ITEM;
@Column (name="DESC_FAM_ITEM")
private String DESC_FAM_ITEM;
@OneToMany(mappedBy = "COD_FAM_ITEM",fetch=FetchType.LAZY)
private List<SubFamiliaItem> subfamiliaitemList;

public FamiliaItem() {
}

public FamiliaItem(Integer cOD_FAM_ITEM, String dESC_FAM_ITEM) {
	COD_FAM_ITEM = cOD_FAM_ITEM;
	DESC_FAM_ITEM = dESC_FAM_ITEM;
}

public Integer getCOD_FAM_ITEM() {
	return COD_FAM_ITEM;
}

public void setCOD_FAM_ITEM(Integer cOD_FAM_ITEM) {
	COD_FAM_ITEM = cOD_FAM_ITEM;
}

public String getDESC_FAM_ITEM() {
	return DESC_FAM_ITEM;
}

public void setDESC_FAM_ITEM(String dESC_FAM_ITEM) {
	DESC_FAM_ITEM = dESC_FAM_ITEM;
}

public List<SubFamiliaItem> getSubfamiliaitemList() {
	return subfamiliaitemList;
}

public void setSubfamiliaitemList(List<SubFamiliaItem> subfamiliaitemList) {
	this.subfamiliaitemList = subfamiliaitemList;
}


@Override
public int hashCode() {
    int hash = 0;
    hash += (COD_FAM_ITEM != null ? COD_FAM_ITEM.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof FamiliaItem)) {
        return false;
    }
    FamiliaItem other = (FamiliaItem) object;
    if ((this.COD_FAM_ITEM == null && other.COD_FAM_ITEM != null) || (this.COD_FAM_ITEM != null && !this.COD_FAM_ITEM.equals(other.COD_FAM_ITEM))) {
        return false;
    }
    return true;
}

@Override
public String toString() {
    return DESC_FAM_ITEM;
}

}
