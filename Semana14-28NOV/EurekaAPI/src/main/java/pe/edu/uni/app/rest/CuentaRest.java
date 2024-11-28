package pe.edu.uni.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.uni.app.dto.TransferenciaDto;
import pe.edu.uni.app.service.CuentaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/cuentas")
public class CuentaRest {

	@Autowired
	private CuentaService cuentaService;
	
	@PostMapping("/transferencia")
	public ResponseEntity<?> transferencia(@RequestBody TransferenciaDto bean){
		try {
			bean = cuentaService.transferencia(bean);
			return ResponseEntity.status(HttpStatus.CREATED).body(bean);
		} catch (Exception e) {
			// Manejo de excepción y respuesta con error 500
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Error en el proceso: " + e.getMessage());
		}		
	}
	
	
}
