package br.edu.ifpb.geradorId;

import java.io.Serializable;
import java.util.Collection;

import br.edu.ifpb.dominio.Animal;
import br.edu.ifpb.dominio.Zoologico;

public class GeradorIdSequencial implements GeradorId, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Long obterProximoId(Zoologico zoo) {
		Long maiorId = getMaiorId(zoo.getAnimais());
		Long proximoId = maiorId + 1;
		return proximoId;
	}

	private Long getMaiorId(Collection<Animal> animais) {
		Long maiorId = 1L;
		
		for (Animal animal : animais) {
			maiorId = Math.max(maiorId, animal.getId());
		}
		
		return maiorId;
	}

}
