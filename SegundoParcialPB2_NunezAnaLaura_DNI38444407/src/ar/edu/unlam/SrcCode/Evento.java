package ar.edu.unlam.SrcCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

public abstract class Evento {

	
	protected String nombreEvento;
	protected Integer idEvento; 
	protected Integer limiteInvitados;
	protected HashSet<Invitado> listaInvitados;
	protected HashSet<Agasajado> agasajado;
	protected Persona organizador; 
	
	
	
	public Evento(String nombreEvento, Integer idEvento, Integer limiteInvitados, Persona organizador) {
		super();
		this.nombreEvento = nombreEvento;
		this.idEvento =idEvento;
		this.limiteInvitados= limiteInvitados; 
		this.organizador= organizador;
		this.listaInvitados= new HashSet<>(); 
	}

	
	public void agregarInvitados(Invitado invitado) {
		listaInvitados.add(invitado); 
	}

	public abstract String getNombreEvento(); 
	public abstract void setNombreEvento(String nombreEvento);


	public abstract HashSet<Invitado> getListaInvitados();


	public abstract void setListaInvitados(HashSet<Invitado> listaInvitados);


	public abstract Integer getCantidadInvitados();

	public abstract void setCantidadInvitados(Integer cantidadInvitados);


	public Integer getIdEvento() {
		return idEvento; 
	}
	
	public Integer getLimiteInvitados() {
		return limiteInvitados;
	}
	
	public Integer getMisInvitados() {
		return listaInvitados.size();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idEvento);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return Objects.equals(idEvento, other.idEvento);
	} 

	
	
	public void obtenerListaInvitadosOrdenadaPorNombre(Evento evento) {
		
		for(Invitado i: listaInvitados) 
			if(!listaInvitados.isEmpty()) {
			ArrayList<Invitado> misInvitados = new ArrayList<>(listaInvitados); 
			
			Collections.sort(misInvitados, new Ordenamiento());
			
			System.out.println(i.getNombre());
			
			}
		
		
		
	}
	

	
	
	
	
}
