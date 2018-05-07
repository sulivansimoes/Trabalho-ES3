package br.edu.univas.si.controller.principal;

import br.edu.univas.si.view.cadastro.cliente.FramePrincipalCliente;
import br.edu.univas.si.view.cadastro.produtoservico.FramePrincipalProduto;
import br.edu.univas.si.view.cadastro.unidademedida.FramePrincipalUnidadeMedida;
import br.edu.univas.si.view.menu.Menu;
import br.edu.univas.si.view.util.MyFrame;

public class ControllerPrincipal {

	Menu viewMenu;
	FramePrincipalUnidadeMedida frameUnidademedida;
	FramePrincipalProduto frameProduto;
	FramePrincipalCliente frameCliente;
	
	public ControllerPrincipal() {
		MyFrame.setlookAndFeel(MyFrame.GRAPHITE);
		viewMenu = new Menu(this);
	}
	
	public void initialize(){
		viewMenu.setVisible(true);		
	}
	
	public void exitSystem(){
		System.out.println("esta escutando");
	}
		
	public void callScreenFrameUnidadeMedida(){
		frameUnidademedida = new FramePrincipalUnidadeMedida();
		frameUnidademedida.setVisible(true);
	}
	
	public void callScreenFrameProduto(){
		frameProduto = new FramePrincipalProduto();
		frameProduto.setVisible(true);
	}
	
	public void callScreenFrameCliente(){
		frameCliente = new FramePrincipalCliente();
		frameCliente.setVisible(true);
	}
}
