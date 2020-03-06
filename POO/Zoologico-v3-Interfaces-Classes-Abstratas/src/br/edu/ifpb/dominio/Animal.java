package br.edu.ifpb.dominio;

import java.io.Serializable;
import java.util.Objects;

public abstract class Animal implements TemRepresentacaoTextual, Serializable, Comparable<Animal> {

	private static final long serialVersionUID = 1L;

	protected static final String LS = System.lineSeparator();
	
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

	public abstract void validarValores();

	@Override
	public int compareTo(Animal outro) {
		String nome1 = this.nome;
		String nome2 = outro.nome;
		
		int compareTo = nome1.compareTo(nome2);
		
		return -1 * compareTo;
	}
}
