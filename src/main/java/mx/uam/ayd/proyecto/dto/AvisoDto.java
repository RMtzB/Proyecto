package mx.uam.ayd.proyecto.dto;

import java.util.LinkedList;

import lombok.Data;
import mx.uam.ayd.proyecto.negocio.modelo.Aviso;


@Data
public class AvisoDto {
	private Long idPublicacion;
	private String titulo,descripcion,ubicacion;
	private LinkedList<String> comentarios;
	private LinkedList<String> urlFotos;

	/**
	 * Este metodo permite generar un DTO a partir de la entidad nota: es un método
	 * de clase y no se necesita un objeto para invocarlo. Se invoca como
	 * AvisoDto.crea(param)
	 * 
	 * @param usuario de entidad
	 * @return dto obtenido a partir de la entidad
	 */
	
	public static AvisoDto creaDto(Aviso aviso) {
		AvisoDto dto = new AvisoDto();

		dto.setIdPublicacion(aviso.getIdPublicacion());
		dto.setTitulo(aviso.getTitulo());
		dto.setDescripcion(aviso.getDescripcion());
		dto.setUbicacion(aviso.getUbicacion());
		dto.setComentarios(aviso.getComentarios());
		dto.setUrlFotos(aviso.getUrlFotos());
		
		return dto;
	}

}
