package pe.edu.uni.semana05.prueba;

import pe.edu.uni.semana05.implementation.MateService;
import pe.edu.uni.semana05.specification.MateAbstract;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class Prueba07 {
	
	public static void main(String[] args) {
		MateAbstract bean = new MateService();
		System.out.println("2^4 = " + bean.potencia(2, 4));
	}

}
