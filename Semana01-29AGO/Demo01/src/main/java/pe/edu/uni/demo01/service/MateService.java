package pe.edu.uni.demo01.service;

public class MateService {

    // Servicio 1
    public int sumar(int n1, int n2) {
        return (n1 + n2);
    }

    // Servicio 2
    public int multiplicar(int n1, int n2) {
        return (n1 * n2);
    }
    
    //Servicio 3
    // Método recursivo para calcular el factorial
    public long factorial(int n) {
        if (n == 0) {
            return 1; // El factorial de 0 es 1
        } else {
            return n * factorial(n - 1); // Llamada recursiva
        }
    }

}
