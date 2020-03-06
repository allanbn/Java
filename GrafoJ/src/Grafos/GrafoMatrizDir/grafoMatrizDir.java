package Grafos.GrafoMatrizDir;

import Grafos.Exceptions.*;
import Grafos.Abstratas.*;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class grafoMatrizDir extends grafoMatriz {
	
	private int[][] Alcance;
	
	public grafoMatrizDir() {
		super();
	}
	
	public grafoMatrizDir(LinkedList<String> V, int[][] M)
			throws VerticeInvalidoException, MatrizInvalidaException, ArestaInvalidaException {
		super(V, M);
	}
	
	public grafoMatrizDir(String[] Verts, int[][] M) {
		super(Verts, M);
		
	}
	
	public grafoMatrizDir(String[] Verts) {
		super(Verts);
		
	}
	
	public grafoMatrizDir(LinkedList<String> Verts) {
		super(Verts);
		
	}
	
	public grafoMatrizDir(LinkedList<String> N, LinkedHashMap<String, String> A, LinkedList<Integer> P) {
		super(N, A);
		
	}
	
	@Override
	public void adicionaArestas(String A) {
		this.addAresta(A);
	}
	
	@Override
	public void adicionaArestasArray(String[] A) {
		for (String a : A) {
			this.addAresta(a);
		}
		super.matrizIn();
	}
	
	@Override
	public void addAresta(String a) throws ArestaInvalidaException {
		if (this.arestaValida(a)) {
			this.M[this.index_primeiro_vertice_aresta(a)][this.index_segundo_vertice_aresta(a)] += 1;
			this.A.add(a);
		} else throw new ArestaInvalidaException(a);
	}
	
	@Override
	public void removeAresta(String A) {
		if (this.arestaValida(A)) {
			if (this.existeAresta(A)) {
				int i_a1 = this.index_primeiro_vertice_aresta(A);
				int i_a2 = this.index_segundo_vertice_aresta(A);
				this.M[i_a1][i_a2] -= 1;
			}
		}
	}
	
	//  tinha public
	void setAlcance(int[][] alcance) {
		this.Alcance = alcance;
	}
	
}

