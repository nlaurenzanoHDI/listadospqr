package ar.com.hdi.generatepdf.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class IntermediarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private BigDecimal codigo;
	private BigDecimal nivel;
	private String nombre;
	private BigDecimal matricula;
	private IntermediarioDTO padre;
	private List<RegistroCondicionComercial> condicionesComercialesPatrimoniales;
	private List<RegistroCondicionComercial> condicionesComercialesPersonales;
	public BigDecimal getCodigo() {
		return codigo;
	}
	public void setCodigo(BigDecimal codigo) {
		this.codigo = codigo;
	}
	public BigDecimal getNivel() {
		return nivel;
	}
	public void setNivel(BigDecimal nivel) {
		this.nivel = nivel;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getMatricula() {
		return matricula;
	}
	public void setMatricula(BigDecimal matricula) {
		this.matricula = matricula;
	}
	public IntermediarioDTO getPadre() {
		return padre;
	}
	public void setPadre(IntermediarioDTO padre) {
		this.padre = padre;
	}
	public List<RegistroCondicionComercial> getCondicionesComercialesPatrimoniales() {
		return condicionesComercialesPatrimoniales;
	}
	public void setCondicionesComercialesPatrimoniales(
			List<RegistroCondicionComercial> condicionesComercialesPatrimoniales) {
		this.condicionesComercialesPatrimoniales = condicionesComercialesPatrimoniales;
	}
	public List<RegistroCondicionComercial> getCondicionesComercialesPersonales() {
		return condicionesComercialesPersonales;
	}
	public void setCondicionesComercialesPersonales(
			List<RegistroCondicionComercial> condicionesComercialesPersonales) {
		this.condicionesComercialesPersonales = condicionesComercialesPersonales;
	}
	
}
