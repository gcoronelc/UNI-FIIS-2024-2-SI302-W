package pe.edu.uni.semana05.prueba;

import pe.edu.uni.semana05.herencia.Clase1;
import pe.edu.uni.semana05.herencia.Clase2;
import pe.edu.uni.semana05.herencia.Clase3;
import pe.edu.uni.semana05.herencia.Clase4;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class Prueba12 {

	public static void main(String[] args) {
		
		Clase2 bean = new Clase2();
		// Compatibilidad
		System.out.println("Compatible con Clase1: " + (bean instanceof Clase1));
		System.out.println("Compatible con Clase2: " + (bean instanceof Clase2));
		System.out.println("Compatible con Clase3: " + (bean instanceof Clase3));
		System.out.println("Compatible con Clase4: " + (bean instanceof Clase4));
	}
}
