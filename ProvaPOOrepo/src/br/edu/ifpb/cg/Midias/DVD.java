package br.edu.ifpb.cg.Midias;

import java.io.Serializable;

public class DVD extends MidiaFilme implements Serializable {

    private static final long serialVersionUID = 1L;

    public DVD(String titulo, Integer duracao, Integer anoLancamento, boolean temExtra) {
        super(titulo, duracao, anoLancamento, temExtra);
    }

    @Override
    public String toString() {
        String s = "Tipo de mídia: DVD" + System.lineSeparator();
        s += this.textoMidiaFilme();
        return s;
    }

}
