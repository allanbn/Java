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

	@Override
	public void validarValores() {
		// Nada a validar
	}
	
	@Override
	public String obterRepresentacaoTextual() {
		String texto = "";
		texto += "Tipo: Leão" + LS;
		texto += "Id: " + getId() + LS;
		texto += "Nome: " + getNome() + LS;
		texto += "Tamanho da Juba (em cm): " + getTamanhoDaJuba() + LS;
		return texto;
	}

}
