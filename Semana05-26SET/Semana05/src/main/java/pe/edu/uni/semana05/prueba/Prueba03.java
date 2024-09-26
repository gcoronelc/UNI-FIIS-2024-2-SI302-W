package pe.edu.uni.semana05.prueba;

import pe.edu.uni.semana05.herencia.Clase1;
import pe.edu.uni.semana05.herencia.Clase2;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class Prueba03 {
	
	public static void main(String[] args) {
		Clase1 bean = new Clase2();
		bean.mostrarNombre();
		System.out.println("Suma: " + bean.sumar(8, 7));
	}

}
