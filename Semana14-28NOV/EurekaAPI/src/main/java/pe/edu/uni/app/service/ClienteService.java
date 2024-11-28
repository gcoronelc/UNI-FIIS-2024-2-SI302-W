package pe.edu.uni.app.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.uni.app.dto.ClienteDto;

@Service
public class ClienteService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public ClienteDto registrarCliente(ClienteDto bean) {
		// Validar
		validarDatos(bean);
		// Datos del contador
		String sql = """
					select int_contitem, int_contlongitud
					from Contador where vch_conttabla = 'Cliente'
				""";
		Map<String, Object> contador = jdbcTemplate.queryForMap(sql);
		int conta = Integer.parseInt(contador.get("int_contitem").toString());
		int longitud = Integer.parseInt(contador.get("int_contlongitud").toString());
		// Generar codigo
		conta++;
		String codigo = String.format("%0" + longitud + "d", conta);
		// Actualiza contador
		sql = """
					update Contador
					set int_contitem = ?
					where vch_conttabla = 'Cliente'
				""";
		jdbcTemplate.update(sql, conta);
		// Registrar nuevo cliente
		sql = """
					insert into cliente(chr_cliecodigo,vch_cliepaterno,
					vch_cliematerno,vch_clienombre,chr_cliedni,
					vch_clieciudad,vch_cliedireccion,vch_clietelefono,
					vch_clieemail) values(?, ?, ?, ?, ?, ?, ?, ?, ?)
				""";
		Object[] datos = { codigo, bean.getPaterno(), bean.getMaterno(), bean.getNombre(), bean.getDni(),
				bean.getCiudad(), bean.getDireccion(), bean.getTelefono(), bean.getEmail() };
		jdbcTemplate.update(sql, datos);
		// Fina
		bean.setCodigo(codigo);
		return bean;
	}

	private void validarDatos(ClienteDto bean) {
		if (!esDNI(bean.getDni())) {
			throw new RuntimeException("El DNI no es correcto.");
		}
		
	}

	public static boolean esDNI(String cadena) {
		String regex = "^\\d{8}$";
		return cadena.matches(regex);
	}

}
