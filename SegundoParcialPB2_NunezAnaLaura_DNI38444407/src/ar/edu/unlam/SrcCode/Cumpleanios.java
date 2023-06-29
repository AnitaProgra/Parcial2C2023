package ar.edu.unlam.SrcCode;

import java.util.HashSet;

public class Cumpleanios extends Evento implements VerificacionInvitados {

	protected Persona cumpleaniero; 
 
	public Cumpleanios(String nombreEvento, Integer idEvento,  Integer cantidadInvitados,Persona cumpleaniero, Persona organizador) {
		super(nombreEvento, idEvento, cantidadInvitados,organizador);
		this.cumpleaniero= cumpleaniero; 
	}

	@Override
	public String getNombreEvento() {
		return nombreEvento;
	}

	@Override
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento= nombreEvento; 
		
	}



	@Override
	public boolean verificarListayLimiteDeInvitados(Evento evento) throws CantidadInvitadosExcedidosException{
		try {
			for(Invitado l: listaInvitados) {	
				if(listaInvitados.size()>evento.getLimiteInvitados()) {
					throw new CantidadInvitadosExcedidosException("la cantidad de invitados supera al limite"); 
				}
			}
			return true; 
		}
		catch(CantidadInvitadosExcedidosException e) {
			System.out.println(e.getMessage());
			 return false;  
		}
		
		

}

	
	
	@Override
	public HashSet<Invitado> getListaInvitados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setListaInvitados(HashSet<Invitado> listaInvitados) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getCantidadInvitados() {
	return listaInvitados.size();
	}

	@Override
	public void setCantidadInvitados(Integer cantidadInvitados) {
		// TODO Auto-generated method stub
		
	}
}