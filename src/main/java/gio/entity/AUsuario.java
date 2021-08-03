package gio.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



public abstract class AUsuario {

	@Id
	private String Id;
	private String nombres;
	private String usuario;
	private String password;
	private String tipo;
	
	public AUsuario(){}
	
	public AUsuario(String nombres, String usuario, String password, String tipo) {
		this.nombres = nombres;
		this.usuario = usuario;
		this.password = password;
		this.tipo = tipo;
	}

	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	
	
}
