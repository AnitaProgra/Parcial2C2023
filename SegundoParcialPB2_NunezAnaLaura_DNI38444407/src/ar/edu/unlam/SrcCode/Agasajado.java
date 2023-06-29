package ar.edu.unlam.SrcCode;

public class Agasajado extends Persona {

	public Agasajado(String nombre, String email) {
		super(nombre, email);
		
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public String getEmail() {
		return email;
	}
	
	

}
