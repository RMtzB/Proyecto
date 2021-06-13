package mx.uam.ayd.proyecto.servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.dto.AvisoidDto;
import mx.uam.ayd.proyecto.negocio.ServicioUsuario;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1") // Versionamiento
@Slf4j
public class AvisoRestController {
	
	@Autowired
	private ServicioUsuario servicioAviso;
	
	@PostMapping(path = "/avisos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AvisoidDto> create(@RequestBody AvisoidDto usuario) {
		System.out.println("entro a get");
		try {
			AvisoidDto avisoDto = servicioAviso.crearAviso(usuario);
			return ResponseEntity.status(HttpStatus.OK).body(avisoidDto);
				
		} catch (Exception ex) {
			HttpStatus status;

			if (ex instanceof IllegalArgumentException) {
				status = HttpStatus.BAD_REQUEST;
			} else {
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
			throw new ResponseStatusException(status, ex.getMessage());
		}

	}
}
