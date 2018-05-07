package br.edu.univas.si.view.cadastro.produtoservico;

import br.edu.univas.si.controller.produto.ControllerAlterar;
import br.edu.univas.si.view.util.MyMessage;
import br.edu.univas.si.view.util.MyValidations;

public class FrameAlterar extends FrameComum{

	private static final long serialVersionUID = 1223156154030726387L;
	private ControllerAlterar controller;
	
	public FrameAlterar(ControllerAlterar controller) {
		super("Alterar - Produto / Serviço");
		this.controller = controller;
		
		super.disableCamposChavePrimaria();
	}

	@Override
	void confirmaClicked() {
		
		if(MyValidations.haveCampoVazio(getAllCamposObrigatorios())){
			MyMessage.camposVazios(this);
		}else{			
			controller.updateProduto(super.criaProduto());	
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
