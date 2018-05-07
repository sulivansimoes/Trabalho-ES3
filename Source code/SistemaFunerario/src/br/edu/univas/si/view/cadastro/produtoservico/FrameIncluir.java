package br.edu.univas.si.view.cadastro.produtoservico;

import br.edu.univas.si.controller.produto.ControllerIncluir;
import br.edu.univas.si.view.util.MyMessage;
import br.edu.univas.si.view.util.MyValidations;

public class FrameIncluir extends FrameComum {


	private static final long serialVersionUID = 8975619550374049396L;
	private ControllerIncluir controller;
	
	public FrameIncluir(ControllerIncluir controller) {
		super("Incluir - Produto / Serviço");
		
		this.controller = controller;
	}

	@Override
	void confirmaClicked() {
		if(MyValidations.haveCampoVazio(getAllCamposObrigatorios())){
			MyMessage.camposVazios(this);
		}else{
			
			//Envia To para controller.
			controller.insertNewProduto(super.criaProduto());
			
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
