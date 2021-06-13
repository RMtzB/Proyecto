package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Publicacion;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

public interface PublicacionRepository extends CrudRepository <Publicacion, Long>{
	public Publicacion findByIdPublicacion(Long id);
	public Publicacion findByTitulo(String titulo);
}
