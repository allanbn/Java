package Grafos;

import Grafos.grafoMatrizNaoDirComPeso.funcoesGMNDP;
import Grafos.grafoMatrizNaoDirComPeso.grafoMatrizNDirComPeso;

import java.io.*;
import java.util.Arrays;
import java.util.Random;


public class Roteiro {
    public static void main(String[] args) {

        /* GRAFOS COM LISTA DE ADJACENCIA */

//        funcoesGrafoLista I = new funcoesGrafoLista();
//        grafoLista G = new grafoLista();
//        Scanner in = new Scanner(System.in);
//        String Vertices = in.nextLine();
//        String conjArestas = in.nextLine();
//        G.addVertice(Vertices);
//        G.putAresta(conjArestas);
//        System.out.println(G.toString());
//        System.out.println(I.verticesNaoAdjcts(G));
//        System.out.println(I.haLaco(G));
//        System.out.println(I.haParalela(G));
//        System.out.println(I.grauVert(G, "A"));
//        System.out.println(I.grauVert(G, "B"));
//        System.out.println(I.grauVert(G, "C"));
//        System.out.println(I.grauVert(G, "D"));
//        System.out.println(I.grauVert(G, "J"));
//        System.out.println(I.grauVert(G, "C"));
//        System.out.println(I.grauVert(G, "E"));
//        System.out.println(I.grauVert(G, "P"));
//        System.out.println(I.grauVert(G, "M"));
//        System.out.println(I.grauVert(G, "T"));
//        System.out.println(I.grauVert(G, "Z"));
//        System.out.println(I.arestaSobreVert(G, "A"));
//        System.out.println(I.arestaSobreVert(G, "B"));
//        System.out.println(I.arestaSobreVert(G, "C"));
//        System.out.println(I.arestaSobreVert(G, "D"));
//        System.out.println(I.arestaSobreVert(G, "J"));
//        System.out.println(I.arestaSobreVert(G, "C"));
//        System.out.println(I.arestaSobreVert(G, "E"));
//        System.out.println(I.arestaSobreVert(G, "P"));
//        System.out.println(I.arestaSobreVert(G, "M"));
//        System.out.println(I.arestaSobreVert(G, "T"));
//        System.out.println(I.arestaSobreVert(G, "Z"));
//        System.out.println(I.ehCompleto(G));
//        System.out.println(I.encontrarCiclo(G));
//        I.passaVertice(G);

        /* GRAFO COM MATRIZ DE ADJACENCIA */

//        funcoesGrafoMatrizNDir F = new funcoesGrafoMatrizNDir();
//        int[][] matriz = {{0,0,0,0,0},{-1,0,0,0,0},{-1,-1,0,0,0},{-1,-1,-1,0,0},{-1,-1,-1,-1,0}};
//        String[] Arestas = {"A-B","A-C","A-D","A-E","B-C","B-D","B-E","C-D","C-E", "D-E"};
//
//        String Vertices;
//        String conjArestas;
//        String[] g_pV = {"J", "C", "E", "P", "M", "T", "Z"};
//        String[] g_pA = {
//                "J-C", "C-E", "C-E", "E-C", "C-P", "C-P", "C-M", "C-T", "M-T", "T-Z"
//        };
//        Scanner in = new Scanner(System.in);
//        Vertices = in.nextLine();
//        conjArestas = in.nextLine();
//        grafoMatrizNDir G = new grafoMatrizNDir(g_pV);
//        G.adicionaVertice(Vertices.split(", "));
//        G.adicionaArestasArray(conjArestas.split(", "));
//        G.adicionaArestasArray(g_pA);
//        G.adicionaArestas(conjArestas);
//        G.adicionaVertice("A");
//        G.adicionaVertice("B");
//        G.adicionaVertice("C");
//        G.adicionaVertice("D");
//        G.adicionaVertice("E");
//        G.adicionaArestas("A-B");
//        G.adicionaArestas("A-A");
//        G.adicionaArestas("B-A");
//        System.out.println(G.toString());
//        System.out.println(F.verticesNaoAdjcts(G));
//        System.out.println(F.haLaco(G));
//        System.out.println(F.haParalela(G));
//        System.out.println(F.grauVert(G, "C"));
//        System.out.println(F.arestaSobreVert(G, "C"));
//        System.out.println(F.ehCompleto(G));
//        System.out.println(F.caminhoEuleriano(G));

        /* GRAFO DIRIGIDO */
//        String Vertices;
//        String conjArestas;
//        String Cargas;
//        Scanner in = new Scanner(System.in);
//        Vertices = in.nextLine();
//        conjArestas = in.nextLine();
//        Cargas = in.nextLine();
//        LinkedList<String> C = new LinkedList<>(Arrays.asList(Cargas.split(", ")));
//        funcoesGrafoMatrizDir F = new funcoesGrafoMatrizDir();
//        grafoMatrizDir G = new grafoMatrizDir();
//        G.adicionaVertice(Vertices.split(", "));
//        G.adicionaArestasArray(conjArestas.split(", "));
//        F.warshall(G);
//        F.dijkstra(G, "A", "AF");
//        int [][] K = null;
//        System.out.println("Digite o vertice inicial:");
//        String vI = in.nextLine();
//        System.out.println("Digite o vertice final:");
//        String vF = in.nextLine();
//        System.out.println("Digite a quantidade de carga:");
//        int bateria = in.nextInt();
//        F.dijkstraCarga(G, vI, vF, C, bateria);
//        System.out.println(G.toString());

        /* GRAFO PARA PRIM E KRUSKELL */

//        String Vertices;
//        String conjArestas;
//        Scanner in = new Scanner(System.in);
//        Vertices = in.nextLine();
//        String[] idk = Vertices.split(", ");
//        String A = "A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, AB, AC, AD, AE, AF, AG";
//        String[] vA = A.split(", ");
//        String[] aA = {"A-B.29", "A-C.0", "A-D.18", "B-E.11", "B-I.28", "C-G.1", "D-C.19", "D-H.1", "E-F.22", "F-J.7", "G-F.25", "G-J.22", "G-K.29", "H-G.28", "H-L.22", "I-M.8", "J-I.23", "J-N.20", "K-O.0", "L-P.13", "M-Q.24", "M-S.28", "N-R.26", "N-S.23", "N-T.7", "O-S.7", "P-T.13", "Q-U.16", "R-Q.5", "R-V.2", "S-R.4", "S-X.27", "U-Y.6", "U-Z.12", "V-Z.16", "V-AA.1", "V-W.28", "W-S.6", "X-AB.12", "X-AC.21", "Y-AD.3", "AB-AE.26", "AD-AE.12", "AE-AF.27", "AE-AG.23"};
//        String[] test = {"A", "B", "C", "D", "E", "F", "G"};
//        String[] Arestas = {"A-B.7", "A-D.5", "B-C.8", "B-D.9", "B-E.7", "C-E.5", "D-E.15", "D-F.6", "E-F.8", "E-G.9", "F-G.11"};





        String[] testArtigo = {"A", "B", "C", "D", "E", "F", "G", "H"};
        String[] ArestasArtigo = {"A-G.4", "A-B.9", "B-C.6", "B-H.7", "C-D.8", "C-E.12", "C-F.8", "D-E.14", "E-F.2", "F-G.1", "F-H.2"};
//      String[] testArtigo1 = {"A", "B", "C", "D", "E", "F", "G", "H"};
//        String[] ArestasArtigo1 = {"A-G.4", "A-B.9", "B-C.6", "B-H.7", "C-D.1", "C-E.12", "C-F.8", "D-E.14", "E-F.2", "F-G.2", "F-H.2"};
//        grafoMatrizNDirComPeso G = new grafoMatrizNDirComPeso(test, Arestas);
        grafoMatrizNDirComPeso G1 = new grafoMatrizNDirComPeso(testArtigo, ArestasArtigo);
//        grafoMatrizNDirComPeso G2 = new grafoMatrizNDirComPeso(vA, aA);
        funcoesGMNDP F = new funcoesGMNDP();
//        F.Prim(G);
//        System.out.println();
        F.Prim(G1);
//        System.out.println();
//        F.Prim(G2);
        F.Kruskal(G1);
//		System.out.println(G);
    }
}

