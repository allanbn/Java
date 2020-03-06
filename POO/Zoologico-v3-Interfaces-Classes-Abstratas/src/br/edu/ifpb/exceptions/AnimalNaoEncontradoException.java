package br.edu.ifpb.exceptions;

public class AnimalNaoEncontradoException extends ZooException {

	private static final long serialVersionUID = 1L;

	public AnimalNaoEncontradoException(Long id) {
		super("Animal não encontrado: " + id);
	}
	
}
