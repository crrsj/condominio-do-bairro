package com.Condominio.dto;

import com.Condominio.modelo.Condominio;

public record CadastrarMorador(
	    Long id,
		String bloco,		
		String apartamento,		
		String garagem,
		String nome,
		String telefone,
		Double agua,
		Double energia,
		Double valorCond,
		String dataVenc,
		String dataPag,
		String status,
		String anotacao) {

	public CadastrarMorador(Condominio cadastre) {
		this(cadastre.getId(),
			    cadastre.getBloco(),
				cadastre.getApartamento(),
				cadastre.getGaragem(),
				cadastre.getNome(),
				cadastre.getTelefone(),
				cadastre.getAgua(),
				cadastre.getEnergia(),
				cadastre.getValorCond(),
				cadastre.getDataVenc(),
				cadastre.getDataPag(),
				cadastre.getStatus(),
				cadastre.getAnotacao()
			                        );
				
	}

}
