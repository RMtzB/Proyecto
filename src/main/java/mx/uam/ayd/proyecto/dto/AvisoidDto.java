package mx.uam.ayd.proyecto.dto;

import java.util.LinkedList;

import lombok.Data;
import mx.uam.ayd.proyecto.negocio.modelo.Aviso;
import mx.uam.ayd.proyecto.negocio.modelo.Publicacion;


@Data
public class AvisoidDto {
	private Long idAviso;
	private String titulo,direccion;

	/**
	 * Este metodo permite generar un DTO a partir de la entidad nota: es un método
	 * de clase y no se necesita un objeto para invocarlo. Se invoca como
	 * AvisoDto.crea(param)
	 * 
	 * @param usuario de entidad
	 * @return dto obtenido a partir de la entidad
	 */
	
	public static AvisoidDto creaDto(Aviso aviso) {
		AvisoidDto dto = new AvisoidDto();

		dto.setIdAviso(aviso.getIdAviso());
		dto.setTitulo(aviso.getTitulo());
		dto.setDireccion(aviso.getDireccion());
		return dto;
	}
	
}
