package ar.com.hdi.generatepdf.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.hdi.commons.utils.HDIUtils;
import ar.com.hdi.generatepdf.domain.dto.DestinatarioMailDTO;
import ar.com.hdi.generatepdf.domain.dto.IntermediarioDTO;
import ar.com.hdi.generatepdf.domain.dto.PeticionDTO;
import ar.com.hdi.generatepdf.domain.dto.RegistroCondicionComercial;
import ar.com.hdi.generatepdf.domain.dto.RegistroDTO;

public class Fillers {
	private static final String FORMATO_FECHA = "dd/MM/yyyy hh:mm";
	public static void fillReporteComision( Map<String, Object> parametros, PeticionDTO peticion) {
		parametros.put("Peticion", peticion);
		parametros.put("Fecha", HDIUtils.dateToString(FORMATO_FECHA, new Date()));
	}
	public static void fillReporteCondicionesComerciales(Map<String, Object> parametros, PeticionDTO peticion) {
		List<IntermediarioDTO> intermediarios = new ArrayList<IntermediarioDTO>();
		intermediarios.add(fillIntermediario(peticion, new BigDecimal(1)));
		intermediarios.add(fillIntermediario(peticion, new BigDecimal(3)));
		intermediarios.add(fillIntermediario(peticion, new BigDecimal(5)));
		parametros.put("Intermediarios", intermediarios);
		parametros.put("Fecha", HDIUtils.dateToString(FORMATO_FECHA, new Date()));
	}
	public static IntermediarioDTO fillIntermediario(PeticionDTO peticion, BigDecimal nivel) {
		IntermediarioDTO intermediario = new IntermediarioDTO();
		if(nivel.intValue()==1) {
			intermediario.setNivel(nivel);
			intermediario.setCodigo(peticion.getCodigoProductor());
			intermediario.setNombre(peticion.getNombreProductor());
			intermediario.setMatricula(peticion.getMatriculaProductor());
			intermediario.setPadre(fillIntermediario(peticion, new BigDecimal(3)));
		} else if(nivel.intValue()==3) {
			intermediario.setNivel(nivel);
			intermediario.setCodigo(peticion.getCodigoOrganizador());
			intermediario.setNombre(peticion.getNombreOrganizador());
			intermediario.setMatricula(peticion.getMatriculaOrganizador());
			intermediario.setPadre(fillIntermediario(peticion, new BigDecimal(5)));
		} else if(nivel.intValue()==5) {
			intermediario.setNivel(nivel);
			intermediario.setCodigo(peticion.getCodigoProductor2());
			intermediario.setNombre(peticion.getNombreProductor2());
			intermediario.setMatricula(peticion.getMatriculaProductor2());
			intermediario.setPadre(null);
		}
		intermediario.setCondicionesComercialesPatrimoniales(fillCondicionesComerciales(peticion.getRegistros(), intermediario.getNivel(), "P"));
		intermediario.setCondicionesComercialesPersonales(fillCondicionesComerciales(peticion.getRegistros(), intermediario.getNivel(), "V"));
		return intermediario;
	}
	public static List<RegistroCondicionComercial> fillCondicionesComerciales(List<RegistroDTO> registros, BigDecimal nivel, String tipo) {
		List<RegistroCondicionComercial> condicionesComerciales = new ArrayList<RegistroCondicionComercial>();
		for(RegistroDTO registro : registros) {
			Map<String, List<BigDecimal>> mapComisiones = obtenerMapComisiones(registros);
			RegistroCondicionComercial condicionComercial = new RegistroCondicionComercial();
			condicionComercial.setCodigoRama(registro.getRama());
			condicionComercial.setExtraPrimaVariable(registro.getExtraprimaVariable());
			condicionComercial.setRama(registro.getDescripcionRama());
			condicionComercial.setTipoRama(registro.getTipoRama());
			if(nivel.intValue()==1)
				condicionComercial.setTotalComision(registro.getProductorNivel1().add(registro.getCobranzaNivel1()).add(registro.getFomento1Nivel1()). add(registro.getFomento2Nivel1()));
			else if(nivel.intValue()==3)
				condicionComercial.setTotalComision(registro.getProductorNivel3().add(registro.getCobranzaNivel3()).add(registro.getFomento1Nivel3()). add(registro.getFomento2Nivel3()));
			else if(nivel.intValue()==5)
				condicionComercial.setTotalComision(registro.getProductorNivel5().add(registro.getCobranfomento1Nivel1zaNivel5()).add(registro.getFomento1Nivel5()). add(registro.getFomento2Nivel5()));
			if(condicionComercial.getTipoRama().equals(tipo) && registro.getSeImprime().equals("S"))
				condicionesComerciales.add(condicionComercial);
		}
		return condicionesComerciales;
	}
	public static Map<String, List<BigDecimal>> obtenerMapComisiones(List<RegistroDTO> registros) {
		Map<String, List<BigDecimal>> map = new HashMap<String, List<BigDecimal>>();
		List<BigDecimal> comisiones = new ArrayList<BigDecimal>();
		for(RegistroDTO registro : registros) {
			comisiones.add(registro.getProductorNivel1());
			comisiones.add(registro.getProductorNivel3());
			comisiones.add(registro.getProductorNivel5());
			map.put(registro.getRama(), comisiones);
		}
		return map;
	}
	public static void obtenerNombresArchivos(PeticionDTO peticion, List<String> nombres) {
		nombres.add("DBA6118P_"
				+ HDIUtils.formatearNumeroPeticion(peticion.getNumero()) + ".pdf");
		nombres.add("DBA6118Q_"
					+ HDIUtils.formatearNumeroPeticion(peticion.getNumero()) + ".pdf");
		nombres.add("DBA6118R_"
					+ HDIUtils.formatearNumeroPeticion(peticion.getNumero()) + ".pdf");
	}
	public static String fillAutoFirma() {
		return "<font face='arial' size='2' color='black'>"+
"<p >"+
"_________________________ <br />HDI Seguros S.A. <br />Tte. Gral. J.D. Perón 650 5P <br />(C1038AAN) BUENOS AIRES <br />Argentina <br />Telefax: (5411) 5300-3300 <br />Email: Proc.RobotHDI@hdi.com.ar <br /><a href='http://www.hdi.com.ar'>http://www.hdi.com.ar</a> </p></font>";
	}
	public static void fillDestinationAddress(List<DestinatarioMailDTO> destinatarios, List<String> destinationsAddress) {
		for(DestinatarioMailDTO destinatario : destinatarios) {
			destinationsAddress.add(destinatario.getEmail());
		}
	}
	public static void fillDestinationName(List<DestinatarioMailDTO> destinatarios, List<String> destinationsAddress) {
		for(DestinatarioMailDTO destinatario : destinatarios) {
			destinationsAddress.add(destinatario.getNombre());
		}
	}
}
