package br.edu.univas.si.controller.unidademedida;

import br.edu.univas.si.model.to.UnidadeMedidaTO;
import br.edu.univas.si.view.cadastro.unidademedida.FrameComum;
import br.edu.univas.si.view.cadastro.unidademedida.FramePrincipalUnidadeMedida;
import br.edu.univas.si.view.cadastro.unidademedida.PanelUnidadeMedida;
import br.edu.univas.si.view.cadastro.unidademedida.TableModelUnidadeMedida;

public abstract class ControllerComum {
	
	//Atualiza JTable da viewPrincipalUnidadeMedida.
	protected void updateViewPrincipal(FramePrincipalUnidadeMedida viewPrincipal){ 
		viewPrincipal.getTableUnidadeMedia().getTable().setModel(new ControllerConsulta().consultaTodasUnidademedida());
	}
	
	protected void populatePanel(UnidadeMedidaTO unidade, FrameComum view){
		view.getPanelUnidadeMedida().getCampo(PanelUnidadeMedida.CODIGO).setText(unidade.getCodigo());
		view.getPanelUnidadeMedida().getCampo(PanelUnidadeMedida.DESCRICAO).setText(unidade.getDescricao());
	}
	
	//Atualiza JTable de acordo com filtro da pesquisa.
	protected void filterViewPrincipal(FramePrincipalUnidadeMedida viewPrincipal, TableModelUnidadeMedida table){
		viewPrincipal.getTableUnidadeMedia().getTable().setModel(table);
	}
	
	abstract void close();
}
