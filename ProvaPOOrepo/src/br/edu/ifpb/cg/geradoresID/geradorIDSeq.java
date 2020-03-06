package br.edu.ifpb.cg.geradoresID;

import br.edu.ifpb.cg.Pessoas.Cliente;
import br.edu.ifpb.cg.Pessoas.Funcionario;
import br.edu.ifpb.cg.domain.Locacao;
import br.edu.ifpb.cg.Midias.Midia;

import java.io.Serializable;
import java.util.List;

public class geradorIDSeq implements geradorID, Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public Long obterIDLocacao(List<Locacao> L) {
        Long ID = 0L;
        if (L.size() > 0) {
            ID = this.obterMaiorIDLoc(L) + 1;
        }
        return ID;
    }

    @Override
    public Long obterIDMidia(List<Midia> L) {
        Long ID = 0L;
        if (L.size() > 0) {
            ID = this.obterMaiorIDMidia(L) + 1;
        }
        return ID;
    }

    @Override
    public Long obterIDCliente(List<Cliente> L) {
        Long ID = 0L;
        if (L.size() > 0) {
            ID = this.obterMaiorIDCliente(L) + 1;
        }
        return ID;
    }

    @Override
    public Long obterIDFuncionario(List<Funcionario> L) {
        Long ID = 0L;
        if (L.size() > 0) {
            ID = this.obterMaiorIDFuncionario(L) + 1;
        }
        return ID;
    }


    private Long obterMaiorIDLoc(List<Locacao> L) {
        Long ID = Long.MIN_VALUE;
        for (Locacao i: L) {
            if (i.getID() > ID) {
                ID = i.getID();
            }
        }
        return ID;
    }

    private Long obterMaiorIDMidia(List<Midia> L) {
        Long ID = Long.MIN_VALUE;
        for (Midia i: L) {
            if (i.getID() > ID) {
                ID = i.getID();
            }
        }
        return ID;
    }

    private Long obterMaiorIDCliente(List<Cliente> L) {
        Long ID = Long.MIN_VALUE;
        for (Cliente i: L) {
            if (i.getID() > ID) {
                ID = i.getID();
            }
        }
        return ID;
    }

    private Long obterMaiorIDFuncionario(List<Funcionario> L) {
        Long ID = Long.MIN_VALUE;
        for (Funcionario i: L) {
            if (i.getID() > ID) {
                ID = i.getID();
            }
        }
        return ID;
    }
}
