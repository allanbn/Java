package br.edu.ifpb.dominio;

import java.io.Serializable;
import java.util.Objects;

public class Animal implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	public Animal(String nome) {
		super();
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Animal [id=" + id + ", nome=" + nome + "]";
	}

	public String getCuriosidade() {
		return "Os animais s�o seres vivos! ¯\\_(ツ)_/¯";
	}

	public void validarValores() {
		// Fazer nada por padrão
	}

}
