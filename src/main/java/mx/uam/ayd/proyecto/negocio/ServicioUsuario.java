package mx.uam.ayd.proyecto.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.UsuarioRepository;
import mx.uam.ayd.proyecto.dto.UsuarioDto;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

@Slf4j
@Service
public class ServicioUsuario {

	@Autowired
	private UsuarioRepository usuarioRepository;

	/**
	 * 
	 * Permite agregar un usuario
	 * 
	 * @param nombre
	 * @param apellido
	 * @param grupo
	 * @return
	 */
	public UsuarioDto agregaUsuario(UsuarioDto usuarioDto) {
		// Regla de negocio: No se permite agregar dos usuarios con el mismo nombre y
		// apellido
		System.out.println(usuarioDto.getNombre());

		Usuario usuario = usuarioRepository.findByNombreAndApellido(usuarioDto.getNombre(), usuarioDto.getApellido());

		if (usuario != null) {
			throw new IllegalArgumentException("Ese usuario ya existe");
		}


		usuario = new Usuario();
		usuario.setNombre(usuarioDto.getNombre());
		usuario.setApellido(usuarioDto.getApellido());
		usuario.setNombreUsuario(usuarioDto.getNombreUsuario());

		usuario = usuarioRepository.save(usuario);

		usuarioDto.setIdUsuario(usuario.getIdUsuario());

		return usuarioDto;
	}

	public UsuarioDto recuperarUsuario(Long id) {
		Usuario usuario = usuarioRepository.findByIdUsuario(id);

		if (usuario == null) {
			throw new IllegalArgumentException("El usuario no existe");
		}

		return UsuarioDto.creaDto(usuario);
	}
}
