package ar.com.hdi.generatepdf.domain.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="destinatario")
public class DestinatarioMailDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String email;
	public String getNombre() {
		return nombre;
	}
	@XmlElement( name = "nombre" )
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	@XmlElement( name = "email" )
	public void setEmail(String email) {
		this.email = email;
	}
	
}
