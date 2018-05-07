package br.edu.univas.si.view.cadastro.produtoservico;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.edu.univas.si.model.to.ProdutoTO;

public class TableModelProduto extends AbstractTableModel{

	private static final long serialVersionUID = -6667631085819977589L;
	
	private ArrayList<ProdutoTO> listaProduto;
	private String[] colunas = new String[]{"Código","Descrição","Tipo","Unidade Medida","Quantidade","Valor"};
	
	//Indice das colunas
	private final int CODIGO 	= 0;
	private final int DESCRICAO = 1;
	private final int TIPO 		= 2;
	private final int UNIDADE_MEDIDA = 3;
	private final int QUANTIDADE = 4;
	private final int VALOR = 5;
	
	public TableModelProduto(){
		listaProduto = new ArrayList<ProdutoTO>();
	}	

	public TableModelProduto(ArrayList<ProdutoTO> listaProduto){
		this.listaProduto = new ArrayList<ProdutoTO>(listaProduto);
	}
	
	@Override
	public int getRowCount() {
		return listaProduto.size();
	}
	
	@Override
	public int getColumnCount() {	
		return colunas.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex){
			case CODIGO : case DESCRICAO : case TIPO : case UNIDADE_MEDIDA :
				return String.class;
			case QUANTIDADE : case VALOR :
				return Double.class;
			default :
				throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false; // false = desabilita edicao da celula - true = habilita edição da célula.
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ProdutoTO produto = listaProduto.get(rowIndex);
		
		switch(columnIndex){
			case CODIGO :
				return produto.getCodigo();
			case DESCRICAO :
				return produto.getDescricao();
			case TIPO :
				return produto.getTipo();
			case UNIDADE_MEDIDA :
				return produto.getUnidadeMedida();
			case QUANTIDADE :
				return produto.getQuantidade();
			case VALOR :
				return produto.getValor();
			default :
				throw new IndexOutOfBoundsException("columnIndex out of bounds");
		
		}
	}
	
	//Adiciona o unidade de medida especificado no model
	public void addProduto(ProdutoTO produto){
		listaProduto.add(produto);
		
		//Pega a quantidade de registros e subtrai 1 para achar o último índice.
	    int ultimoIndice = getRowCount() - 1;
		 
	    // Notifica a mudança.
	    fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
}
