package br.edu.univas.si.controller.cliente;

import br.edu.univas.si.controller.errorlog.ControllerError;
import br.edu.univas.si.model.dao.cadastros.Cliente;
import br.edu.univas.si.model.exception.ClienteException;
import br.edu.univas.si.model.to.ClienteTO;
import br.edu.univas.si.view.cadastro.cliente.FrameAlterar;
import br.edu.univas.si.view.cadastro.cliente.FramePrincipalCliente;

public class ControllerAlterar extends ControllerComum{
	
	private Cliente model;
	private FrameAlterar viewAlterar;
	private FramePrincipalCliente viewPrincipal;
	private ControllerError controllerError;
	
	public ControllerAlterar(FramePrincipalCliente viewPrincipal) {
		this.viewAlterar = new FrameAlterar(this);
		this.viewPrincipal = viewPrincipal;
		this.model = new Cliente();		
	}	
	
	public  void initialize(ClienteTO cliente){
		this.viewAlterar.setVisible(true);
		super.populatePanel(cliente,viewAlterar);
	}
	
	//Altera registro no banco.
	public void updateProduto(ClienteTO cliente){
		
		try {
			model.updateCliente(cliente);
			super.updateViewPrincipal(viewPrincipal);
		} catch (ClienteException e) {
			e.printStackTrace();
			getControllerError().initialize(e);
		}
	}
	
	@Override
	public void close(){
		if(viewAlterar != null){
			viewAlterar.dispose();
		}
	}
	
	private ControllerError getControllerError() {
		if(controllerError == null){
			controllerError = new ControllerError();
		}
		return controllerError;
	}
}
