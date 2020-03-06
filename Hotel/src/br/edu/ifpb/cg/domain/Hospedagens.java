package br.edu.ifpb.cg.domain;

import br.edu.ifpb.cg.quartos.Quartos;

public class Hospedagens {

    private Long ID;
    private Quartos quarto;
    private Funcionarios funcionario;
    private Hospedes hospede;
    private Double valor;
    private Periodo periodo;

    public Hospedagens(Long ID, Quartos quarto, Funcionarios funcionario,
                       Hospedes hospede, Double valor, Periodo periodo) {
        this.ID = ID;
        this.quarto = quarto;
        this.funcionario = funcionario;
        this.hospede = hospede;
        this.valor = valor;
        this.periodo = periodo;
    }
}
