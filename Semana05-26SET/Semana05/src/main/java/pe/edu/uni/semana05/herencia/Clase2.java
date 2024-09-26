package pe.edu.uni.semana05.herencia;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class Clase2 extends Clase1 {

	public Clase2() {
		super("Claudia");
		System.out.println("Hola desde Clase2.");
	}
	
	
	
		  
	public String nombre = "Eric Coronel";

	@Override
	public void mostrarNombre() {
		System.out.println("Hola (super) " + super.nombre);
		System.out.println("Hola (this) " + this.nombre);
	}

	@Override
	public int sumar(int n1, int n2) {
		return (n1 * n2) / (n1 - n2);
	}

	public long factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}

}
