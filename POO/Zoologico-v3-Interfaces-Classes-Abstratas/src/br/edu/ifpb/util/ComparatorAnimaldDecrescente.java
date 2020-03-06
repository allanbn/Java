package br.edu.ifpb.util;

import java.util.Comparator;

import br.edu.ifpb.dominio.Animal;

public class ComparatorAnimaldDecrescente implements Comparator<Animal> {

	@Override
	public int compare(Animal o1, Animal o2) {
		Long id1 = o1.getId();
		Long id2 = o2.getId();
		
		int compareTo = id1.compareTo(id2);
		
		return -1 * compareTo;
	}

}
