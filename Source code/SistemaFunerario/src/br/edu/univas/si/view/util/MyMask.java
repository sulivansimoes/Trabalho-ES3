package br.edu.univas.si.view.util;

import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

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
}
