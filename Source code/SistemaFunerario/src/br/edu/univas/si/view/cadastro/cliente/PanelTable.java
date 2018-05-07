package br.edu.univas.si.view.cadastro.cliente;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import br.edu.univas.si.controller.cliente.ControllerConsulta;

public class PanelTable extends JPanel{
	
	private static final long serialVersionUID = 7483123905006854017L;
	
	private JTable table;
	private JScrollPane scroll;

	public PanelTable() {
		setLayout(new BorderLayout());
		initialize();
	}
	
	private void initialize(){
		add(getScroll());
	}

	private JTable getTableCliente() {
		if(table==null){
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(new ControllerConsulta().consultaTodosClientes() );
		}
		return table;
	}

	private JScrollPane getScroll() {
		if(scroll==null){
			scroll = new JScrollPane(getTableCliente());
			scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		}
		return scroll;
	}
	
	public JTable getTable(){
		return getTableCliente();
	}
}
