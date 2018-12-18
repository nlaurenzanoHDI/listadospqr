package ar.com.hdi.generatepdf.domain.list;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ar.com.hdi.generatepdf.domain.dto.PeticionDTO;
@XmlRootElement(name="peticiones")
public class PeticionList implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<PeticionDTO> peticiones;
	
	public List<PeticionDTO> getPeticiones() {
		return peticiones;
	}
	@XmlElement(name="peticion")
	public void setPeticiones(List<PeticionDTO> peticiones) {
		this.peticiones = peticiones;
	}
	
}
