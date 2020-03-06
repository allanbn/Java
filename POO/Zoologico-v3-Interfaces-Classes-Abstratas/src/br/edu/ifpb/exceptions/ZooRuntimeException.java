package br.edu.ifpb.exceptions;

public class ZooRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ZooRuntimeException(String mensagem) {
		super(mensagem);
	}
	
	public ZooRuntimeException(String mensagem, Throwable erro) {
		super(mensagem, erro);
	}
}
