package ar.edu.unlam.SrcCode;

import java.util.Comparator;

public class Ordenamiento implements Comparator<Persona>{

	@Override
	public int compare(Persona o1, Persona o2) {
		String p1= o1.getNombre();
		String p2= o2.getNombre();
		
		Integer comparador = (p1.compareTo(p2)); 

	if(comparador > 0) {
	         return -1;
	}
	else if(comparador < 0) {
		return 1;
	}
	else{
		return 0;
	}
}
}
