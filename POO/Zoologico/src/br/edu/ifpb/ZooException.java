package br.edu.ifpb;

public class ZooException extends Exception {

	private static final long serialVersionUID = 1L;

	public ZooException(String mensagem) {
		super(mensagem);
	}
	
	public ZooException(String mensagem, Throwable erro) {
		super(mensagem, erro);
	}
}
