package br.edu.univas.si.controller.unidademedida;

import br.edu.univas.si.model.dao.cadastros.UnidadeMedida;
import br.edu.univas.si.model.exception.UnidadeMedidaException;
import br.edu.univas.si.model.to.UnidadeMedidaTO;
import br.edu.univas.si.view.cadastro.unidademedida.FrameAlterarUnidadeMedida;
import br.edu.univas.si.view.cadastro.unidademedida.FramePrincipalUnidadeMedida;

public class ControllerAlterar extends ControllerComum{

	private UnidadeMedida modelUnidadeMedida;
	private FrameAlterarUnidadeMedida viewAlterarUnidadeMedida;
	private FramePrincipalUnidadeMedida viewPrincipalUnidadeMedida;
	
	public ControllerAlterar(FramePrincipalUnidadeMedida viewPrincipalUnidadeMedida) {
		this.viewAlterarUnidadeMedida = new FrameAlterarUnidadeMedida(this);
		this.viewPrincipalUnidadeMedida = viewPrincipalUnidadeMedida;
		this.modelUnidadeMedida = new UnidadeMedida();		
	}	
	
	public  void initialize(UnidadeMedidaTO unidade){
		this.viewAlterarUnidadeMedida.setVisible(true);
		super.populatePanel(unidade,viewAlterarUnidadeMedida);
	}
	
	//Altera registro no banco.
	public void updateUnidadeMedida(UnidadeMedidaTO unidade){
		
		try {
			modelUnidadeMedida.updateUnidadeMedida(unidade);
			super.updateViewPrincipal(viewPrincipalUnidadeMedida);
		} catch (UnidadeMedidaException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void close(){
		if(viewAlterarUnidadeMedida != null){
			viewAlterarUnidadeMedida.dispose();
		}
	}
}