// J, C, E, P
// J-C, J-P, J-E, C-P, C-E, E-P
// A, B, C, D
// a1(A-B), a2(B-C), a3(C-D), a4(D-A)
// a1(A-B), a2(A-C), a3(A-D), a4(B-C), a5(B-D), a6(C-D), a7(D-D) completo
// a1(A-A), a2(B-A), a3(A-A) lacos
// a1(A-B), a2(B-B), a3(B-A) lacos
// a1(C-A), a2(C-C), a3(D-D) lacos
// a1(A-B), a2(B-B), a3(B-A), a4(B-B) lacos
// a1(A-B), a2(A-C), a3(A-D), a4(B-C)

// J, C, E, P, M, T, Z
// a1(J-C), a2(C-E), a4(C-P), a6(C-M), a8(M-T), a9(T-Z) - Paraíba original
// a1(J-C), a2(C-E), a3(C-E), a4(C-P), a5(C-P), a6(C-M), a7(C-T), a8(M-T), a9(T-Z), a10(C-M), a11(M-P), a12(P-C) - Teste de Henrique
// a1(J-C), a2(C-E), a3(C-M), a4(C-P), a5(C-P), a6(M-P), a7(C-T), a8(M-T), a9(P-C)
// a1(C-M), a2(M-M), a3(P-C)

