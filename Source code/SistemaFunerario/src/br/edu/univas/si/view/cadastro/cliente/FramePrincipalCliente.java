package br.edu.univas.si.view.cadastro.cliente;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import br.edu.univas.si.controller.cliente.ControllerAlterar;
import br.edu.univas.si.controller.cliente.ControllerConsulta;
import br.edu.univas.si.controller.cliente.ControllerExcluir;
import br.edu.univas.si.controller.cliente.ControllerIncluir;
import br.edu.univas.si.listeners.ButtonsListenersCadastro;
import br.edu.univas.si.model.to.ClienteTO;
import br.edu.univas.si.view.componentsdefaults.ButtonsPanelCadastro;
import br.edu.univas.si.view.util.MyFrame;



public class FramePrincipalCliente extends MyFrame{

	private static final long serialVersionUID = 1032414008694011245L;
	
	private ButtonsPanelCadastro buttonsPanel;
	private PanelTable tableCliente;	
	
	private ControllerIncluir controllerIncluir;
	private ControllerExcluir controllerExcluir;
	private ControllerAlterar controllerAlterar;
	
	public FramePrincipalCliente(){
		super("Cadastro Cliente");
		
		initialize();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.pack();
		this.setLocationRelativeTo(null);
	}

	private void initialize() {
		
		this.add(getButtonsPanel(), BorderLayout.NORTH);
		this.add(getTable() , BorderLayout.CENTER);
	}
	
	private ButtonsPanelCadastro getButtonsPanel(){
		
		if(buttonsPanel == null){
			buttonsPanel = new ButtonsPanelCadastro();
			buttonsPanel.addButtonsListener(new ButtonsListenersCadastro() {
				
				@Override
				public void incluiPerformed() {
					incluiClicked();
				}
				
				@Override
				public void excluiPerformed() {
					excluiClicked();
				}
				
				@Override
				public void alteraPerformed() {
					alteraClicked();
				}
				
				@Override
				public void sairPerformed() {
					sairClicked();
				}

				@Override
				public void pesquisaPerformed() {
					pesquisaClicked();
				}
			});
		}
		return buttonsPanel;
	}
	
	private void incluiClicked(){
		controllerIncluir = new ControllerIncluir(this);
		controllerIncluir.initialize();		
	}
	
	private void excluiClicked(){
		controllerExcluir = new ControllerExcluir(this);
		controllerExcluir.initialize(getRowSelected());
	}
	
	private void alteraClicked(){
		controllerAlterar = new ControllerAlterar(this);
		controllerAlterar.initialize(getRowSelected());
	}
	
	private void sairClicked(){
		if(controllerIncluir != null){
			controllerIncluir.close(); }
		if(controllerAlterar != null){
			controllerAlterar.close(); }
		if(controllerExcluir != null){
			controllerExcluir.close(); }
		this.dispose();
	}
	
	private void pesquisaClicked(){
		String conteudoPesquisado = getButtonsPanel().getTextPesquisa();
		new ControllerConsulta(this).consultaClientesPorConteudo(conteudoPesquisado);
	}
	
	public PanelTable getTable(){
		if(tableCliente==null){
			tableCliente = new PanelTable();	
		}
		return tableCliente;
	}
	
	//pega registro da linha selecionada no JTable
	private ClienteTO getRowSelected(){
		
		int linha = getTable().getTable().getSelectedRow();
		ClienteTO cliente = new ClienteTO();
		
		if(linha != -1){ 	//-1 é o flag quando nenhuma linha está selecionada.
			//Extrai conteudo da linha selecionada
			String razao_social	= String.valueOf(getTable().getTable().getValueAt(linha, 0));
			String nome_fantasia= String.valueOf(getTable().getTable().getValueAt(linha, 1));
			String tipo			= String.valueOf(getTable().getTable().getValueAt(linha, 2));
			String cpf_cnpj		= String.valueOf(getTable().getTable().getValueAt(linha, 3));
			String endereco 	= String.valueOf( getTable().getTable().getValueAt(linha,4));
			
			//Monta POJO
			cliente.setCpf_cnpj(cpf_cnpj);
			cliente.setNome_fantasia(nome_fantasia);
			cliente.setRazao_social(razao_social);
			cliente.setTipo(tipo.charAt(0));
			cliente.setEndereco(endereco);
		}
		return cliente; 
	}
}