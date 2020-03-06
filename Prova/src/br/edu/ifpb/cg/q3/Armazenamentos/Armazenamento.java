package br.edu.ifpb.cg.q3.Armazenamentos;

import br.edu.ifpb.cg.q3.Geradores.GeradorID;
import br.edu.ifpb.cg.q3.dominio.Estoque;

public interface Armazenamento {

    Estoque recuperar(GeradorID geradorId);

    void armazenar(Estoque e);


}
