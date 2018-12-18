package ar.com.hdi.generatepdf.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.hdi.commons.domain.Constants;
import ar.com.hdi.commons.utils.HDILogger;
import ar.com.hdi.commons.utils.HDIProperties;
import ar.com.hdi.commons.utils.HDIUtils;
import ar.com.hdi.commons.utils.MailUtility;
import ar.com.hdi.commons.utils.ReportUtility;
import ar.com.hdi.generatepdf.domain.dto.PeticionDTO;
import ar.com.hdi.generatepdf.utils.Fillers;
import ar.com.hdi.services.DBA6118PService;
import ar.com.hdi.services.impl.DBA6118PServiceImpl;

public class Main {
	public static void main(String[] args) {
		HDILogger.info(Main.class, "Inicio");
		try {
			DBA6118PService service = new DBA6118PServiceImpl();
			List<PeticionDTO> peticiones = service
					.obtenerPeticiones("A", "CA", "G");
			for (PeticionDTO peticion : peticiones) {
				proceso(peticion);
			}
			HDILogger.info(Main.class, "Fin Proceso Correcto");
		}catch(NullPointerException ne) {
			HDILogger.info(Main.class, "No hay peticiones para procesar...");
		}catch(Exception e) {
			HDILogger.info(Main.class, "Hubo un error");
			HDILogger.error(Main.class, e.getMessage());
		}
	}
	public static void proceso(PeticionDTO peticion) throws Exception {
		HDILogger.debug(Main.class, "Inicio proceso peticion: "+peticion.getNumero());
		List<String> nombres = new ArrayList<String>();
		try {
			Map<String, Object> parametros = new HashMap<String, Object>();
			Fillers.fillReporteComision(parametros, peticion);
			Fillers.obtenerNombresArchivos(peticion, nombres);
			generarListado(parametros, "Comisiones", nombres.get(0));
			parametros = new HashMap<String, Object>();
			Fillers.fillReporteCondicionesComerciales(parametros, peticion);
			generarListado(parametros, "CondicionesComerciales", nombres.get(1));
			parametros = new HashMap<String, Object>();
			Fillers.fillReporteComision(parametros, peticion);
			generarListado(parametros, "ComisionesAgrupadas", nombres.get(2));
			String zipFile = generarZip(nombres,peticion);
			enviarMail(peticion, zipFile);
//			cambiarEstadoPeticion(peticion);
			HDIUtils.borrarZip(zipFile);
		} catch (Exception e) {
			HDILogger.error(Main.class,e.getMessage());
			throw new Exception("Hubo un error en la peticion numero: " + peticion.getNumero() + "  " + peticion.getNombreOrganizador()+"\n ");
			
		}
	}
	public static void cambiarEstadoPeticion(PeticionDTO peticion) {
		DBA6118PService service = new DBA6118PServiceImpl();
		service.cambiarEstadoPeticion("A", "CA", "U", peticion.getNumero());
	}
	public static void enviarMail(PeticionDTO peticion, String zipFile) throws Exception{
		List<String> destinatarios = new ArrayList<String>();
		List<String> destinatariosNombre = new ArrayList<String>();
		Map<String, Object> datosServidor = new HashMap<String,Object>();
		datosServidor.put("server", HDIProperties.getPropiedad(Constants.MAIL_PROPERTIES, "server"));
		datosServidor.put("user", HDIProperties.getPropiedad(Constants.MAIL_PROPERTIES, "user"));
		datosServidor.put("pass", HDIProperties.getPropiedad(Constants.MAIL_PROPERTIES, "pass"));
		datosServidor.put("mime", true);
//		Fillers.fillDestinationAddress(peticion.getDestinatarios(), destinatarios);
//		Fillers.fillDestinationName(peticion.getDestinatarios(), destinatariosNombre);
		destinatarios.add("u.08@srvdesa.com.ar");
		destinatariosNombre.add("Pablo GEnnoni");
		String body = Fillers.fillAutoFirma();
		MailUtility.sendEmail(destinatarios, destinatariosNombre, HDIProperties.getPropiedad(Constants.MAIL_PROPERTIES, "subject"), body, peticion.getRemitente().getEmail(), peticion.getRemitente().getNombre(), datosServidor, zipFile);
	}
	public static String generarZip(List<String> nombres, PeticionDTO peticion) throws Exception {
		String zipName = null;
		if (!nombres.isEmpty()) {
			zipName = "Comisiones_"+ HDIUtils.formatearNumeroPeticion(peticion.getNumero()) +".zip"; 
			HDIUtils.createZipFiles(nombres, zipName);
		}else {
			throw new Exception("No hay archivos");
		}
		return HDIProperties.getPropiedad(Constants.CONFIG_PROPERTIES,
				Constants.DOWNLOAD_LOCATION) +  zipName;
	}
	public static void generarListado(Map<String, Object> parametros, String tipoReport, String nombreArchivo) throws Exception {
		try {
				ReportUtility.generatePdf(
						parametros,
						HDIProperties.getPropiedad(Constants.REPORT_PROPERTIES,
								tipoReport),
						HDIProperties.getPropiedad(Constants.CONFIG_PROPERTIES,
								Constants.DOWNLOAD_LOCATION) + nombreArchivo);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception(e);
		}
	}
}
