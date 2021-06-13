package mx.uam.ayd.proyecto.dto;

import lombok.Data;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

@Data
public class UsuarioidDto{
	
	private String nombre;
	private long id;
	
	/**
	 * Este método permite generar un DTO a partir de la entidad nota: es un método
	 * de clase y no se necesita un objeto para invocarlo. Se invoca como
	 * UsuarioDto.crea(param)
	 * 
	 * @param usuario la entidad
	 * @return dto obtenido a partir de la entidad
	 */
	
	public static UsuarioidDto creaDto(Usuario usuario) {
		UsuarioidDto dto = new UsuarioidDto();
		dto.setId(usuario.getIdUsuario());
		dto.setNombre(usuario.getNombre());
		return dto;
	}
}
