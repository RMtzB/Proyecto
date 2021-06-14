package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.PublicacionRepository;
import mx.uam.ayd.proyecto.dto.PublicacionDto;
import mx.uam.ayd.proyecto.dto.PublicacionParcialDto;
import mx.uam.ayd.proyecto.dto.UsuarioDto;
import mx.uam.ayd.proyecto.dto.comentarioDto;
import mx.uam.ayd.proyecto.negocio.modelo.Publicacion;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

@Slf4j
@Service
public class ServicioPublicacion {
	@Autowired
	private PublicacionRepository publicacionRepository;

	public List<PublicacionParcialDto> recuperaPublicaciones() {
		List<PublicacionParcialDto> publicaciones = new ArrayList<>();

		for (Publicacion publicacion : publicacionRepository.findAll()) {
			publicaciones.add(PublicacionParcialDto.creaDto(publicacion));
		}

		return publicaciones;
	}

	public PublicacionDto recuperaPublicacion(Long id) {
		Publicacion publicacion = publicacionRepository.findByIdPublicacion(id);
		if (publicacion == null) {
			throw new IllegalArgumentException("El usuario no existe");
		}
		return PublicacionDto.creaDto(publicacion);
	}

	public PublicacionParcialDto agregaPublicacion(PublicacionDto nuevaPublicacion) {
				Publicacion publicacion = publicacionRepository.findByTitulo(nuevaPublicacion.getTitulo());
				System.out.println("tit: "+nuevaPublicacion.getTitulo());
				if (publicacion != null) {
					System.out.println("asdasd");
					throw new IllegalArgumentException("Ese usuario ya existe");
				}
				publicacion = new Publicacion();
				
				publicacion.setTitulo(nuevaPublicacion.getTitulo());
				
				publicacion.setPrecio(nuevaPublicacion.getPrecio());
				publicacion.setServicios(nuevaPublicacion.getServicios());
				publicacion.setHoraEtntrada(nuevaPublicacion.getHoraEtntrada());
				publicacion.setRestriccionGenero(nuevaPublicacion.getRestriccionGenero());
				publicacion.setDeposito(nuevaPublicacion.getDeposito());
				publicacion.setNumeroTelefono(nuevaPublicacion.getNumeroTelefono());
				publicacion.setDescripcion(nuevaPublicacion.getDescripcion());
				publicacion.setUrlUbicacion(nuevaPublicacion.getUrlUbicacion());
				publicacion.setDireccion(nuevaPublicacion.getDescripcion());
				publicacion.setComentarios(nuevaPublicacion.getComentarios());
                publicacion.setAmueblado(nuevaPublicacion.isAmueblado());
                publicacion.setMascotas(nuevaPublicacion.isMascotas());
                publicacion.setAval(nuevaPublicacion.isAval());
				
				publicacion = publicacionRepository.save(publicacion);
				System.out.println("se guardo: "+publicacion.getIdPublicacion());
				return PublicacionParcialDto.creaDto(publicacion);
	}

	public comentarioDto añadirComentario(Long id, String comentario) {
		Publicacion publicacion = publicacionRepository.findByIdPublicacion(id);
		publicacion.setComentarios(publicacion.getComentarios()+"--"+comentario);
		publicacionRepository.save(publicacion);
		return comentarioDto.creaDto(publicacion);
	}

	public List<PublicacionParcialDto> recuperaPublicacionesDeUsuario(Long id) {
		List<PublicacionParcialDto> publicaciones = new ArrayList<>();

		for (Publicacion publicacion : publicacionRepository.findByIdUsuario(id)) {
			publicaciones.add(PublicacionParcialDto.creaDto(publicacion));
		}

		return publicaciones;

	}
}

