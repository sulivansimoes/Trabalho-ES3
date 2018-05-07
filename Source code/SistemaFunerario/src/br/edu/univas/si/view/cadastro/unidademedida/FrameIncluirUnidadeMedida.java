package br.edu.univas.si.view.cadastro.unidademedida;

import br.edu.univas.si.controller.unidademedida.ControllerIncluir;
import br.edu.univas.si.view.util.MyMessage;
import br.edu.univas.si.view.util.MyValidations;

public class FrameIncluirUnidadeMedida extends FrameComum{

	private static final long serialVersionUID = 1270321083203174625L;
	
	private ControllerIncluir controller;
	
	public FrameIncluirUnidadeMedida(ControllerIncluir controller) {
		super("Incluir - Unidade Medida");
		this.controller = controller;

	}

	@Override
	void confirmaClicked() {
			if( MyValidations.haveCampoVazio( super.getAllCamposObrigatorios() ) ){
				MyMessage.camposVazios(this);	
			
			}else{
				//Envia TO para controller.	
				controller.insertUnidadeMedida(super.criaUnidadeMedida());			
				//Limpa campos do panel para novo cadastro
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