// A, B, C, D, E, F
// a1(F-F)

// A, B
// a1(A-B), a2(B-A)

// J, C, E, P
// a1(J-C), a2(J-E), a3(J-P), a4(C-E), a5(C-P), a6(E-P)

// A, B, C, D, E, F, G
// a1(A-B), a2(A-D), a3(B-C), a4(B-F), a5(B-E), a6(B-D), a7(C-G), a8(D-E), a9(E-F), a10(F-G) - Teste de Ranzeus

// A, B, C, D, E
// a1(A-B), a2(B-C), a3(A-D), a4(A-E), a5(D-E) - Teste de Ranzeus

// J, C, E, P, M, T, Z
// J-C, C-E, C-M, C-P, C-P, M-P, C-T, M-T, P-C

// A, B, C, D
// D-C, C-B, B-C, B-A


// GRAFO ALOPRADO
// A, B, C, D, E, F, G, H, I, J, K, L
// A-B, A-D, A-C, A-K, A-J, B-A, B-D, B-I, B-F, C-F, C-B, C-J, D-A, D-J, D-F, E-G, E-H, E-I, E-K, F-E, F-A, F-G, G-G, G-H, G-I, G-K, H-A, H-E, J-L, J-K, K-E, K-J

// A-C-B-D-F-G-H-E-K-J-L

// GRAFO DO SITE DE HENRIQUE ROTEIRO 5 - DIJKSTRA TRADICIONAL
/*
A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, AB, AC, AD, AE, AF, AG
A-B, A-C, A-D, B-E, B-I, C-G, D-C, D-H, E-F, F-J, G-F, G-J, G-K, H-G, H-L, I-M, J-I, J-N, K-O, L-P, M-Q, M-S, N-R, N-S, N-T, O-S, P-T, Q-U, R-Q, R-V, S-R, S-X, U-Y, U-Z, V-Z, V-AA, V-W, W-S, X-AB, X-AC, Y-AD, AB-AE, AD-AE, AE-AF, AE-AG
*/
// R = A, B, I, M, S, X, AB, AE, AF

// GRAFO SITE DE HENRIQUE ROTEIRO 5 - DIJKSTRA COM CARGAS
/*
A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, AB, AC, AD, AE, AF, AG
A-B, A-C, A-D, B-E, B-I, C-G, D-C, D-H, E-F, B-F, F-J, G-F, G-J, G-K, H-G, H-L, I-M, J-I, J-N, K-O, L-P, M-Q, M-S, N-R, N-S, N-T, O-S, P-T, Q-U, R-Q, R-V, S-R, S-X, T-S, U-Y, U-Z, V-Z, V-AA, V-W, W-S, X-AB, X-AC, Y-AD, AB-W, AB-AE, AD-AE, AE-AF, AE-AG, AG-AF
L, S, U, AD
*/
//  RESPOSTA CARGA MÁXIMA = A, B, I, M, S, X, AB, AE, AF  - DÁ CERTO
//  RESPOSTA CARGA INICIAL 3 = A, D, H, L, P, T, S, X, AB, AE, AF - DÁ CERTO

/* *
 * NAO SEI MAIS QUAL RUMO ESTE GRAFO ESTÁ TOMANDO
 * ASSIM COMO TAMBÉM NÃO SEI O RUMO QUE MINHA VIDA ESTÁ TOMANDO.
 * ASSINADO: ALLAN BISPO
 * */


/*Macerlo e João Carlos - PRIM
* Caique - PRIM
* */