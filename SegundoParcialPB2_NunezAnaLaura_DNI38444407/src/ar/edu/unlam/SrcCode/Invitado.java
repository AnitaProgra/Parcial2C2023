package ar.edu.unlam.SrcCode;

import java.util.HashSet;

public class Invitado extends Persona{

	protected HashSet<Evento> misEventos; 
	
	public Invitado(String nombre, String email) {
		super(nombre, email);
		this.misEventos= new HashSet<>(); 
	}

	public void agregarMisEventos(Evento evento) {
		misEventos.add(evento); 
	}
	
	
	public Integer cantidadDeEventos() {
		return misEventos.size(); 
	}
	
	public boolean confirmarMiAsistencia(Evento evento) {
		return true; 
	}
	
	public boolean confirmarMiAusencia(Evento evento) {
		return false; 
	}
	

	
	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public String getEmail() {
		return email;
	}

	
	
	
	public boolean verSiEstoyInvitado(Cumpleanios evento, Invitado invitado) throws NoEstaInvitadoException{
	 try { 
		 if(!evento.listaInvitados.contains(invitado)) {
			 throw new NoEstaInvitadoException("Ud no esta en la lista de invitados de este evento");  
	  }
	
	  return true;
	 }
	 
	catch(NoEstaInvitadoException e) {
		System.out.println(e.getMessage());
		return false;
	}
	
	
	}
	

	
	
}