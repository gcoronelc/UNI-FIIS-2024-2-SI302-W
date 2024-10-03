package pe.edu.uni.educaapp.prueba;

import java.util.List;
import pe.edu.uni.educaapp.dto.MatriculaDto;
import pe.edu.uni.educaapp.service.EducaService;

public class Prueba03 {
    
    public static void main(String[] args) {
        try {
            // Datos
            MatriculaDto bean = new MatriculaDto();
            bean.setIdCurso(1);
            bean.setIdAlumno(9);
            bean.setIdEmpleado(6);
            bean.setTipo("regular");
            bean.setCuotas(100);
            // Proceso
            EducaService service = new EducaService();
            bean = service.procMatricula(bean);
            System.out.println(bean);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
