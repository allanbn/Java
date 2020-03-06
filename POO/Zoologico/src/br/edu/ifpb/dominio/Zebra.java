package br.edu.ifpb.dominio;

import br.edu.ifpb.ZooRuntimeException;

public class Zebra extends Animal {

	private static final long serialVersionUID = 1L;
	
	private Integer quantidadeListras;
	
	public Zebra(String nome, Integer quantidadeListras) {
		super(nome);
		this.quantidadeListras = quantidadeListras;
	}

	public Integer getQuantidadeListras() {
		return quantidadeListras;
	}

	public void setQuantidadeListras(Integer quantidadeListras) {
		this.quantidadeListras = quantidadeListras;
	}

	@Override
	public String toString() {
		return "Zebra [quantidadeListras=" + quantidadeListras + ", toString()=" + super.toString() + "]";
	}

	public void validarValores() {
		if (quantidadeListras != null && quantidadeListras == 13) {
			throw new ZooRuntimeException("O Zoológico não admite Zebras com 13 listras.");
		}
	}

}
