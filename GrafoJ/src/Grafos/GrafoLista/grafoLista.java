package Grafos.GrafoLista;

import java.lang.StringBuilder;
import java.util.LinkedList;
import java.util.Collections;
import java.util.LinkedHashMap;

import Grafos.Exceptions.*;

public final class grafoLista {
	
	private static final int QTDE_MAX_SEPARADOR = 1;
	private static final String SEPARADOR_ARESTA = "-";
	private static final char SEPARADOR_ARESTA_C = '-';
	private LinkedList<String> N = new LinkedList<>();
	private LinkedHashMap<String, String> A = new LinkedHashMap<>();
	
	public grafoLista() {
		super();
	}
	
	public grafoLista(LinkedList<String> N, LinkedHashMap<String, String> A) {
		for (String n : N) {
			if (!this.verticeValido(n)) {
				throw new VerticeInvalidoException(n);
			}
		}
		this.N = N;
		for (String a : this.A.keySet()) {
			if (!this.arestaValida(A.get(a))) {
				throw new ArestaInvalidaException(A.get(a));
			}
		}
		this.A = A;
	}
	
	public grafoLista(LinkedList<String> N) {
		for (String n : N) {
			if (!this.verticeValido(n)) {
				throw new VerticeInvalidoException(n);
			}
		}
		this.N = N;
		
		this.A = new LinkedHashMap<>();
	}
	
	public LinkedHashMap<String, String> getArestas() {
		return this.A;
	}
	
	public LinkedList<String> getV() {
		return this.N;
	}
	
	private boolean arestaValida(String aresta) {
		if (Counter(aresta) != grafoLista.QTDE_MAX_SEPARADOR) {
			return false;
		}
		int i_traco = aresta.indexOf(grafoLista.SEPARADOR_ARESTA);
		if (i_traco == 0 || (aresta.substring(aresta.length() - 1)).equals(grafoLista.SEPARADOR_ARESTA)) {
			return false;
		}
		if (!this.existeVertice(aresta.substring(0, i_traco)) ||
				!this.existeVertice(aresta.substring(i_traco + 1))) {
			return false;
		}
		return true;
	}
	
	private boolean verticeValido(String vertice) {
		return !vertice.equals("") && Counter(vertice) == 0;
	}
	
	private boolean existeVertice(String vert) {
		return this.verticeValido(vert) && this.countList(vert) > 0;
	}
	
	private int Counter(String arst) {
		int count = 0;
		for (int i = 0; i < arst.length(); i++) {
			if (arst.charAt(i) == grafoLista.SEPARADOR_ARESTA_C) {
				count++;
			}
		}
		return count;
	}
	
	private int countList(String Y) {
		return Collections.frequency(this.N, Y);
	}
	
	public boolean existeAresta(String aresta) {
		boolean existe = false;
		if (this.arestaValida(aresta)) {
			for (String k : this.A.keySet()) {
				String values = this.A.get(k);
				if (values.equals(aresta)) {
					existe = true;
				}
			}
		}
		return existe;
	}
	
	public void addVertice(String v) throws VerticeInvalidoException {
		for (int i = 0; i < v.length(); i++) {
			if (Character.isLetter(v.charAt(i))) {
				String Vert = Character.toString(v.charAt(i));
				if (this.verticeValido(Vert)) {
					this.N.add(Vert);
				} else {
					throw new VerticeInvalidoException(Vert);
				}
			}
		}
	}
	
	public void putAresta(String a) throws ArestaInvalidaException {
		boolean Parent = false;
		String Nome = "";
		String Aresta = "";
		
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == ',' || i == a.length() - 1) {
				Parent = false;
				if (this.arestaValida(Aresta)) {
					this.A.put(Nome, Aresta);
				} else {
					throw new ArestaInvalidaException(this.A.get(Aresta));
				}
				Nome = "";
				Aresta = "";
			} else if (a.charAt(i) == '(') {
				Parent = true;
			} else if (Character.isLetterOrDigit(a.charAt(i)) && !Parent) {
				Nome += Character.toString(a.charAt(i));
			} else if ((Character.isLetter(a.charAt(i)) || a.charAt(i) == grafoLista.SEPARADOR_ARESTA_C) && Parent) {
				Aresta += Character.toString(a.charAt(i));
			}
		}
	}
	
	@Override
	public String toString() {
		int count = 0;
		StringBuilder grafo_str = new StringBuilder();
		for (int a = 0; a < this.N.size(); a++) {
			grafo_str.append(this.N.get(a));
			if (a < this.N.size() - 1) {
				grafo_str.append(", ");
			}
		}
		grafo_str.append("\n");
		for (String k : (this.A.keySet())) {
			grafo_str.append(this.A.get(k));
			if (!(count == this.A.size() - 1)) {
				grafo_str.append(", ");
			}
			count++;
		}
		return grafo_str.toString();
	}
}