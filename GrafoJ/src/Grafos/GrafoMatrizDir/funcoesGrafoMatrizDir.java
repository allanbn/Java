package Grafos.GrafoMatrizDir;

import java.util.LinkedList;

public class funcoesGrafoMatrizDir {
	
	private LinkedList<LinkedList<String>> A = new LinkedList<>();
	
	public funcoesGrafoMatrizDir() {
		super();
	}
	
	//  Warshall
	public int[][] warshall(grafoMatrizDir G) {
		int[][] M = G.getM();
		int[][] E = new int[M.length][M.length];
		for (int i = 0; i < E.length; i++) {
			for (int j = 0; j < E.length; j++) {
				E[i][j] = M[i][j];
			}
		}
		for (int i = 0; i < E.length; i++) {
			for (int j = 0; j < E.length; j++) {
				if (E[j][i] > 0) {
					for (int k = 0; k < E.length; k++) {
						if (E[j][k] < E[i][k]) {
							E[j][k] = E[i][k];
						}
					}
				}
			}
		}
		G.setAlcance(E);
		return E;
	}
	
	//  Dijkstra puro
	public void dijkstra(grafoMatrizDir G, String I, String F) {
		
		int BETA = 0;
		int PHI = 1;
		int PI = 2;
		int INFINITY = Integer.MAX_VALUE;
		LinkedList<String> Verts = G.getV();
		int[][] matrizAdj = G.getM();
		int[][] warshall = warshall(G);
		int[][] matrizInfo = new int[matrizAdj.length][3];
		if (warshall[Verts.indexOf(I)][Verts.indexOf(F)] == 0) {
			System.out.println("Nao tem caminho");
		} else {
			matrizInfo[Verts.indexOf(I)][BETA] = 0;
			matrizInfo[Verts.indexOf(I)][PI] = -1;
			for (int i = 0; i < matrizInfo.length; i++) {
				if (!I.equals(Verts.get(i))) {
					matrizInfo[i][BETA] = INFINITY;
					matrizInfo[i][PHI] = 0;
					matrizInfo[i][PI] = -1;
				}
			}
			int W = Verts.indexOf(I);
			while (W != Verts.indexOf(F)) {
				System.out.println(W);
				matrizInfo[W][PHI] = 1;
				for (int i = 0; i < Verts.size(); i++) {
					if ((W != i) && (matrizAdj[W][i] > 0) && (matrizInfo[i][PHI] == 0) && (matrizInfo[i][BETA] > matrizInfo[W][BETA] + 1)) {
						matrizInfo[i][BETA] += 1;
						matrizInfo[i][PI] = W;
					}
				}
				int MIN = INFINITY;
				int index_min = -1;
				for (int i = 0; i < matrizInfo.length; i++) {
					if ((W != i) && (matrizInfo[i][BETA] < INFINITY) && (matrizInfo[i][BETA] < MIN) && (matrizInfo[i][PHI] == 0)) {
						MIN = matrizInfo[i][BETA];
						index_min = i;
					}
				}
				if (index_min != -1) {
					W = index_min;
				}
			}
			LinkedList<String> caminho = new LinkedList<>();
			int vertice = Verts.indexOf(F);
			caminho.add(F);
			while (matrizInfo[vertice][PI] != -1) {
				caminho.add(Verts.get(matrizInfo[vertice][PI]));
				vertice = matrizInfo[vertice][PI];
			}
			LinkedList<String> caminhocerto = new LinkedList<>();
			for (int i = caminho.size() - 1; i >= 0; i--) {
				caminhocerto.add(caminho.get(i));
			}
			System.out.println(caminhocerto);
		}
	}

//  TENTEI DE MODO ITERATIVO, MAS, NÃO DEU CERTO
//    public void dijkstraCargas(grafoMatrizDir G, String I, String F, LinkedList<String> C, int B) {

//        int BATERY = (B);
//        int BETA = 0;
//        int PHI = 1;
//        int PI = 2;
//        int INFINITY = Integer.MAX_VALUE;
//        LinkedList<String> Verts = G.getV();
//        int[][] matrizAdj = G.getM();
//        int[][] warshall = warshall(G);
//        int[][] matrizInfo = new int[matrizAdj.length][3];
//        if (warshall[Verts.indexOf(I)][Verts.indexOf(F)] == 0) {
//            System.out.println("Nao tem caminho");
//        } else {
//            matrizInfo[Verts.indexOf(I)][BETA] = 0;
//            matrizInfo[Verts.indexOf(I)][PHI] = 1;
//            matrizInfo[Verts.indexOf(I)][PI] = -1;
//            for (int i = 0; i < matrizInfo.length; i++) {
//                if (!I.equals(Verts.get(i))) {
//                    matrizInfo[i][BETA] = INFINITY;
//                    matrizInfo[i][PHI] = 0;
//                    matrizInfo[i][PI] = -1;
//                }
//            }
//            int W = Verts.indexOf(I);
//            while (W != Verts.indexOf(F)) {
//                LinkedList<Integer> adj = this.verticesAdjs(G, Verts.get(W));
////                System.out.println(W);
//                for (int i = 0; i < Verts.size(); i++) {
//                    if ((W != i) && (matrizAdj[W][i] > 0) && (matrizInfo[i][PHI] == 0) && (matrizInfo[i][BETA] > matrizInfo[W][BETA] + 1)) {
//                        matrizInfo[i][BETA] = matrizInfo[W][BETA] + 1;
//                        matrizInfo[i][PI] = W;
//                    }
//                }
//                int MIN = INFINITY;
//                int index_min = -1;
//                for (int i = 0; i < matrizInfo.length; i++) {
//                    if ((W != i) && (matrizInfo[i][BETA] < INFINITY) && (matrizInfo[i][BETA] < MIN) && (matrizInfo[i][PHI] == 0)) {
//                        MIN = matrizInfo[i][BETA];
//                        index_min = i;
//                    }
//                }
//                if (index_min != -1) {
//                    matrizInfo[index_min][PHI] = 1;
//                    W = index_min;
//                }
//                if (W == Verts.indexOf(F)) {
//                    System.out.println("EOQ");
//                    matrizInfo[W][PHI] = 1;
//                    LinkedList<String> caminho = new LinkedList<>();
//                    int vertice = Verts.indexOf(F);
//                    caminho.add(F);
//                    while (matrizInfo[vertice][PI] != -1) {
//                        caminho.add(Verts.get(matrizInfo[vertice][PI]));
//                        vertice = matrizInfo[vertice][PI];
//                    }
//                    LinkedList<String> caminhocerto = new LinkedList<>();
//                    for (int i = caminho.size() - 1; i >= 0; i--) {
//                        caminhocerto.add(caminho.get(i));
//                    }
//                    for (int i = 0; i < caminhocerto.size(); i++) {
//                        if (BATERY == -1) {
//                            break;
//                        }
//                        if (C.contains(caminhocerto.get(i))) {
//                            BATERY = 5;
//                        }
//                        else {
//                            BATERY--;
//                        }
//                    }
//                    if (BATERY == -1) {
//                        for (int i = caminhocerto.size() - 1; i >= 0; i--) {
//                            if (C.contains(caminhocerto.get(i))) {
//                                matrizInfo[Verts.indexOf(caminhocerto.get(i))][PHI] = 0;
//                            }
//                        }
//                        BATERY = B;
//                        W = Verts.indexOf(I);
//                    }
//                    else {
//                        break;
//                    }
//                }
////                    if (BATERY - 1 > 0) {
////                        if (C.contains(Verts.get(index_min))) BATERY = 5;
////                        BATERY--;
////                        W = index_min;
////                        matrizInfo[W][PHI] = 1;
////                    } else if (BATERY - 1 == 0) {
////                        if (C.contains(Verts.get(index_min))) {
////                            BATERY = 5;
////                            W = index_min;
////                            matrizInfo[W][PHI] = 1;
////
////                        } else {
////                            BATERY++;
////                            matrizInfo[index_min][PHI] = 1;
////                            W = matrizInfo[index_min][PI];
////
////                        }
////
////                    }
////                } else if (matrizInfo[W][PI] != -1) {
////                    W = matrizInfo[W][PI];
////                    if (W == Verts.indexOf(I)) {
////                        BATERY = B;
////                    }
////                }
//            }
//        }
	
