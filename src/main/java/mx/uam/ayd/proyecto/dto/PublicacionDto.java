package mx.uam.ayd.proyecto.dto;

import lombok.Data;
import mx.uam.ayd.proyecto.negocio.modelo.Publicacion;

@Data
public class PublicacionDto {
	
	private Long idPublicacion,idUsuario;
	private String titulo,precio,servicios,horaEtntrada,restriccionGenero,deposito,numeroTelefono,descripcion,urlUbicacion,direccion;
	private boolean amueblado,mascotas,aval;
	private String comentarios;

	public static PublicacionDto creaDto(Publicacion publicacion) {
		
		PublicacionDto dto = new PublicacionDto();
		dto.setIdUsuario(publicacion.getIdUsuario());
		dto.setIdPublicacion(publicacion.getIdPublicacion());
		dto.setTitulo(publicacion.getTitulo());
		dto.setPrecio(publicacion.getPrecio());
		dto.setServicios(publicacion.getServicios());
		dto.setHoraEtntrada(publicacion.getHoraEtntrada());
		dto.setRestriccionGenero(publicacion.getRestriccionGenero());
		dto.setDeposito(publicacion.getDeposito());
		dto.setNumeroTelefono(publicacion.getNumeroTelefono());
		dto.setDescripcion(publicacion.getDescripcion());
		dto.setUrlUbicacion(publicacion.getUrlUbicacion());
		dto.setAmueblado(publicacion.isAmueblado());
		dto.setMascotas(publicacion.isMascotas());
		dto.setAval(publicacion.isAval());
		dto.setDireccion(publicacion.getDireccion());
		dto.setComentarios(publicacion.getComentarios());

		return dto;
	}
}
