package br.edu.univas.si.view.cadastro.produtoservico;

import br.edu.univas.si.controller.produto.ControllerExcluir;

public class FrameExcluir extends FrameComum{

	private static final long serialVersionUID = -4414831007874839764L;
	private ControllerExcluir controller;
	
	public FrameExcluir(ControllerExcluir controller) {
		super("Excluir - Produto / Serviço");
		this.controller = controller;
		
		disableAllCampos();
	}

	@Override
	void confirmaClicked() {
		controller.deleteProduto(super.getCampo(PanelProduto.CODIGO).getText().trim());
		controller.close();
	}

	@Override
	void fechaClicked() {
		controller.close();
	}

}
