package ar.edu.unlam.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.SrcCode.Agasajado;
import ar.edu.unlam.SrcCode.CantidadInvitadosExcedidosException;
import ar.edu.unlam.SrcCode.Casamiento;
import ar.edu.unlam.SrcCode.Cumpleanios;
import ar.edu.unlam.SrcCode.Evento;
import ar.edu.unlam.SrcCode.Invitado;
import ar.edu.unlam.SrcCode.NoEstaInvitadoException;
import ar.edu.unlam.SrcCode.Organizador;
import ar.edu.unlam.SrcCode.Persona;

public class TestParcial {

	@Test
	public void queSePuedaCrearUnCumpleanios() {
		
	Persona cumpleaniero= new Agasajado("UNLAM", "universidad@unlam.edu.ar"); 	
		
	Persona organizadora1= new Organizador("Maite Perez", "juanperez@unlam.edu.ar"); 	
	
	Evento cumpleUnlam = new Cumpleanios("Cumpleanios Unlam", 661, 100, cumpleaniero , organizadora1); 
	
	Integer idEsperado=661; 
	
	assertEquals(idEsperado, ((Evento)cumpleUnlam).getIdEvento());
	
	}
	
	@Test
	public void queSePuedaCrearUnCasamiento() {
		
		Persona novio= new Agasajado("Jose Ginobili", "universidad@unlam.edu.ar"); 	
		Persona novia= new Agasajado("Mia Cruz", "universidad@unlam.edu.ar"); 	
		
		Persona organizadora1= new Organizador("Maria Juarez","mariajuarez@unlam.edu.ar"); 	
		
		Evento casamiento = new Casamiento("Boda Mia Y Jose", 662, 100, organizadora1); 
		
		Integer idEsperado=662; 
		
		assertEquals(idEsperado, ((Evento)casamiento).getIdEvento());
	}
	
	
	@Test
	public void queSePuedaAgregarNoviosAlCasamiento() {
		
		Persona novio= new Agasajado("Jose Ginobili", "universidad@unlam.edu.ar"); 	
		Persona novia= new Agasajado("Mia Cruz", "universidad2@unlam.edu.ar"); 	
		
		Persona organizadora1= new Organizador("Maria Juarez","mariajuarez@unlam.edu.ar"); 	
		
		Evento casamiento = new Casamiento("Boda Mia Y Jose", 662, 100, organizadora1); 
		
		((Casamiento)casamiento).agregarNovios(((Agasajado)novio));
		((Casamiento)casamiento).agregarNovios(((Agasajado)novia));
		
		 
		
		assertEquals((Integer)2 , ((Casamiento)casamiento).queLosNoviosEstenCargadosCorrectamente());
		
	}
	
