package br.edu.ifpb.cg.q3.Geradores;

import br.edu.ifpb.cg.q3.dominio.Estoque;
import br.edu.ifpb.cg.q3.dominio.Produto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class geradorSequencial implements GeradorID, Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public Long obterProximoId(Estoque e) {
        Long maiorId = getMaiorId(e.getProdutos());
        Long proximoId = maiorId + 1;
        return proximoId;
    }

    private Long getMaiorId(Collection<Produto> p) {
        Long maiorId = 1L;
        for (Produto ps : p) {
            maiorId = Math.max(maiorId, ps.getId());
        }
        return maiorId;
    }
}
