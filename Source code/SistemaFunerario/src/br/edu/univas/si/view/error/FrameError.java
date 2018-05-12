package br.edu.univas.si.view.error;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.Date;

import br.edu.univas.si.controller.errorlog.ControllerError;
import br.edu.univas.si.listeners.ButtonsListenersConfirmaFecha;
import br.edu.univas.si.view.componentsdefaults.ButtonsPanelConfirmaFecha;
import br.edu.univas.si.view.util.MyFrame;
import br.edu.univas.si.view.util.MyMessage;

public class FrameError extends MyFrame{

	private static final long serialVersionUID = -1235984604510313413L;
	
	private PanelError panelError;
	private ButtonsPanelConfirmaFecha buttons;
	private ControllerError controllerError;
	
	public FrameError() {
		super("Error Log");
		
		initialize();
		
		setPreferredSize(new Dimension(455, 455));
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	private void initialize(){
		add(getPanelError(),BorderLayout.CENTER);
		add(getButtons(), BorderLayout.SOUTH);
	}
	
	private PanelError getPanelError(){
		if(panelError==null){
			panelError = new PanelError();
		}
		return panelError;
	}
	
	private ButtonsPanelConfirmaFecha getButtons(){
		if(buttons==null){
			buttons = new ButtonsPanelConfirmaFecha();
			buttons.setTitleButtonConfirma("Salvar");
			buttons.addButtonsListenersConfirmaFecha(new ButtonsListenersConfirmaFecha() {
				
				@Override
				public void fechaPerformed() {
					fechaClicked();
				}
				
				@Override
				public void confirmaPerformed() {
					salvaClicked();				
				}
			});
		}
		return buttons;
	}
	
	public void setTextArea(Exception e){
		getPanelError().setTextArea(e.toString());
	}
	
	private void fechaClicked(){
		this.dispose();
	}
	
	private void salvaClicked(){
		
		String dateError = "log_"+String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+"-"+
												 Integer.valueOf((Calendar.getInstance().get(Calendar.MONTH)+1)) +"-"+
												 Calendar.getInstance().get(Calendar.YEAR)+"_"+
												 String.valueOf(new Date().getTime()));
		
		
		getControllerError().salvaError(dateError ,getPanelError().getText());

		MyMessage.informativo(this, "Log foi criado no seguinte diretório: c:\\logsSistemaFunerario\\"+dateError);
		
		fechaClicked();
	}
	
	private ControllerError getControllerError(){
		if(controllerError == null){
			controllerError = new ControllerError();
		}
		return controllerError;
	}
}
