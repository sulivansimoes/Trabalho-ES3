package br.edu.univas.si.controller.unidademedida;

import br.edu.univas.si.controller.errorlog.ControllerError;
import br.edu.univas.si.model.dao.cadastros.UnidadeMedida;
import br.edu.univas.si.model.exception.UnidadeMedidaException;
import br.edu.univas.si.view.cadastro.unidademedida.FramePrincipalUnidadeMedida;
import br.edu.univas.si.view.cadastro.unidademedida.TableModelUnidadeMedida;

public class ControllerConsulta extends ControllerComum{
	
	UnidadeMedida model;
	FramePrincipalUnidadeMedida viewPrincipal;
	
	ControllerError controllerError;
	
	public ControllerConsulta(){
		model = new UnidadeMedida();
	}
	
	public ControllerConsulta(FramePrincipalUnidadeMedida view){
		viewPrincipal = view;
		model = new UnidadeMedida();
	}

	public TableModelUnidadeMedida consultaTodasUnidademedida(){
		try {
			return new TableModelUnidadeMedida(model.consultaUnidadeMedida());
		} catch (UnidadeMedidaException e) {
			e.printStackTrace();
			getControllerError().initialize(e);		
		}
		
		return null;
	}
	
	public void consultaUnidademedidaPorConteudo(String busca){
		try {
			TableModelUnidadeMedida tbl = new TableModelUnidadeMedida(model.consultaUnidademedidaPorConteudo(busca) );
			super.filterViewPrincipal(viewPrincipal, tbl);
		} catch (UnidadeMedidaException e) {
			e.printStackTrace();
			getControllerError().initialize(e);
		}
	}
	
	private ControllerError getControllerError() {
		if(controllerError == null){
			controllerError = new ControllerError();
		}
		return controllerError;
	}

	@Override
	void close(){}
}
