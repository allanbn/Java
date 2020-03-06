package Grafos.grafoMatrizNaoDirComPeso;


import Grafos.util.objAresta;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;



// Grafo com Matriz Não Direcionado com PESOS (GMNDP)
public class funcoesGMNDP {

    public funcoesGMNDP() {

    }

    public void Prim(grafoMatrizNDirComPeso G) {


        // Escolhe o vertice com as arestas de menor peso
        LinkedList<String> Verts = new LinkedList<>(G.getV());

        PriorityQueue[][] PQ = G.getMatrizPeso();
        int W = -1;
        int soma = Integer.MAX_VALUE;
        int i1;
        int i2;
        for (int i = 0; i < Verts.size(); i++) {
//			int somaTmp = -1;
            for (int j = 0; j < Verts.size(); j++) {
                if (i <= j) {
                    i1 = i;
                    i2 = j;
                } else {
                    i1 = j;
                    i2 = i;
                }
                if (G.existeAresta(Verts.get(i1) + "-" + Verts.get(i2))) {
                    if (PQ[i1][i2].size() > 0) {
//						Iterator x = PQ[i1][i2].iterator();
//						while (x.hasNext()) {
                        if ((int) PQ[i1][i2].peek() < soma) {
                            soma = (int) PQ[i1][i2].peek();
                            W = i1;
                        }
//						}
                    }
                }
            }
//			if (somaTmp != -1 && somaTmp < soma) {
//				soma = somaTmp;
//				W = i1;
//			}
        }
        //	PRIM COMEÇA DE FATO AQUI
        LinkedList<String> A = new LinkedList<>(G.getA());
        LinkedList<String> MST = new LinkedList<>();
        Set<String> Visitados = new HashSet<>();
        LinkedList<Integer> P = new LinkedList<>();
        int V = W;
//        System.out.println(V);
        Visitados.add(Verts.get(V));
        while (Verts.size() != Visitados.size()) {
            int peso = Integer.MAX_VALUE;
            String arst = null;
            for (String i : Visitados) {
                i1 = -1;
                i2 = -1;
                for (String s : Verts) {
                    if (A.contains(i + "-" + s) && !Visitados.contains(s)) {
                        i1 = Verts.indexOf(i);
                        i2 = Verts.indexOf(s);
                    }
                    else if (A.contains(s + "-" + i) && !Visitados.contains(s)) {
                        i1 = Verts.indexOf(s);
                        i2 = Verts.indexOf(i);
                    }
                    if(i1 != -1 && i2 != -1) {
                        if (PQ[i1][i2].size() > 0) {
                            int I = (int) PQ[i1][i2].peek();
                            if (A.contains(Verts.get(i1) + "-" + Verts.get(i2))) {
                                if (I < peso) {
                                    arst = Verts.get(i1) + "-" + Verts.get(i2);
                                    peso = I;
                                }
                            }
                        }
                    }
                }
            }
            if (arst != null) {
                if (!MST.contains(arst)) {
                    MST.add(arst);
                    P.add(peso);
                    if (Verts.indexOf(arst.substring(0, arst.indexOf("-"))) != V && !Visitados.contains(arst.substring(0, arst.indexOf("-")))) {
                        V = Verts.indexOf(arst.substring(0, arst.indexOf("-")));
                    } else if (Verts.indexOf(arst.substring(arst.indexOf("-"))) != V && !Visitados.contains(arst.substring(arst.indexOf("-") + 1))) {
                        V = Verts.indexOf(arst.substring(arst.indexOf("-") + 1));
                    }
                    Visitados.add(Verts.get(V));
                    A.remove(arst);
                }
            }
        }
//		System.out.println(MST);
        String str = "MST (Prim): ";
        for (int i = 0; i < MST.size(); i++) {
            str += MST.get(i) + "." + P.get(i);
            if (i < MST.size() - 1) {
                str += ", ";
            }
        }
        System.out.println(str);
    }

