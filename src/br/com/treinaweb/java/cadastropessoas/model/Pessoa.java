package br.com.treinaweb.java.cadastropessoas.model;

public class Pessoa {

	private int id;
	private String nome;
	private int idade;
	
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public Pessoa(int id, String nome, int idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override //boa pratica 
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", idade=" + idade + "]";
	}

}
