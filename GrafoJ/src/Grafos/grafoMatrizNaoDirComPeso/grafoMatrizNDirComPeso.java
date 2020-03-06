package Grafos.grafoMatrizNaoDirComPeso;

import Grafos.Abstratas.grafoMatriz;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class grafoMatrizNDirComPeso extends grafoMatriz {
	
	private PriorityQueue[][] matrizPeso;
	private LinkedList<String> arestasComPeso = new LinkedList<>();
	
	// A-B.2, A-B.5, A-B.20
	public grafoMatrizNDirComPeso() {
		super();
	}

//    public grafoMatrizNDirComPeso(LinkedList<String> V, int[][] M, LinkedList<LinkedList<LinkedList<Integer>>> P)
//            throws VerticeInvalidoException, MatrizInvalidaException, ArestaInvalidaException {
//        super(V, M);
//        this.matrizPeso = P;
//    }
//
//    public grafoMatrizNDirComPeso(String[] V, int[][] M, LinkedList<LinkedList<LinkedList<Integer>>> P) {
//        super(V, M);
//        this.matrizPeso = P;
//    }
//
//    public grafoMatrizNDirComPeso(LinkedList<String> N, LinkedHashMap<String, String> A) {
//        super(N, A);
//    }
//
//    public grafoMatrizNDirComPeso(String[] V) {
//        super(V);
//    }
//
//    public grafoMatrizNDirComPeso(LinkedList<String> V) {
	
	//        super(V);
//    }
	public grafoMatrizNDirComPeso(String[] V, String[] A) {
		for (String i : V) {
			this.adicionaVertice(i);
		}
		this.matrizPeso = new PriorityQueue[this.V.size()][this.V.size()];
		for (String i : A) {
			this.arestasComPeso.add(i);
			this.splitAddAresta(i);
		}
		for (int i = 0; i < this.V.size(); i++) {
			for (int j = 0; j < this.V.size(); j++) {
				this.matrizPeso[i][j] = new PriorityQueue<Integer>();
			}
		}
		this.addPesoMatriz();
		this.menosUmMatriz();
	}
	
	private void addPesoMatriz() {
		for (String i : this.arestasComPeso) {
			String[] s = i.split("\\.");
			int i_a1 = this.index_primeiro_vertice_aresta(s[0]);
			int i_a2 = this.index_segundo_vertice_aresta(s[0]);
			if (i_a1 < i_a2) {
				this.matrizPeso[i_a1][i_a2].add(Integer.parseInt(s[1]));
			} else if (i_a1 > i_a2) {
				this.matrizPeso[i_a2][i_a1].add(Integer.parseInt(s[1]));
			} else {
				this.matrizPeso[i_a1][i_a1].add(Integer.parseInt(s[1]));
			}
		}
	}
	
	private void splitAddAresta(String s) {
		String[] str = s.split("\\.");
		if (this.arestaValida(str[0])) {
			super.addAresta(str[0]);
//            if (this.hashPeso.keySet().contains(str[0])) {
//                this.hashPeso.get(str[0]).add(Integer.parseInt(str[1]));
//            }
//            else {
//                this.hashPeso.put(str[0], new LinkedList<>());
//                this.hashPeso.get(str[0]).add(Integer.parseInt(str[1]));
//            }
		}
	}
	
	public PriorityQueue[][] getMatrizPeso() {
		return matrizPeso;
	}
	
	public void setMatrizPeso(PriorityQueue[][] matrizPeso) {
		this.matrizPeso = matrizPeso;
	}
	
	public LinkedList<String> getA() {
		return this.A;
	}
	
	public LinkedList<String> getArestasComPeso() {
		return this.arestasComPeso;
	}
	
	@Override
	public void adicionaArestas(String s) {
		this.splitAddAresta(s);
	}
	
	@Override
	public void adicionaArestasArray(String[] s) {
		for (String i : s) {
			this.splitAddAresta(i);
		}
	}
	
	@Override
	public void removeAresta(String s) {
		
		if (existeAresta(s)) {
			int i_a1 = index_primeiro_vertice_aresta(s);
			int i_a2 = index_segundo_vertice_aresta(s);
			if (i_a1 < i_a2) {
				this.M[i_a1][i_a2] -= 1;
				this.matrizPeso[i_a1][i_a2].remove();
			} else if (i_a1 > i_a2) {
				this.M[i_a2][i_a1] -= 1;
				this.matrizPeso[i_a2][i_a1].remove();
			} else {
				this.M[i_a1][i_a1] -= 1;
				this.matrizPeso[i_a1][i_a1].remove();
			}
//            this.hashPeso.get(s).removeFirst();
//            if (this.hashPeso.get(s).isEmpty()) {
//                this.hashPeso.remove(s);
//            }
		}
	}
	
	@Override
	public String toString() {
		String s = super.grafoTexto();
		s += System.lineSeparator();
		s += "Pesos" + System.lineSeparator();
		for (int i = 0; i < this.M.length; i++) {
			for (int j = 0; j < this.M.length; j++) {
				String a = this.V.get(i) + "-" + this.V.get(j);
				if (this.existeAresta(a)) {
					s += a + ":" + this.matrizPeso[i][j];
					s += System.lineSeparator();
				}
			}
		}
		return s;
	}
	
}