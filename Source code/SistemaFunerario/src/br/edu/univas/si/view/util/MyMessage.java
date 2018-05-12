package br.edu.univas.si.view.util;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Summary: Classe contém métodos responsaveis por exibir telas de mensagens padrões do sistema, para usuário,
 * @author Súlivan Simões
 */
public class MyMessage {

	
	/**
	 * Summary: Mostra mensagem para usuário preencher campos
	 * @param frameRelative   o quadro (JFrame) no qual o diálogo é exibido; se nulo, o Frame padrão será usado
	 */
	public static void camposVazios(JFrame frameRelative){
		JOptionPane.showMessageDialog(frameRelative, "Campos com asterisco ( * ) são de prechimento obrigatório. Preencha os "
				 					 + "campos obrigatórios antes de salvar.","Problema",JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Summary: Mostra mensagem para usuário se deseja fechar tela sem salvar.
	 * @param frameRelative   o quadro (JFrame) no qual o diálogo é exibido; se nulo, o Frame padrão será usado.
	 * @return   Retorna true caso a opção sim seja selecionada, retorna false caso contrário 
	 */
	public static boolean fecharSemSalvar(JFrame frameRelative){
		Object[] opcoes = {"Sim","Não"};
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
	
	/**
	 * Summary: Mostra mensagem informativa para usuário
	 * @param frameRelative   o quadro (JFrame) no qual o diálogo é exibido; se nulo, o Frame padrão será usado.
	 * @param mensagem	o conteudo que será exibido para usuário.
	 */
	 public static final void informativo(JFrame frameRelative, String text){
		 		 
		 JOptionPane.showMessageDialog(frameRelative, 
				 					   text,
				 					   "Aviso",
				 					   JOptionPane.INFORMATION_MESSAGE);
	 }
}
