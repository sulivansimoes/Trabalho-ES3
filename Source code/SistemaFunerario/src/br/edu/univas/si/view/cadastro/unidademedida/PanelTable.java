package br.edu.univas.si.view.cadastro.unidademedida;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import br.edu.univas.si.controller.unidademedida.ControllerConsulta;

public class PanelTable extends JPanel{

	private static final long serialVersionUID = 6444281616435672861L;

	private JTable tableUnidadeMedida;
	private JScrollPane scroll;

	public PanelTable() {
		setLayout(new BorderLayout());
		initialize();
	}
	
	private void initialize(){
		add(getScroll());
	}

	private JTable getTableUnidadeMedida() {
		if(tableUnidadeMedida==null){
			tableUnidadeMedida = new JTable();
			tableUnidadeMedida.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableUnidadeMedida.setModel(new ControllerConsulta().consultaTodasUnidademedida() );
		}
		return tableUnidadeMedida;
	}

	private JScrollPane getScroll() {
		if(scroll==null){
			scroll = new JScrollPane(getTableUnidadeMedida());
			scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		}
		return scroll;
	}
	
	public JTable getTable(){
		return getTableUnidadeMedida();
	}
}