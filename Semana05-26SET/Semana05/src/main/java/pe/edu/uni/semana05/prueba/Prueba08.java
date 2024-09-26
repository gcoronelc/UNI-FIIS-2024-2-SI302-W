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
public class Prueba08 {
	
	public static void main(String[] args) {
		
		MateAbstract bean = new MateAbstract() {
			@Override
			public long potencia(int base, int exponente) {
				long p=1;
				for (int i = 0; i < exponente; i++) {
					p *= base;
				}
				return p;
			}
		};
		
		System.out.println("" + bean.getClass());
		System.out.println("2^4 = " + bean.potencia(2, 4));
	}

}
