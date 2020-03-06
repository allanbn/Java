package br.edu.ifpb.geradorId;

import br.edu.ifpb.dominio.Animal;
import br.edu.ifpb.dominio.Zoologico;

import java.io.Serializable;
import java.util.Collection;

public class GeradorIdPar implements GeradorId, Serializable {

    private static final long serialVersionUID = 1L;

    public Long obterProximoId(Zoologico zoo) {

        Long maiorId = this.getMaiorId(zoo.getAnimais());
        Long proximoId;

        if (maiorId == 0L) {
            proximoId = 0L;
        }
        else {
            if (maiorId % 2 != 0) {
                proximoId = maiorId + 1L;
            }
            else {
                proximoId = maiorId + 2L;
            }
        }
        return proximoId;
    }

    private Long getMaiorId(Collection<Animal> animais) {

        Long maiorId = -1L;

        for (Animal animal : animais) {
            maiorId = Math.max(maiorId, animal.getId());
        }

        return maiorId;
    }
}
