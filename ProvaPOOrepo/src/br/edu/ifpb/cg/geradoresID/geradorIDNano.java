package br.edu.ifpb.cg.geradoresID;

import br.edu.ifpb.cg.Pessoas.Cliente;
import br.edu.ifpb.cg.Pessoas.Funcionario;
import br.edu.ifpb.cg.domain.Locacao;
import br.edu.ifpb.cg.Midias.Midia;

import java.io.Serializable;
import java.util.List;

public class geradorIDNano implements geradorID, Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public Long obterIDLocacao(List<Locacao> L) {
        return System.nanoTime();
    }

    @Override
    public Long obterIDMidia(List<Midia> L) {
        return System.nanoTime();
    }

    @Override
    public Long obterIDCliente(List<Cliente> L) {
        return null;
    }

    @Override
    public Long obterIDFuncionario(List<Funcionario> L) {
        return null;
    }
}
