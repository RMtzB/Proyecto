package mx.uam.ayd.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.dto.PublicacionDto;
import mx.uam.ayd.proyecto.dto.PublicacionParcialDto;
import mx.uam.ayd.proyecto.negocio.ServicioPublicacion;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1") // Versionamiento
@Slf4j
public class PublicacionRestController {
	
	@Autowired
	private ServicioPublicacion servicioPublicacion;
	
	@GetMapping(path = "/publicaciones", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PublicacionParcialDto>> retrieveAll() {
		List<PublicacionParcialDto> usuarios = servicioPublicacion.recuperaPublicaciones();

		return ResponseEntity.status(HttpStatus.OK).body(usuarios);
	}
	
	
	@GetMapping(path = "/publicaciones/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PublicacionDto> retrieve(@PathVariable("id") Long id) {
		try {
			PublicacionDto publicacion = servicioPublicacion.recuperaPublicacion(id);
			return ResponseEntity.status(HttpStatus.OK).body(publicacion);
		} catch (Exception ex) {
			HttpStatus status;

			if (ex instanceof IllegalArgumentException) {
				status = HttpStatus.NOT_FOUND;
			} else {
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}

			throw new ResponseStatusException(status, ex.getMessage());
		}
	}
		
	@PostMapping(path = "/publicacion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PublicacionParcialDto> create(@RequestBody PublicacionDto nuevaPublicacion) {

		try {
			PublicacionParcialDto publicacionDto = servicioPublicacion.agregaPublicacion(nuevaPublicacion);

			return ResponseEntity.status(HttpStatus.CREATED).body(publicacionDto);
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

