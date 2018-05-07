package br.edu.univas.si.view.componentsdefaults;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.si.listeners.ButtonsListenersCadastro;
import br.edu.univas.si.view.util.MyImageIcons;

public class ButtonsPanelCadastro extends JPanel {

	private static final long serialVersionUID = -6801362317252349009L;

	private JButton incluiButton;
	private JButton alteraButton;
	private JButton excluiButton;
	private JButton sairButton;
	private JButton pesquisaButton;
	
	private JTextField pesquisaTextField;

	private GridBagConstraints gbcIncluiButton;
	private GridBagConstraints gbcAlteraButton;
	private GridBagConstraints gbcExcluiButton;
	private GridBagConstraints gbcSairButton;
	private GridBagConstraints gbcPesquisaButton;
	private GridBagConstraints gbcPesquisaTextField;
		
	
	private ArrayList<ButtonsListenersCadastro> listeners = new ArrayList<>();

	public ButtonsPanelCadastro() {
		initialize();
	}

	private void initialize() {
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(0,80));
		
		this.add(this.getIncluiButton(), this.getGbcIncluiButton());
		this.add(this.getAlteraButton(), this.getGbcAlteraButton());
		this.add(this.getExcuiButton(), this.getGbcExcluiButton());
		this.add(this.getSairButton(), this.getGbcSairButton());
		this.add(this.getPesquisaButton(), this.getGbcPesquisaButton());
		this.add(this.getPesquisaTextField(), this.getGbcPesquisaTextField());
	}

	private JButton getIncluiButton() {
		if (incluiButton == null) {
			incluiButton = new JButton("Incluir");
			incluiButton.setFont(new Font("Century",Font.PLAIN,14));
			incluiButton.setPreferredSize(new Dimension(100, 40));
			incluiButton.setIcon(MyImageIcons.getImageIconAdd(22,22));
			incluiButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					incluiClicked();
				}
			});
		}
		return incluiButton;
	}

	private JButton getAlteraButton() {
		if(alteraButton == null){
			alteraButton = new JButton("Alterar");
			alteraButton.setFont(new Font("Century",Font.PLAIN,14));
			alteraButton.setPreferredSize(new Dimension(100, 40));
			alteraButton.setIcon(MyImageIcons.getImageIconPencil(22,22));
			alteraButton.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					alteraClicked();
				}
			}); 
		}
		return alteraButton;
	}
	
	private JButton getExcuiButton(){
		if(excluiButton == null){
			excluiButton = new JButton("Excluir");
			excluiButton.setFont(new Font("Century",Font.PLAIN,14));
			excluiButton.setPreferredSize(new Dimension(100, 40));
			excluiButton.setIcon(MyImageIcons.getImageIconLixo(22,22));
			excluiButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					excluiClicked();					
				}
			});
			
			
		}
		return excluiButton;
	}

	private JButton getSairButton() {
		if(sairButton==null){
			sairButton = new JButton("Sair");
			sairButton.setFont(new Font("Century",Font.PLAIN,14));
			sairButton.setPreferredSize(new Dimension(100, 40));
			sairButton.setIcon(MyImageIcons.getImageIconExit(28, 28));
			sairButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sairClicked();					
				}
			});
		}
		return sairButton;
	}
	
	private JButton getPesquisaButton(){
		if(pesquisaButton==null){
			pesquisaButton = new JButton("Pesquisa");
			pesquisaButton.setFont(new Font("Century",Font.PLAIN,14));
			pesquisaButton.setPreferredSize(new Dimension(100, 40));
			pesquisaButton.setIcon(MyImageIcons.getImageIconLupa(22,22));
			pesquisaButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					pesquisaClicked();
				}
			});
		}
		return pesquisaButton;
	}
	
	private JTextField getPesquisaTextField(){
		
		if(pesquisaTextField == null){
			pesquisaTextField = new JTextField();
			pesquisaTextField.setColumns(50);
		}
		return pesquisaTextField;
	}

	private GridBagConstraints getGbcIncluiButton() {
		if (gbcIncluiButton == null) {
			gbcIncluiButton = new GridBagConstraints();
			gbcIncluiButton.insets = new Insets(3, 3, 3, 3);
			gbcIncluiButton.gridx = 2;
			gbcIncluiButton.gridy = 0;
			gbcIncluiButton.fill = GridBagConstraints.BOTH;
		}
		return gbcIncluiButton;
	}

	private GridBagConstraints getGbcAlteraButton() {
		if(gbcAlteraButton == null){
			gbcAlteraButton = new GridBagConstraints();
			gbcAlteraButton.insets = new Insets(3,3,3,3);
			gbcAlteraButton.gridx = 3;
			gbcAlteraButton.gridy = 0;
		}
		return gbcAlteraButton;
	}
	
	private GridBagConstraints getGbcExcluiButton(){
		if(gbcExcluiButton ==null){
			gbcExcluiButton = new GridBagConstraints();
			gbcExcluiButton.insets = new Insets(3,3,3,3);
			gbcExcluiButton.gridx = 4;
			gbcExcluiButton.gridy = 0;
		}
		return gbcExcluiButton;
	}

	private GridBagConstraints getGbcSairButton() {
		if(gbcSairButton == null){
			gbcSairButton = new GridBagConstraints();
			gbcSairButton.insets = new Insets(3, 3, 3, 3);
			gbcSairButton.gridx = 0;
			gbcSairButton.gridy = 0;
		}
		return gbcSairButton;
	}
	
	private GridBagConstraints getGbcPesquisaTextField(){
		
		if(gbcPesquisaTextField == null){
			gbcPesquisaTextField = new GridBagConstraints();
			gbcPesquisaTextField.insets = new Insets(3, 3, 3, 3);
			gbcPesquisaTextField.gridx = 6;
			gbcPesquisaTextField.gridy = 0;
		}
		
		return gbcPesquisaTextField;
	}
	
	private GridBagConstraints getGbcPesquisaButton(){
		if(gbcPesquisaButton == null){
			gbcPesquisaButton = new GridBagConstraints();
			gbcPesquisaButton.insets = new Insets(3, 30, 3, 3);
			gbcPesquisaButton.gridx = 5;
			gbcPesquisaButton.gridy = 0;
		}
		return gbcPesquisaButton;
	}
	
	public void addButtonsListener(ButtonsListenersCadastro listener){
		listeners.add(listener); //adiciona ouviente no array de ouvientes
	}
	
	private void incluiClicked() {
		for(ButtonsListenersCadastro l : listeners){
			l.incluiPerformed();
		}
	}
	
	private void alteraClicked(){
		for(ButtonsListenersCadastro l : listeners){
			l.alteraPerformed();
		}
	}
	
	private void excluiClicked(){
		for(ButtonsListenersCadastro l : listeners){
			l.excluiPerformed();
		}
	}
	
	private void sairClicked(){
		for(ButtonsListenersCadastro l : listeners){
			l.sairPerformed();
		}
	}
	
	private void pesquisaClicked(){
		for(ButtonsListenersCadastro l : listeners){
			l.pesquisaPerformed();
		}
	}
	
	public String getTextPesquisa(){
		return getPesquisaTextField().getText().trim();
	}
}
