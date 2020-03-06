package br.edu.ifpb.cg.armazenamento;

import br.edu.ifpb.cg.GeradorID.interGeradorID;
import br.edu.ifpb.cg.domain.Hotel;

public interface Armazenamento {


    Hotel recuperar(interGeradorID geradorID);

    void armazenar(Hotel H);


}
