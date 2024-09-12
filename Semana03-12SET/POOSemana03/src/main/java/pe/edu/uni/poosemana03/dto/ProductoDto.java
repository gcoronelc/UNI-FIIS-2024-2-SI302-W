package pe.edu.uni.poosemana03.dto;

public class ProductoDto {
    
    private String nombre;
    private double precio;
    private int stock;

    public ProductoDto() {
        //this.nombre = "Televisor";
        //this.precio = 3500.00;
        //this.stock = 50;
        this("Laptop", 5790.0, 80);
    }

    public ProductoDto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    /*
    @Override
    public String toString() {
        String repo = "(";
        repo += "nombre:" + this.nombre;
        repo += ", precio:" + this.precio;
        repo += ", stock:" + this.stock;
        repo += ")";
        return repo;
    }
*/

    @Override
    public String toString() {
        return this.nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    

    
    
    
    
}
