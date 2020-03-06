package Grafos.GrafoLista;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class funcoesGrafoLista {
	
	private static StringBuilder strResult = new StringBuilder();
	private static StringBuilder priVertice = new StringBuilder();
	private static StringBuilder ultVert = new StringBuilder();
	private static StringBuilder strCount = new StringBuilder();
	private static StringBuilder strCountInv = new StringBuilder();
	private static StringBuilder strInv = new StringBuilder();
	private static LinkedList<String> listResult = new LinkedList<>();
	
	private static LinkedHashMap<String, LinkedList<String>> formaConjunto(grafoLista G) {
		LinkedHashMap<String, LinkedList<String>> Set = new LinkedHashMap<>();
		for (String k : G.getV()) {
			funcoesGrafoLista.priVertice.setLength(0);
			funcoesGrafoLista.ultVert.setLength(0);
			LinkedList<String> Ligacao = new LinkedList<>();
			for (String x : G.getArestas().keySet()) {
				if (G.getArestas().get(x).contains(k)) {
					funcoesGrafoLista.priVertice.append(G.getArestas().get(x).charAt(0));
					funcoesGrafoLista.ultVert.append(G.getArestas().get(x).charAt(2));
					if (k.equals(funcoesGrafoLista.priVertice.toString())) {
						Ligacao.add(funcoesGrafoLista.ultVert.toString());
					} else if (k.equals(funcoesGrafoLista.ultVert.toString())) {
						Ligacao.add(funcoesGrafoLista.priVertice.toString());
					}
				}
				funcoesGrafoLista.priVertice.setLength(0);
				funcoesGrafoLista.ultVert.setLength(0);
			}
			Set.put(k, Ligacao);
		}
		return Set;
	}
	
	private static int contaOcorrencia(String X, String Y) {
		funcoesGrafoLista.strCount.setLength(0);
		funcoesGrafoLista.strCountInv.setLength(0);
		byte count = 0;
		funcoesGrafoLista.strCount.append(Y.charAt(0));
		funcoesGrafoLista.strCountInv.append(Y.charAt(2));
		if (funcoesGrafoLista.strCount.toString().equals(X) || funcoesGrafoLista.strCountInv.toString().equals(X)) {
			count++;
		}
		return count;
	}
	
	private static boolean arestaIncide(String X, String Y) {
		boolean incide = false;
		funcoesGrafoLista.strCount.setLength(0);
		funcoesGrafoLista.strCountInv.setLength(0);
		funcoesGrafoLista.strCount.append(Y.charAt(0));
		funcoesGrafoLista.strCountInv.append(Y.charAt(2));
		if (funcoesGrafoLista.strCount.toString().equals(X) || funcoesGrafoLista.strCountInv.toString().equals(X)) {
			incide = true;
		}
		return incide;
	}
	
	public LinkedList<String> verticesNaoAdjcts(grafoLista G) {
		funcoesGrafoLista.listResult.clear();
		funcoesGrafoLista.strResult.setLength(0);
		funcoesGrafoLista.strInv.setLength(0);
		LinkedList<String> Vert = G.getV();
		for (String i : Vert) {
			for (String j : Vert) {
				funcoesGrafoLista.strResult.append(i);
				funcoesGrafoLista.strResult.append("-");
				funcoesGrafoLista.strResult.append(j);
				funcoesGrafoLista.strInv = new StringBuilder(funcoesGrafoLista.strResult);
				funcoesGrafoLista.strInv.reverse();
				if (!G.existeAresta(funcoesGrafoLista.strResult.toString()) &&
						!G.existeAresta(funcoesGrafoLista.strInv.toString())) {
					if (!funcoesGrafoLista.listResult.contains(funcoesGrafoLista.strResult.toString()) ||
							!funcoesGrafoLista.listResult.contains(funcoesGrafoLista.strInv.toString())) {
						funcoesGrafoLista.listResult.add(funcoesGrafoLista.strResult.toString());
					}
				}
				funcoesGrafoLista.strResult.setLength(0);
			}
		}
		return funcoesGrafoLista.listResult;
	}
	
	public boolean haLaco(grafoLista G) {
		boolean temLaco = false;
		funcoesGrafoLista.strResult.setLength(0);
		LinkedList<String> Vert = G.getV();
		for (String i : Vert) {
			funcoesGrafoLista.strResult.append(i);
			funcoesGrafoLista.strResult.append("-");
			funcoesGrafoLista.strResult.append(i);
			if (G.existeAresta(strResult.toString())) {
				temLaco = true;
			}
			funcoesGrafoLista.strResult.setLength(0);
		}
		return temLaco;
	}
	
	public boolean haParalela(grafoLista G) {
		boolean existeParalela = false;
		funcoesGrafoLista.strInv.setLength(0);
		funcoesGrafoLista.strResult.setLength(0);
		LinkedList<String> Vert = G.getV();
		for (int i = 0; i < Vert.size(); i++) {
			byte count = 0;
			for (int j = 0; i < Vert.size(); i++) {
				funcoesGrafoLista.strResult.append(Vert.get(i));
				funcoesGrafoLista.strResult.append("-");
				funcoesGrafoLista.strResult.append(Vert.get(j));
				funcoesGrafoLista.strInv = new StringBuilder(funcoesGrafoLista.strResult);
				funcoesGrafoLista.strInv.reverse();
				if (G.existeAresta(funcoesGrafoLista.strResult.toString()) &&
						G.existeAresta(funcoesGrafoLista.strInv.toString())) {
					count++;
				}
				if (count > 0) existeParalela = true;
				funcoesGrafoLista.strResult.setLength(0);
			}
		}
		return existeParalela;
	}
	
	public int grauVert(grafoLista G, String V) {
		funcoesGrafoLista.strInv.setLength(0);
		LinkedHashMap<String, String> Arestas = G.getArestas();
		byte count = 0;
		for (String k : Arestas.keySet()) {
			count += funcoesGrafoLista.contaOcorrencia(V, Arestas.get(k));
			funcoesGrafoLista.strInv.setLength(0);
		}
		return count;
	}
	
	public LinkedList<String> arestaSobreVert(grafoLista G, String V) {
		funcoesGrafoLista.listResult.clear();
		LinkedHashMap<String, String> Arestas = G.getArestas();
		for (String k : G.getArestas().keySet()) {
			if (funcoesGrafoLista.arestaIncide(V, Arestas.get(k))) {
				funcoesGrafoLista.listResult.add(k);
			}
		}
		return funcoesGrafoLista.listResult;
	}
	
	public boolean ehCompleto(grafoLista G) {
		boolean Completo = false;
		byte count = 0;
		LinkedHashMap<String, String> Arestas = G.getArestas();
		LinkedList<String> Verts = G.getV();
		if (Verts.size() == 1) Completo = true;
		else {
			if (this.haLaco(G)) {
				for (String i : Verts) {
					funcoesGrafoLista.strResult.setLength(0);
					funcoesGrafoLista.strResult.append(i);
					funcoesGrafoLista.strResult.append("-");
					funcoesGrafoLista.strResult.append(i);
					LinkedHashMap<String, String> A = new LinkedHashMap<>(Arestas);
					for (String k : A.keySet()) {
						if (funcoesGrafoLista.strResult.toString().equals(Arestas.get(k))) Arestas.remove(k);
					}
				}
			}
			LinkedHashMap<String, LinkedList<String>> Conjunto = funcoesGrafoLista.formaConjunto(G);
			LinkedList<String> vertTest;
			for (String k : Conjunto.keySet()) {
				vertTest = new LinkedList<>(G.getV());
				for (String i : Conjunto.get(k)) {
					vertTest.remove(i);
				}
				if (vertTest.size() == 1 && vertTest.contains(k)) count += 1;
			}
			if (count == Verts.size()) Completo = true;
		}
		return Completo;
	}
	
	/* A partir de um determinado vertice, existe um ciclo?
	 * A, B, C, D
	 * a1(A-B), a2(B-C), a3(C-D), a4(D-A)
	 * Contador de quantas vezes o vertice aparece
	 * Guardar o vertice inicial
	 * Guardar o vertice atual
	 * Guardar o proximo vertice
	 * se o proximo vertice em alguma das arestas for igual ao vertice inicial, ciclo achado
	 * Achou o vertice 2x, fim do ciclo
	 * a2, a3 */
	
	public void passaVertice(grafoLista G) {
		boolean encontrouCaminho = false;
		String Vert = null;
		LinkedList<String> caminho = new LinkedList<>();
		for (String V : G.getV()) {
			LinkedList<String> todasArestas = new LinkedList<>(G.getArestas().keySet());
			caminho = procurarCiclo(G, V, todasArestas, caminho);
			// O vertice de partida é o mesmo do fim
			// tem algum vertice ou aresta que se repete
			if (caminho.size() >= 1 && this.verificaFim(G, V, caminho)) {
				encontrouCaminho = true;
				Vert = V;
				break;
			} else {
				System.out.println("Sem caminho em " + V);
				caminho.clear();
			}
		}
		if (encontrouCaminho) {
			this.retornaCaminho(G, Vert, caminho);
		} else this.semCaminho();
	}
	
	public LinkedList<String> procurarCiclo(grafoLista G, String V, LinkedList<String> allArestas, LinkedList<String> path) {
		LinkedList<String> arestasIncidentes = new LinkedList<>(this.arestaSobreVert(G, V));
		LinkedHashMap<String, String> Arestas = new LinkedHashMap<>(G.getArestas());
		String verticeDestino;
		if (arestasIncidentes.size() == 1) {
			if (this.ehLaco(G, arestasIncidentes, V)) {
				path.add(arestasIncidentes.get(0));
				allArestas.remove(arestasIncidentes.get(0));
			} else if (path.isEmpty()) return path;
			else path.remove(path.size() - 1);
		} else if (arestasIncidentes.size() > 1) {
			for (String A : arestasIncidentes) {
				if (allArestas.contains(A)) {
					String verticeA = Character.toString(Arestas.get(A).charAt(0));
					String verticeB = Character.toString(Arestas.get(A).charAt(2));
					if (!verticeA.equals(verticeB)) {
						path.add(A);
						allArestas.remove(A);
						if (V.equals(verticeB)) {
							verticeDestino = verticeA;
						} else verticeDestino = verticeB;
					} else {
						path.add(A);
						allArestas.remove(A);
						return path;
					}
					if (this.contaQuantidadeVertices(G, verticeDestino, path) >= 2) return path;
					procurarCiclo(G, verticeDestino, allArestas, path);
					if (this.contaQuantidadeVertices(G, V, path) >= 2) return path;
				}
			}
		}
		if (arestasIncidentes.size() >= 1) {
			if ((this.contaQuantidadeVertices(G, V, path) < 2) && (!this.ehLaco(G, arestasIncidentes, V))) path.clear();
		}
		return path;
	}
	
	private void retornaCaminho(grafoLista G, String V, LinkedList<String> Caminho) {
		StringBuilder out = new StringBuilder();
		System.out.println("Caminho achado em " + V);
		for (String I : Caminho) {
			String X = G.getArestas().get(I).replace("-", I);
			out.append(X);
			if (Caminho.indexOf(I) != Caminho.size() - 1) {
				out.append(" ");
			}
		}
		System.out.println(out);
	}
	
	private void semCaminho() {
		System.out.println(false);
	}
	
	private int contaQuantidadeVertices(grafoLista G, String V, LinkedList<String> path) {
		int count = 0;
		LinkedHashMap<String, String> TUDO = new LinkedHashMap<>(G.getArestas());
		for (String I : path) {
			if (TUDO.get(I).contains(V)) {
				count++;
			}
		}
		return count;
	}
	
	private boolean ehLaco(grafoLista G, LinkedList<String> arestasIncidentes, String V) {
		boolean Laco = false;
		LinkedHashMap<String, String> Arestas = G.getArestas();
		String A = arestasIncidentes.get(0);
		String verticeA = Character.toString(Arestas.get(A).charAt(0));
		String verticeB = Character.toString(Arestas.get(A).charAt(2));
		if (verticeA.equals(verticeB)) Laco = true;
		return Laco;
	}
	
	private boolean verificaFim(grafoLista G, String V, LinkedList<String> path) {
		LinkedHashMap<String, String> Arestas = G.getArestas();
		boolean fimIgual = false;
		String arestaInicial = Arestas.get(path.get(0));
		String arestaFinal = Arestas.get(path.get(path.size() - 1));
		if (arestaInicial.contains(V) && arestaFinal.contains(V)) fimIgual = true;
		return fimIgual;
	}
}