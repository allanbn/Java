package br.edu.ifpb.cg.domain;

import br.edu.ifpb.cg.quartos.Quartos;
import br.edu.ifpb.cg.GeradorID.interGeradorID;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private List<Funcionarios> funcionarios;
    private List<Hospedes> hospedes;
    private List<Hospedagens> hospedagens;
    private List<Quartos> quartos;
    private interGeradorID geradorId;

    public Hotel(interGeradorID geradorId) {
        this.geradorId = geradorId;
    }

    public List<Funcionarios> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionarios> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Quartos> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<Quartos> quartos) {
        this.quartos = quartos;
    }

    public List<Hospedes> getHospedes() {
        return hospedes;
    }

    public void setHospedes(List<Hospedes> hospedes) {
        this.hospedes = hospedes;
    }

    public List<Hospedagens> getHospedagens() {
        return hospedagens;
    }

    public void setHospedagens(List<Hospedagens> hospedagens) {
        this.hospedagens = hospedagens;
    }

    public void addFuncionario(Funcionarios F) {
        this.funcionarios.add(F);
    }

    public void addHospedes(Hospedes H) {
        this.hospedes.add(H);
    }

    public void addHospedagens(Hospedagens H) {
        this.hospedagens.add(H);
    }

    public void addQuarto(Quartos Q) {
        Q.setID(geradorId.obterProximoID());
        this.quartos.add(Q);
    }

}
