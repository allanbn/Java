package br.edu.ifpb.cg.q3;

import br.edu.ifpb.cg.q3.Armazenamentos.Armazenamento;
import br.edu.ifpb.cg.q3.Armazenamentos.armazenamentoBin;
import br.edu.ifpb.cg.q3.Geradores.GeradorID;
import br.edu.ifpb.cg.q3.Geradores.geradorIdNanotime;
import br.edu.ifpb.cg.q3.dominio.Estoque;


public class Menu {

    public static void main(String[] args) {

        Armazenamento armazenamento = new armazenamentoBin("a.ser");

        GeradorID geradorId = new geradorIdNanotime();

        Estoque a = armazenamento.recuperar(geradorId);
        MenuPrincipal m = new MenuPrincipal();
        m.exibirMenu(a);
        armazenamento.armazenar(a);
    }
}
