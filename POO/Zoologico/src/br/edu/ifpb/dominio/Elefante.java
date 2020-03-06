package br.edu.ifpb.dominio;

public class Elefante extends Animal {

    private static final long serialVersionUID = 1L;

    private Integer peso;

    public Elefante(String nome, Integer peso) {
        super(nome);
        this.peso = peso;
    }

    public Integer getPeso(){
        return this.peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Cobra [peso=" + this.peso + ", toString()=" + super.toString() + "]";
    }

}
