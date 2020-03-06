package br.edu.ifpb.cg.q3.Geradores;

import br.edu.ifpb.cg.q3.dominio.Estoque;

public interface GeradorID {

    Long obterProximoId(Estoque p);

}
