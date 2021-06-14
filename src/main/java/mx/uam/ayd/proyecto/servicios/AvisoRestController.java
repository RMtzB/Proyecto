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
import mx.uam.ayd.proyecto.dto.AvisoDto;
import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.dto.AvisoidDto;
import mx.uam.ayd.proyecto.dto.comentarioDto;
import mx.uam.ayd.proyecto.negocio.ServicioAviso;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1") // Versionamiento
@Slf4j
public class AvisoRestController {
	
	@Autowired
	private ServicioAviso servicioAviso;
	
	@GetMapping(path = "/avisos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AvisoidDto>> retrieveAll() {
		List<AvisoidDto> usuarios = servicioAviso.recuperaAvisos();
		return ResponseEntity.status(HttpStatus.OK).body(usuarios);
	}
		
	@GetMapping(path = "/avisos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AvisoDto> retrieve(@PathVariable("id") Long id) {
		try {
			AvisoDto aviso = servicioAviso.recuperaAviso(id);
			return ResponseEntity.status(HttpStatus.OK).body(aviso);
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

	@PostMapping(path = "/avisos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AvisoDto> create(@RequestBody AvisoDto nuevoAviso) {
		System.out.println(nuevoAviso.getComentarios()+"PincheNeurotico");
		try {
			AvisoDto avisoDto = servicioAviso.agregaAviso(nuevoAviso);
			return ResponseEntity.status(HttpStatus.CREATED).body(avisoDto);
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
	
	@PatchMapping(path = "/avisos/{id}/{comentario}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<comentarioDto> retrieve(@PathVariable("id") Long id,@PathVariable("comentario") String comentario) {
		try {
			comentarioDto aux=servicioAviso.añadirComentario(id,comentario);
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