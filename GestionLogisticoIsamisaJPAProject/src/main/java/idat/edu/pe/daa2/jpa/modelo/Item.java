package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item implements Serializable {
	
private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional=false)
	@Column (name="COD_ITEM")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer COD_ITEM;
	@Column (name="DESC_ITEM")
	private String DESC_ITEM;
	@Column (name="PREC_ITEM")
	private Double PREC_ITEM;
	@Column (name="COM_ITEM")
	private String COM_ITEM;
	
	@JoinColumn (name = "COD_SUB_FAM_ITEM", referencedColumnName = "COD_SUB_FAM_ITEM")
	@ManyToOne (optional=false)
	private SubFamiliaItem COD_SUB_FAM_ITEM;
	
	@JoinColumn (name = "ID_CLASE", referencedColumnName = "ID_CLASE")
	@ManyToOne (optional=false)
	private Clase ID_CLASE;
	
	@JoinColumn (name = "ID_UNMED", referencedColumnName = "ID_UNMED")
	@ManyToOne (optional=false)
	private Unmed ID_UNMED;
	
	@JoinColumn (name = "COD_VAL", referencedColumnName = "COD_VAL")
	@ManyToOne (optional=false)
	private Validacion COD_VAL;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "COD_ITEM",fetch=FetchType.LAZY)
	private List<DetTransaccion> dettransaccionList;

	public Item() {
	}

	public Item(Integer cOD_ITEM, String dESC_ITEM, Double pREC_ITEM, String cOM_ITEM, SubFamiliaItem cOD_SUB_FAM_ITEM,
			Clase iD_CLASE, Unmed iD_UNMED, Validacion cOD_VAL) {
		COD_ITEM = cOD_ITEM;
		DESC_ITEM = dESC_ITEM;
		PREC_ITEM = pREC_ITEM;
		COM_ITEM = cOM_ITEM;
		COD_SUB_FAM_ITEM = cOD_SUB_FAM_ITEM;
		ID_CLASE = iD_CLASE;
		ID_UNMED = iD_UNMED;
		COD_VAL = cOD_VAL;
	}

	public Integer getCOD_ITEM() {
		return COD_ITEM;
	}

	public void setCOD_ITEM(Integer cOD_ITEM) {
		COD_ITEM = cOD_ITEM;
	}

	public String getDESC_ITEM() {
		return DESC_ITEM;
	}

	public void setDESC_ITEM(String dESC_ITEM) {
		DESC_ITEM = dESC_ITEM;
	}

	public Double getPREC_ITEM() {
		return PREC_ITEM;
	}

	public void setPREC_ITEM(Double pREC_ITEM) {
		PREC_ITEM = pREC_ITEM;
	}

	public String getCOM_ITEM() {
		return COM_ITEM;
	}

	public void setCOM_ITEM(String cOM_ITEM) {
		COM_ITEM = cOM_ITEM;
	}

	public SubFamiliaItem getCOD_SUB_FAM_ITEM() {
		return COD_SUB_FAM_ITEM;
	}

	public void setCOD_SUB_FAM_ITEM(SubFamiliaItem cOD_SUB_FAM_ITEM) {
		COD_SUB_FAM_ITEM = cOD_SUB_FAM_ITEM;
	}

	public Clase getID_CLASE() {
		return ID_CLASE;
	}

	public void setID_CLASE(Clase iD_CLASE) {
		ID_CLASE = iD_CLASE;
	}

	public Unmed getID_UNMED() {
		return ID_UNMED;
	}

	public void setID_UNMED(Unmed iD_UNMED) {
		ID_UNMED = iD_UNMED;
	}

	public Validacion getCOD_VAL() {
		return COD_VAL;
	}

	public void setCOD_VAL(Validacion cOD_VAL) {
		COD_VAL = cOD_VAL;
	}
	
	public List<DetTransaccion> getDettransaccionList() {
		return dettransaccionList;
	}

	public void setDettransaccionList(List<DetTransaccion> dettransaccionList) {
		this.dettransaccionList = dettransaccionList;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (COD_ITEM != null ? COD_ITEM.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.COD_ITEM == null && other.COD_ITEM != null) || (this.COD_ITEM != null && !this.COD_ITEM.equals(other.COD_ITEM))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Item[ COD_ITEM=" + COD_ITEM + " ]";
    }
	
}
