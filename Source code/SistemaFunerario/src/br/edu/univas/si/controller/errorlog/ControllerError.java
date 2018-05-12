package br.edu.univas.si.controller.errorlog;

import br.edu.univas.si.model.util.ArquivoTxtUtil;
import br.edu.univas.si.view.error.FrameError;

public class ControllerError {
	
	FrameError view;
	
	public ControllerError() {
		view = new FrameError();
	}
	
	public void initialize(Exception e){
		view.setVisible(true);
		view.setTextArea(e);
	}
	
	public void salvaError(String nameArquivo , String error){
		ArquivoTxtUtil.criaArquivo(nameArquivo, error);
	}
}
