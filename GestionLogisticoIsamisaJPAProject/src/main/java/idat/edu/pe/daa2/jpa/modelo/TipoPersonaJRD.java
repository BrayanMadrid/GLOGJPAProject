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
@Table(name="tipo_persona_jrd")
public class TipoPersonaJRD implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional=false)
	@Column (name="ID_TIPO_PERSONA_JRD")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID_TIPO_PERSONA_JRD;
	@Column (name="DESC_TIPO_PERSONA_JRD")
	private String DESC_TIPO_PERSONA_JRD;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ID_TIPO_PERSONA_JRD",fetch=FetchType.LAZY)
	private List<Persona> personaList;
	
	public TipoPersonaJRD() {
	}
	
	

	public TipoPersonaJRD(Integer iD_TIPO_PERSONA_JRD, String dESC_TIPO_PERSONA_JRD) {
		super();
		ID_TIPO_PERSONA_JRD = iD_TIPO_PERSONA_JRD;
		DESC_TIPO_PERSONA_JRD = dESC_TIPO_PERSONA_JRD;
	}



	public TipoPersonaJRD(String dESC_TIPO_PERSONA_JRD) {
		DESC_TIPO_PERSONA_JRD = dESC_TIPO_PERSONA_JRD;
	}

	public Integer getID_TIPO_PERSONA_JRD() {
		return ID_TIPO_PERSONA_JRD;
	}

	public void setID_TIPO_PERSONA_JRD(Integer iD_TIPO_PERSONA_JRD) {
		ID_TIPO_PERSONA_JRD = iD_TIPO_PERSONA_JRD;
	}

	public String getDESC_TIPO_PERSONA_JRD() {
		return DESC_TIPO_PERSONA_JRD;
	}

	public void setDESC_TIPO_PERSONA_JRD(String dESC_TIPO_PERSONA_JRD) {
		DESC_TIPO_PERSONA_JRD = dESC_TIPO_PERSONA_JRD;
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
	        hash += (ID_TIPO_PERSONA_JRD != null ? ID_TIPO_PERSONA_JRD.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof TipoPersona)) {
	            return false;
	        }
	        TipoPersonaJRD other = (TipoPersonaJRD) object;
	        if ((this.ID_TIPO_PERSONA_JRD == null && other.ID_TIPO_PERSONA_JRD != null) || (this.ID_TIPO_PERSONA_JRD != null && !this.ID_TIPO_PERSONA_JRD.equals(other.ID_TIPO_PERSONA_JRD))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return DESC_TIPO_PERSONA_JRD;
	    }
	

}
