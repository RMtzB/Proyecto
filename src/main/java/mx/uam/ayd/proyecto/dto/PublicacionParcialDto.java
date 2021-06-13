package mx.uam.ayd.proyecto.dto;

import lombok.Data;
import mx.uam.ayd.proyecto.negocio.modelo.Publicacion;

@Data
public class PublicacionParcialDto {
	private String titulo, descripcion, precio;
	private Long idPublicacion;

	public static PublicacionParcialDto creaDto(Publicacion publicacion) {
		PublicacionParcialDto dto = new PublicacionParcialDto();
		dto.setIdPublicacion(publicacion.getIdPublicacion());
		dto.setTitulo(publicacion.getTitulo());
		dto.setDescripcion(publicacion.getDescripcion());
		return dto;
	}
}