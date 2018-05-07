package br.edu.univas.si.view.util;

import java.util.ArrayList;

import javax.swing.JFormattedTextField;

/**
 * Summary: Classe cont�m m�todos responsaveis para fazer valida��es genericas da view.
 * @author S�livan Sim�es
 */
public class MyValidations {
	
	/**
	 * Summary: Valida se campos est�o preenchidos.
	 * @param campos   ArrayList de JFormattedTextField, contendo campos que ser�o verificados.
	 * @return    Se tiver algum campo vazio o m�todo retornar� true, caso contr�rio retornar� false,
	 */
	public static boolean haveCampoVazio(ArrayList<JFormattedTextField> campos){
		
		for(JFormattedTextField campo : campos){
			
			if( campo.getText().trim().isEmpty() ){
				return true;
			}
		}		
		return false;
	}
	
	/**
	 * Summary: Valida se String � s� cont�m n�meros
	 * @param texto   String contendo texto a ser verificado
	 * @return    Se tiver somente n�meros retornar� true, caso contr�rio retornar� false,
	 */
	public static final boolean isNumber(String texto){
		if(texto == null || texto.isEmpty()){
            return false;
        }
        for (char letra : texto.toCharArray()){
            if(letra < '0' || letra > '9')
                return false;
        }
        return true;
    }
}