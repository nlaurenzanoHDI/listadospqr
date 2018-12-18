package ar.com.hdi.generatepdf.domain.dto;

import java.util.List;

public class FichaCondicionComercial {
	private List<IntermediarioDTO> intermediarios;
	public List<IntermediarioDTO> getIntermediarios() {
		return intermediarios;
	}
	public void setIntermediarios(List<IntermediarioDTO> intermediarios) {
		this.intermediarios = intermediarios;
	}
}
