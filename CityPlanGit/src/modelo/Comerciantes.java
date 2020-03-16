package modelo;

public class Comerciantes {
	
	private String idComerciante;
	private String nombreComerciante;
	private String apellidoComerciante;
	private String passwordComerciante;
	private Evento anuncioComerciante;
	
	public Comerciantes() {
		super();
	}
	
	public String getIdComerciante() {
		return idComerciante;
	}
	public void setIdComerciante(String idComerciante) {
		this.idComerciante = idComerciante;
	}
	public String getPasswordComerciante() {
		return passwordComerciante;
	}
	public void setPasswordComerciante(String passwordComerciante) {
		this.passwordComerciante = passwordComerciante;
	}
	public Evento getAnuncioComerciante() {
		return anuncioComerciante;
	}
	public void setAnuncioComerciante(Evento anuncioComerciante) {
		this.anuncioComerciante = anuncioComerciante;
	}
	public String getNombreComerciante() {
		return nombreComerciante;
	}

	public void setNombreComerciante(String nombreComerciante) {
		this.nombreComerciante = nombreComerciante;
	}

	public String getApellidoComerciante() {
		return apellidoComerciante;
	}

	public void setApellidoComerciante(String apellidoComerciante) {
		this.apellidoComerciante = apellidoComerciante;
	}

}
