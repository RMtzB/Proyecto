package mx.uam.ayd.proyecto.datos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Publicacion;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

public interface PublicacionRepository extends CrudRepository <Publicacion, Long>{
	public Publicacion findByIdPublicacion(Long id);
	public List<Publicacion>  findByIdUsuario(Long idUsuario);
	public Publicacion findByTitulo(String titulo);
}
