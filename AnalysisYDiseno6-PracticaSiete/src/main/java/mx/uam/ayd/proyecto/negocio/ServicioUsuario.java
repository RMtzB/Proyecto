package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.GrupoRepository;
import mx.uam.ayd.proyecto.datos.UsuarioRepository;
import mx.uam.ayd.proyecto.dto.UsuarioDto;
import mx.uam.ayd.proyecto.negocio.modelo.Grupo;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

@Slf4j
@Service
public class ServicioUsuario {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private GrupoRepository grupoRepository;

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

		Optional<Grupo> optGrupo = grupoRepository.findById(usuarioDto.getGrupo());

		if (optGrupo.isEmpty()) {
			throw new IllegalArgumentException("No se encontró el grupo");
		}

		Grupo grupo = optGrupo.get();

		log.info("Agregando usuario nombre: " + usuarioDto.getNombre() + " apellido:" + usuarioDto.getApellido());

		usuario = new Usuario();
		usuario.setNombre(usuarioDto.getNombre());
		usuario.setApellido(usuarioDto.getApellido());
		usuario.setEdad(usuarioDto.getEdad());

		usuario = usuarioRepository.save(usuario);

		if (grupo.addUsuario(usuario)) {
			usuario.setGrupo(grupo);
		} else {
			throw new IllegalArgumentException("Un usuario no puede estar dos veces en un grupo");
		}

		grupoRepository.save(grupo);

		usuarioDto.setIdUsuario(usuario.getIdUsuario());

		return usuarioDto;
	}

	/**
	 * Recupera todos los usuarios existentes
	 * 
	 * @return Una lista con los usuarios (o lista vacía)
	 */
	public List<UsuarioDto> recuperaUsuarios() {
		System.out.println("usuarioRepository = " + usuarioRepository);

		List<UsuarioDto> usuarios = new ArrayList<>();

		for (Usuario usuario : usuarioRepository.findAll()) {
			usuarios.add(UsuarioDto.creaDto(usuario));
		}

		return usuarios;
	}

	public UsuarioDto recuperarUsuario(Long id) {
		Usuario usuario = usuarioRepository.findByIdUsuario(id);

		if (usuario == null) {
			throw new IllegalArgumentException("El usuario no existe");
		}

		return UsuarioDto.creaDto(usuario);
	}

	public UsuarioDto eliminarUsuario(Long id) {
		Usuario usuario = usuarioRepository.findByIdUsuario(id);

		if (usuario == null) {
			throw new IllegalArgumentException("El usuario no se pudo eliminar");
		}
		
		usuario.getGrupo().removeUsuario(usuario);
		usuarioRepository.deleteById(id);
		
		return UsuarioDto.creaDto(usuario);
	}

	public UsuarioDto actualizarUsuario(Long id, UsuarioDto usuarioDto) {
		Usuario usuario = usuarioRepository.findByIdUsuario(id);

		if (usuario == null) {
			throw new IllegalArgumentException("El usuario no existe");
		}

		usuario.setNombre(usuarioDto.getNombre());
		usuario.setApellido(usuarioDto.getApellido());
		usuario.setEdad(usuarioDto.getEdad());
		
		if(usuario.getGrupo().getIdGrupo() == usuarioDto.getGrupo()) {
			UsuarioDto usuarioActualizado = UsuarioDto.creaDto(usuarioRepository.save(usuario));
			
			return usuarioActualizado;
		}

		Optional<Grupo> optGrupo = grupoRepository.findById(usuarioDto.getGrupo());

		if (optGrupo.isEmpty()) {
			throw new IllegalArgumentException("No se encontró el grupo");
		}

		Grupo grupo = optGrupo.get();
		
		usuario = usuarioRepository.save(usuario);

		if (grupo.addUsuario(usuario)) {
			usuario.setGrupo(grupo);
		} else {
			throw new IllegalArgumentException("Un usuario no puede estar dos veces en un grupo");
		}

		grupoRepository.save(grupo);

		usuarioDto.setIdUsuario(usuario.getIdUsuario());

		return usuarioDto;
	}
}
