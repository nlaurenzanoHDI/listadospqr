package ar.com.hdi.generatepdf.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "peticion")
public class PeticionDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private BigDecimal numero;
	private BigDecimal codigoProductor;
	private String nombreProductor;
	private BigDecimal matriculaProductor;
	private BigDecimal codigoOrganizador;
	private String nombreOrganizador;
	private BigDecimal matriculaOrganizador;
	private BigDecimal codigoProductor2;
	private String nombreProductor2;
	private BigDecimal matriculaProductor2;
	private List<RegistroDTO> registros;
	private DestinatarioMailDTO remitente;
	private List<DestinatarioMailDTO> destinatarios;
	public BigDecimal getNumero() {
		return numero;
	}
	@XmlElement(name = "numero")
	public void setNumero(BigDecimal numero) {
		this.numero = numero;
	}
	public BigDecimal getCodigoProductor() {
		return codigoProductor;
	}
	@XmlElement(name = "codProductor")
	public void setCodigoProductor(BigDecimal codigoProductor) {
		this.codigoProductor = codigoProductor;
	}
	public String getNombreProductor() {
		return nombreProductor;
	}
	@XmlElement(name = "nomProductor")
	public void setNombreProductor(String nombreProductor) {
		this.nombreProductor = nombreProductor;
	}
	public BigDecimal getCodigoOrganizador() {
		return codigoOrganizador;
	}
	@XmlElement(name = "codOrganizad")
	public void setCodigoOrganizador(BigDecimal codigoOrganizador) {
		this.codigoOrganizador = codigoOrganizador;
	}
	public String getNombreOrganizador() {
		return nombreOrganizador;
	}
	@XmlElement(name = "nomOrganizad")
	public void setNombreOrganizador(String nombreOrganizador) {
		this.nombreOrganizador = nombreOrganizador;
	}
	
	public List<RegistroDTO> getRegistros() {
		return registros;
	}
	@XmlElementWrapper( name = "registros" )
	@XmlElement ( name = "registro" )
	public void setRegistros(List<RegistroDTO> registros) {
		this.registros = registros;
	}
	public BigDecimal getMatriculaProductor() {
		return matriculaProductor;
	}
	@XmlElement(name = "matProductor")
	public void setMatriculaProductor(BigDecimal matriculaProductor) {
		this.matriculaProductor = matriculaProductor;
	}
	public BigDecimal getMatriculaOrganizador() {
		return matriculaOrganizador;
	}
	@XmlElement(name = "matOrganizad")
	public void setMatriculaOrganizador(BigDecimal matriculaOrganizador) {
		this.matriculaOrganizador = matriculaOrganizador;
	}
	public BigDecimal getCodigoProductor2() {
		return codigoProductor2;
	}
	@XmlElement(name = "codProducto2")
	public void setCodigoProductor2(BigDecimal codigoProductor2) {
		this.codigoProductor2 = codigoProductor2;
	}
	public String getNombreProductor2() {
		return nombreProductor2;
	}
	@XmlElement(name = "nomProducto2")
	public void setNombreProductor2(String nombreProductor2) {
		this.nombreProductor2 = nombreProductor2;
	}
	public BigDecimal getMatriculaProductor2() {
		return matriculaProductor2;
	}
	@XmlElement(name = "matProducto2")
	public void setMatriculaProductor2(BigDecimal matriculaProductor2) {
		this.matriculaProductor2 = matriculaProductor2;
	}
	public List<DestinatarioMailDTO> getDestinatarios() {
		return destinatarios;
	}
	@XmlElementWrapper( name = "destinatarios" )
	@XmlElement ( name = "destinatario" )
	public void setDestinatarios(List<DestinatarioMailDTO> destinatarios) {
		this.destinatarios = destinatarios;
	}
	public List<RegistroDTO> getRegistrosPatrimoniales() {
		List<RegistroDTO> registros = new ArrayList<RegistroDTO>();
		for(RegistroDTO registro : this.getRegistros()) {
			if(registro.getTipoRama().equals("P") && registro.getSeImprime().equals("S")) {
				registros.add(registro);
			}
		}
		return registros;
	}
	public List<RegistroDTO> getRegistrosPersonas() {
		List<RegistroDTO> registros = new ArrayList<RegistroDTO>();
		for(RegistroDTO registro : this.getRegistros()) {
			if(registro.getTipoRama().equals("V") && registro.getSeImprime().equals("S")) {
				registros.add(registro);
			}
		}
		return registros;
	}
	public DestinatarioMailDTO getRemitente() {
		return remitente;
	}
	@XmlElement(name = "remitente")
	public void setRemitente(DestinatarioMailDTO remitente) {
		this.remitente = remitente;
	}
	
}