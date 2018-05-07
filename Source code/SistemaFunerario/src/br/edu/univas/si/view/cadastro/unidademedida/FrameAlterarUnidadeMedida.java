package br.edu.univas.si.view.cadastro.unidademedida;

import br.edu.univas.si.controller.unidademedida.ControllerAlterar;
import br.edu.univas.si.view.util.MyMessage;
import br.edu.univas.si.view.util.MyValidations;

public class FrameAlterarUnidadeMedida extends FrameComum {

	private static final long serialVersionUID = 2091370091680800364L;
	private ControllerAlterar controller;
	
	public FrameAlterarUnidadeMedida(ControllerAlterar controller) {
		super("Alterar - Unidade Medida");
		this.controller = controller;
		
		super.disableCamposChavePrimaria();
	}

	@Override
	void confirmaClicked() {
		if( MyValidations.haveCampoVazio( super.getAllCamposObrigatorios() ) ){
			MyMessage.camposVazios(this);	
		}else{
			//Envia TO para controller.	
			controller.updateUnidadeMedida(super.criaUnidadeMedida());;
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
