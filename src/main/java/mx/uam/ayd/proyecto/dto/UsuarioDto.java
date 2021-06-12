package mx.uam.ayd.proyecto.dto;

import lombok.Data;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

@Data
public class UsuarioDto {

	private long idUsuario;

	private String nombre; // No vacío, no numérico

	private String apellido; // No vacío

	private String nombreUsuario; // Rango entre 1 - 120

	/**
	 * Este método permite generar un DTO a partir de la entidad nota: es un método
	 * de clase y no se necesita un objeto para invocarlo. Se invoca como
	 * UsuarioDto.crea(param)
	 * 
	 * @param usuario la entidad
	 * @return dto obtenido a partir de la entidad
	 */
	
	public static UsuarioDto creaDto(Usuario usuario) {
		UsuarioDto dto = new UsuarioDto();

		dto.setIdUsuario(usuario.getIdUsuario());
		dto.setNombre(usuario.getNombre());
		dto.setApellido(usuario.getApellido());
		dto.setNombreUsuario(usuario.getNombreUsuario());

		return dto;
	}
}
