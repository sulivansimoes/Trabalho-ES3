package br.edu.univas.si.view.cadastro.cliente;

import br.edu.univas.si.controller.cliente.ControllerAlterar;
import br.edu.univas.si.view.util.MyMessage;
import br.edu.univas.si.view.util.MyValidations;

public class FrameAlterar extends FrameComum{

	private static final long serialVersionUID = 1228252324276984955L;
	
	private ControllerAlterar controller;
	
	public FrameAlterar(ControllerAlterar controller) {
		super("Alterar - Cliente");
		this.controller = controller;
		
		super.disableCamposChavePrimaria();
	}

	@Override
	void confirmaClicked() {
		
		if(MyValidations.haveCampoVazio(super.getAllCamposObrigatorios())){
			MyMessage.camposVazios(this);
		}else{			
			controller.updateProduto(super.criaCliente());	
			controller.close();
		}		
	}

	@Override
	void fechaClicked() {
		if(MyMessage.fecharSemSalvar(this)){
			controller.close();
		}
	}
}
