package pe.edu.uni.semana05.prueba;

import pe.edu.uni.semana05.herencia.Clase2;
import pe.edu.uni.semana05.herencia.Clase3;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class Prueba10 {

	public static void main(String[] args) {
		
		Clase2 bean = new Clase3();
		// DownCasting
		Clase3 alfa = (Clase3) bean;
		alfa.mostrarNombre();
	}
}
