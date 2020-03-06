package br.edu.ifpb.cg.q3.dominio;

public class Detergente extends Produto {

    private static final long serialVersionUID = 1L;

    private boolean neutro;

    public Detergente(String s, Integer q, String d, String b) {
        super(s, q, d);
        if (b.equals("Sim") || b.equals("sim")) {
            this.neutro = true;
        } else this.neutro = false;
    }

    public String toString() {
        String s = "";
        s += super.produtoTexto();
        if (this.neutro) {
            s += "Neutro: Sim" + System.lineSeparator();
        }
        else {
            s += "Neutro: Não" + System.lineSeparator();
        }
        return s;
    }
}
