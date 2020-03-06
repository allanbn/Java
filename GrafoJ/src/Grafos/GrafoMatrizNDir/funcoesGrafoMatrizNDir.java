package Grafos.GrafoMatrizNDir;


import java.util.LinkedList;

public class funcoesGrafoMatrizNDir {
	
	private static StringBuilder strResult = new StringBuilder();
	private static LinkedList<String> listResult = new LinkedList<>();
	
	public LinkedList<String> verticesNaoAdjcts(grafoMatrizNDir G) {
		funcoesGrafoMatrizNDir.listResult.clear();
		LinkedList<String> Vert = G.getV();
		
		int[][] M = G.getM();
		for (int i = 0; i < Vert.size(); i++) {
			String nAdj;
			String Inv;
			for (int j = 0; j < Vert.size(); j++) {
				if (M[i][j] <= 0) {
					nAdj = Vert.get(i) + "-" + Vert.get(j);
					Inv = Vert.get(j) + "-" + Vert.get(i);
					if (!G.existeAresta(nAdj) && !G.existeAresta(Inv)) {
						if (!funcoesGrafoMatrizNDir.listResult.contains(nAdj) ||
								!funcoesGrafoMatrizNDir.listResult.contains(Inv)) {
							funcoesGrafoMatrizNDir.listResult.add(nAdj);
						}
					}
				}
			}
		}
		return funcoesGrafoMatrizNDir.listResult;
	}
	
	public boolean haLaco(grafoMatrizNDir G) {
		boolean temLaco = false;
		funcoesGrafoMatrizNDir.strResult.setLength(0);
		LinkedList<String> Vert = G.getV();
		int[][] M = G.getM();
		for (int i = 0; i < Vert.size(); i++) {
			if (M[i][i] > 0) {
				temLaco = true;
				break;
			}
		}
		return temLaco;
	}
	
	public boolean haParalela(grafoMatrizNDir G) {
		LinkedList<String> Verts = G.getV();
		int[][] M = G.getM();
		for (int i = 0; i < Verts.size(); i++) {
			for (int j = 0; j < Verts.size(); j++) {
				if (M[i][j] > 1) {
					return true;
				}
			}
		}
		return false;
	}
	
	public int grauVert(grafoMatrizNDir G, String V) {
		LinkedList<String> Verts = G.getV();
		int[][] M = G.getM();
		int count = 0;
		int index;
		if (G.verticeValido(V)) {
			index = Verts.indexOf(V);
			for (int i = 0; i < Verts.size(); i++) {
				if (index < i) {
					if (M[index][i] > 0) count += M[index][i];
				} else {
					if (M[i][index] > 0) count += M[i][index];
				}
			}
		}
		return count;
	}
	
	public LinkedList<String> arestaSobreVert(grafoMatrizNDir G, String V) {
		funcoesGrafoMatrizNDir.listResult.clear();
		int[][] M = G.getI();
		LinkedList<String> Verts = G.getV();
		int index;
		if (G.verticeValido(V)) {
			index = Verts.indexOf(V);
			for (int i = 0; i < M[index].length; i++) {
				String Aresta;
				if (M[index][i] > 0) {
					Aresta = "a" + (i + 1);
					funcoesGrafoMatrizNDir.listResult.add(Aresta);
				}
			}
		}
		return funcoesGrafoMatrizNDir.listResult;
	}
	
	public boolean ehCompleto(grafoMatrizNDir G) {
		byte count = 0;
		LinkedList<String> Verts = G.getV();
		int[][] M = G.getM();
		if (Verts.size() == 1) return true;
		for (int i = 0; i < Verts.size(); i++) {
			for (int j = 0; j < Verts.size(); j++) {
				if (M[i][j] > 0) count += 1;
				else if (M[i][j] == -1) count -= 1;
			}
		}
		if (count == 0 || count == Verts.size() - 1) {
			return true;
		}
		return false;
	}
	
	public boolean caminhoEuleriano(grafoMatrizNDir G) {
		LinkedList<String> Verts = G.getV();
		byte count = 0;
		for (String i : Verts) {
			if (this.grauVert(G, i) % 2 != 0) count += 1;
		}
		if (count == 0 || count == 2) return true;
		return false;
	}

//    public void Krim(grafoMatrizNDir G) {
//
//    }
}