package br.edu.ifpb.cg;

import br.edu.ifpb.cg.Armazenamentos.Armazenamento;
import br.edu.ifpb.cg.Armazenamentos.ArmazenamentoBin;
import br.edu.ifpb.cg.domain.Locadora;
import br.edu.ifpb.cg.geradoresID.geradorID;
import br.edu.ifpb.cg.geradoresID.geradorIDNano;
import br.edu.ifpb.cg.geradoresID.geradorIDSeq;

import java.util.Scanner;

public class main {

    public static void main (String[] args) {
        geradorID G = null;
        G = new geradorIDNano();
//        G = new geradorIDSeq();
        Armazenamento armazenamento = new ArmazenamentoBin("LocadoraXPTO.bin");
        Locadora L = armazenamento.recuperar(G);
        Menu menu = new Menu(L, new Scanner(System.in));
        menu.apresentação();
        armazenamento.armazenar(L);
    }
}
