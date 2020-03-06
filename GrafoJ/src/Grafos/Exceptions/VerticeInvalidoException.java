package Grafos.Exceptions;

public class VerticeInvalidoException extends RuntimeException {
	public VerticeInvalidoException(String v) {
		System.out.println("O vértice " + v + " é inválido");
	}
}

