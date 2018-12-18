package ar.com.hdi.services;

import java.math.BigDecimal;
import java.util.List;

import ar.com.hdi.generatepdf.domain.dto.PeticionDTO;

public interface DBA6118PService {
	public List<PeticionDTO> obtenerPeticiones(String empresa, String sucursal, String tipo);
	public void cambiarEstadoPeticion(String empresa, String sucursal, String tipo, BigDecimal numero);
}
