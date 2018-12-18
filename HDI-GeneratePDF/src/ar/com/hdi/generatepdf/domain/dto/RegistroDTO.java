package ar.com.hdi.generatepdf.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "registro" )
public class RegistroDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String rama;
	private String descripcionRama;
	private String tipoRama;
	private BigDecimal extraprimaVariable;
	private BigDecimal recargoFinanciero;
	private BigDecimal extraPrimaFija;
	private String codigoExtraPrimaFija;
	private String recargoCondicionEspecial;
	private BigDecimal bonificacionSobrePrima;
	private BigDecimal codigoPlanPago;
	private String formaAcreedor1;
	private String formaAcreedor2;
	private String formaAcreedor3;
	private String formaAcreedor4;
	private String formaAcreedor5;
	private String formaAcreedor6;
	private String formaAcreedor7;
	private String formaAcreedor8;
	private String formaAcreedor9;	
	private BigDecimal comisionProductor;
	private String baseComisionProductor;
	private BigDecimal productorNivel1;
	private BigDecimal productorNivel2;
	private BigDecimal productorNivel3;
	private BigDecimal productorNivel4;
	private BigDecimal productorNivel5;
	private BigDecimal productorNivel6;
	private BigDecimal productorNivel7;
	private BigDecimal productorNivel8;
	private BigDecimal productorNivel9;
	private BigDecimal comisionCobrador;
	private String baseComisionCobranza;
	private BigDecimal cobranzaNivel1;
	private BigDecimal cobranzaNivel2;
	private BigDecimal cobranzaNivel3;
	private BigDecimal cobranzaNivel4;
	private BigDecimal cobranfomento1Nivel1zaNivel5;
	private BigDecimal cobranzaNivel6;
	private BigDecimal cobranzaNivel7;
	private BigDecimal cobranzaNivel8;
	private BigDecimal cobranzaNivel9;
	private BigDecimal comisionFomento1;
	private String baseComisionFomento1;
	private BigDecimal fomento1Nivel1;
	private BigDecimal fomento1Nivel2;
	private BigDecimal fomento1Nivel3;
	private BigDecimal fomento1Nivel4;
	private BigDecimal fomento1Nivel5;
	private BigDecimal fomento1Nivel6;
	private BigDecimal fomento1Nivel7;
	private BigDecimal fomento1Nivel8;
	private BigDecimal fomento1Nivel9;
	private BigDecimal comisionFomento2;
	private String baseComisionFomento2;
	private BigDecimal fomento2Nivel1;
	private BigDecimal fomento2Nivel2;
	private BigDecimal fomento2Nivel3;
	private BigDecimal fomento2Nivel4;
	private BigDecimal fomento2Nivel5;
	private BigDecimal fomento2Nivel6;
	private BigDecimal fomento2Nivel7;
	private BigDecimal fomento2Nivel8;
	private BigDecimal fomento2Nivel9;
	private String seImprime;
	private String consultar;
	private List<DestinatarioMailDTO> destinatarios;
	public String getRama() {
		return rama;
	}
	@XmlElement( name = "rama" )
	public void setRama(String rama) {
		this.rama = rama;
	}
	public String getDescripcionRama() {
		return descripcionRama;
	}
	@XmlElement( name = "ramaDesc" )
	public void setDescripcionRama(String descripcionRama) {
		this.descripcionRama = descripcionRama;
	}
	public String getTipoRama() {
		return tipoRama;
	}
	@XmlElement( name = "tipoRama" )
	public void setTipoRama(String tipoRama) {
		this.tipoRama = tipoRama;
	}
	public BigDecimal getExtraprimaVariable() {
		return extraprimaVariable;
	}
	@XmlElement( name = "extraPrimaVar" )
	public void setExtraprimaVariable(BigDecimal extraprimaVariable) {
		this.extraprimaVariable = extraprimaVariable;
	}
	public BigDecimal getRecargoFinanciero() {
		return recargoFinanciero;
	}
	@XmlElement( name = "recargoFinanc" )
	public void setRecargoFinanciero(BigDecimal recargoFinanciero) {
		this.recargoFinanciero = recargoFinanciero;
	}
	public BigDecimal getExtraPrimaFija() {
		return extraPrimaFija;
	}
	@XmlElement( name = "extraPrimaFij" )
	public void setExtraPrimaFija(BigDecimal extraPrimaFija) {
		this.extraPrimaFija = extraPrimaFija;
	}
	public String getCodigoExtraPrimaFija() {
		return codigoExtraPrimaFija;
	}
	@XmlElement( name = "codigoExPaFij" )
	public void setCodigoExtraPrimaFija(String codigoExtraPrimaFija) {
		this.codigoExtraPrimaFija = codigoExtraPrimaFija;
	}
	public String getRecargoCondicionEspecial() {
		return recargoCondicionEspecial;
	}
	@XmlElement( name = "condiciEspRec" )
	public void setRecargoCondicionEspecial(String recargoCondicionEspecial) {
		this.recargoCondicionEspecial = recargoCondicionEspecial;
	}
	public BigDecimal getBonificacionSobrePrima() {
		return bonificacionSobrePrima;
	}
	@XmlElement( name = "bonifSobPrima" )
	public void setBonificacionSobrePrima(BigDecimal bonificacionSobrePrima) {
		this.bonificacionSobrePrima = bonificacionSobrePrima;
	}
	public BigDecimal getCodigoPlanPago() {
		return codigoPlanPago;
	}
	@XmlElement( name = "codigoPlanPag" )
	public void setCodigoPlanPago(BigDecimal codigoPlanPago) {
		this.codigoPlanPago = codigoPlanPago;
	}
	public BigDecimal getComisionProductor() {
		return comisionProductor;
	}
	@XmlElement( name = "comisionProd" )
	public void setComisionProductor(BigDecimal comisionProductor) {
		this.comisionProductor = comisionProductor;
	}
	public String getBaseComisionProductor() {
		return baseComisionProductor;
	}
	@XmlElement( name = "baseComiProd" )
	public void setBaseComisionProductor(String baseComisionProductor) {
		this.baseComisionProductor = baseComisionProductor;
	}
	public BigDecimal getProductorNivel1() {
		return productorNivel1;
	}
	@XmlElement( name = "prodNivel1" )
	public void setProductorNivel1(BigDecimal productorNivel1) {
		this.productorNivel1 = productorNivel1;
	}
	public BigDecimal getProductorNivel2() {
		return productorNivel2;
	}
	@XmlElement( name = "prodNivel2" )
	public void setProductorNivel2(BigDecimal productorNivel2) {
		this.productorNivel2 = productorNivel2;
	}
	public BigDecimal getProductorNivel3() {
		return productorNivel3;
	}
	@XmlElement( name = "prodNivel3" )
	public void setProductorNivel3(BigDecimal productorNivel3) {
		this.productorNivel3 = productorNivel3;
	}
	public BigDecimal getProductorNivel4() {
		return productorNivel4;
	}
	@XmlElement( name = "prodNivel4" )
	public void setProductorNivel4(BigDecimal productorNivel4) {
		this.productorNivel4 = productorNivel4;
	}
	public BigDecimal getProductorNivel5() {
		return productorNivel5;
	}
	@XmlElement( name = "prodNivel5" )
	public void setProductorNivel5(BigDecimal productorNivel5) {
		this.productorNivel5 = productorNivel5;
	}
	public BigDecimal getProductorNivel6() {
		return productorNivel6;
	}
	@XmlElement( name = "prodNivel6" )
	public void setProductorNivel6(BigDecimal productorNivel6) {
		this.productorNivel6 = productorNivel6;
	}
	public BigDecimal getProductorNivel7() {
		return productorNivel7;
	}
	@XmlElement( name = "prodNivel7" )
	public void setProductorNivel7(BigDecimal productorNivel7) {
		this.productorNivel7 = productorNivel7;
	}
	public BigDecimal getProductorNivel8() {
		return productorNivel8;
	}
	@XmlElement( name = "prodNivel8" )
	public void setProductorNivel8(BigDecimal productorNivel8) {
		this.productorNivel8 = productorNivel8;
	}
	public BigDecimal getProductorNivel9() {
		return productorNivel9;
	}
	@XmlElement( name = "prodNivel9" )
	public void setProductorNivel9(BigDecimal productorNivel9) {
		this.productorNivel9 = productorNivel9;
	}
	public BigDecimal getComisionCobrador() {
		return comisionCobrador;
	}
	@XmlElement( name = "comisionCobr" )
	public void setComisionCobrador(BigDecimal comisionCobrador) {
		this.comisionCobrador = comisionCobrador;
	}
	public String getBaseComisionCobranza() {
		return baseComisionCobranza;
	}
	@XmlElement( name = "baseComiCobr" )
	public void setBaseComisionCobranza(String baseComisionCobranza) {
		this.baseComisionCobranza = baseComisionCobranza;
	}
	public BigDecimal getCobranzaNivel1() {
		return cobranzaNivel1;
	}
	@XmlElement( name = "cobrNivel1" )
	public void setCobranzaNivel1(BigDecimal cobranzaNivel1) {
		this.cobranzaNivel1 = cobranzaNivel1;
	}
	public BigDecimal getCobranzaNivel2() {
		return cobranzaNivel2;
	}
	@XmlElement( name = "cobrNivel2" )
	public void setCobranzaNivel2(BigDecimal cobranzaNivel2) {
		this.cobranzaNivel2 = cobranzaNivel2;
	}
	public BigDecimal getCobranzaNivel3() {
		return cobranzaNivel3;
	}
	@XmlElement( name = "cobrNivel3" )
	public void setCobranzaNivel3(BigDecimal cobranzaNivel3) {
		this.cobranzaNivel3 = cobranzaNivel3;
	}
	public BigDecimal getCobranzaNivel4() {
		return cobranzaNivel4;
	}
	@XmlElement( name = "cobrNivel4" )
	public void setCobranzaNivel4(BigDecimal cobranzaNivel4) {
		this.cobranzaNivel4 = cobranzaNivel4;
	}
	public BigDecimal getCobranfomento1Nivel1zaNivel5() {
		return cobranfomento1Nivel1zaNivel5;
	}
	@XmlElement( name = "cobrNivel5" )
	public void setCobranfomento1Nivel1zaNivel5(
			BigDecimal cobranfomento1Nivel1zaNivel5) {
		this.cobranfomento1Nivel1zaNivel5 = cobranfomento1Nivel1zaNivel5;
	}
	public BigDecimal getCobranzaNivel6() {
		return cobranzaNivel6;
	}
	@XmlElement( name = "cobrNivel6" )
	public void setCobranzaNivel6(BigDecimal cobranzaNivel6) {
		this.cobranzaNivel6 = cobranzaNivel6;
	}
	public BigDecimal getCobranzaNivel7() {
		return cobranzaNivel7;
	}
	@XmlElement( name = "cobrNivel7" )
	public void setCobranzaNivel7(BigDecimal cobranzaNivel7) {
		this.cobranzaNivel7 = cobranzaNivel7;
	}
	public BigDecimal getCobranzaNivel8() {
		return cobranzaNivel8;
	}
	@XmlElement( name = "cobrNivel8" )
	public void setCobranzaNivel8(BigDecimal cobranzaNivel8) {
		this.cobranzaNivel8 = cobranzaNivel8;
	}
	public BigDecimal getCobranzaNivel9() {
		return cobranzaNivel9;
	}
	@XmlElement( name = "cobrNivel9" )
	public void setCobranzaNivel9(BigDecimal cobranzaNivel9) {
		this.cobranzaNivel9 = cobranzaNivel9;
	}
	public BigDecimal getComisionFomento1() {
		return comisionFomento1;
	}
	@XmlElement( name = "comisionFom1" )
	public void setComisionFomento1(BigDecimal comisionFomento1) {
		this.comisionFomento1 = comisionFomento1;
	}
	public String getBaseComisionFomento1() {
		return baseComisionFomento1;
	}
	@XmlElement( name = "baseComiFom1" )
	public void setBaseComisionFomento1(String baseComisionFomento1) {
		this.baseComisionFomento1 = baseComisionFomento1;
	}
	public BigDecimal getFomento1Nivel1() {
		return fomento1Nivel1;
	}
	@XmlElement( name = "fom1Nivel1" )
	public void setFomento1Nivel1(BigDecimal fomento1Nivel1) {
		this.fomento1Nivel1 = fomento1Nivel1;
	}
	public BigDecimal getFomento1Nivel2() {
		return fomento1Nivel2;
	}
	@XmlElement( name = "fom1Nivel2" )
	public void setFomento1Nivel2(BigDecimal fomento1Nivel2) {
		this.fomento1Nivel2 = fomento1Nivel2;
	}
	public BigDecimal getFomento1Nivel3() {
		return fomento1Nivel3;
	}
	@XmlElement( name = "fom1Nivel3" )
	public void setFomento1Nivel3(BigDecimal fomento1Nivel3) {
		this.fomento1Nivel3 = fomento1Nivel3;
	}
	public BigDecimal getFomento1Nivel4() {
		return fomento1Nivel4;
	}
	@XmlElement( name = "fom1Nivel4" )
	public void setFomento1Nivel4(BigDecimal fomento1Nivel4) {
		this.fomento1Nivel4 = fomento1Nivel4;
	}
	public BigDecimal getFomento1Nivel5() {
		return fomento1Nivel5;
	}
	@XmlElement( name = "fom1Nivel5" )
	public void setFomento1Nivel5(BigDecimal fomento1Nivel5) {
		this.fomento1Nivel5 = fomento1Nivel5;
	}
	public BigDecimal getFomento1Nivel6() {
		return fomento1Nivel6;
	}
	@XmlElement( name = "fom1Nivel6" )
	public void setFomento1Nivel6(BigDecimal fomento1Nivel6) {
		this.fomento1Nivel6 = fomento1Nivel6;
	}
	public BigDecimal getFomento1Nivel7() {
		return fomento1Nivel7;
	}
	@XmlElement( name = "fom1Nivel7" )
	public void setFomento1Nivel7(BigDecimal fomento1Nivel7) {
		this.fomento1Nivel7 = fomento1Nivel7;
	}
	public BigDecimal getFomento1Nivel8() {
		return fomento1Nivel8;
	}
	@XmlElement( name = "fom1Nivel8" )
	public void setFomento1Nivel8(BigDecimal fomento1Nivel8) {
		this.fomento1Nivel8 = fomento1Nivel8;
	}
	public BigDecimal getFomento1Nivel9() {
		return fomento1Nivel9;
	}
	@XmlElement( name = "fom1Nivel9" )
	public void setFomento1Nivel9(BigDecimal fomento1Nivel9) {
		this.fomento1Nivel9 = fomento1Nivel9;
	}
	public BigDecimal getComisionFomento2() {
		return comisionFomento2;
	}
	@XmlElement( name = "comisionFom2" )
	public void setComisionFomento2(BigDecimal comisionFomento2) {
		this.comisionFomento2 = comisionFomento2;
	}
	public String getBaseComisionFomento2() {
		return baseComisionFomento2;
	}
	@XmlElement( name = "baseComiFom2" )
	public void setBaseComisionFomento2(String baseComisionFomento2) {
		this.baseComisionFomento2 = baseComisionFomento2;
	}
	public BigDecimal getFomento2Nivel1() {
		return fomento2Nivel1;
	}
	@XmlElement( name = "fom2Nivel1" )
	public void setFomento2Nivel1(BigDecimal fomento2Nivel1) {
		this.fomento2Nivel1 = fomento2Nivel1;
	}
	public BigDecimal getFomento2Nivel2() {
		return fomento2Nivel2;
	}
	@XmlElement( name = "fom2Nivel2" )
	public void setFomento2Nivel2(BigDecimal fomento2Nivel2) {
		this.fomento2Nivel2 = fomento2Nivel2;
	}
	public BigDecimal getFomento2Nivel3() {
		return fomento2Nivel3;
	}
	@XmlElement( name = "fom2Nivel3" )
	public void setFomento2Nivel3(BigDecimal fomento2Nivel3) {
		this.fomento2Nivel3 = fomento2Nivel3;
	}
	public BigDecimal getFomento2Nivel4() {
		return fomento2Nivel4;
	}
	@XmlElement( name = "fom2Nivel4" )
	public void setFomento2Nivel4(BigDecimal fomento2Nivel4) {
		this.fomento2Nivel4 = fomento2Nivel4;
	}
	public BigDecimal getFomento2Nivel5() {
		return fomento2Nivel5;
	}
	@XmlElement( name = "fom2Nivel5" )
	public void setFomento2Nivel5(BigDecimal fomento2Nivel5) {
		this.fomento2Nivel5 = fomento2Nivel5;
	}
	public BigDecimal getFomento2Nivel6() {
		return fomento2Nivel6;
	}
	@XmlElement( name = "fom2Nivel6" )
	public void setFomento2Nivel6(BigDecimal fomento2Nivel6) {
		this.fomento2Nivel6 = fomento2Nivel6;
	}
	public BigDecimal getFomento2Nivel7() {
		return fomento2Nivel7;
	}
	@XmlElement( name = "fom2Nivel7" )
	public void setFomento2Nivel7(BigDecimal fomento2Nivel7) {
		this.fomento2Nivel7 = fomento2Nivel7;
	}
	public BigDecimal getFomento2Nivel8() {
		return fomento2Nivel8;
	}
	@XmlElement( name = "fom2Nivel8" )
	public void setFomento2Nivel8(BigDecimal fomento2Nivel8) {
		this.fomento2Nivel8 = fomento2Nivel8;
	}
	public BigDecimal getFomento2Nivel9() {
		return fomento2Nivel9;
	}
	@XmlElement( name = "fom2Nivel9" )
	public void setFomento2Nivel9(BigDecimal fomento2Nivel9) {
		this.fomento2Nivel9 = fomento2Nivel9;
	}
	public List<DestinatarioMailDTO> getDestinatarios() {
		return destinatarios;
	}
	@XmlElementWrapper( name = "destinatarios" )
	@XmlElement ( name = "destinatario" )
	public void setDestinatarios(List<DestinatarioMailDTO> destinatarios) {
		this.destinatarios = destinatarios;
	}
	public String getFormaAcreedor1() {
		return formaAcreedor1;
	}
	@XmlElement( name = "formaAcre1" )
	public void setFormaAcreedor1(String formaAcreedor1) {
		this.formaAcreedor1 = formaAcreedor1;
	}
	public String getFormaAcreedor2() {
		return formaAcreedor2;
	}
	@XmlElement( name = "formaAcre2" )
	public void setFormaAcreedor2(String formaAcreedor2) {
		this.formaAcreedor2 = formaAcreedor2;
	}
	public String getFormaAcreedor3() {
		return formaAcreedor3;
	}
	@XmlElement( name = "formaAcre3" )
	public void setFormaAcreedor3(String formaAcreedor3) {
		this.formaAcreedor3 = formaAcreedor3;
	}
	public String getFormaAcreedor4() {
		return formaAcreedor4;
	}
	@XmlElement( name = "formaAcre4" )
	public void setFormaAcreedor4(String formaAcreedor4) {
		this.formaAcreedor4 = formaAcreedor4;
	}
	public String getFormaAcreedor5() {
		return formaAcreedor5;
	}
	@XmlElement( name = "formaAcre5" )
	public void setFormaAcreedor5(String formaAcreedor5) {
		this.formaAcreedor5 = formaAcreedor5;
	}
	public String getFormaAcreedor6() {
		return formaAcreedor6;
	}
	@XmlElement( name = "formaAcre6" )
	public void setFormaAcreedor6(String formaAcreedor6) {
		this.formaAcreedor6 = formaAcreedor6;
	}
	public String getFormaAcreedor7() {
		return formaAcreedor7;
	}
	@XmlElement( name = "formaAcre7" )
	public void setFormaAcreedor7(String formaAcreedor7) {
		this.formaAcreedor7 = formaAcreedor7;
	}
	public String getFormaAcreedor8() {
		return formaAcreedor8;
	}
	@XmlElement( name = "formaAcre8" )
	public void setFormaAcreedor8(String formaAcreedor8) {
		this.formaAcreedor8 = formaAcreedor8;
	}
	public String getFormaAcreedor9() {
		return formaAcreedor9;
	}
	@XmlElement( name = "formaAcre9" )
	public void setFormaAcreedor9(String formaAcreedor9) {
		this.formaAcreedor9 = formaAcreedor9;
	}
	public String getSeImprime() {
		return seImprime;
	}
	@XmlElement( name = "seImprime" )
	public void setSeImprime(String seImprime) {
		this.seImprime = seImprime;
	}
	public String getConsultar() {
		return consultar;
	}
	@XmlElement(name = "consultar")
	public void setConsultar(String consultar) {
		this.consultar = consultar;
	}
	
}
