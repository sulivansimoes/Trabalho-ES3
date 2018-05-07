package br.edu.univas.si.view.cadastro.cliente;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.univas.si.view.util.MyMask;

public class PanelCliente extends JPanel{

	private static final long serialVersionUID = -5630902628398514429L;
	
	private JLabel labelCpfCnpj;
	private JLabel labelNomeFantasia;
	private JLabel labelRazaoSocial;
	private JLabel labelEndereco;
	private JLabel labelTipo;
	
	private JFormattedTextField textFieldCpfCnpj;
	private JFormattedTextField textFieldNomeFantasia;
	private JFormattedTextField textFieldRazaoSocial;
	private JFormattedTextField textFieldEndereco;
	
	private JComboBox<String> comboBoxTipo;
	
	//Indice de todos os campos.
	public static final int RAZAO_SOCIAL  = 1;
	public static final int NOME_FANTASIA = 2;
	public static final int TIPO		  = 3;
	public static final int CPF_CNPJ 	  = 4;
	public static final int ENDERECO	  = 5;
	
	public PanelCliente(){
		setLayout(new GridLayout(6, 6,3,10));
		setBorder(new EmptyBorder(50, 50, 50, 50));
		initialize();
	}
	
	private void initialize(){
		add(getLabelRazaoSocial());
		add(getTextFieldRazaoSocial());
		add(getLabelNomeFantasia());
		add(getTextFieldNomeFantasia());
		add(getLabelTIpo());
		add(getComboBoxTipo());
		add(getLabelCpfCnpj());
		add(getTextFieldCpfCnpj());
		add(getLabelEndereco());
		add(geTextFieldEndereco());
	}

	private JLabel getLabelCpfCnpj() {
		if(labelCpfCnpj==null){
			labelCpfCnpj = new JLabel("Cpf/Cnpj: *");
			labelCpfCnpj.setFont(new Font("Century", Font.PLAIN, 14));
		}
		return labelCpfCnpj;
	}

	private JLabel getLabelNomeFantasia() {
		if(labelNomeFantasia==null){
			labelNomeFantasia = new JLabel("Nome Fantasia: *");
			labelNomeFantasia.setFont(new Font("Century", Font.PLAIN, 14));
		}
		return labelNomeFantasia;
	}

	private JLabel getLabelRazaoSocial() {
		if(labelRazaoSocial==null){
			labelRazaoSocial = new JLabel("Razão Social: *");
			labelRazaoSocial.setFont(new Font("Century", Font.PLAIN, 14));
		}
		return labelRazaoSocial;
	}

	private JLabel getLabelEndereco() {
		if(labelEndereco==null){
			labelEndereco = new JLabel("Endereço: *");
			labelEndereco.setFont(new Font("Century", Font.PLAIN, 14));
		}
		return labelEndereco;
	}
	
	private JLabel getLabelTIpo(){
		if(labelTipo==null){
			labelTipo = new JLabel();
			labelTipo.setText("Tipo: *");
			labelTipo.setFont(new Font("Century", Font.PLAIN, 14));
		}
		return labelTipo;
	}

	private JFormattedTextField getTextFieldCpfCnpj() {
		if(textFieldCpfCnpj==null){
			textFieldCpfCnpj = new JFormattedTextField();
		}
		return textFieldCpfCnpj;
	}

	private JFormattedTextField getTextFieldNomeFantasia() {
		if(textFieldNomeFantasia==null){
			textFieldNomeFantasia = new JFormattedTextField();
		}
		return textFieldNomeFantasia;
	}

	private JFormattedTextField getTextFieldRazaoSocial() {
		if(textFieldRazaoSocial == null){
			textFieldRazaoSocial = new JFormattedTextField();
		}
		return textFieldRazaoSocial;
	}
	
	private JFormattedTextField geTextFieldEndereco(){
		if(textFieldEndereco==null){
			textFieldEndereco = new JFormattedTextField();
		}
		return textFieldEndereco;
	}
	
	public ArrayList<JFormattedTextField> getAllCamposObrigatorios(){
		ArrayList<JFormattedTextField> campos = new ArrayList<>();
		
		campos.add(getTextFieldCpfCnpj());
		campos.add(getTextFieldNomeFantasia());
		campos.add(getTextFieldRazaoSocial());
		campos.add(geTextFieldEndereco());
					
		return campos;
	}
	
	private JComboBox<String> getComboBoxTipo() {
		if(comboBoxTipo==null){
			comboBoxTipo = new JComboBox<>();
			comboBoxTipo = new JComboBox<>(new String[]{"Fisica","Juridica"});
			comboBoxTipo.setSelectedIndex(0);
						
			MyItemListener actionListener = new MyItemListener();
			comboBoxTipo.addItemListener(actionListener);
		}
		return comboBoxTipo;
	}
	
	public JFormattedTextField getCampo(int indexCampo){
		switch(indexCampo){
			case RAZAO_SOCIAL :
				return getTextFieldRazaoSocial();
			case NOME_FANTASIA :
				return getTextFieldNomeFantasia();
			case CPF_CNPJ :
				return getTextFieldCpfCnpj();
			case ENDERECO :
				return geTextFieldEndereco();
			case TIPO :
				 JFormattedTextField tipo = new JFormattedTextField();
				 if(getComboBoxTipo().getSelectedIndex() == 0){
					  tipo.setText("F");
				 }else{
					  tipo.setText("J");
				 }
				 return tipo;
			default :
				throw new IndexOutOfBoundsException("Index out of bounds");
		}
	}
	
	public void disableCamposChavePrimaria(){
		getTextFieldCpfCnpj().setEnabled(false);
	}
	
	public void disableAllCampos(){
		getTextFieldCpfCnpj().setEnabled(false);
		getTextFieldNomeFantasia().setEnabled(false);
		getTextFieldRazaoSocial().setEnabled(false);
		geTextFieldEndereco().setEnabled(false);
		getComboBoxTipo().setEnabled(false);
	}
	
	public void clearAllCampos(){
		getTextFieldCpfCnpj().setText("");
		getTextFieldNomeFantasia().setText("");
		getTextFieldRazaoSocial().setText("");
		geTextFieldEndereco().setText("");
		getComboBoxTipo().setSelectedIndex(0);
	}
	
	//Inner Class //TODO TERMINAR
	public class MyItemListener implements ItemListener {
		  
		 @Override
		  public void itemStateChanged(ItemEvent evt) {
		 
		    if (getComboBoxTipo().getSelectedIndex() == 0) {
		    	MyMask.maskCpf(getTextFieldCpfCnpj());
		    }else if (getComboBoxTipo().getSelectedIndex() == 1){
		    	MyMask.maskCnpj(getTextFieldCpfCnpj());
		    }
		 }
	}
}
