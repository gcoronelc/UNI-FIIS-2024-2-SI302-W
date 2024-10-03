package pe.edu.uni.educaapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.educaapp.db.AccesoDB;
import pe.edu.uni.educaapp.dto.MatriculaDto;

public class EducaService {


    public List<MatriculaDto> conMatricula(int idCurso){
        List<MatriculaDto> lista = new ArrayList<>();
        String sql = "select cur_id, alu_id, emp_id, mat_tipo,";
        sql += "convert(varchar(20),mat_fecha,103) mat_fecha,";
        sql += "mat_precio, mat_cuotas, mat_nota ";
        sql += "from MATRICULA where cur_id=?";
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            cn = AccesoDB.getConnection();
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, idCurso);
            rs = pstm.executeQuery();
            while(rs.next()){
                MatriculaDto bean = new MatriculaDto();
                bean.setIdCurso(rs.getInt("cur_id"));
                bean.setIdAlumno(rs.getInt("alu_id"));
                bean.setFecha(rs.getString("mat_fecha"));
                bean.setTipo(rs.getString("mat_tipo"));
                bean.setPrecio(rs.getDouble("mat_precio"));
                bean.setCuotas(rs.getInt("mat_cuotas"));
                bean.setNota(rs.getInt("mat_nota"));
                lista.add(bean);
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error en el proceso, intentelo nuevamenet!!!");
        } finally{
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return lista;
    }

    
}
