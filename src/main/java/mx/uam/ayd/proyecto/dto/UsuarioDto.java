package mx.uam.ayd.proyecto.dto;

import lombok.Data;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

@Data
public class UsuarioDto {
	
	private String nombre, contra;
	
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
		dto.setNombre(usuario.getNombre());
		dto.setContra(usuario.getContra());
		return dto;
	}
}


