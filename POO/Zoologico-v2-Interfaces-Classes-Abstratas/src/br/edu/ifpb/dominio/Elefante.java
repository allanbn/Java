package br.edu.ifpb.dominio;

import br.edu.ifpb.exceptions.ZooRuntimeException;

public class Elefante extends Animal {

    private Integer peso;


    public Elefante(String nome, Integer peso) {
        super(nome);
        this.peso = peso;
    }

    public Integer getPeso() {
        return this.peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String toString() {
        return "Elefante [peso=" + this.peso + ", toString()=" + super.toString() + "]";
    }

    @Override
    public void validarValores() {
        if (this.peso != null && this.peso < 2) {
            throw new ZooRuntimeException("O Zoológico não admite Elefantes com peso abaixo de duas toneladas.");
        }
    }

    @Override
    public String obterRepresentacaoTextual() {
        String texto = "";
        texto += "Tipo: Elefante" + LS;
        texto += "Id: " + getId() + LS;
        texto += "Nome: " + getNome() + LS;
        texto += "Peso: " + getPeso() + LS;
        return texto;
    }
}
