package pe.edu.uni.semana05.implementation;

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
public class MateService extends MateAbstract {

	@Override
	public long potencia(int base, int exponente) {
		// Revisar este condicional
		if(exponente < 0){
			throw new RuntimeException("No se acepta exponentes negativos.");
		}
		if (exponente == 0) {
			return 1;
		}
		return base * potencia(base, exponente - 1);
	}

}
