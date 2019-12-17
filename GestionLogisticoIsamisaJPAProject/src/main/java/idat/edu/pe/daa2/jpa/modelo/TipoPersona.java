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
@Table(name="tipo_persona")
public class TipoPersona implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional=false)
	@Column (name="ID_TIPO_PERSONA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID_TIPO_PERSONA;
	@Column (name="DESC_TIPO_PERSONA")
	private String DESC_TIPO_PERSONA;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ID_TIPO_PERSONA",fetch=FetchType.LAZY)
	private List<Persona> personaList;
	 
	public TipoPersona() {
		// TODO Auto-generated constructor stub
	}	

	public TipoPersona(Integer iD_TIPO_PERSONA, String dESC_TIPO_PERSONA) {
		ID_TIPO_PERSONA = iD_TIPO_PERSONA;
		DESC_TIPO_PERSONA = dESC_TIPO_PERSONA;
	}

	public TipoPersona(String dESC_TIPO_PERSONA) {
		DESC_TIPO_PERSONA = dESC_TIPO_PERSONA;
	}

	public Integer getID_TIPO_PERSONA() {
		return ID_TIPO_PERSONA;
	}

	public void setID_TIPO_PERSONA(Integer iD_TIPO_PERSONA) {
		ID_TIPO_PERSONA = iD_TIPO_PERSONA;
	}

	public String getDESC_TIPO_PERSONA() {
		return DESC_TIPO_PERSONA;
	}

	public void setDESC_TIPO_PERSONA(String dESC_TIPO_PERSONA) {
		DESC_TIPO_PERSONA = dESC_TIPO_PERSONA;
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
        hash += (ID_TIPO_PERSONA != null ? ID_TIPO_PERSONA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPersona)) {
            return false;
        }
        TipoPersona other = (TipoPersona) object;
        if ((this.ID_TIPO_PERSONA == null && other.ID_TIPO_PERSONA != null) || (this.ID_TIPO_PERSONA != null && !this.ID_TIPO_PERSONA.equals(other.ID_TIPO_PERSONA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return DESC_TIPO_PERSONA;
    }


}
