package br.edu.univas.si.view.cadastro.produtoservico;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;

import br.edu.univas.si.listeners.ButtonsListenersConfirmaFecha;
import br.edu.univas.si.model.to.ProdutoTO;
import br.edu.univas.si.view.componentsdefaults.ButtonsPanelConfirmaFecha;
import br.edu.univas.si.view.util.MyFrame;

public abstract class FrameComum extends MyFrame{
	
	private static final long serialVersionUID = 7316401035624284636L;
	
	private PanelProduto panelProduto;
	private ButtonsPanelConfirmaFecha buttonsPanel;
	
	public FrameComum(String title) {
		super(title);
		
		setPreferredSize(new Dimension(780, 400));
		
		initialize();
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
	}

	private void initialize() {
		add(getButtonsPanel(), BorderLayout.NORTH);
		add(getPanelProduto(), BorderLayout.CENTER);
	}

	private ButtonsPanelConfirmaFecha getButtonsPanel() {
		if (buttonsPanel == null) {
			buttonsPanel = new ButtonsPanelConfirmaFecha();
			buttonsPanel.addButtonsListenersConfirmaFecha(new ButtonsListenersConfirmaFecha() {
				@Override
				public void fechaPerformed() {
					fechaClicked();
				}

				@Override
				public void confirmaPerformed() {
					confirmaClicked();
				}
			});
		}
		return buttonsPanel;
	}

	public PanelProduto getPanelProduto() {
		if (panelProduto == null) {
			panelProduto = new  PanelProduto();
		}
		return panelProduto;
	}
	
	protected void disableAllCampos(){
		getPanelProduto().disableAllCampos();
	}
	
	protected void disableCamposChavePrimaria(){
		getPanelProduto().disableCamposChavePrimaria();
	}
	
	protected ArrayList<JFormattedTextField> getAllCamposObrigatorios(){
		return getPanelProduto().getAllCamposObrigatorios();
	}
	
	protected JFormattedTextField getCampo(int indexCampo){
		return getPanelProduto().getCampo(indexCampo);
	}
	
	protected void clearAllCampos(){
		getPanelProduto().clearAllCampos();
	}
	
	protected ProdutoTO criaProduto(){
		
		//Extrai informações dos campos.
		String codigo	 = getCampo(PanelProduto.CODIGO).getText().trim();
		String descricao = getCampo(PanelProduto.DESCRICAO).getText().trim();
		String tipo 	 = getCampo(PanelProduto.TIPO).getText().trim();
		String unidade   = getCampo(PanelProduto.UNIDADE_MEDIDA).getText().trim();
		double quantidade= Double.valueOf(getCampo(PanelProduto.QUANTIDADE).getText().trim());
		double valor 	 = Double.valueOf(getCampo(PanelProduto.VALOR).getText().trim());
			
		//Monta Produto.
		ProdutoTO produto = new ProdutoTO();
		produto.setCodigo(codigo);
		produto.setDescricao(descricao);
		produto.setQuantidade(quantidade);
		produto.setTipo(tipo);
		produto.setUnidadeMedida(unidade);
		produto.setValor(valor);
		
		return produto;
	}
	
	abstract void confirmaClicked();
	
	abstract void fechaClicked();
}
