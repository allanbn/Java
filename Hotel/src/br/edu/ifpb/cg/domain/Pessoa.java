package br.edu.ifpb.cg.domain;

public abstract class Pessoa {

    private Long ID;
    private String nome;
    private Long cpf;

    public Pessoa(String nome, Long cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
}
