package pe.edu.uni.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.uni.app.dto.TransferenciaDto;

@Service
public class CuentaService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String,Object>> consultaMovimientos(String cuenta){
		String sql = """
			select int_movinumero nro, dtt_movifecha fecha, 
			chr_tipocodigo tipo, dec_moviimporte importe
			from Movimiento
			where chr_cuencodigo = ?
		""";
		List<Map<String,Object>> lista;
		lista = jdbcTemplate.queryForList(sql, cuenta);
		return lista;
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public TransferenciaDto transferencia(TransferenciaDto bean) {
		// Validaciones
		validarCuentaExiste(bean.getCuentaOrigen());
		validarCuentaExiste(bean.getCuentaDestino());
		if(bean.getCuentaOrigen().equals(bean.getCuentaDestino())) {
			throw new RuntimeException("Las 2 cuentas no pueden ser iguales.");
		}
		validarMismaMoneda(bean.getCuentaOrigen(),bean.getCuentaDestino());
		
		// Proceso
		int contOrigen = actualizarSaldoCuenta(bean.getCuentaOrigen(), -1*bean.getImporte());
		int contDestino = actualizarSaldoCuenta(bean.getCuentaDestino(), bean.getImporte());
		registrarMovimiento(bean.getCuentaOrigen(),contOrigen,bean.getEmpleado(),
				"009",bean.getImporte(),bean.getCuentaDestino());
		registrarMovimiento(bean.getCuentaDestino(),contDestino,bean.getEmpleado(),
				"008",bean.getImporte(),bean.getCuentaOrigen());
		
		
		// Reporte final
		System.out.println("Proceso ok.");
		return bean;
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
	private void registrarMovimiento(String cuenta, int cont, String empleado, String tipo,
			Double importe, String referencia) {
		String sql = """
			insert into movimiento(chr_cuencodigo,int_movinumero,dtt_movifecha,
			chr_emplcodigo,chr_tipocodigo,dec_moviimporte,chr_cuenreferencia)
			values(?,?,getdate(),?,?,?,?)				
		""";
		jdbcTemplate.update(sql,cuenta,cont,empleado,tipo,importe,referencia);
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
	private int actualizarSaldoCuenta(String cuenta, double importe) {
		String sql = """
			update cuenta 
			set dec_cuensaldo = dec_cuensaldo + ?, 
			int_cuencontmov = int_cuencontmov + 1
			where chr_cuencodigo = ?				
		""";
		int filas = jdbcTemplate.update(sql, importe, cuenta);
		if(filas != 1) {
			throw new RuntimeException("La cuenta " + cuenta + " no existe o esta inhabilitada.");
		}
		sql = "select int_cuencontmov from cuenta where chr_cuencodigo=?";
		int cont = jdbcTemplate.queryForObject(sql, Integer.class, cuenta);
		return cont;
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
	private void validarMismaMoneda(String cuentaOrigen, String cuentaDestino) {
		String sql = """
			with 
			t1 as (
				select chr_monecodigo m1 from Cuenta where chr_cuencodigo=?
			),
			t2 as (
				select chr_monecodigo m2 from Cuenta where chr_cuencodigo=?
			)
			select count(1) cont from t1 join t2 on t1.m1=t2.m2				
		""";
		int cont = jdbcTemplate.queryForObject(sql, Integer.class, cuentaOrigen, cuentaDestino);
		if(cont==0) {
			throw new RuntimeException("Las cuentas deben ser de la misma moneda.");
		}
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
	private void validarCuentaExiste(String cuenta) {
		String sql = """
			select count(1) cont from cuenta 
			where chr_cuencodigo=? and vch_cuenestado='ACTIVO'
		""";
		int cont = jdbcTemplate.queryForObject(sql, Integer.class, cuenta);
		if(cont != 1) {
			throw new RuntimeException("Cuenta " + cuenta  + " no existe.");
		}
	}

}
