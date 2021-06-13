package mx.uam.ayd.proyecto.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.UsuarioRepository;
import mx.uam.ayd.proyecto.dto.UsuarioDto;
import mx.uam.ayd.proyecto.dto.UsuarioidDto;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

@Slf4j
@Service
public class ServicioUsuario {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioidDto iniciarSesion(UsuarioDto usuariodto) {
		Usuario usuario = usuarioRepository.findByNombre(usuariodto.getNombre());

		if (usuario == null) {
			throw new IllegalArgumentException("El usuario no existe");
		}
		
		if(!usuario.getContra().equals(usuario.getContra())) {
			throw new IllegalArgumentException("Contraseña incorrecta");
		}
		
		return UsuarioidDto.creaDto(usuario);
	}
}
