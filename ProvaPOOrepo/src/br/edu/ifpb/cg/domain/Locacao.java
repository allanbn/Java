package br.edu.ifpb.cg.domain;


import br.edu.ifpb.cg.Midias.Midia;
import br.edu.ifpb.cg.Pessoas.Cliente;
import br.edu.ifpb.cg.Pessoas.Funcionario;

import java.io.Serializable;

public class Locacao implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long ID;
    private Cliente cliente;
    private Funcionario funcionario;
    private Midia midia;
    private Double valorAluguel;
    private Double valorMulta;
    private Periodo periodo;
    private Boolean pago = null;
    private Boolean gostou = null;

    public Locacao(Cliente cliente, Funcionario funcionario, Midia midia, Double valorAluguel, Periodo periodo) {
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.midia = midia;
        this.valorAluguel = valorAluguel;
        this.periodo = periodo;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Midia getMidia() {
        return midia;
    }

    public void setMidia(Midia midia) {
        this.midia = midia;
    }

    public Double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(Double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(Double valorMulta) {
        this.valorMulta = valorMulta;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Boolean isPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public Boolean isGostou() {
        return gostou;
    }

    public void setGostou(Boolean gostou) {
        this.gostou = gostou;
    }

    public String toString() {
        String s = "";
        s+= "ID: " + this.ID + System.lineSeparator();
        s+= "Cliente: " + System.lineSeparator() + this.cliente.toString() + System.lineSeparator();
        s+= "Funcionario: " + System.lineSeparator() + this.funcionario.toString() + System.lineSeparator();
        s+= "Midia: " + this.midia.toString() + System.lineSeparator();
        s+= "Valor do alguel: " + this.valorAluguel + System.lineSeparator();
        s+= "Valor da multa: " + this.valorMulta + System.lineSeparator();
        s+= "Periodo: " + this.periodo + System.lineSeparator();
        s+= "Pago: " + this.pago + System.lineSeparator();
        s+= "Gostou: " + this.gostou + System.lineSeparator();
        return s;
    }
}
