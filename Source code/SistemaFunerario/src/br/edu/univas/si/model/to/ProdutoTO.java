package br.edu.univas.si.model.to;

public class ProdutoTO {

	private String codigo;
	private String descricao;
	private String tipo;
	private String unidadeMedida;
	private double quantidade;
	private double valor;
	
	public ProdutoTO(){
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getUnidadeMedida() {
		return unidadeMedida;
	}
	
	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	
	public double getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
}
