package br.edu.ifpb;

import java.io.Serializable;

import br.edu.ifpb.dominio.Zoologico;

public class GeradorIdNanotime implements Serializable {

	private static final long serialVersionUID = 1L;

	public Long recuperarProximoId(Zoologico zoo) {
		return System.nanoTime();
	}
	
}
