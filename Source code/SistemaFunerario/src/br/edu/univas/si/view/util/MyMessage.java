package br.edu.univas.si.view.util;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Summary: Classe cont�m m�todos responsaveis por exibir telas de mensagens padr�es do sistema, para usu�rio,
 * @author S�livan Sim�es
 */
public class MyMessage {

	
	/**
	 * Summary: Mostra mensagem para usu�rio preencher campos
	 * @param frameRelative   o quadro (JFrame) no qual o di�logo � exibido; se nulo, o Frame padr�o ser� usado
	 */
	public static void camposVazios(JFrame frameRelative){
		JOptionPane.showMessageDialog(frameRelative, "Campos com asterisco ( * ) s�o de prechimento obrigat�rio. Preencha os "
				 					 + "campos obrigat�rios antes de salvar.","Problema",JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Summary: Mostra mensagem para usu�rio se deseja fechar tela sem salvar.
	 * @param frameRelative   o quadro (JFrame) no qual o di�logo � exibido; se nulo, o Frame padr�o ser� usado.
	 * @return   Retorna true caso a op��o sim seja selecionada, retorna false caso contr�rio 
	 */
	public static boolean fecharSemSalvar(JFrame frameRelative){
		Object[] opcoes = {"Sim","N�o"};
		int escolha = JOptionPane.showOptionDialog(frameRelative, 
												  "Deseja fechar sem salvar ?", 
												  "Aviso", 
												  JOptionPane.YES_NO_OPTION, 
												  JOptionPane.QUESTION_MESSAGE, 
												  null , 
												  opcoes , 
												  opcoes[1]);
		
		if(escolha==0){ //Sim
			return true;
		}
		return false;
	}
}
