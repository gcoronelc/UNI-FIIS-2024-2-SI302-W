package pe.edu.uni.app.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.uni.app.service.SeguridadService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/seguridad")
public class SeguridadRest {
	
	@Autowired
	private SeguridadService seguridadService;

	@PostMapping("/logon")
	public ResponseEntity<?> logon(String usuario, String clave){
		Map<String,Object> rec = seguridadService.validar(usuario, clave);
		if(rec!=null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(rec);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Usuario no existe. ");
		}
	}
}
