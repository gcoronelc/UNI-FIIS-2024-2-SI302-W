package pe.edu.uni.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.uni.app.dto.ClienteDto;
import pe.edu.uni.app.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRest {

	@Autowired
	private ClienteService clienteService;

	@PostMapping()
	public ResponseEntity<?> registrarCliente(@RequestBody ClienteDto bean) {
		try {
			bean = clienteService.registrarCliente(bean);
			return ResponseEntity.status(HttpStatus.CREATED).body(bean);
		} catch (Exception e) {
			// Manejo de excepción y respuesta con error 500
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Error al registrar el cliente: " + e.getMessage());
		}
	}

}
