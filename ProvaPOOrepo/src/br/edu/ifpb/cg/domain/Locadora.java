package br.edu.ifpb.cg.domain;

import br.edu.ifpb.cg.Midias.Midia;
import br.edu.ifpb.cg.Pessoas.Cliente;
import br.edu.ifpb.cg.Pessoas.Funcionario;
import br.edu.ifpb.cg.geradoresID.geradorID;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Locadora implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Midia> midias;
    private List<Cliente> clientes;
    private List<Funcionario> funcionarios;
    private List<Locacao> locacoes;
    private geradorID gerador;

    public void setGerador(geradorID gerador) {
        this.gerador = gerador;
    }

    public Locadora(geradorID gerador) {
        this.gerador = gerador;
        this.midias = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.locacoes = new ArrayList<>();
    }

    public List<Midia> getMidias() {
        return midias;
    }

    public void setMidias(List<Midia> midias) {
        this.midias = midias;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(List<Locacao> locacoes) {
        this.locacoes = locacoes;
    }

    public void addMidia(Midia M) {
        M.setID(gerador.obterIDMidia(this.midias));
        this.midias.add(M);
    }

    public void addClientes(Cliente C) {
        C.setID(gerador.obterIDCliente(this.clientes));
        this.clientes.add(C);
    }

    public void addFuncionarios(Funcionario F) {
        F.setID(gerador.obterIDFuncionario(this.funcionarios));
        this.funcionarios.add(F);
    }

    public void addLocacoes(Locacao L) {
        L.setID(gerador.obterIDLocacao(this.locacoes));
        this.locacoes.add(L);
    }

    public void removeCliente(Cliente C) {
        this.clientes.remove(C);
    }

    public void removeFuncionario(Funcionario F) {
        this.funcionarios.remove(F);
    }

    public void removeMidia(Midia M) {
        this.midias.remove(M);
    }

    public void removeLocacao(Locacao L) {
        this.locacoes.remove(L);
    }

}
