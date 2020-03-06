package br.edu.ifpb.cg.Pessoas;

import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    private String endereco;

    public Cliente(String nome, Long CPF, String endereco) {
        super(nome, CPF);
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        String s = "";
        s += this.obterTexto();
        s += this.endereco + System.lineSeparator();
        return s;
    }
}
