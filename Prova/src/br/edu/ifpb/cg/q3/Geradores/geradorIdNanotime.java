package br.edu.ifpb.cg.q3.Geradores;

import br.edu.ifpb.cg.q3.dominio.Estoque;

import java.io.Serializable;

public class geradorIdNanotime implements GeradorID, Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public Long obterProximoId(Estoque p) {
        Long proximoId = System.nanoTime();
        return proximoId;
    }
}
