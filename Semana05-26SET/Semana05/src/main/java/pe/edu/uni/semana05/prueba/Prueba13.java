package pe.edu.uni.semana05.prueba;

import pe.edu.uni.semana05.implementation.VentaService;
import pe.edu.uni.semana05.specification.VentaSpec;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class Prueba13 {

	public static void main(String[] args) {
		// Datos
		double precio = 56.80;
		int cantidad = 8;
		// Reporte
		VentaSpec ventaSpec = new VentaService();
		System.out.println("Importe: " + ventaSpec.calcImporte(precio, cantidad));
		System.out.println("Impuesto: " + ventaSpec.calcImpuesto(precio, cantidad));
		System.out.println("Total: " + ventaSpec.calcTotal(precio, cantidad));

	}
}
