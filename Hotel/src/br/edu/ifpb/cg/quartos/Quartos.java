package br.edu.ifpb.cg.quartos;

public abstract class Quartos {

    private Long ID;
    private Integer numero;
    private Integer andar;
    private Integer qntdMaximaPessoas;

    public Quartos(Integer numero, Integer andar, Integer qntdMaximaPessoas) {
//        this.ID = ID;
        this.numero = numero;
        this.andar = andar;
        this.qntdMaximaPessoas = qntdMaximaPessoas;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
}
