package pe.edu.uni.demo01.prueba;

import pe.edu.uni.demo01.service.MateService;

public class Prueba03 {
    
    public static void main(String[] args) {
        // Datos
        int n = 5;
        // Proceso
        MateService service = new MateService();
        long factorial = service.factorial(n);
        
        // Reporte
        System.out.println("Numero : " + n);
        System.out.println("factorial: " + factorial);
    }
       
}
