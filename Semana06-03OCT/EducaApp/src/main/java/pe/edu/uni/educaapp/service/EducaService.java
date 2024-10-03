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

    
    public MatriculaDto procMatricula(MatriculaDto bean){
        Connection cn = null;
        PreparedStatement pstm;
        ResultSet rs;
        String sql;
        double precio;
        String tipo;
        int filas;
        try {
            // Inicio de Tx
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            // Validaciones
            
            
            
            
            // Precio del curso
            sql = "select cur_precio from  curso where cur_id=?";
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, bean.getIdCurso());
            rs = pstm.executeQuery();
            if(!rs.next()){
                throw new SQLException("No existe el curso.");
            }
            precio = rs.getDouble("cur_precio");
            rs.close();
            pstm.close();
            // Determinar precio final
            tipo = bean.getTipo().toUpperCase();
            precio = switch (tipo) {
                case "BECA" -> 0.0;
                case "MEDIABECA" -> precio/2;
                default -> precio;
            };
            // Registrar matricula
            sql = "insert into matricula(cur_id,alu_id,emp_id,mat_tipo,";
            sql += "mat_fecha,mat_precio,mat_cuotas) ";
            sql += "values(?,?,?,?,getdate(),?,?)";
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, bean.getIdCurso());
            pstm.setInt(2, bean.getIdAlumno());
            pstm.setInt(3, bean.getIdEmpleado());
            pstm.setString(4, bean.getTipo());
            pstm.setDouble(5, bean.getPrecio());
            pstm.setInt(6, bean.getCuotas());
            pstm.executeUpdate();
            pstm.close();
            // Incrementar los matriculados
            sql = "update curso set cur_matriculados = cur_matriculados + 1 ";
            sql += "where cur_id =?";
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, bean.getIdCurso());
            filas = pstm.executeUpdate();
            if(filas != 1){
                throw new SQLException("Error en el codigo del curso.");
            }
            // Confirmar Tx
            cn.commit();
            bean.setPrecio(precio);
        } catch (SQLException e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            throw new RuntimeException("Error en el proceso, intentelo nuevamente!!!");
        } finally{
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return bean;
    }
}
