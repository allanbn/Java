package br.edu.ifpb.dominio;

public class Leao extends Animal {

	private static final long serialVersionUID = 1L;

	private Integer tamanhoDaJuba;

	public Leao(String nome, Integer tamanhoDaJuba) {
		super(nome);
		this.tamanhoDaJuba = tamanhoDaJuba;
	}

	public Integer getTamanhoDaJuba() {
		return tamanhoDaJuba;
	}

	public void setTamanhoDaJuba(Integer tamanhoDaJuba) {
		this.tamanhoDaJuba = tamanhoDaJuba;
	}
	
	@Override
	public String toString() {
		return "Leao [tamanhoDaJuba=" + tamanhoDaJuba + ", toString()=" + super.toString() + "]";
	}

}
