package br.edu.ifpb.cg.Midias;

import java.io.Serializable;

public class CD extends Midia implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer qntdFaixas;

    public CD(String titulo, Integer duracao, Integer anoLancamento, Integer qntdFaixas) {
        super(titulo, duracao, anoLancamento);
        this.qntdFaixas = qntdFaixas;
    }

    public Integer getQntdFaixas() {
        return qntdFaixas;
    }

    public void setQntdFaixas(Integer qntdFaixas) {
        this.qntdFaixas = qntdFaixas;
    }

    @Override
    public String toString() {
        String s = "Tipo de mídia: CD" + System.lineSeparator();
        s = this.obterTexto();
        s += "Quantidade de faixas: " + this.qntdFaixas + System.lineSeparator();
        return s;
    }
}
