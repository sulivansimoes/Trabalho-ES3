package br.edu.univas.si.model.to;

import java.util.Date;

public class VendaCabecalhoTO {

	private String codigo;
	private String serie;
	private Date dtEmissao;
	private String cliente;
	private double valorVenda;
	
	public VendaCabecalhoTO(){
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getSerie() {
		return serie;
	}
	
	public void setSerie(String serie) {
		this.serie = serie;
	}
	
	public Date getDtEmissao() {
		return dtEmissao;
	}
	
	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public double getValorVenda() {
		return valorVenda;
	}
	
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
}
