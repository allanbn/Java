package br.edu.ifpb.cg.Armazenamentos;

import br.edu.ifpb.cg.domain.Locadora;
import br.edu.ifpb.cg.geradoresID.geradorID;

public interface Armazenamento {

    void armazenar(Locadora L);

    Locadora recuperar(geradorID G);

}
