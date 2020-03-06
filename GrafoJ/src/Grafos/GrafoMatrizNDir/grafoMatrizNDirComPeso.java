package Grafos.GrafoMatrizNDir;

import Grafos.Abstratas.grafoMatriz;

import java.util.ArrayList;
import java.util.LinkedList;

public class grafoMatrizNDirComPeso extends grafoMatriz{

    private LinkedList[][] matrizPeso;
    private LinkedList<Integer> P = new LinkedList<>();
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
        for (String i : A) {
            this.arestasComPeso.add(i);
            this.splitAddAresta(i);
        }
        this.matrizPeso = new LinkedList[this.V.size()][this.A.size()];
        for (int i = 0; i < this.V.size(); i++) {
            for (int j = 0; j < this.A.size(); j++) {
                this.matrizPeso[i][j] = new LinkedList<Integer>();
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
            }
            else if (i_a1 > i_a2) {
                this.matrizPeso[i_a2][i_a1].add(Integer.parseInt(s[1]));
            }
            else {
                this.matrizPeso[i_a1][i_a1].add(Integer.parseInt(s[1]));
            }
        }
    }

    private void splitAddAresta(String s) {
        String[] str = s.split("\\.");
        if (this.arestaValida(str[0])) {
            super.addAresta(str[0]);
            this.P.add(Integer.parseInt(str[1]));
        }
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

    }
}
