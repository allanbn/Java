package br.edu.ifpb.cg.q3.dominio;

public class Feijao extends Produto {

    private static final long serialVersionUID = 1L;

    private Integer kg;

    public Feijao(String s, Integer q, String d, Integer p) {
        super(s, q, d);
        this.kg = p;
    }

    @Override
    public String toString() {
        String s = "";
        s += super.produtoTexto();
        s += "Peso (kg): " + this.kg;
        return s;
    }
}
