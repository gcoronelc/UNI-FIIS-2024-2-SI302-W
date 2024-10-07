package pe.edu.uni.educa2024.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.uni.educa2024.db.AccesoDB;
import pe.edu.uni.educa2024.dto.MatriculaDto;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class EducaService {

	public MatriculaDto procMatricula(MatriculaDto bean) {
		Connection cn = null;
		PreparedStatement pstm;
		String sql;
		int cont;
		try {
			// Inicio de Tx
			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false); // Inicio de Tx
			// Validar el curso
			double precio = validarCurso(cn, bean.getIdCurso());
			// Validar alumno
			validarAlumno(cn, bean.getIdAlumno());
			// Validar empleado
			validarEmpleado(cn, bean.getIdEmpleado());
			// Validar si ya existe la matricula
			validarMatricula(cn, bean.getIdCurso(), bean.getIdAlumno());
			// Validar tipo
			String tipo = bean.getTipo().toUpperCase().trim();
			int index = "REGULAR,MEDIABECA,BECA".indexOf(tipo);
			if (index == -1) {
				throw new SQLException("Tipo de matricula incorrecto.");
			}
			// Validar cuotas
			if (bean.getCuotas() < 1 || bean.getCuotas() > 3) {
				throw new SQLException("Número de cuotas incorrecto.");
			}
			if (!tipo.equals("REGULAR") && bean.getCuotas() != 1) {
				throw new SQLException("Número de cuotas incorrecto.");
			}
			// Determinar precio
			precio = switch (tipo) {
				case "REGULAR" ->
					precio;
				case "MEDIABECA" ->
					precio / 2;
				case "BECA" ->
					precio * 0.10;
				default ->
					precio;
			};
			// Registrar matricula
			sql = "insert into matricula(cur_id,alu_id,emp_id,mat_tipo,";
			sql += "mat_fecha,mat_precio,mat_cuotas) ";
			sql += "values(?,?,?,?,getdate(),?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, bean.getIdCurso());
			pstm.setInt(2, bean.getIdAlumno());
			pstm.setInt(3, bean.getIdEmpleado());
			pstm.setString(4, tipo);
			pstm.setDouble(5, precio);
			pstm.setInt(6, bean.getCuotas());
			pstm.executeUpdate();
			pstm.close();
			// Actualizar el curso
			sql = """
				update curso 
				set cur_matriculados = cur_matriculados + 1
				where cur_id =?
         """;
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, bean.getIdCurso());
			cont = pstm.executeUpdate();
			pstm.close();
			if(cont==0){
				throw new SQLException("No se pudo actualizar el curso.");
			}
			// Confirmar la Tx
			cn.commit();
			bean.setPrecio(precio);
		} catch (SQLException e) {
			try {
				cn.rollback(); // Cancelar la Tx
			} catch (Exception e1) {
			}
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			try {
				cn.rollback(); // Cancelar la Tx
			} catch (Exception e1) {
			}
			throw new RuntimeException("Error en el proceso, intentelo mas tarde!!");
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return bean;
	}

	private double validarCurso(Connection cn, int idCurso) throws SQLException {
		String sql = "select cur_precio from  curso where cur_id=?";
		PreparedStatement pstm = cn.prepareStatement(sql);
		pstm.setInt(1, idCurso);
		ResultSet rs = pstm.executeQuery();
		if (!rs.next()) {
			throw new SQLException("Curso no existe.");
		}
		double precio = rs.getDouble("cur_precio");
		rs.close();
		pstm.close();
		return precio;
	}

	private void validarAlumno(Connection cn, int idAlumno) throws SQLException {
		String sql = "select count(1) cont from alumno where alu_id=?";
		PreparedStatement pstm = cn.prepareStatement(sql);
		pstm.setInt(1, idAlumno);
		ResultSet rs = pstm.executeQuery();
		rs.next();
		int cont = rs.getInt("cont");
		rs.close();
		pstm.close();
		if (cont != 1) {
			throw new SQLException("Alumno no existe.");
		}
	}

	private void validarEmpleado(Connection cn, int idEmpleado) throws SQLException {
		String sql = "select count(1) cont from empleado where emp_id=?";
		PreparedStatement pstm = cn.prepareStatement(sql);
		pstm.setInt(1, idEmpleado);
		ResultSet rs = pstm.executeQuery();
		rs.next();
		int cont = rs.getInt("cont");
		rs.close();
		pstm.close();
		if (cont != 1) {
			throw new SQLException("Empleado no existe.");
		}
	}

	private void validarMatricula(Connection cn, int idCurso, int idAlumno) throws SQLException {
		String sql = "select count(1) cont from matricula where cur_id=? and alu_id=?";
		PreparedStatement pstm = cn.prepareStatement(sql);
		pstm.setInt(1, idCurso);
		pstm.setInt(2, idAlumno);
		ResultSet rs = pstm.executeQuery();
		rs.next();
		int cont = rs.getInt("cont");
		rs.close();
		pstm.close();
		if (cont > 0) {
			throw new SQLException("Matricula ya esta registrada.");
		}
	}

}
