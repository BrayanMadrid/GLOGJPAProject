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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pais")
public class Pais implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional=false)
	@Column (name="ID_PAIS")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID_PAIS;
	@Column (name="DES_PAIS")
	private String DES_PAIS;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ID_PAIS")
	private List<Departamento> departamentoList;
	 
	public Pais() {
	}

	public Pais(String dES_PAIS) {
		DES_PAIS = dES_PAIS;
	}

	public Integer getID_PAIS() {
		return ID_PAIS;
	}

	public void setID_PAIS(Integer iD_PAIS) {
		ID_PAIS = iD_PAIS;
	}

	public String getDES_PAIS() {
		return DES_PAIS;
	}

	public void setDES_PAIS(String dES_PAIS) {
		DES_PAIS = dES_PAIS;
	}
	
	 public List<Departamento> getDepartamentoList() {
		return departamentoList;
	}

	public void setDepartamentoList(List<Departamento> departamentoList) {
		this.departamentoList = departamentoList;
	}

	@Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (ID_PAIS != null ? ID_PAIS.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Pais)) {
	            return false;
	        }
	        Pais other = (Pais) object;
	        if ((this.ID_PAIS == null && other.ID_PAIS != null) || (this.ID_PAIS != null && !this.ID_PAIS.equals(other.ID_PAIS))) {
	            return false;
	        }
	        return true;
	    }
}
