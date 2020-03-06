package Grafos.Exceptions;

public class ArestaInvalidaException extends RuntimeException {
	public ArestaInvalidaException(String a) {
		System.out.println("A aresta " + a + " é inválida");
	}
}
