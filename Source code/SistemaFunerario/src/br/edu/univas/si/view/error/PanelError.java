package br.edu.univas.si.view.error;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class PanelError extends JPanel{

	private static final long serialVersionUID = -3142662976527077140L;
	
	private JTextArea textAreaError;
	private JScrollPane scroll;
	
	public PanelError() {
		setLayout(new FlowLayout());
		initialize();
	}
	
	private void initialize(){
		this.add(getScroll());
	}
	
	private JTextArea getTextAreaError(){
		if(textAreaError == null){
			textAreaError = new JTextArea();
			textAreaError.setColumns(38);
			textAreaError.setRows(18);
			textAreaError.setLineWrap(true);
		}
		return textAreaError;
	}
	
	private JScrollPane getScroll(){
		if(scroll==null){
			scroll = new JScrollPane(getTextAreaError());
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		}
		return scroll;
	}
	
	public void setTextArea(String text){
		getTextAreaError().setText(quebraText(text));
	}
	
	public String getText(){
		return getTextAreaError().getText();
	}
	
	private String quebraText(String text){	
		String aux = "";
		int count = 0;
		for(Character caracter : text.toCharArray()){
			
			if(count==61){
				aux += "\n";
			}
			aux += caracter;
			count++;
		}
		return aux;
	}
}
