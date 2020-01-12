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
@Table(name="det_transaccion")
public class DetTransaccion implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional=false)
	@Column (name="ID_DET_TRANSACCION")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID_DET_TRANSACCION;
	@Column (name="LINE")
	private Integer LINE;
	@Column (name="CANTIDAD")
	private Double CANTIDAD;
	
	@JoinColumn (name = "ID_TRANSACCION", referencedColumnName = "ID_TRANSACCION")
	@ManyToOne (optional=false)
	private Transaccion ID_TRANSACCION;
	
	@JoinColumn (name = "COD_ITEM", referencedColumnName = "COD_ITEM")
	@ManyToOne (optional=false)
	private Item COD_ITEM;

	public DetTransaccion() {
	}

	public DetTransaccion(Integer iD_DET_TRANSACCION, Integer lINE, Double cANTIDAD, Transaccion iD_TRANSACCION,
			Item cOD_ITEM) {
		ID_DET_TRANSACCION = iD_DET_TRANSACCION;
		LINE = lINE;
		CANTIDAD = cANTIDAD;
		ID_TRANSACCION = iD_TRANSACCION;
		COD_ITEM = cOD_ITEM;
	}

	public Integer getID_DET_TRANSACCION() {
		return ID_DET_TRANSACCION;
	}

	public void setID_DET_TRANSACCION(Integer iD_DET_TRANSACCION) {
		ID_DET_TRANSACCION = iD_DET_TRANSACCION;
	}

	public Integer getLINE() {
		return LINE;
	}

	public void setLINE(Integer lINE) {
		LINE = lINE;
	}

	public Double getCANTIDAD() {
		return CANTIDAD;
	}

	public void setCANTIDAD(Double cANTIDAD) {
		CANTIDAD = cANTIDAD;
	}

	public Transaccion getID_TRANSACCION() {
		return ID_TRANSACCION;
	}

	public void setID_TRANSACCION(Transaccion iD_TRANSACCION) {
		ID_TRANSACCION = iD_TRANSACCION;
	}

	public Item getCOD_ITEM() {
		return COD_ITEM;
	}

	public void setCOD_ITEM(Item cOD_ITEM) {
	COD_ITEM = cOD_ITEM;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (ID_DET_TRANSACCION != null ? ID_DET_TRANSACCION.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetTransaccion)) {
            return false;
        }
        DetTransaccion other = (DetTransaccion) object;
        if ((this.ID_DET_TRANSACCION == null && other.ID_DET_TRANSACCION != null) || (this.ID_DET_TRANSACCION != null && !this.ID_DET_TRANSACCION.equals(other.ID_DET_TRANSACCION))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.DetTransaccion[ ID_DET_TRANSACCION=" + ID_DET_TRANSACCION + " ]";
    }
	

}
