package br.edu.ifpb.cg.geradoresID;

import br.edu.ifpb.cg.Pessoas.Cliente;
import br.edu.ifpb.cg.Pessoas.Funcionario;
import br.edu.ifpb.cg.domain.Locacao;
import br.edu.ifpb.cg.Midias.Midia;

import java.util.List;

public interface geradorID {

    Long obterIDLocacao(List<Locacao> L);

    Long obterIDMidia(List<Midia> L);

    Long obterIDCliente(List<Cliente> L);

    Long obterIDFuncionario(List<Funcionario> L);

}
