package mx.uam.ayd.proyecto.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.AvisoRepository;

@Slf4j
@Service
public class ServicioAviso {
	@Autowired
	private AvisoRepository avisoRepository;


}
