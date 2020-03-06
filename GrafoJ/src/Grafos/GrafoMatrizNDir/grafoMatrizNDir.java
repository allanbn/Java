package Grafos.GrafoMatrizNDir;

import Grafos.Exceptions.*;
import Grafos.Abstratas.*;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class grafoMatrizNDir extends grafoMatriz {
	
	public grafoMatrizNDir() {
		super();
	}
	
	public grafoMatrizNDir(LinkedList<String> V, int[][] M)
			throws VerticeInvalidoException, MatrizInvalidaException, ArestaInvalidaException {
		super(V, M);
		this.menosUmMatriz();
	}
	
	public grafoMatrizNDir(String[] V, int[][] M) {
		super(V, M);
		this.menosUmMatriz();
	}
	
	//  tinha public
	grafoMatrizNDir(String[] V) {
		super(V);
		this.menosUmMatriz();
	}
	
	//  tinha public
	grafoMatrizNDir(LinkedList<String> V) {
		super(V);
		this.menosUmMatriz();
	}
	
	//  tinha public
	grafoMatrizNDir(LinkedList<String> N, LinkedHashMap<String, String> A) {
		super(N, A);
		this.menosUmMatriz();
	}
	
	@Override
	public void adicionaArestas(String A) {
		super.addAresta(A);
		this.menosUmMatriz();
	}
	
	@Override
	public void adicionaArestasArray(String[] A) {
		for (String a : A) {
			addAresta(a);
		}
		this.menosUmMatriz();
		this.matrizIn();
	}
	
	@Override
	public void removeAresta(String A) {
		if (this.arestaValida(A)) {
			if (this.existeAresta(A)) {
				int i_a1 = this.index_primeiro_vertice_aresta(A);
				int i_a2 = this.index_segundo_vertice_aresta(A);
				if (i_a1 > i_a2) {
					if (this.M[i_a1][i_a2] > 0) {
						this.M[i_a1][i_a2] -= 1;
					}
				} else if (i_a1 < i_a2) {
					this.M[i_a2][i_a1] -= 1;
				} else {
					this.M[i_a1][i_a1] -= 1;
				}
			}
		}
	}
	
	
}
