package Grafos.GrafoLista;

public class VerticeInvalidoException extends RuntimeException {
	public VerticeInvalidoException(String v) {
		System.out.println("O vértice " + v + " é inválido");
	}
}