	@Test
	public void queSePuedaInvitarGenteAUnCumpleanios() {
		
		Persona cumpleaniero= new Agasajado("UNLAM", "universidad@unlam.edu.ar"); 	
		
		Persona organizadora1= new Organizador("Maite Perez", "juanperez@unlam.edu.ar"); 	
		
		Persona invitado1= new Invitado("Mia Cruz", "universitario1@unlam.edu.ar");
		Persona invitado2= new Invitado("Morena Cruz", "universitario2@unlam.edu.ar");
		Persona invitado3= new Invitado("Juan Pablo", "universitario3@unlam.edu.ar");
		Persona invitado4= new Invitado("miguel diaz", "universitario4@unlam.edu.ar");
		Persona invitado5= new Invitado("gaston rod", "universitario5@unlam.edu.ar");
		Persona invitado6= new Invitado("Nazarena Valdez", "universitario6@unlam.edu.ar");
		Persona invitado7= new Invitado("Manuel Guzman", "universitario7@unlam.edu.ar");
		
		Evento cumpleUnlam = new Cumpleanios("Cumpleanios Unlam", 661, 100, cumpleaniero , organizadora1); 
		cumpleUnlam.agregarInvitados((Invitado)invitado1);
		cumpleUnlam.agregarInvitados((Invitado)invitado2);
		cumpleUnlam.agregarInvitados((Invitado)invitado3);
		cumpleUnlam.agregarInvitados((Invitado)invitado4);
		cumpleUnlam.agregarInvitados((Invitado)invitado5);
		cumpleUnlam.agregarInvitados((Invitado)invitado6);
		cumpleUnlam.agregarInvitados((Invitado)invitado7);
		
		Integer invitadosEsperados= 7; 
		
		assertEquals(invitadosEsperados, cumpleUnlam.getCantidadInvitados());
		
	}
	
	
	@Test
	public void queUnInvitadoPuedaAgregarEventosASuListaDeEventos() {
        
		Persona cumpleaniero= new Agasajado("UNLAM", "universidad@unlam.edu.ar"); 	
		Persona cumpleaniera= new Agasajado("Lola Perez", "lolaperez@unlam.edu.ar"); 
		
		Persona organizadora1= new Organizador("Maite Perez", "juanperez@unlam.edu.ar"); 	
		
		Evento cumpleUnlam = new Cumpleanios("Cumpleanios Unlam", 661, 100, cumpleaniero , organizadora1); 
		Evento cumpleLola = new Cumpleanios("Cumpleanios Lola", 763, 100, cumpleaniera , organizadora1);
		
		Persona invitado1= new Invitado("Manuel Guzman", "universitario7@unlam.edu.ar");
		
		((Invitado)invitado1).agregarMisEventos(cumpleUnlam);
		((Invitado)invitado1).agregarMisEventos(cumpleLola);
		
		assertEquals((Integer)2, ((Invitado)invitado1).cantidadDeEventos()); 
		
	}
	
	
	@Test
	public void queNoSePuedaInvitarMasPersonasDelLimiteDeInvitados() throws CantidadInvitadosExcedidosException {
	
		Persona cumpleaniero= new Agasajado("UNLAM", "universidad@unlam.edu.ar"); 	
		
		Persona organizadora1= new Organizador("Maite Perez", "juanperez@unlam.edu.ar"); 	
		
		Evento cumpleUnlam = new Cumpleanios("Cumpleanios Unlam", 661, 5, cumpleaniero , organizadora1); 
		
		
		Persona invitado2= new Invitado("Manuel Guzman", "universitario7@unlam.edu.ar");
		Persona invitado3= new Invitado("Juan Pablo", "universitario3@unlam.edu.ar");
		Persona invitado4= new Invitado("miguel diaz", "universitario4@unlam.edu.ar");
		Persona invitado5= new Invitado("gaston rod", "universitario5@unlam.edu.ar");
		Persona invitado6= new Invitado("Nazarena Valdez", "universitario6@unlam.edu.ar");
		Persona invitado7= new Invitado("Manuel Guzman", "universitario7@unlam.edu.ar");
		
		cumpleUnlam.agregarInvitados(((Invitado)invitado2));
		cumpleUnlam.agregarInvitados(((Invitado)invitado3));
		cumpleUnlam.agregarInvitados(((Invitado)invitado4));
		cumpleUnlam.agregarInvitados(((Invitado)invitado5));
		cumpleUnlam.agregarInvitados(((Invitado)invitado6));
		cumpleUnlam.agregarInvitados(((Invitado)invitado7));
		
		assertTrue(((Cumpleanios)cumpleUnlam).verificarListayLimiteDeInvitados(cumpleUnlam)); 
		
	}

	
	
	
	@Test
	public void queUnInvitadoPuedaVerSiEstaInvitado() throws NoEstaInvitadoException {
	
		Persona cumpleaniero= new Agasajado("UNLAM", "universidad@unlam.edu.ar"); 	
		
		Persona organizadora1= new Organizador("Maite Perez", "juanperez@unlam.edu.ar"); 	
		
		Evento cumpleUnlam = new Cumpleanios("Cumpleanios Unlam", 661, 5, cumpleaniero , organizadora1); 
		
		
		Persona invitado2= new Invitado("Manuel Guzman", "universitario7@unlam.edu.ar");
		Persona invitado3= new Invitado("Juan Pablo", "universitario3@unlam.edu.ar");
		Persona invitado4= new Invitado("miguel diaz", "universitario4@unlam.edu.ar");
		Persona invitado5= new Invitado("gaston rod", "universitario5@unlam.edu.ar");
		Persona invitado6= new Invitado("Nazarena Valdez", "universitario6@unlam.edu.ar");
		Persona invitado7= new Invitado("Manuel Guzman", "universitario7@unlam.edu.ar");
		
		cumpleUnlam.agregarInvitados(((Invitado)invitado2));
		cumpleUnlam.agregarInvitados(((Invitado)invitado3));
		cumpleUnlam.agregarInvitados(((Invitado)invitado4));
		cumpleUnlam.agregarInvitados(((Invitado)invitado5));
		cumpleUnlam.agregarInvitados(((Invitado)invitado6));
	
		
		assertTrue(((Invitado)invitado5).verSiEstoyInvitado(((Cumpleanios)cumpleUnlam), ((Invitado)invitado5))); 
		
	}
	
	
	@Test
	public void verLaListaDeInvitadosOrdenada() {
	
		Persona cumpleaniero= new Agasajado("UNLAM", "universidad@unlam.edu.ar"); 	
		
		Persona organizadora1= new Organizador("Maite Perez", "juanperez@unlam.edu.ar"); 	
		
		Evento cumpleUnlam = new Cumpleanios("Cumpleanios Unlam", 661, 5, cumpleaniero , organizadora1); 
		
		//el metodo ordena la lista alfabeticamente de la Z a la A
		
		Persona invitado2= new Invitado("Ana Guzman", "aniversitario7@unlam.edu.ar");
		Persona invitado3= new Invitado("brenda Pablo", "cniversitario3@unlam.edu.ar");
		Persona invitado4= new Invitado("miguel diaz", "bniversitario4@unlam.edu.ar");
		Persona invitado5= new Invitado("brian rodriguez", "rniversitario5@unlam.edu.ar");
		Persona invitado6= new Invitado("Nazarena Valdez", "vniversitario6@unlam.edu.ar");
		Persona invitado7= new Invitado("Manuel Guzman", "zniversitario7@unlam.edu.ar");
		
		cumpleUnlam.agregarInvitados(((Invitado)invitado2));
		cumpleUnlam.agregarInvitados(((Invitado)invitado3));
		cumpleUnlam.agregarInvitados(((Invitado)invitado4));
		cumpleUnlam.agregarInvitados(((Invitado)invitado5));
		cumpleUnlam.agregarInvitados(((Invitado)invitado6));
	
		cumpleUnlam.obtenerListaInvitadosOrdenadaPorNombre(cumpleUnlam); 
		
	}

}
