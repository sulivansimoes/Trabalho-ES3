package br.edu.univas.si.view.cadastro.cliente;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;

import br.edu.univas.si.listeners.ButtonsListenersConfirmaFecha;
import br.edu.univas.si.model.to.ClienteTO;
import br.edu.univas.si.view.componentsdefaults.ButtonsPanelConfirmaFecha;
import br.edu.univas.si.view.util.MyFrame;

public abstract class FrameComum extends MyFrame{

	private static final long serialVersionUID = -6153896842679101831L;
	
	private PanelCliente panelCliente;
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
		add(getPanelCliente(), BorderLayout.CENTER);
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

	public PanelCliente getPanelCliente() {
		if (panelCliente == null) {
			panelCliente = new  PanelCliente();
		}
		return panelCliente;
	}
	
	protected void disableAllCampos(){
		getPanelCliente().disableAllCampos();
	}
	
	protected void disableCamposChavePrimaria(){
		getPanelCliente().disableCamposChavePrimaria();
	}
	
	protected ArrayList<JFormattedTextField> getAllCamposObrigatorios(){
		return getPanelCliente().getAllCamposObrigatorios();
	}
	
	protected JFormattedTextField getCampo(int indexCampo){
		return getPanelCliente().getCampo(indexCampo);
	}
	
	protected void clearAllCampos(){
		getPanelCliente().clearAllCampos();
	}
	
	protected ClienteTO criaCliente(){
		
		//Extrai conteudo dos campos.
		String razao_social  = getCampo(PanelCliente.RAZAO_SOCIAL).getText().trim();
		String nome_fantasia = getCampo(PanelCliente.NOME_FANTASIA).getText().trim();
		String tipo 	= getCampo(PanelCliente.TIPO).getText().trim(); 
		String cpf_cnpj = getCampo(PanelCliente.CPF_CNPJ).getText().trim().replaceAll("\\D","");;
		String endereco = getCampo(PanelCliente.ENDERECO).getText().trim(); 
		
		//Criando POJO
		ClienteTO cliente = new ClienteTO();
		cliente.setRazao_social(razao_social);
		cliente.setNome_fantasia(nome_fantasia);
		cliente.setTipo(tipo.charAt(0));
		cliente.setCpf_cnpj(cpf_cnpj);
		cliente.setEndereco(endereco);
		
		return cliente;
	}
	
	abstract void confirmaClicked();
	
	abstract void fechaClicked();
}
