package pe.edu.uni.semana05.implementation;

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
public class VentaService implements VentaSpec{

	@Override
	public double calcTotal(double precio, int cantidad) {
		return (precio * cantidad);
	}

	@Override
	public double calcImporte(double precio, int cantidad) {
		return 0;
	}

	@Override
	public double calcImpuesto(double precio, int cantidad) {
		return 0;
	}

	

}
