package mx.uam.ayd.proyecto.dto;

import java.util.LinkedList;

import lombok.Data;
import mx.uam.ayd.proyecto.negocio.modelo.Publicacion;

@Data
public class PublicacionDto {
	
	private Long idPublicacion;
	private String titulo,precio,servicios,horaEtntrada,restriccionGenero,deposito,numeroTelefono,descripcion,ubicacion;
	private boolean amueblado,mascotas,aval;
	private String comentarios;

	public static PublicacionDto creaDto(Publicacion publicacion) {
		
		PublicacionDto dto = new PublicacionDto();
		dto.setTitulo(publicacion.getTitulo());
		dto.setPrecio(publicacion.getPrecio());
		dto.setServicios(publicacion.getServicios());
		dto.setHoraEtntrada(publicacion.getHoraEtntrada());
		dto.setRestriccionGenero(publicacion.getRestriccionGenero());
		dto.setDeposito(publicacion.getDeposito());
		dto.setNumeroTelefono(publicacion.getNumeroTelefono());
		dto.setDescripcion(publicacion.getDescripcion());
		dto.setUbicacion(publicacion.getUbicacion());
		dto.setAmueblado(publicacion.isAmueblado());
		dto.setMascotas(publicacion.isMascotas());
		dto.setAval(publicacion.isAval());
		dto.setComentarios(publicacion.prepararComentarios());

		return dto;
	}
}
