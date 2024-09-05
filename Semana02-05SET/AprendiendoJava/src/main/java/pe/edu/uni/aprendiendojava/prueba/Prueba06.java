package pe.edu.uni.aprendiendojava.prueba;

import pe.edu.uni.aprendiendojava.service.VentaService;

public class Prueba06 {

    public static void main(String[] args) {
        
        VentaService service = new VentaService();
        
       
        System.out.println("Precio: " + service.getPrecio());
        System.out.println("Cantidad: " + service.getCantidad());
        System.out.println("Importe: " + service.getImporte());
        System.out.println("Impuesto: " + service.getImpuesto());
        System.out.println("Total: " + service.getTotal());
    }

}
