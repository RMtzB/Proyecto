package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Aviso;
import mx.uam.ayd.proyecto.negocio.modelo.Publicacion;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

public interface AvisoRepository extends CrudRepository <Aviso, Long> {
	public Aviso findByTitulo(String titulo);
	public Aviso findByIdAviso(Long id);
}
