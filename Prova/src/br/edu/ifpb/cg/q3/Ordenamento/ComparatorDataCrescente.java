package br.edu.ifpb.cg.q3.Ordenamento;

import br.edu.ifpb.cg.q3.dominio.Produto;
import br.edu.ifpb.cg.q3.dominio.minhaData;

import java.util.Comparator;

public class ComparatorDataCrescente implements Comparator<Produto> {

    @Override
    public int compare(Produto p1, Produto p2) {

        minhaData d1 = p1.getData();
        minhaData d2 = p2.getData();

        return d1.compareTo(d2);
    }
}
