package mx.uam.ayd.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.dto.PublicacionDto;
import mx.uam.ayd.proyecto.dto.PublicacionParcialDto;
import mx.uam.ayd.proyecto.dto.comentarioDto;
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
		List<PublicacionParcialDto> publicaciones = servicioPublicacion.recuperaPublicaciones();

		return ResponseEntity.status(HttpStatus.OK).body(publicaciones);
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
		
	@PostMapping(path = "/publicaciones", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PublicacionParcialDto> create(@RequestBody PublicacionDto nuevaPublicacion) {
		System.out.println("crearpublicacion");

		try {
			PublicacionParcialDto publicacionDto = servicioPublicacion.agregaPublicacion(nuevaPublicacion);
			System.out.println("puede jalar");
			return ResponseEntity.status(HttpStatus.CREATED).body(publicacionDto);
		} catch (Exception ex) {
			HttpStatus status;

			if (ex instanceof IllegalArgumentException) {
				System.out.println("badrequest");
				status = HttpStatus.BAD_REQUEST;
			} else {
				System.out.println("internal");
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}

			throw new ResponseStatusException(status, ex.getMessage());
		}

	}
	
	@PatchMapping(path = "/publicaciones/{id}/{comentario}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<comentarioDto> retrieve(@PathVariable("id") Long id,@PathVariable("comentario") String comentario) {
		try {
			System.out.println(comentario);
			comentarioDto aux=servicioPublicacion.añadirComentario(id,comentario);
			return ResponseEntity.status(HttpStatus.OK).body(aux);
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
}

