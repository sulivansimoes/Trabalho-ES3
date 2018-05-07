package br.edu.univas.si.controller.cliente;

import br.edu.univas.si.model.to.ClienteTO;
import br.edu.univas.si.view.cadastro.cliente.FrameComum;
import br.edu.univas.si.view.cadastro.cliente.FramePrincipalCliente;
import br.edu.univas.si.view.cadastro.cliente.PanelCliente;
import br.edu.univas.si.view.cadastro.cliente.TableModelCliente;


public abstract class ControllerComum {

	//Atualiza JTable da viewPrincipalUnidadeMedida.
	protected void updateViewPrincipal(FramePrincipalCliente viewPrincipal){ 
		viewPrincipal.getTable().getTable().setModel(new ControllerConsulta().consultaTodosClientes() );
	}	
	
	protected void populatePanel(ClienteTO cliente, FrameComum view){
		view.getPanelCliente().getCampo(PanelCliente.CPF_CNPJ).setText(cliente.getCpf_cnpj());
		view.getPanelCliente().getCampo(PanelCliente.NOME_FANTASIA).setText(cliente.getNome_fantasia());
		view.getPanelCliente().getCampo(PanelCliente.RAZAO_SOCIAL).setText(cliente.getRazao_social());
		view.getPanelCliente().getCampo(PanelCliente.TIPO).setText(String.valueOf(cliente.getTipo()));
		view.getPanelCliente().getCampo(PanelCliente.ENDERECO).setText(String.valueOf(cliente.getEndereco()));
	}
	
	//Atualiza JTable de acordo com filtro da pesquisa.
	protected void filterViewPrincipal(FramePrincipalCliente viewPrincipal, TableModelCliente table){ 
		viewPrincipal.getTable().getTable().setModel(table);
	}
	
	abstract void close();
}
