package pe.edu.uni.demo01.prueba;

import pe.edu.uni.demo01.service.MateService;

public class Prueba01 {
    
    public static void main(String[] args) {
        // Datos
        int n1 = 40;
        int n2 = 30;
        // Proceso
        MateService service = new MateService();
        int suma = service.sumar(n1, n2);
        // Reporte
        System.out.println("Numero 1: " + n1);
        System.out.println("Numero 2: " + n2);
        System.out.println("Suma: " + suma);
    }
       
}
