package br.edu.univas.si.view.cadastro.produtoservico;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelProduto extends JPanel{

	private static final long serialVersionUID = -8772558152483188109L;
	
	private JLabel labelCodigo;
	private JLabel labelDescricao;
	private JLabel labelTipo;
	private JLabel labelUnidadeMedida;
	private JLabel labelQuantidade;
	private JLabel labelValor;
	
	private JFormattedTextField textFieldCodigo;
	private JFormattedTextField textFieldDecricao;
	private JFormattedTextField textFieldUnidadeMedida;
	private JFormattedTextField textFieldValor;
	private JFormattedTextField textFieldQuantidade;
	
	private JComboBox<String> comboBoxTipo;
	
	//Indice dos campos
	public static final int CODIGO = 1;
	public static final int DESCRICAO = 2;
	public static final int TIPO = 3;
	public static final int UNIDADE_MEDIDA = 4;
	public static final int QUANTIDADE = 5;
	public static final int VALOR = 6;
	
	
	public PanelProduto(){
		setLayout(new GridLayout(6, 6,3,10));
		setBorder(new EmptyBorder(50, 50, 50, 50));
		initialize();
	}
	
	public void initialize(){
		add(getLabelCodigo());
		add(getTextFieldCodigo());
		add(getLabelDescricao());
		add(getTextFieldDecricao());
		add(getLabelTipo());
		add(getComboBoxTipo());
		add(getLabelUnidadeMedida());
		add(getTextFieldUnidadeMedida());
		add(getLabelQuantidade());
		add(getTextFieldQuantidade());
		add(getLabelValor());
		add(getTextFieldValor());
	}

	private JLabel getLabelCodigo() {
		if(labelCodigo == null){
			labelCodigo = new JLabel("Código: *");
			labelCodigo.setFont(new Font("Century", Font.PLAIN, 14));
		}
		return labelCodigo;
	}

	private JLabel getLabelDescricao() {
		if(labelDescricao == null){
			labelDescricao = new JLabel("Descrição: *");
			labelDescricao.setFont(new Font("Century", Font.PLAIN, 14));
		}
		return labelDescricao;
	}

	private JLabel getLabelTipo() {
		if(labelTipo == null){
			labelTipo = new JLabel("Tipo: *");
			labelTipo.setFont(new Font("Century", Font.PLAIN, 14));
		}
		return labelTipo;
	}

	private JLabel getLabelUnidadeMedida() {
		if(labelUnidadeMedida == null){
			labelUnidadeMedida = new JLabel("Unidade medida: *");
			labelUnidadeMedida.setFont(new Font("Century", Font.PLAIN, 14));
		}
		return labelUnidadeMedida;
	}

	private JLabel getLabelQuantidade() {
		if(labelQuantidade == null){
			labelQuantidade = new  JLabel("Quantidade: *");
			labelQuantidade.setFont(new Font("Century", Font.PLAIN, 14));
		}
		return labelQuantidade;
	}

	private JLabel getLabelValor() {
		if(labelValor == null){
			labelValor = new JLabel("Valor: *");
			labelValor.setFont(new Font("Century", Font.PLAIN, 14));
		}
		return labelValor;
	}

	private JFormattedTextField getTextFieldCodigo() {
		if(textFieldCodigo == null){
			textFieldCodigo = new JFormattedTextField();
		}
		return textFieldCodigo;
	}

	private JFormattedTextField getTextFieldDecricao() {
		if(textFieldDecricao == null){
			textFieldDecricao = new JFormattedTextField();
		}
		return textFieldDecricao;
	}

	private JFormattedTextField getTextFieldUnidadeMedida() {
		if(textFieldUnidadeMedida == null){
			textFieldUnidadeMedida = new JFormattedTextField();
		}
		return textFieldUnidadeMedida;
	}

	private JFormattedTextField getTextFieldValor() {
		if(textFieldValor == null){
			textFieldValor = new JFormattedTextField();
		}
		return textFieldValor;
	}
	
	private JFormattedTextField getTextFieldQuantidade(){
		if(textFieldQuantidade == null){
			textFieldQuantidade = new JFormattedTextField();
		}
		return textFieldQuantidade;
	}

	private JComboBox<String> getComboBoxTipo() {
		if(comboBoxTipo == null){
			comboBoxTipo = new JComboBox<>(new String[]{"Serviço","Produto"});
			comboBoxTipo.setSelectedIndex(1);
		}
		return comboBoxTipo;
	}
	
	public ArrayList<JFormattedTextField> getAllCamposObrigatorios(){
		ArrayList<JFormattedTextField> campos = new ArrayList<>();
		
		campos.add(getTextFieldCodigo());
		campos.add(getTextFieldDecricao());
		campos.add(getTextFieldUnidadeMedida());
		campos.add(getTextFieldValor());
		campos.add(getTextFieldQuantidade());
			
		return campos;
	}
	
	public JFormattedTextField getCampo(int indexCampo){
		switch(indexCampo){
			case CODIGO :
				return getTextFieldCodigo();
			case DESCRICAO :
				return getTextFieldDecricao();
			case UNIDADE_MEDIDA :
				return getTextFieldUnidadeMedida();
			case QUANTIDADE :
				return getTextFieldQuantidade();
			case VALOR :
				return getTextFieldValor();
			case TIPO :
				
				 JFormattedTextField tipo = new JFormattedTextField();
				 if(getComboBoxTipo().getSelectedIndex() == 0){
					  tipo.setText("S");
				 }else{
					  tipo.setText("P");
				 }
				 return tipo;
			default :
				throw new IndexOutOfBoundsException("Index out of bounds");
		}
	}
	
	public void disableCamposChavePrimaria(){
		getTextFieldCodigo().setEnabled(false);
	}
	
	public void disableAllCampos(){
		getTextFieldCodigo().setEnabled(false);
		getTextFieldDecricao().setEnabled(false);
		getTextFieldQuantidade().setEnabled(false);
		getTextFieldUnidadeMedida().setEnabled(false);
		getTextFieldValor().setEnabled(false);
		getComboBoxTipo().setEnabled(false);
	}
	
	public void clearAllCampos(){
		getTextFieldCodigo().setText("");
		getTextFieldDecricao().setText("");
		getTextFieldQuantidade().setText("1.000");
		getTextFieldValor().setText("0");
		getTextFieldUnidadeMedida().setText("");
		getComboBoxTipo().setSelectedIndex(0);
	}
	
}
