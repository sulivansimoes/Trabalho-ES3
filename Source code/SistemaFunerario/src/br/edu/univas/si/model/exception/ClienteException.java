package br.edu.univas.si.model.exception;

public class ClienteException extends Exception{
	
	private static final long serialVersionUID = -3987660236785639102L;

	public ClienteException(String mensagem) {
		super(mensagem);
	}
}
