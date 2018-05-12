package br.edu.univas.si.model.util;

import java.io.File;
import java.io.FileWriter;

import br.edu.univas.si.controller.errorlog.ControllerError;


/**
 * Summary: Classe cont�m m�todos responsaveis por criar e escrever arquivos txt.
 * @author S�livan Sim�es
 */
public class ArquivoTxtUtil {

	private static FileWriter arquivo;
	private static ControllerError controllerError;
	
	public static final void criaArquivo(String nameArquivo, String conteudo){
		
		try {			
			new File("C:/logsSistemaFunerario/").mkdir(); //Cria diret�rio se n�o existir
			arquivo = new FileWriter(new File("C:/logsSistemaFunerario/"+nameArquivo+".txt"));
			arquivo.write(conteudo);
			arquivo.close();	
		} catch (Exception e) {
			e.printStackTrace();
			getControllerError().initialize(e);
		}
	}
	
	private static ControllerError getControllerError() {
		if(controllerError == null){
			controllerError = new ControllerError();
		}
		return controllerError;
	}
}