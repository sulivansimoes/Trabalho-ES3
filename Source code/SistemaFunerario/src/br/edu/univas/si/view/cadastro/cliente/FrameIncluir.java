package br.edu.univas.si.view.cadastro.cliente;

import br.edu.univas.si.controller.cliente.ControllerIncluir;
import br.edu.univas.si.view.util.MyMessage;
import br.edu.univas.si.view.util.MyValidations;

public class FrameIncluir extends FrameComum{
	
	private static final long serialVersionUID = 2422799504382465164L;
	
	ControllerIncluir controller;
	
	public FrameIncluir(ControllerIncluir controller){
		super("Incluir - Cliente");
		this.controller = controller;
	}

	@Override
	void confirmaClicked() {
		if(MyValidations.haveCampoVazio(super.getAllCamposObrigatorios())){
			MyMessage.camposVazios(this);
		}else{
			controller.insertCliente(super.criaCliente());
			super.clearAllCampos();
		}
		
	}

	@Override
	void fechaClicked() {
		if(MyMessage.fecharSemSalvar(this)){
			controller.close();
		}
	}
}
