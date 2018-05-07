package br.edu.univas.si.view.cadastro.unidademedida;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;

import br.edu.univas.si.listeners.ButtonsListenersConfirmaFecha;
import br.edu.univas.si.model.to.UnidadeMedidaTO;
import br.edu.univas.si.view.componentsdefaults.ButtonsPanelConfirmaFecha;
import br.edu.univas.si.view.util.MyFrame;

public abstract class FrameComum extends MyFrame{

	private static final long serialVersionUID = 5000881815931502703L;
	
	private PanelUnidadeMedida panelUnidadeMedida;
	private ButtonsPanelConfirmaFecha buttonsPanel;
	
	public FrameComum(String title) {
		super(title);
		
		setPreferredSize(new Dimension(700, 270));
		
		initialize();
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
	}

	private void initialize() {
		add(getButtonsPanel(), BorderLayout.NORTH);
		add(getPanelUnidadeMedida(), BorderLayout.CENTER);
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

	public PanelUnidadeMedida getPanelUnidadeMedida() {
		if (panelUnidadeMedida == null) {
			panelUnidadeMedida = new PanelUnidadeMedida();
		}
		return panelUnidadeMedida;
	}
	
	protected void disableAllCampos(){
		getPanelUnidadeMedida().disableAllCampos();
	}
	
	protected void disableCamposChavePrimaria(){
		getPanelUnidadeMedida().disableCamposChavePrimaria();
	}
	
	protected ArrayList<JFormattedTextField> getAllCamposObrigatorios(){
		return getPanelUnidadeMedida().getAllCamposObrigatorios();
	}
	
	protected JFormattedTextField getCampo(int indexCampo){
		return getPanelUnidadeMedida().getCampo(indexCampo);
	}
	
	protected void clearAllCampos(){
		getPanelUnidadeMedida().clearAllCampos();
	}
	
	protected UnidadeMedidaTO criaUnidadeMedida(){
		
		//Extrai informações do campo.
		String codigo 	 = getCampo(PanelUnidadeMedida.CODIGO).getText().trim();
		String descricao = getCampo(PanelUnidadeMedida.DESCRICAO).getText().trim();
		
		//Monta TO
		UnidadeMedidaTO unidade = new UnidadeMedidaTO();
		unidade.setCodigo(codigo);
		unidade.setDescricao(descricao);
		
		return unidade;
	}
	
	abstract void confirmaClicked();
	
	abstract void fechaClicked();

}
