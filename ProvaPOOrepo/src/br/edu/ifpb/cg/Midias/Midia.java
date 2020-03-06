package br.edu.ifpb.cg.Midias;

import java.io.Serializable;

public abstract class Midia implements Midias, Serializable {

    private static final long serialVersionUID = 1L;

    private Long ID;
    private String titulo;
    private Integer duracao;
    private Integer anoLancamento;

    public Midia(String titulo, Integer duracao, Integer anoLancamento) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public String obterTexto() {
        String s = "";
        s += "ID: " + this.ID + System.lineSeparator();
        s += "Titulo: " + this.titulo + System.lineSeparator();
        s += "Duracao: " + this.duracao + System.lineSeparator();
        s += "Lançado no ano: " + this.anoLancamento + System.lineSeparator();
        return s;
    }
}
