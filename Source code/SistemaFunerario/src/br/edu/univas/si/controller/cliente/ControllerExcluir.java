package br.edu.univas.si.controller.cliente;

import br.edu.univas.si.model.dao.cadastros.Cliente;
import br.edu.univas.si.model.exception.ClienteException;
import br.edu.univas.si.model.to.ClienteTO;
import br.edu.univas.si.view.cadastro.cliente.FrameExcluir;
import br.edu.univas.si.view.cadastro.cliente.FramePrincipalCliente;

public class ControllerExcluir extends ControllerComum {
	private Cliente model;
	private FrameExcluir viewExcluir;
	private FramePrincipalCliente viewPrincipal;
	
	public ControllerExcluir(FramePrincipalCliente viewPrincipal) {
		this.viewExcluir = new FrameExcluir(this);
		this.viewPrincipal = viewPrincipal;
		this.model = new Cliente();		
	}	
	
	public  void initialize(ClienteTO cliente){
		this.viewExcluir.setVisible(true);
		super.populatePanel(cliente,viewExcluir);
	}
	
	//Exclui registro no banco.
	public void deleteCliente(String codigo){
		
		try {
			model.deleteCliente(codigo);
			super.updateViewPrincipal(viewPrincipal);
		} catch (ClienteException e) {
			e.printStackTrace();
		}
	}
	
	public void close(){
		if(viewExcluir != null){
			viewExcluir.dispose();
		}
	}
}
