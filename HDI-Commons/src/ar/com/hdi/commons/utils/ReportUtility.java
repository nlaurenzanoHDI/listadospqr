package ar.com.hdi.commons.utils;

import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class ReportUtility {
	public static void generatePdf(Map<String, Object> parametros,
			String nombreReporte, String nombreArchivoPdf) throws Exception {
		try {
			JasperPrint informe = JasperFillManager.fillReport(nombreReporte,
					parametros, new JREmptyDataSource());
			JasperExportManager
					.exportReportToPdfFile(informe, nombreArchivoPdf);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			throw new Exception(e.getMessage());
		}
	}
}
