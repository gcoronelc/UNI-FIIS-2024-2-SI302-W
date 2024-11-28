package pe.edu.uni.app.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SeguridadService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Map<String,Object> validar(String usuario, String clave){
		String sql = """
			select chr_emplcodigo codigo, vch_emplpaterno paterno,
			vch_emplmaterno materno, vch_emplnombre nombre 
			from empleado
			where vch_emplusuario = ? and vch_emplclave = ?				
		""";
		Map<String,Object> rec;
		try {
			rec = jdbcTemplate.queryForMap(sql, usuario, clave);
		} catch (Exception e) {
			rec = null;
		}
		return rec;
	}
}
