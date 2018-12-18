package ar.com.hdi.commons.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import ar.com.hdi.commons.domain.Constants;
import ar.com.hdi.commons.utils.HDILogger;
import ar.com.hdi.commons.utils.HDIProperties;

public class RestService {
	private String armarUrl (String serviceName, Map<String, String> params){
		String url = HDIProperties.getPropiedad(Constants.CONFIG_PROPERTIES, "urlServicios") +serviceName+ "?";
		
		String parametros = "";
		for (Map.Entry<String, String> entry : params.entrySet()) {
			parametros = parametros + entry.getKey() + "=" + entry.getValue() + "&";
		}
		url = url + parametros;
		HDILogger.debug(RestService.class, (url));
		return url;
	}
	
	public InputStream getRestService(String serviceName, Map<String, String> params){
		try {
			URL url = new URL(this.armarUrl(serviceName, params));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setDoOutput(true);
			if (conn.getResponseCode() != 200) {
				HDILogger.error(RestService.class,"URL PROBLEMA " + url.toString());
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			} else {
				if (conn.getHeaderField("X-MessageSeverity")!=null) {
					if(conn.getHeaderField("X-MessageSeverity").equals("10")) {
						HDILogger.error(RestService.class, conn.getHeaderField("X-LongMessage")); 
					}
				}
			}
			conn.getInputStream();
			return conn.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			HDILogger.error(RestService.class, e.getMessage());
		}
		return null;
	}
}
