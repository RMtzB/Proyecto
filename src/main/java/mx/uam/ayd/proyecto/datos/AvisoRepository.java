package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Aviso;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

public interface AvisoRepository extends CrudRepository <Aviso, Long> {
		
}
