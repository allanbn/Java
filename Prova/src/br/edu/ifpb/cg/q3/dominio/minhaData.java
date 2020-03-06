package br.edu.ifpb.cg.q3.dominio;

import java.io.Serializable;

public class minhaData implements Serializable, Comparable<minhaData> {

    private static final long serialVersionUID = 1L;

    private Integer dia;
    private Integer mes;
    private Integer ano;
//    private Date data;

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public minhaData(String data) {
        String[] s = data.split("/");
        if (this.validarData(s)) {
            this.dia = Integer.parseInt(s[0]);
            this.mes = Integer.parseInt(s[1]);
            this.ano = Integer.parseInt(s[2]);
        }
    }


    private boolean validarData(String[] d) {
        if (0 < Integer.parseInt(d[0]) && Integer.parseInt(d[0]) < 32) {
            if (0 < Integer.parseInt(d[1]) && Integer.parseInt(d[1]) < 13) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        String s = "";
        s += this.dia;
        s += "/";
        s += this.mes;
        s += "/";
        s += this.ano;
        return s;
    }

//    @Override
//    public int compareTo(minhaData data) {
//
//        Integer ano = data.getAno();
//        Integer mes = data.getMes();
//        Integer dia = data.getDia();
//
//        if (this.ano > ano) {
//            return 1;
//        }
//
//        if (this.mes > mes) {
//            return 1;
//        }
//        else if (this.mes < mes) {
//            return -1;
//        }
//        if (this.dia > dia) {
//            return 1;
//        }
//        else if (this.dia < dia) {
//            return -1;
//        }
//        return 0;
//    }

    @Override
    public int compareTo(minhaData d) {

        if (!this.ano.equals(d.ano)) {
            return this.ano - d.ano;
        }
        if (!this.mes.equals(d.mes)) {
            return this.mes - d.mes;
        }
        return this.dia - d.dia;
    }
}
