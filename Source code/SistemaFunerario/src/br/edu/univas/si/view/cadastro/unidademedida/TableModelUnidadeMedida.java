package br.edu.univas.si.view.cadastro.unidademedida;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.edu.univas.si.model.to.UnidadeMedidaTO;

public class TableModelUnidadeMedida extends AbstractTableModel{
	
	private static final long serialVersionUID = 6965930102710951555L;
	
	private ArrayList<UnidadeMedidaTO> listaUnidadeMedida;
	private String[] colunas = new String[]{"Código","Descrição"};
	
	//Indice das colunas
	private final int CODIGO 	= 0;
	private final int DESCRICAO = 1;
	
	public TableModelUnidadeMedida(){
		listaUnidadeMedida = new ArrayList<UnidadeMedidaTO>();
	}	

	public TableModelUnidadeMedida(ArrayList<UnidadeMedidaTO> listaUnidadeMedida){
		this.listaUnidadeMedida = new ArrayList<UnidadeMedidaTO>(listaUnidadeMedida);
	}
	
	@Override
	public int getRowCount() {
		return listaUnidadeMedida.size();
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
			case CODIGO : case DESCRICAO :
				return String.class;
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
		UnidadeMedidaTO unidadeMedida = listaUnidadeMedida.get(rowIndex);
		
		switch(columnIndex){
			case CODIGO :
				return unidadeMedida.getCodigo();
			case DESCRICAO :
				return unidadeMedida.getDescricao();
			default :
				throw new IndexOutOfBoundsException("columnIndex out of bounds");
		
		}
	}
	
	//Adiciona o unidade de medida especificado no model
	public void addProduto(UnidadeMedidaTO unidadeMedida){
		listaUnidadeMedida.add(unidadeMedida);
		
		//Pega a quantidade de registros e subtrai 1 para achar o último índice.
	    int ultimoIndice = getRowCount() - 1;
		 
	    // Notifica a mudança.
	    fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
}
