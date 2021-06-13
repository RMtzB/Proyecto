package mx.uam.ayd.proyecto.servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.negocio.ServicioUsuario;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1") // Versionamiento
@Slf4j
public class AvisoRestController {
	
	@Autowired
	private ServicioUsuario servicioAviso;
	

}
