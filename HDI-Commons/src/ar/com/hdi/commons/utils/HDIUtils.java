package ar.com.hdi.commons.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import ar.com.hdi.commons.domain.Constants;

public class HDIUtils {
	private static SecureRandom secureRandom = new SecureRandom();
	
	public static String getSecureToken(int length) {
		return new BigInteger(length * 5, secureRandom).toString(32);
	}
	
	public static String dateToString(String format, Date fecha) {
		DateFormat df = new SimpleDateFormat(format);
		return df.format(fecha);
	}
	public static String createZipFiles(List<String> files, String zipFileName) {
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("Test String");
			
			String fileName = HDIProperties.getPropiedad(Constants.CONFIG_PROPERTIES, Constants.DOWNLOAD_LOCATION) + zipFileName;
			File f = new File(fileName);
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
			for (String file : files) {
//				String pdfFile = createPdf(file, className);
				ZipEntry e = new ZipEntry(file);
				out.putNextEntry(e);
				FileInputStream fis = new FileInputStream(HDIProperties.getPropiedad(Constants.CONFIG_PROPERTIES, Constants.DOWNLOAD_LOCATION) + file);
				int leer;
				byte[] buffer = new byte[1024];
				while (0 < (leer = fis.read(buffer))) {
					out.write(buffer, 0, leer);
				}
				fis.close();
				out.closeEntry();
				File filePdf = new File(HDIProperties.getPropiedad(Constants.CONFIG_PROPERTIES, Constants.DOWNLOAD_LOCATION)+file);
				filePdf.delete();
			}
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "";
	}
	public static void borrarZip(String zipFile) {
		File zip = new File(zipFile);
		zip.delete();
	}
	
	public static String formatearNumeroPeticion(BigDecimal numero) {
		return String.format("%07d", numero.longValue());
	}
}
