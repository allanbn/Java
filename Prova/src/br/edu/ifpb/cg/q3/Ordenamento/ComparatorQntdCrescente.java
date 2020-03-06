package br.edu.ifpb.cg.q3.Ordenamento;

import br.edu.ifpb.cg.q3.dominio.Produto;

import java.util.Comparator;

public class ComparatorQntdCrescente implements Comparator<Produto> {

    @Override
    public int compare(Produto produto, Produto t1) {

        Integer qntd1 = produto.getQuantidade();
        Integer qntd2 = t1.getQuantidade();

        return qntd1.compareTo(qntd2);
    }
}
