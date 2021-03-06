package mx.uam.ayd.proyecto.dto;

import lombok.Data;
import mx.uam.ayd.proyecto.negocio.modelo.Aviso;
import mx.uam.ayd.proyecto.negocio.modelo.Publicacion;
@Data
public class comentarioDto {
	private String comentarios;

	public static comentarioDto creaDto(Publicacion p) {
		comentarioDto dto = new comentarioDto();
		dto.setComentarios(p.getComentarios());
		return dto;
	}
	

	public static comentarioDto creaDto(Aviso a) {
		comentarioDto dto = new comentarioDto();
		dto.setComentarios(a.getComentarios());
		return dto;
	}

}
