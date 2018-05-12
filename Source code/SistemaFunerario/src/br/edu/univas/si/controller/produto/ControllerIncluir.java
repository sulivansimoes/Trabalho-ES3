package br.edu.univas.si.controller.produto;


import br.edu.univas.si.controller.errorlog.ControllerError;
import br.edu.univas.si.model.dao.cadastros.Produto;
import br.edu.univas.si.model.exception.ProdutoException;
import br.edu.univas.si.model.to.ProdutoTO;
import br.edu.univas.si.view.cadastro.produtoservico.FrameIncluir;
import br.edu.univas.si.view.cadastro.produtoservico.FramePrincipalProduto;

public class ControllerIncluir extends ControllerComum {
	
	private FramePrincipalProduto viewPrincipal;
	private FrameIncluir   viewIncluir;
	private Produto modelProduto;
	private ControllerError controllerError;
	
	
	public ControllerIncluir(FramePrincipalProduto viewPrincipal){
		viewIncluir = new FrameIncluir(this);
		this.viewPrincipal = viewPrincipal;
		modelProduto = new Produto();
	}
	
	public void initialize(){
		viewIncluir.setVisible(true);
	}
	
	//Inclui produto na base de dados...
	public void insertNewProduto(ProdutoTO produto){
		try {
			modelProduto.insertNewProduto(produto);
			super.updateViewPrincipal(viewPrincipal);
		} catch (ProdutoException e) {
			e.printStackTrace();
			getControllerError().initialize(e);
		}
	}
			
	@Override
	public void close(){
		if(viewIncluir != null){
			viewIncluir.dispose();
		}
	}
	
	private ControllerError getControllerError() {
		if(controllerError == null){
			controllerError = new ControllerError();
		}
		return controllerError;
	}
	
}
