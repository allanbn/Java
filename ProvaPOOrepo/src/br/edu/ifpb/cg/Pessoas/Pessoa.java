package br.edu.ifpb.cg.Pessoas;

import java.io.Serializable;

public abstract class Pessoa implements Pessoas, Serializable {

    private static final long serialVersionUID = 1L;

    private Long ID;
    private String nome;
    private Long CPF;

    public Pessoa(String nome, Long CPF) {
        this.nome = nome;
        this.CPF = CPF;
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCPF() {
        return CPF;
    }

    public void setCPF(Long CPF) {
        this.CPF = CPF;
    }

    @Override
    public String obterTexto() {
       String s = "";
       s += "ID: " + this.ID + System.lineSeparator();
       s += "Nome: " + this.nome + System.lineSeparator();
       s += "CPF: " + this.CPF + System.lineSeparator();
       return s;
    }
}
