package br.edu.ifpb.cg.q3.Ordenamento;

import br.edu.ifpb.cg.q3.dominio.Produto;

import java.util.Comparator;

public class ComparatorAlfa implements Comparator<Produto> {
    @Override
    public int compare(Produto o1, Produto o2) {

        String p1 = o1.getMarca();
        String p2 = o2.getMarca();

        return p1.compareTo(p2);
    }
}
