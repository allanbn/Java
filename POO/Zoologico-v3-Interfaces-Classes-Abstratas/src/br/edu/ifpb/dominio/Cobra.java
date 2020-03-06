package br.edu.ifpb.dominio;

public class Cobra extends Animal {

	private static final long serialVersionUID = 1L;

	private Boolean ehVenenosa;

	public Cobra(String nome, Boolean ehVenenosa) {
		super(nome);
		this.ehVenenosa = ehVenenosa;
	}

	public Boolean getEhVenenosa() {
		return ehVenenosa;
	}

	public void setEhVenenosa(Boolean ehVenenosa) {
		this.ehVenenosa = ehVenenosa;
	}

	@Override
	public String toString() {
		return "Cobra [ehVenenosa=" + ehVenenosa + ", toString()=" + super.toString() + "]";
	}

	@Override
	public void validarValores() {
		// Nada a validar
	}
	
	@Override
	public String obterRepresentacaoTextual() {
		String texto = "";
		texto += "Tipo: Cobra" + LS;
		texto += "Id: " + getId() + LS;
		texto += "Nome: " + getNome() + LS;
		texto += "É venenosa? " + getEhVenenosa() + LS;
		return texto;
	}

}
