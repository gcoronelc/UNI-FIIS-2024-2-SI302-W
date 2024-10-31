package pe.edu.uni.app.service;

import org.springframework.stereotype.Service;

@Service
public class MateService {

	public long calcularFactorial(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo.");
        }
        long resultado = 1;
        for (int i = 1; i <= numero; i++) {
            resultado *= i;
        }
        return resultado;
    }
	
}
