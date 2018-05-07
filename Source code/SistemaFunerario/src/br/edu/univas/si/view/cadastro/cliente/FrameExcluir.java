package br.edu.univas.si.view.cadastro.cliente;

import br.edu.univas.si.controller.cliente.ControllerExcluir;

public class FrameExcluir extends FrameComum{
	
	private static final long serialVersionUID = 1L;
	private ControllerExcluir controller;
	
	public FrameExcluir(ControllerExcluir controller) {
		super("Excluir - Cliente");
		this.controller = controller;
		
		disableAllCampos();
	}

	@Override
	void confirmaClicked() {
		controller.deleteCliente(super.getCampo(PanelCliente.CPF_CNPJ).getText().trim());
		controller.close();
	}

	@Override
	void fechaClicked() {
			controller.close();
	}
}
