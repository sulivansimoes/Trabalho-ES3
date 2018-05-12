package br.edu.univas.si.controller.unidademedida;

import br.edu.univas.si.controller.errorlog.ControllerError;
import br.edu.univas.si.model.dao.cadastros.UnidadeMedida;
import br.edu.univas.si.model.exception.UnidadeMedidaException;
import br.edu.univas.si.model.to.UnidadeMedidaTO;
import br.edu.univas.si.view.cadastro.unidademedida.FrameIncluirUnidadeMedida;
import br.edu.univas.si.view.cadastro.unidademedida.FramePrincipalUnidadeMedida;

public class ControllerIncluir extends ControllerComum{
	
	private UnidadeMedida modelUnidadeMedida;
	private FrameIncluirUnidadeMedida viewIncluirUnidadeMedida;
	private FramePrincipalUnidadeMedida viewPrincipalUnidadeMedida;
	private ControllerError controllerError;
	
	public ControllerIncluir(FramePrincipalUnidadeMedida viewPrincipalUnidadeMedida) {
		this.viewIncluirUnidadeMedida = new FrameIncluirUnidadeMedida(this);
		this.viewPrincipalUnidadeMedida = viewPrincipalUnidadeMedida;
		this.modelUnidadeMedida = new UnidadeMedida();		
	}	
	
	public  void initialize(){
		this.viewIncluirUnidadeMedida.setVisible(true);
	}
	
	//Inclui registro no banco.
	public void insertUnidadeMedida(UnidadeMedidaTO unidade){
		
		try {
			modelUnidadeMedida.insertNewUnidadeMedida(unidade);
			super.updateViewPrincipal(viewPrincipalUnidadeMedida);
		} catch (UnidadeMedidaException e) {
			e.printStackTrace();
			getControllerError().initialize(e);
		}
	}
	
	public void close(){
		if(viewIncluirUnidadeMedida != null){
			viewIncluirUnidadeMedida.dispose();
		}
	}
	
	private ControllerError getControllerError() {
		if(controllerError == null){
			controllerError = new ControllerError();
		}
		return controllerError;
	}
}
