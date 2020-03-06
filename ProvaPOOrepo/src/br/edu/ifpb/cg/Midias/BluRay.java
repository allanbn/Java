package br.edu.ifpb.cg.Midias;

import java.io.Serializable;

public class BluRay extends MidiaFilme implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean eh3D;

    public BluRay(String titulo, Integer duracao, Integer anoLancamento, boolean temExtra, boolean eh3D) {
        super(titulo, duracao, anoLancamento, temExtra);
        this.eh3D = eh3D;
    }

    public boolean isEh3D() {
        return eh3D;
    }

    public void setEh3D(boolean eh3D) {
        this.eh3D = eh3D;
    }

    @Override
    public String toString() {
        String s = "Tipo de mídia: Bluray" + System.lineSeparator();
        s += this.textoMidiaFilme();
        s += "É 3D: " + this.eh3D + System.lineSeparator();
        return s;
    }

}
