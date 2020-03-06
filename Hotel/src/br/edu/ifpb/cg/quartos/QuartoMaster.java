package br.edu.ifpb.cg.quartos;

public class QuartoMaster extends Quartos {

    private boolean temHidro;
    private boolean temVista;

    public QuartoMaster(Long ID, Integer numero, Integer andar, Integer qntdMaximaPessoas,
                        boolean temHidro, boolean temVista) {
        super(ID, numero, andar, qntdMaximaPessoas);
        this.temHidro = temHidro;
        this.temVista = temVista;
    }
}
