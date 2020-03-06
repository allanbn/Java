package br.edu.ifpb.util;

import java.util.Comparator;

import br.edu.ifpb.dominio.Animal;

public class ComparatorAnimalNome implements Comparator<Animal> {

	@Override
	public int compare(Animal o1, Animal o2) {
		String nomeAnimal1 = o1.getNome();
		String nomeAnimal2 = o2.getNome();
		return nomeAnimal1.compareTo(nomeAnimal2);
	}

}
