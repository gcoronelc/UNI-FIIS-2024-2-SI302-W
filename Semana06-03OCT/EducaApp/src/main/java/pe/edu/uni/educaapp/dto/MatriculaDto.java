package pe.edu.uni.educaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class MatriculaDto {

    private int idCurso;
    private int idAlumno;
    private int idEmpleado;
    private String tipo;
    private String fecha;
    private double precio;
    private int cuotas;
    private int nota;

}
