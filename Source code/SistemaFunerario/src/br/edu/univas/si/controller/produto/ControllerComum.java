package br.edu.univas.si.controller.produto;

import br.edu.univas.si.model.to.ProdutoTO;
import br.edu.univas.si.view.cadastro.produtoservico.FrameComum;
import br.edu.univas.si.view.cadastro.produtoservico.FramePrincipalProduto;
import br.edu.univas.si.view.cadastro.produtoservico.PanelProduto;
import br.edu.univas.si.view.cadastro.produtoservico.TableModelProduto;

public abstract class ControllerComum {

	//Atualiza JTable da viewPrincipal.
	protected void updateViewPrincipal(FramePrincipalProduto viewPrincipal){ 
		viewPrincipal.getTable().getTable().setModel(new ControllerConsulta().consultaTodosProdutos());
	}	
	
	protected void populatePanel(ProdutoTO produto, FrameComum view){
		view.getPanelProduto().getCampo(PanelProduto.CODIGO).setText(produto.getCodigo());
		view.getPanelProduto().getCampo(PanelProduto.DESCRICAO).setText(produto.getDescricao());
		view.getPanelProduto().getCampo(PanelProduto.UNIDADE_MEDIDA).setText(produto.getUnidadeMedida());
		view.getPanelProduto().getCampo(PanelProduto.QUANTIDADE).setText(String.valueOf(produto.getQuantidade()));
		view.getPanelProduto().getCampo(PanelProduto.VALOR).setText(String.valueOf(produto.getValor()));
	}
	
	//Atualiza JTable de acordo com filtro da pesquisa.
	protected void filterViewPrincipal(FramePrincipalProduto viewPrincipal, TableModelProduto table){ 
		viewPrincipal.getTable().getTable().setModel(table);
	}
	
	abstract void close();
}
