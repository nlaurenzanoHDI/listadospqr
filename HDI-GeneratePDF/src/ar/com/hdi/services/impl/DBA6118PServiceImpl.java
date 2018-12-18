package ar.com.hdi.services.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import ar.com.hdi.commons.service.RestService;
import ar.com.hdi.generatepdf.domain.dto.PeticionDTO;
import ar.com.hdi.generatepdf.domain.list.PeticionList;
import ar.com.hdi.services.DBA6118PService;


public class DBA6118PServiceImpl extends RestService implements DBA6118PService {

	@Override
	public List<PeticionDTO> obtenerPeticiones(String empresa, String sucursal,
			String tipo) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("empresa", empresa);
		params.put("sucursal", sucursal);
		params.put("tipo", tipo);
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(PeticionList.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			PeticionList peticionList = (PeticionList)jaxbUnmarshaller.unmarshal(this.getRestService("dbalistados/obtenerPeticiones", params));
			return peticionList.getPeticiones();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void cambiarEstadoPeticion(String empresa,
			String sucursal, String tipo, BigDecimal numero) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("empresa", empresa);
		params.put("sucursal", sucursal);
		params.put("numero", numero.toString());
		params.put("tipo", tipo);
		this.getRestService("dbalistados/cambiarEstadoPeticion", params);
	}
	
}
