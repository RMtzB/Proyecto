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

				if (publicacion != null) {
					throw new IllegalArgumentException("Ese usuario ya existe");
				}

				publicacion = publicacionRepository.save(publicacion);

				return PublicacionParcialDto.creaDto(publicacion);
	}
}

