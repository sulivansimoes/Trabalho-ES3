package br.edu.univas.si.controller.produto;

import br.edu.univas.si.controller.errorlog.ControllerError;
import br.edu.univas.si.model.dao.cadastros.Produto;
import br.edu.univas.si.model.exception.ProdutoException;
import br.edu.univas.si.model.to.ProdutoTO;
import br.edu.univas.si.view.cadastro.produtoservico.FrameExcluir;
import br.edu.univas.si.view.cadastro.produtoservico.FramePrincipalProduto;

public class ControllerExcluir extends ControllerComum {

	private Produto model;
	private FrameExcluir viewExcluir;
	private FramePrincipalProduto viewPrincipal;
	private ControllerError controllerError;
	
	public ControllerExcluir(FramePrincipalProduto viewPrincipal) {
		this.viewExcluir = new FrameExcluir(this);
		this.viewPrincipal = viewPrincipal;
		this.model = new Produto();		
	}	
	
	public  void initialize(ProdutoTO produto){
		this.viewExcluir.setVisible(true);
		super.populatePanel(produto,viewExcluir);
	}
	
	//Exclui registro no banco.
	public void deleteProduto(String codigo){
		
		try {
			model.deleteProduto(codigo);
			super.updateViewPrincipal(viewPrincipal);
		} catch (ProdutoException e) {
			e.printStackTrace();
			getControllerError().initialize(e);
		}
	}
	
	@Override
	public void close(){
		if(viewExcluir != null){
			viewExcluir.dispose();
		}
	}
	
	private ControllerError getControllerError() {
		if(controllerError == null){
			controllerError = new ControllerError();
		}
		return controllerError;
	}
}
