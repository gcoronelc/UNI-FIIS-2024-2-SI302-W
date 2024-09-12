package pe.edu.uni.poosemana03.service;

import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.poosemana03.dto.ProductoDto;

public class ProductoService {
    
    private static List<ProductoDto> lista;
    
    static{
        lista = new ArrayList<>();
        lista.add(new ProductoDto("Televisor", 3500.0, 50));
        lista.add(new ProductoDto("Laptop", 5500.0, 120));
        lista.add(new ProductoDto("Impresora", 800.0, 140));
        lista.add(new ProductoDto("Mueble para computo", 850.0, 80));
        lista.add(new ProductoDto("Celular", 1200.0, 65));
    }
    
    public List<ProductoDto> getProductos(){
        return lista;
    }
    
}
