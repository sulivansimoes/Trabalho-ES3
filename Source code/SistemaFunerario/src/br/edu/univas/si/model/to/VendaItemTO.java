package br.edu.univas.si.model.to;

public class VendaItemTO {

	private String codigoVenda;
	private String serieVenda;
	private int item;
	private String produto;
	private double quantidade;
	private double valorProduto;
	private double valorItem;

	public VendaItemTO(){
		
	}	
	
	public String getCodigoVenda() {
		return codigoVenda;
	}
	
	public void setCodigoVenda(String codigoVenda) {
		this.codigoVenda = codigoVenda;
	}
	
	public String getSerieVenda() {
		return serieVenda;
	}
	
	public void setSerieVenda(String serieVenda) {
		this.serieVenda = serieVenda;
	}
	
	public int getItem() {
		return item;
	}
	
	public void setItem(int item) {
		this.item = item;
	}
	
	public String getProduto() {
		return produto;
	}
	
	public void setProduto(String produto) {
		this.produto = produto;
	}
	
	public double getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	
	public double getValorProduto() {
		return valorProduto;
	}
	
	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}
	
	public double getValorItem() {
		return valorItem;
	}
	
	public void setValorItem(double valorItem) {
		this.valorItem = valorItem;
	}
}
