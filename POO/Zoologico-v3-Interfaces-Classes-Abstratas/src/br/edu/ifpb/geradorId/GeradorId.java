package br.edu.ifpb.geradorId;

import br.edu.ifpb.dominio.Zoologico;

public interface GeradorId {

	public Long obterProximoId(Zoologico zoo);
	
}
