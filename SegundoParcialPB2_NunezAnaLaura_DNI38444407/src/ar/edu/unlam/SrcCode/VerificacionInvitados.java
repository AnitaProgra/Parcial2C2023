package ar.edu.unlam.SrcCode;

public interface VerificacionInvitados {

	
	public abstract boolean verificarListayLimiteDeInvitados(Evento evento) throws CantidadInvitadosExcedidosException; 
}
