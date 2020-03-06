package br.edu.ifpb.geradorId;

import java.io.Serializable;

import br.edu.ifpb.dominio.Zoologico;

public class GeradorIdNanotime implements GeradorId, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Long obterProximoId(Zoologico zoo) {
		Long proximoId = System.nanoTime();
		return proximoId;
	}
	
}
