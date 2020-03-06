package Grafos.Interfaces;

import Grafos.Exceptions.ArestaInvalidaException;

import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;

public interface grafoComMatriz {
	
	boolean verticeValido(String V);
	
	boolean existeAresta(String a);
	
	void adicionaArestas(String A);
	
	void adicionaArestasArray(String[] A);
	
	void addAresta(String a) throws ArestaInvalidaException;
	
	void removeAresta(String A);
	
	void adicionaVertice(String V);
	
	void adicionaVertice(String[] V);
	
	LinkedList<String> getV();
	
	int[][] getM();
	
	int[][] getI();
	
	String grafoTexto();
	
}
