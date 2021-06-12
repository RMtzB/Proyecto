package mx.uam.ayd.proyecto.dto;

import lombok.Data;
import mx.uam.ayd.proyecto.negocio.modelo.Grupo;

@Data
public class GrupoDto {
	private long idGrupo;

	private String nombre;
	
	public static GrupoDto creaDto(Grupo grupo) {
		GrupoDto dto = new GrupoDto();
		
		dto.setIdGrupo(grupo.getIdGrupo());
		dto.setNombre(grupo.getNombre());
		
		return dto;
	}
}
