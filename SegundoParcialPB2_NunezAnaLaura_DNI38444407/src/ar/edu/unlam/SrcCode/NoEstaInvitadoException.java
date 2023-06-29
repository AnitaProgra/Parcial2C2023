package ar.edu.unlam.SrcCode;

public class NoEstaInvitadoException extends Exception {

	protected String mensaje;

	public NoEstaInvitadoException(String mensaje) {
		super(mensaje);
		
	} 
	
	
}
