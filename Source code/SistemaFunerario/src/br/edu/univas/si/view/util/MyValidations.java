package br.edu.univas.si.view.util;

import java.util.ArrayList;

import javax.swing.JFormattedTextField;

/**
 * Summary: Classe contém métodos responsaveis para fazer validações genericas da view.
 * @author Súlivan Simões
 */
public class MyValidations {
	
	/**
	 * Summary: Valida se campos estão preenchidos.
	 * @param campos   ArrayList de JFormattedTextField, contendo campos que serão verificados.
	 * @return    Se tiver algum campo vazio o método retornará true, caso contrário retornará false,
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
	 * Summary: Valida se String é só contém números
	 * @param texto   String contendo texto a ser verificado
	 * @return    Se tiver somente números retornará true, caso contrário retornará false,
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