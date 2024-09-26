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
public class Clase1 {

	public Clase1() {
		System.out.println("Hola desde Clase1.");
	}
	
	public Clase1(String nombre) {
		System.out.println("Hola " + nombre + ".");
	}
	
	public String nombre = "Gustavo Coronel";
	
	public void mostrarNombre(){
		System.out.println("Hola " + nombre);
	}
	
	
	/**
	 * Metodo que permite sumar 2 numeros enteros.
	 * @param n1 Numero 1.
	 * @param n2 Numero 2.
	 * @return Retorna la suma de n1 y n2.
	 */
	public int sumar(int n1, int n2){
		return (n1+n2);
	}

}