    public void Kruskal(grafoMatrizNDirComPeso G) {
        // LEMBRAR DE ADICIONAR AS CAIXAS COMO PARAMETRO
        int menorPeso = Integer.MAX_VALUE;
        int maiorPeso = Integer.MIN_VALUE;
        String maiorAresta = null;
        String menorAresta = null;
        PriorityQueue[][] PQ = G.getMatrizPeso();
        LinkedList<String> Verts = new LinkedList<>(G.getV());
        for (String i : Verts) {
            for (String j : Verts) {
                if (G.existeAresta(i + "-" + j)) {
                    Iterator It = PQ[Verts.indexOf(i)][Verts.indexOf(j)].iterator();
                    while (It.hasNext()) {
                        int pesoTmp = (int) It.next();
                        if (pesoTmp > maiorPeso) {
                            maiorAresta = i + "-" + j;
                            maiorPeso = pesoTmp;
                        }
                        if (pesoTmp < menorPeso) {
                            menorAresta = i + "-" + j;
                            menorPeso = pesoTmp;
                        }
                    }
                }
            }
        }
        int range = maiorPeso - menorPeso;
        long interval = (long) Math.ceil((double) range / 5); // range / boxes
        List<ArrayList<objAresta>> Boxes = new ArrayList<>();
        List<objAresta> listObjArestas = new LinkedList<>();
        for (int i = 0; i < G.getArestasComPeso().size(); i++) {
            String arst = G.getArestasComPeso().get(i);
            String[] arstSplit = arst.split("\\.");
            listObjArestas.add(new objAresta(arstSplit[0], Integer.parseInt(arstSplit[1])));
        }
        for (int i = 0; i < 5; i++) {
            Boxes.add(new ArrayList<>());
        }
        int m = menorPeso;
        for (int i = 0; i < Boxes.size(); i++) {
            for (objAresta obj : listObjArestas) {
                if (m <= obj.getPeso() && obj.getPeso() <= m + interval && !Boxes.contains(obj)) {
                    Boxes.get(i).add(obj);
                }
            }
            m += interval;
        }
        int n = Boxes.size();
        //	BUBBLE SORT
        for (int b = 0; b < n; b++) {
            for (int i = 0; i < Boxes.get(b).size() - 1; i++) {
                for (int j = 0; j < Boxes.get(b).size() - i - 1; j++) {
                    if (Boxes.get(b).get(j).getPeso() > Boxes.get(b).get(j + 1).getPeso()) {
                        objAresta temp = Boxes.get(b).get(j);
                        Boxes.get(b).set(j, Boxes.get(b).get(j + 1));
                        Boxes.get(b).set(j + 1, temp);
                    }
                }
            }
        }
        LinkedList<String> Visitados = new LinkedList<>();
        LinkedList<String> MST = new LinkedList<>();
        LinkedList<Integer> Peso = new LinkedList<>();
        String V = Boxes.get(0).get(0).getAresta();
        Peso.add(Boxes.get(0).get(0).getPeso());
        Visitados.add(V.substring(0, V.indexOf("-")));
        Visitados.add(V.substring(V.indexOf("-") + 1));
        MST.add(V);
        for (int i = 0; i < Boxes.size(); i++) {
            for (int j = 0; j < Boxes.get(i).size(); j++) {
                objAresta arst = Boxes.get(i).get(j);
                if (!Visitados.contains(arst.getAresta().substring(0, arst.getAresta().indexOf("-")))) {
                    if (!MST.contains(arst.getAresta())) {
                        MST.add(arst.getAresta());
                        Peso.add(arst.getPeso());
                        Visitados.add(arst.getAresta().substring(0, arst.getAresta().indexOf("-")));
                    }
                } else if (!Visitados.contains(arst.getAresta().substring(arst.getAresta().indexOf("-") + 1))) {
                    if (!MST.contains(arst.getAresta())) {
                        MST.add(arst.getAresta());
                        Peso.add(arst.getPeso());
                        Visitados.add(arst.getAresta().substring(arst.getAresta().indexOf("-") + 1));
                    }
                }
            }
        }
        String s = "MST (Kruskal): ";
        for (int i = 0; i < MST.size(); i++) {
            s += MST.get(i) + "." + Peso.get(i);
            if (i < MST.size() - 1) {
                s += ", ";
            }
        }
        System.out.println(s);
    }
}

