package br.edu.ifpb.cg.domain;

import java.io.Serializable;
import java.util.Date;

public class Periodo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date dataInicial;
    private Date dataFinal;

    public Periodo(Date dataInicial, Date dataFinal) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataIncial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
}
