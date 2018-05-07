package br.edu.univas.si.view.cadastro.unidademedida;

import br.edu.univas.si.controller.unidademedida.ControllerExcluir;

public class FrameExcluirUnidadeMedida extends FrameComum{

	private static final long serialVersionUID = -6731498310698744093L;
	
	private ControllerExcluir controller;
	
	public FrameExcluirUnidadeMedida(ControllerExcluir controller) {
		super("Excluir - Unidade Medida");
		this.controller = controller;
		
		super.disableAllCampos();
	}

	@Override
	void confirmaClicked() {
		controller.deleteUnidadeMedida(super.getCampo(PanelUnidadeMedida.CODIGO).getText().trim());
		fechaClicked();
	}

	@Override
	void fechaClicked() {
		controller.close();
	}	
}
