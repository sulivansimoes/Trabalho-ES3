package br.edu.univas.si.controller.produto;

import br.edu.univas.si.model.dao.cadastros.Produto;
import br.edu.univas.si.model.exception.ProdutoException;
import br.edu.univas.si.view.cadastro.produtoservico.FramePrincipalProduto;
import br.edu.univas.si.view.cadastro.produtoservico.TableModelProduto;

public class ControllerConsulta extends ControllerComum {
	
	Produto model;
	FramePrincipalProduto viewPrincipal;
	
	public ControllerConsulta(){
		model = new Produto();
	}
	
	public ControllerConsulta(FramePrincipalProduto view){
		viewPrincipal = view;
		model = new Produto();
	}

	public TableModelProduto consultaTodosProdutos(){
		try {
			return new TableModelProduto(model.consultaProdutos() );
		} catch (ProdutoException e) {
			// TODO fazer tratamento com console log.
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void consultaProdutosPorConteudo(String busca){
		try {
			TableModelProduto tbl =  new TableModelProduto(model.consultaProdutosPorConteudo(busca) );
			super.filterViewPrincipal(viewPrincipal, tbl);
		} catch (ProdutoException e) {
			e.printStackTrace();
		}
				
	}

	@Override
	void close() {}
}
