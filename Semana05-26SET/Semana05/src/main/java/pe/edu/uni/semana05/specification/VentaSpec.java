package pe.edu.uni.semana05.specification;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public interface VentaSpec {

	double calcTotal(double precio, int cantidad);

	double calcImporte(double precio, int cantidad);

	double calcImpuesto(double precio, int cantidad);

}
