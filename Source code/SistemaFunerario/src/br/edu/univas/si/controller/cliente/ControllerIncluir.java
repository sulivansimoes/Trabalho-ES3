package br.edu.univas.si.controller.cliente;

import br.edu.univas.si.model.dao.cadastros.Cliente;
import br.edu.univas.si.model.exception.ClienteException;
import br.edu.univas.si.model.to.ClienteTO;
import br.edu.univas.si.view.cadastro.cliente.FrameIncluir;
import br.edu.univas.si.view.cadastro.cliente.FramePrincipalCliente;

public class ControllerIncluir extends ControllerComum{
	private Cliente model;
	private FrameIncluir viewIncluir;
	private FramePrincipalCliente viewPrincipal;
	
	public ControllerIncluir(FramePrincipalCliente viewPrincipal) {
		this.viewIncluir = new FrameIncluir(this);
		this.viewPrincipal = viewPrincipal;
		this.model = new Cliente();		
	}	
	
	public  void initialize(){
		this.viewIncluir.setVisible(true);
	}
	
	//Inclui registro no banco.
	public void insertCliente(ClienteTO cliente){
		
		try {
			model.insertNewCliente(cliente);
			super.updateViewPrincipal(viewPrincipal);
		} catch (ClienteException e) {
			e.printStackTrace();
		}
	}
		
	public void close(){
		if(viewIncluir != null){
			viewIncluir.dispose();
		}
	}
}