	//  função para calcular se a bateria encaixa em um dos caminhos encontrados pela "calculaCaminhos".
	private void calculaBateria(LinkedList<LinkedList<String>> path, LinkedList<String> C, int B) {
		
		int BATERY;
		int j;
		LinkedList<String> menorCaminho = new LinkedList<>();
//        if (B == 0) return menorCaminho;
		for (int i = 0; i < path.size(); i++) {
			BATERY = (B);
			for (j = 0; j < path.get(i).size(); j++) {
				if (BATERY == -1) {
					break;
				}
				if (C.contains(path.get(i).get(j))) {
					BATERY = 5;
				} else {
					BATERY--;
				}
			}
			if (BATERY == -1) {
				if (j == path.get(i).size() - 1) {
					if (path.get(i).size() <= menorCaminho.size()) {
						menorCaminho = path.get(i);
					} else if (menorCaminho.size() == 0) {
						menorCaminho = path.get(i);
					}
				}
			} else {
				if (BATERY > -1) {
					if (menorCaminho.size() == 0) {
						menorCaminho = path.get(i);
					} else if (path.get(i).size() <= menorCaminho.size()) {
						menorCaminho = path.get(i);
					}
				}
			}
		}
		System.out.println(menorCaminho);
	}
	
	//  função para procurar os vertices adjacentes de um determinado vertice passado na chamada recursiva de "calculaCaminhos"
	private LinkedList<Integer> verticesAdjs(grafoMatrizDir G, String V) {
		
		LinkedList<Integer> resposta = new LinkedList<>();
		for (int i = 0; i < G.getV().size(); i++) {
			if (G.getM()[G.getV().indexOf(V)][i] > 0) {
				resposta.add(i);
			}
		}
		return resposta;
	}
	
