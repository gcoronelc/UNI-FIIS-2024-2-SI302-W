package pe.edu.uni.educaapp.prueba;

import java.sql.Connection;
import pe.edu.uni.educaapp.db.AccesoDB;

public class Prueba01 {
    
    public static void main(String[] args) {
        try {
            Connection cn = AccesoDB.getConnection();
            System.out.println("Conexión ok!!!!!");
            cn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
