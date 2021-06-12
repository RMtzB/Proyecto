package mx.uam.ayd.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.dto.GrupoDto;
import mx.uam.ayd.proyecto.negocio.ServicioGrupo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1") // Versionamiento
@Slf4j
public class GrupoRestController {
	@Autowired
	private ServicioGrupo servicioGrupo;
	
	@GetMapping(path = "/grupos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<GrupoDto>> retrieveAll() {
		List<GrupoDto> grupos = servicioGrupo.recuperaGrupos();
		
		return ResponseEntity.status(HttpStatus.OK).body(grupos);
	}
}
