package mx.uam.ayd.proyecto.datos;


import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

/**
 * 
 * Repositorio para usuarios
 * 
 * @author humbertocervantes
 *
 */
public interface UsuarioRepository extends CrudRepository <Usuario, Long> {
	
	public Usuario findByNombre(String nombre);
	
	public Usuario findByIdUsuario(Long id);
}
