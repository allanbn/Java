package br.edu.ifpb.dominio;

import java.io.Serializable;
import java.util.ArrayList;

import br.edu.ifpb.AnimalNaoEncontradoException;
import br.edu.ifpb.GeradorIdNanotime;
import br.edu.ifpb.ZooException;

public class Zoologico implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<Animal> animais;

    private GeradorIdNanotime geradorId;

    public Zoologico(GeradorIdNanotime geradorId) {
        this.animais = new ArrayList<Animal>();
        this.geradorId = geradorId;
    }

    public ArrayList<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(ArrayList<Animal> animais) {
        this.animais = animais;
    }

    public GeradorIdNanotime getGeradorId() {
        return geradorId;
    }

    public void setGeradorId(GeradorIdNanotime geradorId) {
        this.geradorId = geradorId;
    }

    public void adicionarAnimal(Animal animal) throws ZooException {
        animal.validarValores();
        Long id = this.geradorId.recuperarProximoId(this);
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

}
