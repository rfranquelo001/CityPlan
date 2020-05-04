package dl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the Cliente database table.
 * 
 */
@Entity
@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
//METER QUERY EN FUNCION DEL NOMBRE
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idCliente;
	private String correoCliente;
	private String nombreCliente;
	private String passwordCliente;
	private List<Opinion> opinions;

	public Cliente() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCorreoCliente() {
		return this.correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getPasswordCliente() {
		return this.passwordCliente;
	}

	public void setPasswordCliente(String passwordCliente) {
		this.passwordCliente = passwordCliente;
	}

	// bi-directional many-to-one association to Opinion
	@OneToMany(mappedBy = "cliente")
	public List<Opinion> getOpinions() {
		return this.opinions;
	}

	public void setOpinions(List<Opinion> opinions) {
		this.opinions = opinions;
	}

	public Opinion addOpinion(Opinion opinion) {
		getOpinions().add(opinion);
		opinion.setCliente(this);

		return opinion;
	}

	public Opinion removeOpinion(Opinion opinion) {
		getOpinions().remove(opinion);
		opinion.setCliente(null);

		return opinion;
	}

}