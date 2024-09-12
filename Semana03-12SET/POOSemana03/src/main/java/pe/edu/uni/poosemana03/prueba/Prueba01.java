package pe.edu.uni.poosemana03.prueba;

import pe.edu.uni.poosemana03.service.MateService;

public class Prueba01 {

    public static void main(String[] args) {
        // Datos
        int n1 = 16;
        int n2 = 19;
        int n3 = 16;
        // Proceso
        MateService service = new MateService();
        int pr1 = service.calcPromedio(n1, n2);
        int pr2 = service.calcPromedio(n1, n2, n3);
        // Reporte
        System.out.println("Promedio 1: " + pr1);
        System.out.println("Promedio 2: " + pr2);
    }
    
}
