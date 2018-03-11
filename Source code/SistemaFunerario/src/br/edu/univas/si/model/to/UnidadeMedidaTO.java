package br.edu.univas.si.model.to;

public class UnidadeMedidaTO {
	
	private String codigo;
	private String descricao;
	
	public UnidadeMedidaTO(){
	}
	
	public String getCodigo(){
		return codigo;
	}
	
	public void setCodigo(String codigo){
		this.codigo = codigo;
	}
	
	public String getDescricao(){
		return descricao;
	}
	
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
}
