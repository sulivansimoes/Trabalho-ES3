package br.edu.univas.si.controller.produto;

import br.edu.univas.si.controller.errorlog.ControllerError;
import br.edu.univas.si.model.dao.cadastros.Produto;
import br.edu.univas.si.model.exception.ProdutoException;
import br.edu.univas.si.model.to.ProdutoTO;
import br.edu.univas.si.view.cadastro.produtoservico.FrameAlterar;
import br.edu.univas.si.view.cadastro.produtoservico.FramePrincipalProduto;

public class ControllerAlterar extends ControllerComum{

	private Produto model;
	private FrameAlterar viewAlterar;
	private FramePrincipalProduto viewPrincipal;
	private ControllerError controllerError;
	
	public ControllerAlterar(FramePrincipalProduto viewPrincipal) {
		this.viewAlterar = new FrameAlterar(this);
		this.viewPrincipal = viewPrincipal;
		this.model = new Produto();		
	}	
	
	public  void initialize(ProdutoTO produto){
		this.viewAlterar.setVisible(true);
		super.populatePanel(produto, viewAlterar);
	}
	
	//Altera registro no banco.
	public void updateProduto(ProdutoTO produto){
		
		try {
			model.updateProduto(produto);
			super.updateViewPrincipal(viewPrincipal);
		} catch (ProdutoException e) {
			e.printStackTrace();
			getControllerError().initialize(e);
		}
	}
	
	@Override
	public void close(){
		if(viewAlterar != null){
			viewAlterar.dispose();
		}
	}
	
	private ControllerError getControllerError() {
		if(controllerError == null){
			controllerError = new ControllerError();
		}
		return controllerError;
	}
}