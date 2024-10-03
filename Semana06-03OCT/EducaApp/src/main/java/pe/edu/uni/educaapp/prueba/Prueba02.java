package pe.edu.uni.educaapp.prueba;

import java.util.List;
import pe.edu.uni.educaapp.dto.MatriculaDto;
import pe.edu.uni.educaapp.service.EducaService;

public class Prueba02 {
    
    public static void main(String[] args) {
        try {
            EducaService service = new EducaService();
            List<MatriculaDto> lista = service.conMatricula(1);
            for (MatriculaDto bean : lista) {
                System.out.println(bean);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
