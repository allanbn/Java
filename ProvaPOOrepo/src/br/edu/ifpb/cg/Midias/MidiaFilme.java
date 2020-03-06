package br.edu.ifpb.cg.Midias;

import java.io.Serializable;

public abstract class MidiaFilme extends Midia implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean temExtra;

    public MidiaFilme(String titulo, Integer duracao, Integer anoLancamento, boolean temExtra) {
        super(titulo, duracao, anoLancamento);
        this.temExtra = temExtra;
    }

    public boolean isTemExtra() {
        return temExtra;
    }

    public void setTemExtra(boolean temExtra) {
        this.temExtra = temExtra;
    }

    public String textoMidiaFilme() {
        String s = this.obterTexto();
        s += "Tem extra: " + this.temExtra + System.lineSeparator();
        return s;
    }
}
