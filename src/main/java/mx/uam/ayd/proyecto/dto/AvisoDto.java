package mx.uam.ayd.proyecto.dto;

import lombok.Data;
import mx.uam.ayd.proyecto.negocio.modelo.Aviso;


@Data
public class AvisoDto {
	private String titulo,descripcion,direccion,comentarios;



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

		dto.setTitulo(aviso.getTitulo());
		dto.setDescripcion(aviso.getDescripcion());
		dto.setDireccion(aviso.getDireccion());
		dto.setComentarios(aviso.getComentarios());
		return dto;
	}

}
