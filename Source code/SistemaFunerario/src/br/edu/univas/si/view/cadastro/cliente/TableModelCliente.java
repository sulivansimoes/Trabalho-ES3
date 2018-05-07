package br.edu.univas.si.view.cadastro.cliente;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.edu.univas.si.model.to.ClienteTO;

public class TableModelCliente extends AbstractTableModel{

	private static final long serialVersionUID = -346842540800318040L;
	
	private ArrayList<ClienteTO> listaCliente;
	private String[] colunas = new String[]{"Razão Social","Nome Fantasia","Tipo","CPF / CNPJ","Endereço"};
	
	//Indice das colunas
	private final int RAZAO_SOCIAL 	= 0;
	private final int NOME_FANTASIA = 1;
	private final int TIPO 		= 2;
	private final int CPF_CNPJ 	= 3;
	private final int ENDERECO	= 4;
	
	public TableModelCliente(){
		listaCliente = new ArrayList<ClienteTO>();
	}	

	public TableModelCliente(ArrayList<ClienteTO> listaCliente){
		this.listaCliente = new ArrayList<ClienteTO>(listaCliente);
	}
	
	@Override
	public int getRowCount() {
		return listaCliente.size();
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
			case RAZAO_SOCIAL : case NOME_FANTASIA : case TIPO : case CPF_CNPJ : case ENDERECO :
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
		
		ClienteTO cliente = listaCliente.get(rowIndex);
		
		switch(columnIndex){
			case RAZAO_SOCIAL :
				return cliente.getRazao_social();
			case  NOME_FANTASIA:
				return cliente.getNome_fantasia();
			case  TIPO:
				return cliente.getTipo();
			case CPF_CNPJ :
				return cliente.getCpf_cnpj();
			case  ENDERECO:
				return cliente.getEndereco();
			default :
				throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}
	
	//Adiciona o unidade de medida especificado no model
	public void addProduto(ClienteTO cliente){
		listaCliente.add(cliente);
		
		//Pega a quantidade de registros e subtrai 1 para achar o último índice.
	    int ultimoIndice = getRowCount() - 1;
		 
	    // Notifica a mudança.
	    fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
}