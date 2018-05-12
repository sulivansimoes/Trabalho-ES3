package br.edu.univas.si.controller.cliente;

import br.edu.univas.si.controller.errorlog.ControllerError;
import br.edu.univas.si.model.dao.cadastros.Cliente;
import br.edu.univas.si.model.exception.ClienteException;
import br.edu.univas.si.view.cadastro.cliente.FramePrincipalCliente;
import br.edu.univas.si.view.cadastro.cliente.TableModelCliente;

public class ControllerConsulta extends ControllerComum{
		
	private Cliente model;
	private FramePrincipalCliente viewPrincipal; 
	private ControllerError controllerError;
	
	public ControllerConsulta(){
		model = new Cliente();
	}
	
	public ControllerConsulta(FramePrincipalCliente view){
		viewPrincipal = view;
		model = new Cliente();
	}

	public TableModelCliente consultaTodosClientes(){
		try {
			return new TableModelCliente(model.consultaClientes() );
		} catch (ClienteException e) {
			e.printStackTrace();
			getControllerError().initialize(e);
		}
		
		return null;
	}
	
	public void consultaClientesPorConteudo(String busca){
		try {
			TableModelCliente tbl = new TableModelCliente(model.consultaClientesPorConteudo(busca) );
			super.filterViewPrincipal(viewPrincipal, tbl);
		} catch (ClienteException e) {
			e.printStackTrace();
			getControllerError().initialize(e);
		}
	}
	
	private ControllerError getControllerError() {
		if(controllerError == null){
			controllerError = new ControllerError();
		}
		return controllerError;
	}

	@Override
	void close(){}
}
