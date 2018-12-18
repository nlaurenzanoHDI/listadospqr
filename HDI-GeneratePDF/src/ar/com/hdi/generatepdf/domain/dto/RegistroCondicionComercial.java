package ar.com.hdi.generatepdf.domain.dto;

import java.math.BigDecimal;

public class RegistroCondicionComercial {
	private String codigoRama;
	private String rama;
	private String tipoRama;
	private BigDecimal totalComision;
	private BigDecimal extraPrimaVariable;
	public String getCodigoRama() {
		return codigoRama;
	}
	public void setCodigoRama(String codigoRama) {
		this.codigoRama = codigoRama;
	}
	public String getRama() {
		return rama;
	}
	public void setRama(String rama) {
		this.rama = rama;
	}
	public String getTipoRama() {
		return tipoRama;
	}
	public void setTipoRama(String tipoRama) {
		this.tipoRama = tipoRama;
	}
	public BigDecimal getTotalComision() {
		return totalComision;
	}
	public void setTotalComision(BigDecimal totalComision) {
		this.totalComision = totalComision;
	}
	public BigDecimal getExtraPrimaVariable() {
		return extraPrimaVariable;
	}
	public void setExtraPrimaVariable(BigDecimal extraPrimaVariable) {
		this.extraPrimaVariable = extraPrimaVariable;
	}
	
}
