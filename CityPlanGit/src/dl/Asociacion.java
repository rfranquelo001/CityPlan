package dl;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Asociacion database table.
 * 
 */
@Entity
@NamedQuery(name="Asociacion.findAll", query="SELECT a FROM Asociacion a")
public class Asociacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idAsociacion;
	private String cif;
	private String nombreAsociacion;
	private List<Comerciante> comerciantes;

	public Asociacion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdAsociacion() {
		return this.idAsociacion;
	}

	public void setIdAsociacion(int idAsociacion) {
		this.idAsociacion = idAsociacion;
	}


	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}


	public String getNombreAsociacion() {
		return this.nombreAsociacion;
	}

	public void setNombreAsociacion(String nombreAsociacion) {
		this.nombreAsociacion = nombreAsociacion;
	}


	//bi-directional many-to-one association to Comerciante
	@OneToMany(mappedBy="asociacion")
	public List<Comerciante> getComerciantes() {
		return this.comerciantes;
	}

	public void setComerciantes(List<Comerciante> comerciantes) {
		this.comerciantes = comerciantes;
	}

	public Comerciante addComerciante(Comerciante comerciante) {
		getComerciantes().add(comerciante);
		comerciante.setAsociacion(this);

		return comerciante;
	}

	public Comerciante removeComerciante(Comerciante comerciante) {
		getComerciantes().remove(comerciante);
		comerciante.setAsociacion(null);

		return comerciante;
	}

}