package br.edu.univas.si.controller.unidademedida;

import br.edu.univas.si.model.dao.cadastros.UnidadeMedida;
import br.edu.univas.si.model.exception.UnidadeMedidaException;
import br.edu.univas.si.model.to.UnidadeMedidaTO;
import br.edu.univas.si.view.cadastro.unidademedida.FrameExcluirUnidadeMedida;
import br.edu.univas.si.view.cadastro.unidademedida.FramePrincipalUnidadeMedida;

public class ControllerExcluir extends ControllerComum{

	private UnidadeMedida modelUnidadeMedida;
	private FrameExcluirUnidadeMedida viewExcluirUnidadeMedida;
	private FramePrincipalUnidadeMedida viewPrincipalUnidadeMedida;
	
	public ControllerExcluir(FramePrincipalUnidadeMedida viewPrincipalUnidadeMedida) {
		this.viewExcluirUnidadeMedida = new FrameExcluirUnidadeMedida(this);
		this.viewPrincipalUnidadeMedida = viewPrincipalUnidadeMedida;
		this.modelUnidadeMedida = new UnidadeMedida();		
	}	
	
	public  void initialize(UnidadeMedidaTO unidade){	
		this.viewExcluirUnidadeMedida.setVisible(true);
		super.populatePanel(unidade,viewExcluirUnidadeMedida);
	}
	
	//Exclui registro no banco.
	public void deleteUnidadeMedida(String codigo){
		
		try {
			modelUnidadeMedida.deleteUnidadeMedida(codigo);
			super.updateViewPrincipal(viewPrincipalUnidadeMedida);
		} catch (UnidadeMedidaException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void close(){
		if(viewExcluirUnidadeMedida != null){
			viewExcluirUnidadeMedida.dispose();
		}
	}
}
