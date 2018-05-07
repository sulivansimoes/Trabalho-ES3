package br.edu.univas.si.view.cadastro.produtoservico;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import br.edu.univas.si.controller.produto.ControllerAlterar;
import br.edu.univas.si.controller.produto.ControllerConsulta;
import br.edu.univas.si.controller.produto.ControllerExcluir;
import br.edu.univas.si.controller.produto.ControllerIncluir;
import br.edu.univas.si.listeners.ButtonsListenersCadastro;
import br.edu.univas.si.model.to.ProdutoTO;
import br.edu.univas.si.view.componentsdefaults.ButtonsPanelCadastro;
import br.edu.univas.si.view.util.MyFrame;

public class FramePrincipalProduto extends MyFrame{
	
	private static final long serialVersionUID = 635536417644231488L;
	
	private ButtonsPanelCadastro buttonsPanel;
	private PanelTable tableProduto;	
	
	private ControllerIncluir controllerIncluir;
	private ControllerExcluir controllerExcluir;
	private ControllerAlterar controllerAlterar;
	
	public FramePrincipalProduto(){
		super("Cadastro Produto / Serviço");
		
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
		new ControllerConsulta(this).consultaProdutosPorConteudo(conteudoPesquisado);
	}
	
	public PanelTable getTable(){
		if(tableProduto==null){
			tableProduto = new PanelTable();	
		}
		return tableProduto;
	}
	
	//pega registro da linha selecionada no JTable
	private ProdutoTO getRowSelected(){
		
		int linha = getTable().getTable().getSelectedRow();
		ProdutoTO produto = new ProdutoTO();
		
		if(linha != -1){ 	//-1 é o flag quando nenhuma linha está selecionada.
			//Extrai conteudo da linha selecionada	
			String codigo	= String.valueOf(getTable().getTable().getValueAt(linha, 0));
			String descricao= String.valueOf(getTable().getTable().getValueAt(linha, 1));
			String tipo		= String.valueOf(getTable().getTable().getValueAt(linha, 2));
			String unidade	= String.valueOf(getTable().getTable().getValueAt(linha, 3));
			String quantidade = String.valueOf( getTable().getTable().getValueAt(linha, 4));
			String valor	  =  String.valueOf( getTable().getTable().getValueAt(linha, 5));
			
			produto.setCodigo(codigo);
			produto.setDescricao(descricao);
			produto.setTipo(tipo);
			produto.setUnidadeMedida(unidade);
			produto.setValor(Double.valueOf(valor));
			produto.setQuantidade(Double.valueOf(quantidade));
		}
		return produto;
	}
}
