package br.edu.ifpb.cg.Pessoas;

import java.io.Serializable;

public class Funcionario extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    private Double salario;

    public Funcionario(String nome, Long CPF, Double salario) {
        super(nome, CPF);
        this.salario = salario;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        String s = "";
        s += this.obterTexto();
        s += this.salario + System.lineSeparator();
        return s;
    }
}
