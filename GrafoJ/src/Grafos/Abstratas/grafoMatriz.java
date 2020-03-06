package Grafos.Abstratas;

import Grafos.Exceptions.ArestaInvalidaException;
import Grafos.Exceptions.MatrizInvalidaException;
import Grafos.Exceptions.VerticeInvalidoException;
import Grafos.Interfaces.grafoComMatriz;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public abstract class grafoMatriz implements grafoComMatriz {
	
	protected int[][] M;
	protected int[][] I;
	protected LinkedList<String> V = new LinkedList<>();
	protected LinkedList<String> A = new LinkedList<>();
	private String SEPARADOR_ARESTA = "-";
	private int QTDE_MAX_SEPARADOR = 1;
	private int maior_vertice = 0;
	
	
	public grafoMatriz() {
		super();
	}
	
	public grafoMatriz(LinkedList<String> V, int[][] M) throws VerticeInvalidoException, MatrizInvalidaException, ArestaInvalidaException {
		for (String v : V) {
			if (!this.verticeValido(v)) {
				throw new VerticeInvalidoException(v);
			}
			if (v.length() > this.maior_vertice) {
				this.maior_vertice = v.length();
			}
		}
		
		this.V = V;
		
		if (M.length != V.size()) {
			throw new MatrizInvalidaException();
		}
		
		for (int[] i : M) {
			if (i.length != V.size()) {
				throw new MatrizInvalidaException();
			}
		}
		
		for (int i = 0; i < V.size(); i++) {
			for (int j = 0; j < V.size(); j++) {
				if (i > j && !(M[i][j] == -1)) {
					throw new MatrizInvalidaException();
				}
				String aresta = V.get(i) + this.SEPARADOR_ARESTA + V.get(j);
				if (!this.arestaValida(aresta)) {
					throw new ArestaInvalidaException(aresta);
				}
			}
			this.M = M;
		}
		this.matrizIn();
	}
	
	public grafoMatriz(String[] V, int[][] M) {
		for (String v : V) {
			this.addVertGrafo(v.trim());
		}
		
		this.M = new int[this.V.size()][this.V.size()];
		
		for (int i = 0; i < this.V.size(); i++) {
			for (int j = 0; j < this.V.size(); j++) {
				this.M[i][j] = M[i][j];
			}
		}
		this.matrizIn();
	}
	
	public grafoMatriz(String[] V, String[] A) {
		for (String i : V) {
			if (!this.verticeValido(i)) {
				throw new VerticeInvalidoException(i);
			}
			this.addVertGrafo(i);
		}
		for (String i : A) {
			if (i.contains(".")) {
				String[] s = i.split(".");
				this.addAresta(s[0]);
			} else {
				this.addAresta(i);
			}
		}
	}
	
	public grafoMatriz(LinkedList<String> V, LinkedHashMap<String, String> A) {
		for (String i : V) {
			if (!this.verticeValido(i)) {
				throw new VerticeInvalidoException(i);
			}
		}
		this.V = V;
		this.M = new int[this.V.size()][this.V.size()];
		for (String a : A.keySet()) {
			if (!this.arestaValida(A.get(a))) {
				throw new ArestaInvalidaException(A.get(a));
			}
			this.addAresta(A.get(a));
		}
		this.matrizIn();
	}
	
	public grafoMatriz(LinkedList<String> V) {
		for (String n : V) {
			if (!this.verticeValido(n)) {
				throw new VerticeInvalidoException(n);
			}
		}
		this.V = V;
		this.M = new int[this.V.size()][this.V.size()];
	}
	
	public grafoMatriz(String[] V) {
		for (String v : V) {
			this.addVertGrafo(v.trim());
		}
		this.M = new int[this.V.size()][this.V.size()];
	}
	
	private int count(String arst) {
		int count = 0;
		for (int i = 0; i < arst.length(); i++) {
			if (Character.toString(arst.charAt(i)).equals(this.SEPARADOR_ARESTA)) {
				count++;
			}
		}
		return count;
	}
	
	private String primeiro_vertice_aresta(String a) {
		return a.substring(0, a.indexOf(this.SEPARADOR_ARESTA));
	}
	
	private String segundo_vertice_aresta(String a) {
		return a.substring(a.indexOf(this.SEPARADOR_ARESTA) + 1);
	}
	
	protected int index_primeiro_vertice_aresta(String a) {
		return this.V.indexOf(this.primeiro_vertice_aresta(a));
	}
	
	protected int index_segundo_vertice_aresta(String a) {
		return this.V.indexOf(this.segundo_vertice_aresta(a));
	}
	
	private boolean existeVertice(String V) {
		return this.verticeValido(V) && this.V.contains(V);
	}
	
	@Override
	public boolean verticeValido(String V) {
		return !V.equals("") && this.count(V) == 0;
	}
	
	@Override
	public void adicionaVertice(String V) throws VerticeInvalidoException {
		
		if (this.V.contains(V)) {
			throw new VerticeInvalidoException(V);
		}
		
		if (this.verticeValido(V)) {
			if (V.length() > this.maior_vertice) this.maior_vertice = V.length();
		}
		
		this.V.add(V);
		this.M = new int[this.V.size()][this.V.size()];
	}
	
	@Override
	public void adicionaVertice(String[] V) throws VerticeInvalidoException {
		for (String v : V) {
			if (this.V.contains(v)) {
				throw new VerticeInvalidoException(v);
			}
			
			if (this.verticeValido(v)) {
				if (v.length() > this.maior_vertice) this.maior_vertice = v.length();
			}
			
			this.V.add(v);
			
		}
		
		this.M = new int[this.V.size()][this.V.size()];
	}
	
	private void addVertGrafo(String V) {
		this.V.add(V);
	}
	
	protected boolean arestaValida(String aresta) {
		if (this.count(aresta) != this.QTDE_MAX_SEPARADOR) {
			return false;
		}
		int i_traco = aresta.indexOf(this.QTDE_MAX_SEPARADOR);
		if (i_traco == 0 ||
				(Character.toString(aresta.charAt(aresta.length() - 1))).equals(this.SEPARADOR_ARESTA)) {
			return false;
		}
		if (!this.existeVertice(aresta.substring(0, aresta.indexOf(this.SEPARADOR_ARESTA))) ||
				!this.existeVertice(aresta.substring(aresta.indexOf(this.SEPARADOR_ARESTA) + 1))) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean existeAresta(String a) {
//        boolean existe = false;
		
		if (this.arestaValida(a)) {
			return this.M[this.index_primeiro_vertice_aresta(a)][this.index_segundo_vertice_aresta(a)] > 0;
//            for (int i = 0; i < this.M.length; i++) {
//                for (int j = 0; j < this.M.length; j++) {
//                    if (this.M[this.index_primeiro_vertice_aresta(a)][this.index_segundo_vertice_aresta(a)] > 0) {
//                        existe = true;
//                    }
//                }
//            }
//        }
		}
		return false;
	}
	
	@Override
	public void addAresta(String a) throws ArestaInvalidaException {
		if (this.arestaValida(a)) {
			int i_a1 = this.index_primeiro_vertice_aresta(a);
			int i_a2 = this.index_segundo_vertice_aresta(a);
			if (i_a1 <= i_a2) {
				this.M[i_a1][i_a2] += 1;
				this.A.add(a);
			} else {
				this.M[i_a2][i_a1] += 1;
				this.A.add(a);
			}
			
		} else throw new ArestaInvalidaException(a);
	}
	
	protected void menosUmMatriz() {
		for (int i = 0; i < this.V.size(); i++) {
			for (int j = 0; j < this.V.indexOf(this.V.get(i)); j++) {
				this.M[i][j] = -1;
			}
		}
	}
	
	protected void matrizIn() {
		this.I = new int[this.V.size()][this.A.size()];
		for (int a = 0; a < this.V.size(); a++) {
			for (int b = 0; b < this.A.size(); b++) {
				if (this.A.get(b).contains(this.V.get(a))) {
					this.I[a][b] = 1;
				}
			}
		}
	}
	
	public LinkedList<String> getV() {
		return this.V;
	}
	
	public int[][] getM() {
		return this.M;
	}
	
	public int[][] getI() {
		return this.I;
	}
	
	@Override
	public String grafoTexto() {
		StringBuilder grafo_str = new StringBuilder();
		grafo_str.append("\nMatriz de Adjacência\n");
		grafo_str.append("  ");
		for (int i = 0; i < this.V.size(); i++) {
			grafo_str.append(this.V.get(i));
			if (i < this.V.size() - 1) {
				grafo_str.append(" ");
			}
		}
		grafo_str.append("\n");
		for (int i = 0; i < this.V.size(); i++) {
			grafo_str.append(this.V.get(i));
			grafo_str.append(" ");
			for (int j = 0; j < this.V.size(); j++) {
				grafo_str.append(this.M[i][j]);
				if (j != this.V.size() - 1) {
					grafo_str.append(" ");
				}
			}
			grafo_str.append("\n");
		}
		grafo_str.append("\n");
//        grafo_str.append("Matriz de Incidência\n");
//        grafo_str.append("  ");
//        for (int i = 0; i < this.I[0].length; i++) {
//            grafo_str.append(i);
//            if (i < this.I[0].length -1) {
//                grafo_str.append(" ");
//            }
//        }
//        grafo_str.append("\n");
//        for (int i = 0; i < this.V.size(); i++) {
//            grafo_str.append(this.V.get(i));
//            grafo_str.append(" ");
//            for (int j = 0; j < this.I[i].length; j++) {
//                grafo_str.append(this.I[i][j]);
//                String A = String.valueOf(j);
//                if (j < this.I[i].length - 1) {
//                    for (int k = 0; k < A.length(); k++) {
//                        grafo_str.append(" ");
//                    }
//                }
//            }
//            grafo_str.append("\n");
//        }
//        grafo_str.append("\n");
//        grafo_str.append("Matriz de Alcançabilidade\n");
//        grafo_str.append("  ");
//        for (int i = 0; i < this.V.size(); i++){
//            grafo_str.append(this.V.get(i));
//            if (i < this.V.size() - 1){
//                grafo_str.append(" ");
//            }
//        }
//        grafo_str.append("\n");
//        for (int i = 0; i < this.Alcance.length; i++) {
//            grafo_str.append(this.V.get(i));
//            grafo_str.append(" ");
//            for (int j = 0; j < this.Alcance.length; j++) {
//                grafo_str.append(this.Alcance[i][j]);
//                if (j < this.Alcance.length - 1) {
//                    grafo_str.append(" ");
//                }
//            }
//            grafo_str.append("\n");
//        }
		return grafo_str.toString();
	}
	
}
