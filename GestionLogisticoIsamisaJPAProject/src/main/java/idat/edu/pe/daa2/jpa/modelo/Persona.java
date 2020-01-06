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
@Table(name="persona")
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional=false)
	@Column (name="ID_PERSONA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID_PERSONA;
	@Column (name="NOM1_PERSONA")
	private String NOM1_PERSONA;
	@Column (name="NOM2_PERSONA")
	private String NOM2_PERSONA;
	@Column (name="APE_PAT_PERSONA")
	private String APE_PAT_PERSONA;
	@Column (name="APE_MAT_PERSONA")
	private String APE_MAT_PERSONA;
	@Column (name="DNI_PERSONA")
	private String DNI_PERSONA;
	@Column (name="RUC_PERSONA")
	private String RUC_PERSONA;
	@Column (name="TEL_PERSONA")
	private String TEL_PERSONA;
	@Column (name="EMAIL_PERSONA")
	private String EMAIL_PERSONA;
	@Column (name="DIR_PERSONA")
	private String DIR_PERSONA;
	
	@JoinColumn (name = "ID_CIUDAD", referencedColumnName = "ID_CIUDAD")
	@ManyToOne (optional=false)
	private Ciudad ID_CIUDAD;
	
	@JoinColumn (name = "ID_TIPO_PERSONA", referencedColumnName = "ID_TIPO_PERSONA")
	@ManyToOne (optional=false)
	private TipoPersona ID_TIPO_PERSONA;
	
	@JoinColumn (name = "ID_TIPO_PERSONA_JRD", referencedColumnName = "ID_TIPO_PERSONA_JRD")
	@ManyToOne (optional=false)
	private TipoPersonaJRD ID_TIPO_PERSONA_JRD;
	
	@JoinColumn (name = "ID_TIPO_PERSONA_EMP", referencedColumnName = "ID_TIPO_PERSONA_EMP")
	@ManyToOne (optional=false)
	private TipoPersonaEMP ID_TIPO_PERSONA_EMP;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ID_PERSONA",fetch=FetchType.LAZY)
	private List<Transaccion> transaccionList;
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public Persona(Integer iD_PERSONA, String nOM1_PERSONA, String nOM2_PERSONA, String aPE_PAT_PERSONA,
			String aPE_MAT_PERSONA, String dNI_PERSONA, String rUC_PERSONA, String tEL_PERSONA, String eMAIL_PERSONA,
			String dIR_PERSONA, Ciudad iD_CIUDAD, TipoPersona iD_TIPO_PERSONA, TipoPersonaJRD iD_TIPO_PERSONA_JRD,
			TipoPersonaEMP iD_TIPO_PERSONA_EMP) {
		ID_PERSONA = iD_PERSONA;
		NOM1_PERSONA = nOM1_PERSONA;
		NOM2_PERSONA = nOM2_PERSONA;
		APE_PAT_PERSONA = aPE_PAT_PERSONA;
		APE_MAT_PERSONA = aPE_MAT_PERSONA;
		DNI_PERSONA = dNI_PERSONA;
		RUC_PERSONA = rUC_PERSONA;
		TEL_PERSONA = tEL_PERSONA;
		EMAIL_PERSONA = eMAIL_PERSONA;
		DIR_PERSONA = dIR_PERSONA;
		ID_CIUDAD = iD_CIUDAD;
		ID_TIPO_PERSONA = iD_TIPO_PERSONA;
		ID_TIPO_PERSONA_JRD = iD_TIPO_PERSONA_JRD;
		ID_TIPO_PERSONA_EMP = iD_TIPO_PERSONA_EMP;
	}

	public Integer getID_PERSONA() {
		return ID_PERSONA;
	}

	public void setID_PERSONA(Integer iD_PERSONA) {
		ID_PERSONA = iD_PERSONA;
	}

	public String getNOM1_PERSONA() {
		return NOM1_PERSONA;
	}

	public void setNOM1_PERSONA(String nOM1_PERSONA) {
		NOM1_PERSONA = nOM1_PERSONA;
	}

	public String getNOM2_PERSONA() {
		return NOM2_PERSONA;
	}

	public void setNOM2_PERSONA(String nOM2_PERSONA) {
		NOM2_PERSONA = nOM2_PERSONA;
	}

	public String getAPE_PAT_PERSONA() {
		return APE_PAT_PERSONA;
	}

	public void setAPE_PAT_PERSONA(String aPE_PAT_PERSONA) {
		APE_PAT_PERSONA = aPE_PAT_PERSONA;
	}

	public String getAPE_MAT_PERSONA() {
		return APE_MAT_PERSONA;
	}

	public void setAPE_MAT_PERSONA(String aPE_MAT_PERSONA) {
		APE_MAT_PERSONA = aPE_MAT_PERSONA;
	}

	public String getDNI_PERSONA() {
		return DNI_PERSONA;
	}

	public void setDNI_PERSONA(String dNI_PERSONA) {
		DNI_PERSONA = dNI_PERSONA;
	}

	public String getRUC_PERSONA() {
		return RUC_PERSONA;
	}

	public void setRUC_PERSONA(String rUC_PERSONA) {
		RUC_PERSONA = rUC_PERSONA;
	}

	public String getTEL_PERSONA() {
		return TEL_PERSONA;
	}

	public void setTEL_PERSONA(String tEL_PERSONA) {
		TEL_PERSONA = tEL_PERSONA;
	}

	public String getEMAIL_PERSONA() {
		return EMAIL_PERSONA;
	}

	public void setEMAIL_PERSONA(String eMAIL_PERSONA) {
		EMAIL_PERSONA = eMAIL_PERSONA;
	}

	public String getDIR_PERSONA() {
		return DIR_PERSONA;
	}

	public void setDIR_PERSONA(String dIR_PERSONA) {
		DIR_PERSONA = dIR_PERSONA;
	}

	public Ciudad getID_CIUDAD() {
		return ID_CIUDAD;
	}

	public void setID_CIUDAD(Ciudad iD_CIUDAD) {
		ID_CIUDAD = iD_CIUDAD;
	}

	public TipoPersona getID_TIPO_PERSONA() {
		return ID_TIPO_PERSONA;
	}

	public void setID_TIPO_PERSONA(TipoPersona iD_TIPO_PERSONA) {
		ID_TIPO_PERSONA = iD_TIPO_PERSONA;
	}

	public TipoPersonaJRD getID_TIPO_PERSONA_JRD() {
		return ID_TIPO_PERSONA_JRD;
	}

	public void setID_TIPO_PERSONA_JRD(TipoPersonaJRD iD_TIPO_PERSONA_JRD) {
		ID_TIPO_PERSONA_JRD = iD_TIPO_PERSONA_JRD;
	}

	public TipoPersonaEMP getID_TIPO_PERSONA_EMP() {
		return ID_TIPO_PERSONA_EMP;
	}

	public void setID_TIPO_PERSONA_EMP(TipoPersonaEMP iD_TIPO_PERSONA_EMP) {
		ID_TIPO_PERSONA_EMP = iD_TIPO_PERSONA_EMP;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (ID_PERSONA != null ? ID_PERSONA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.ID_PERSONA == null && other.ID_PERSONA != null) || (this.ID_PERSONA != null && !this.ID_PERSONA.equals(other.ID_PERSONA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Persona[ ID_PERSONA=" + ID_PERSONA + " ]";
    }
	

}
