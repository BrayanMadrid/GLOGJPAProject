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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="tipo_persona_emp")
public class TipoPersonaEMP implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional=false)
	@Column (name="ID_TIPO_PERSONA_EMP")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID_TIPO_PERSONA_EMP;
	@Column (name="DESC_TIPO_PERSONA_EMP")
	private String DESC_TIPO_PERSONA_EMP;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ID_TIPO_PERSONA_EMP",fetch=FetchType.LAZY)
	private List<Persona> personaList;
	
	public TipoPersonaEMP() {
	}
	
	

	public TipoPersonaEMP(Integer iD_TIPO_PERSONA_EMP, String dESC_TIPO_PERSONA_EMP) {
		ID_TIPO_PERSONA_EMP = iD_TIPO_PERSONA_EMP;
		DESC_TIPO_PERSONA_EMP = dESC_TIPO_PERSONA_EMP;
	}



	public TipoPersonaEMP(String dESC_TIPO_PERSONA_EMP) {
		DESC_TIPO_PERSONA_EMP = dESC_TIPO_PERSONA_EMP;
	}

	public Integer getID_TIPO_PERSONA_EMP() {
		return ID_TIPO_PERSONA_EMP;
	}

	public void setID_TIPO_PERSONA_EMP(Integer iD_TIPO_PERSONA_EMP) {
		ID_TIPO_PERSONA_EMP = iD_TIPO_PERSONA_EMP;
	}

	public String getDESC_TIPO_PERSONA_EMP() {
		return DESC_TIPO_PERSONA_EMP;
	}

	public void setDESC_TIPO_PERSONA_EMP(String dESC_TIPO_PERSONA_EMP) {
		DESC_TIPO_PERSONA_EMP = dESC_TIPO_PERSONA_EMP;
	}
	

    @XmlTransient
	public List<Persona> getPersonaList() {
		return personaList;
	}

	public void setPersonaList(List<Persona> personaList) {
		this.personaList = personaList;
	}
	
	 @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (ID_TIPO_PERSONA_EMP != null ? ID_TIPO_PERSONA_EMP.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof TipoPersona)) {
	            return false;
	        }
	        TipoPersonaEMP other = (TipoPersonaEMP) object;
	        if ((this.ID_TIPO_PERSONA_EMP == null && other.ID_TIPO_PERSONA_EMP != null) || (this.ID_TIPO_PERSONA_EMP != null && !this.ID_TIPO_PERSONA_EMP.equals(other.ID_TIPO_PERSONA_EMP))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return DESC_TIPO_PERSONA_EMP;
	    }
	

}
