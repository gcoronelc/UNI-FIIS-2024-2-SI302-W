package pe.edu.uni.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferenciaDto {

	private String cuentaOrigen;
	private String cuentaDestino;
	private Double importe;
	private String clave;
	private String empleado;
	
}
