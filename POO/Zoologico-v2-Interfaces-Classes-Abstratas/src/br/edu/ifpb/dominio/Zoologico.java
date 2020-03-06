package br.edu.ifpb.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import br.edu.ifpb.exceptions.AnimalNaoEncontradoException;
import br.edu.ifpb.exceptions.ZooException;
import br.edu.ifpb.geradorId.GeradorId;

public class Zoologico implements TemRepresentacaoTextual, Serializable {

	private static final long serialVersionUID = 1L;

	private Collection<Animal> animais;

	private GeradorId geradorId;

	public Zoologico(GeradorId geradorId) {
		this.animais = new ArrayList<Animal>();
		this.geradorId = geradorId;
	}

	public Collection<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(Collection<Animal> animais) {
		this.animais = animais;
	}

	public GeradorId getGeradorId() {
		return geradorId;
	}

	public void setGeradorId(GeradorId geradorId) {
		this.geradorId = geradorId;
	}

	public void adicionarAnimal(Animal animal) throws ZooException {
		animal.validarValores();
		Long id = this.geradorId.obterProximoId(this);
		animal.setId(id);
		this.animais.add(animal);
	}

	public void removerAnimal(Long id) throws ZooException {
		Animal animalASerRemovido = null;
		for (Animal animal : animais) {
			if (animal.getId().equals(id)) {
				animalASerRemovido = animal;
				break;
			}
		}
		if (animalASerRemovido == null) {
			throw new AnimalNaoEncontradoException(id);
		}
		this.animais.remove(animalASerRemovido);
	}


	@Override
	public String obterRepresentacaoTextual() {
		return String.format("Zoológico POO, contendo ao todo %d animais. Venha nos visitar!", this.animais.size());
	}

}
