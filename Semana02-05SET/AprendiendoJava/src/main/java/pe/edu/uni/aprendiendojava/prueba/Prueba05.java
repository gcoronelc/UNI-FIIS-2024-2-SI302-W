package pe.edu.uni.aprendiendojava.prueba;

import pe.edu.uni.aprendiendojava.service.VentaService;

public class Prueba05 {

    public static void main(String[] args) {
        
        VentaService service = new VentaService();
        
        service.setPrecio(798.00);
        service.setCantidad(7);
        
        System.out.println("Importe: " + service.getImporte());
        System.out.println("Impuesto: " + service.getImpuesto());
        System.out.println("Total: " + service.getTotal());
    }

}
