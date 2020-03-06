package br.edu.ifpb.cg.quartos;

public class QuartoSimples extends Quartos {

    private boolean ehDuplo;

    private boolean temAr;

    public QuartoSimples(Long ID, Integer numero, Integer andar,
                         Integer qntdMaximaPessoas, boolean ehDuplo, boolean temAr) {
        super(ID, numero, andar, qntdMaximaPessoas);
        this.ehDuplo = ehDuplo;
        this.temAr = temAr;
    }

    public boolean isEhDuplo() {
        return ehDuplo;
    }

    public void setEhDuplo(boolean ehDuplo) {
        this.ehDuplo = ehDuplo;
    }

    public boolean isTemAr() {
        return temAr;
    }

    public void setTemAr(boolean temAr) {
        this.temAr = temAr;
    }
}