	//  função que acha todos os caminhos entres o vertice inicial e o vertice passado
	private void calculaCaminhos(grafoMatrizDir G, String u, String d, boolean[] Visitados,
								 LinkedList<String> caminhoTmp) {
		
		Visitados[G.getV().indexOf(u)] = true;
		
		if (G.getV().indexOf(u) == G.getV().indexOf(d)) {
			this.A.add(new LinkedList<>(caminhoTmp));
		}
		for (int i : this.verticesAdjs(G, u)) {
			if (!Visitados[i]) {
				caminhoTmp.add(G.getV().get(i));
				calculaCaminhos(G, G.getV().get(i), d, Visitados, caminhoTmp);
				caminhoTmp.remove(G.getV().get(i));
			}
		}
		Visitados[G.getV().indexOf(u)] = false;
	}
	
	//  função de chamada para projeto de drone
	public void dijkstraCarga(grafoMatrizDir G, String s, String d, LinkedList<String> C, int B) {
		
		if (this.warshall(G)[G.getV().indexOf(s)][G.getV().indexOf(d)] > 0) {
			boolean[] Visitados = new boolean[G.getV().size()];
			LinkedList<String> path = new LinkedList<>();
			path.add(s);
			this.calculaCaminhos(G, s, d, Visitados, path);
			if (this.A.get(0).size() > 0) {
				this.calculaBateria(this.A, C, B);
			} else {
				this.semCaminho();
			}
		} else {
			this.semCaminho();
		}
	}
	
	//  função auxiliar para exibir que não há caminho entre os vertices caso ocorra
	private void semCaminho() {
		
		LinkedList<String> A = new LinkedList<>();
		System.out.println(A);
	}
}
