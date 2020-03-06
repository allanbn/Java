package br.edu.ifpb.cg.q3.Ordenamento;

import br.edu.ifpb.cg.q3.dominio.minhaData;

import java.util.Comparator;

public class ComparatorDataAnt implements Comparator<minhaData> {

	@Override
	public int compare(minhaData o1, minhaData o2) {

		return -1 * o1.compareTo(o2);
	}
}
