package br.edu.univas.si.view.cadastro.unidademedida;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.univas.si.view.util.MyMask;

public class PanelUnidadeMedida extends JPanel {

	private static final long serialVersionUID = -3610735265046166848L;
	
	private JLabel labelCodigo;
	private JLabel labelDescricao;
	
	private JFormattedTextField textFieldCodigo;
	private JFormattedTextField textFieldDescricao;
	
	//Indices dos campos
	public static final int CODIGO = 0;
	public static final int DESCRICAO = 1;
	
	
	public PanelUnidadeMedida(){
		setLayout(new GridLayout(2, 2,3,10));
		setBorder(new EmptyBorder(50, 50, 50, 50));
		initialize();
	}
	
	private void initialize(){
		
		add(getLabelCodigo());
		add(getTextFieldCodigo());
		add(getLabelDescricao());
		add(getTextFieldDescricao());
	}
	
	private JLabel getLabelCodigo(){
		if(labelCodigo ==null){
			labelCodigo = new JLabel("Codigo: *");
			labelCodigo.setFont(new Font("Century", Font.PLAIN, 14));
		}
		return labelCodigo;
	}
	
	private JLabel getLabelDescricao(){
		if(labelDescricao==null){
			labelDescricao = new JLabel("Descrição: *");
			labelDescricao.setFont(new Font("Century", Font.PLAIN, 14));
		}
		return labelDescricao;
	}
	
	private JFormattedTextField getTextFieldCodigo(){
		if(textFieldCodigo==null){
			textFieldCodigo = new JFormattedTextField();
			MyMask.maskUnidadeMedida(textFieldCodigo);
		}
		return textFieldCodigo;
	}
	
	private JFormattedTextField getTextFieldDescricao(){
		if(textFieldDescricao==null){
			textFieldDescricao = new JFormattedTextField();			
		}
		return textFieldDescricao;
	}
	
	public ArrayList<JFormattedTextField> getAllCamposObrigatorios(){
		
		ArrayList<JFormattedTextField> campos = new ArrayList<>();
		
		campos.add(getTextFieldCodigo());
		campos.add(getTextFieldDescricao());
		
		return campos;
	}
	
	public JFormattedTextField getCampo(int indexCampo){
		
		switch(indexCampo){
			case CODIGO :
				return getTextFieldCodigo();
			case DESCRICAO :
				return  getTextFieldDescricao();
			default :
				throw new IndexOutOfBoundsException("Index out of bounds");
		}
	}
	
	public void disableCamposChavePrimaria(){
		getTextFieldCodigo().setEnabled(false);
	}
	
	public void disableAllCampos(){
		getTextFieldCodigo().setEnabled(false);
		getTextFieldDescricao().setEnabled(false);
	}
	
	public void clearAllCampos(){
		getTextFieldCodigo().setText("");
		getTextFieldDescricao().setText("");
	}
}
