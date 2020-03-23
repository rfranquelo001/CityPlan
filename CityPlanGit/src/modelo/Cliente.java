package modelo;

public class Cliente {
	
	private String idCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String passwordCliente;
	private String filtrosCliente;
	private String aliasCliente;
	
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getPasswordCliente() {
		return passwordCliente;
	}
	public void setPasswordCliente(String passwordCliente) {
		this.passwordCliente = passwordCliente;
	}
	public String getFiltrosCliente() {
		return filtrosCliente;
	}
	public void setFiltrosCliente(String filtrosCliente) {
		this.filtrosCliente = filtrosCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public String getAliasCliente() {
		return aliasCliente;
	}
	public void setAliasCliente(String aliasCliente) {
		this.aliasCliente = aliasCliente;
	}

}
