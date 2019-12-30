package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
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
@Table(name="sub_fam_item")
public class SubFamiliaItem implements Serializable {
	
private static final long serialVersionUID = 1L;

@Id
@Basic(optional=false)
@Column (name="COD_SUB_FAM_ITEM")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer COD_SUB_FAM_ITEM;
@Column (name="DESC_SUB_FAM_ITEM")
private String DESC_SUB_FAM_ITEM;
@JoinColumn (name = "COD_FAM_ITEM", referencedColumnName = "COD_FAM_ITEM")
@ManyToOne (optional=false)
private FamiliaItem COD_FAM_ITEM;

@OneToMany(mappedBy = "COD_SUB_FAM_ITEM")
private List<Item> itemList;

public SubFamiliaItem() {
}

public SubFamiliaItem(Integer cOD_SUB_FAM_ITEM, String dESC_SUB_FAM_ITEM, FamiliaItem cOD_FAM_ITEM) {
	COD_SUB_FAM_ITEM = cOD_SUB_FAM_ITEM;
	DESC_SUB_FAM_ITEM = dESC_SUB_FAM_ITEM;
	COD_FAM_ITEM = cOD_FAM_ITEM;
}

public Integer getCOD_SUB_FAM_ITEM() {
	return COD_SUB_FAM_ITEM;
}

public void setCOD_SUB_FAM_ITEM(Integer cOD_SUB_FAM_ITEM) {
	COD_SUB_FAM_ITEM = cOD_SUB_FAM_ITEM;
}

public String getDESC_SUB_FAM_ITEM() {
	return DESC_SUB_FAM_ITEM;
}

public void setDESC_SUB_FAM_ITEM(String dESC_SUB_FAM_ITEM) {
	DESC_SUB_FAM_ITEM = dESC_SUB_FAM_ITEM;
}

public FamiliaItem getCOD_FAM_ITEM() {
	return COD_FAM_ITEM;
}

public void setCOD_FAM_ITEM(FamiliaItem cOD_FAM_ITEM) {
	COD_FAM_ITEM = cOD_FAM_ITEM;
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
    hash += (COD_SUB_FAM_ITEM != null ? COD_SUB_FAM_ITEM.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof SubFamiliaItem)) {
        return false;
    }
    SubFamiliaItem other = (SubFamiliaItem) object;
    if ((this.COD_SUB_FAM_ITEM == null && other.COD_SUB_FAM_ITEM != null) || (this.COD_SUB_FAM_ITEM != null && !this.COD_SUB_FAM_ITEM.equals(other.COD_SUB_FAM_ITEM))) {
        return false;
    }
    return true;
}


}
