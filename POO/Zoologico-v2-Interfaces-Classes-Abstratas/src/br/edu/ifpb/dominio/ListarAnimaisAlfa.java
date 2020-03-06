package br.edu.ifpb.dominio;

import java.util.Comparator;

public class ListarAnimaisAlfa implements Comparator<Animal> {


    @Override
    public int compare(Animal a, Animal b) {
        return a.getNome().compareTo(b.getNome());
    }

}
