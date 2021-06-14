package mx.uam.ayd.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.ResponseEntity;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.dto.UsuarioDto;
import mx.uam.ayd.proyecto.dto.UsuarioidDto;
import mx.uam.ayd.proyecto.negocio.ServicioUsuario;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1") // Versionamiento
@Slf4j
public class UsuarioRestController{

	@Autowired
	private ServicioUsuario servicioUsuarios;

	/**
	 * Verifica si el usuario tiene permitido inciar sesión
	 * 
	 * @return
	 */
	@PostMapping(path = "/usuarios", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioidDto> create(@RequestBody UsuarioDto usuario) {
		try {
			UsuarioidDto usuarioDto = servicioUsuarios.iniciarSesion(usuario);
			return ResponseEntity.status(HttpStatus.OK).body(usuarioDto);
				
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
