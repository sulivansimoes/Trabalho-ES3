package br.edu.univas.si.view.util;

import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 * Summary: Classe cont�m m�todos responsaveis por aplicar mascaras no JFormattedTextField
 * @author S�livan Sim�es
 *
 */
public class MyMask {

	public static final void maskCpf(JFormattedTextField cpf){
		
		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setValidCharacters("1234567890");
			mascaraCpf.install(cpf);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static final void maskCnpj(JFormattedTextField cnpj){
		
		try {
			MaskFormatter mascaraCnpj = new MaskFormatter("##.###.###/####-##");
			mascaraCnpj.setValidCharacters("1234567890");
			mascaraCnpj.install(cnpj);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static final void maskUnidadeMedida(JFormattedTextField unidadeMedida){
		
		try {
			MaskFormatter mascaraUnidadeMedida = new MaskFormatter("**");
			mascaraUnidadeMedida.setInvalidCharacters("@#$%�&!*.,/��?��������������~");
			mascaraUnidadeMedida.install(unidadeMedida);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
