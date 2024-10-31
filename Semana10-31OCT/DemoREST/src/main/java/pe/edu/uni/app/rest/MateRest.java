package pe.edu.uni.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.uni.app.service.MateService;

@RestController
@RequestMapping("/mate")
public class MateRest {
	
	@Autowired
    private MateService mateService;

	@GetMapping("/suma")
    public int suma(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }
	
	@GetMapping("/factorial/{numero}")
    public ResponseEntity<?> calcularFactorial(@PathVariable int numero) {
		try {
			long resultado = mateService.calcularFactorial(numero);
			return ResponseEntity.ok(resultado);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		} 
    }
	
}
