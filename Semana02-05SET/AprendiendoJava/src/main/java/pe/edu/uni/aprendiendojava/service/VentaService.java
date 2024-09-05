package pe.edu.uni.aprendiendojava.service;

public class VentaService {

    private double precio;
    private int cantidad;

    /**
     * Constructor por defecto
     */
    public VentaService() {
        this.precio = 1000.00;
        this.cantidad = 20;
        System.out.println("Objeto creado.");
    }

    /**
     * Constructor adocional
     * @param precio Precio del producto.
     * @param cantidad Cantidad vendida
     */
    public VentaService(double precio, int cantidad) {
        this.precio = precio;
        this.cantidad = cantidad;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Chau objeto.");
    }
    
    

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return (precio * cantidad);
    }

    public double getImporte() {
        return (getTotal() / 1.18);
    }

    public double getImpuesto() {
        return this.getTotal() - this.getImporte();
    }
}
