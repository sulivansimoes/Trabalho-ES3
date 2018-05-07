package br.edu.univas.si.view.cadastro.unidademedida;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import br.edu.univas.si.controller.unidademedida.ControllerAlterar;
import br.edu.univas.si.controller.unidademedida.ControllerConsulta;
import br.edu.univas.si.controller.unidademedida.ControllerExcluir;
import br.edu.univas.si.controller.unidademedida.ControllerIncluir;
import br.edu.univas.si.listeners.ButtonsListenersCadastro;
import br.edu.univas.si.model.to.UnidadeMedidaTO;
import br.edu.univas.si.view.componentsdefaults.ButtonsPanelCadastro;
import br.edu.univas.si.view.util.MyFrame;

public class FramePrincipalUnidadeMedida extends MyFrame{

	private static final long serialVersionUID = -9050283071705767542L;
	
	private ButtonsPanelCadastro buttonsPanel;
	private PanelTable tableUnidadeMedia;	
	private ControllerIncluir controllerIncluir;
	private ControllerExcluir controllerExcluir;
	private ControllerAlterar controllerAlterar;
	
	public FramePrincipalUnidadeMedida(){
		super("Cadastro Unidade Medida");
		
		initialize();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.pack();
		this.setLocationRelativeTo(null);
	}

	private void initialize() {
		
		this.add(getButtonsPanel(), BorderLayout.NORTH);
		this.add(getTableUnidadeMedia() , BorderLayout.CENTER);
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
		if (controllerAlterar != null) controllerAlterar.close();
		if (controllerExcluir != null) controllerExcluir.close();
		if (controllerIncluir != null) controllerIncluir.close();
		this.dispose();
	}
	
	private void pesquisaClicked(){
		String conteudoPesquisado = getButtonsPanel().getTextPesquisa();
		new ControllerConsulta(this).consultaUnidademedidaPorConteudo(conteudoPesquisado);
	}
	
	public PanelTable getTableUnidadeMedia(){
		if(tableUnidadeMedia==null){
			tableUnidadeMedia = new PanelTable();	
		}
		return tableUnidadeMedia;
	}
	
	//pega registro da linha selecionada no JTable
	private UnidadeMedidaTO getRowSelected(){
		
		int linha = getTableUnidadeMedia().getTable().getSelectedRow();
		UnidadeMedidaTO unidade = new UnidadeMedidaTO();
		
		if(linha != -1){ 	//-1 é o flag quando nenhuma linha está selecionada.
			//Extrai conteudo da linha selecionada
			String codigo 	 = String.valueOf(getTableUnidadeMedia().getTable().getValueAt(linha, 0)); 
			String descricao = String.valueOf(getTableUnidadeMedia().getTable().getValueAt(linha, 1));
			
			unidade.setCodigo(codigo);
			unidade.setDescricao(descricao);
		}
		return unidade;
	}
}
