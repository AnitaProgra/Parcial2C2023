package ar.edu.unlam.SrcCode;

public class Organizador extends Persona{

	public Organizador(String nombre, String email) {
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
