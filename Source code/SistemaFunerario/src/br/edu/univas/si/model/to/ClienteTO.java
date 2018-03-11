package br.edu.univas.si.model.to;

public class ClienteTO {

	private char tipo;
	private String razao_social;
	private String nome_fantasia;
	private String cpf_cnpj;
	private String endereco;
	
	public ClienteTO(){	
	}
		
	public char getTipo() {
		return tipo;
	}
	
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
	public String getRazao_social() {
		return razao_social;
	}
	
	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}
	
	public String getNome_fantasia() {
		return nome_fantasia;
	}
	
	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}
	
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}
	
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
