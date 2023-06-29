package ar.edu.unlam.SrcCode;

import java.util.Objects;

public abstract class Persona {

	protected String nombre; 
	protected String email;
	
	
	public Persona(String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email;
	} 
	
	
	public abstract String getNombre();
	public abstract String getEmail();


	@Override
	public int hashCode() {
		return Objects.hash(email);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(email, other.email);
	}
	

	
	
}
