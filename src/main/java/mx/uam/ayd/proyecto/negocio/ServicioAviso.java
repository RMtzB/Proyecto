package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.AvisoRepository;
import mx.uam.ayd.proyecto.dto.AvisoDto;
import mx.uam.ayd.proyecto.dto.AvisoidDto;
import mx.uam.ayd.proyecto.dto.comentarioDto;
import mx.uam.ayd.proyecto.negocio.modelo.Aviso;

@Slf4j
@Service
public class ServicioAviso {
	@Autowired
	private AvisoRepository avisoRepository;

	public List<AvisoidDto> recuperaAvisos() {
		List<AvisoidDto> avisos = new ArrayList<>();
		for (Aviso aviso : avisoRepository.findAll()) {
			avisos.add(AvisoidDto.creaDto(aviso));
		}
		return avisos;
	}
	
	public AvisoDto recuperaAviso(Long id) {
		Aviso aviso = avisoRepository.findByIdAviso(id);
		if (aviso == null) {
			throw new IllegalArgumentException("El usuario no existe");
		}
		return AvisoDto.creaDto(aviso);
	}
	

	public AvisoDto agregaAviso(AvisoDto nuevoAviso) {
			Aviso aviso = avisoRepository.findByTitulo(nuevoAviso.getTitulo());
			if (aviso != null) {
				throw new IllegalArgumentException("Ese usuario ya existe");
			}
			aviso = new Aviso();
			aviso.setTitulo(nuevoAviso.getTitulo());
			aviso.setDescripcion(nuevoAviso.getDescripcion());
			aviso.setDireccion(nuevoAviso.getDireccion());
			aviso.setComentarios(nuevoAviso.getComentarios());
			aviso = avisoRepository.save(aviso);
			return AvisoDto.creaDto(aviso);
}

	public comentarioDto añadirComentario(Long id, String comentario) {
		Aviso aviso = avisoRepository.findByIdAviso(id);
		aviso.setComentarios(aviso.getComentarios()+"--"+comentario);
		avisoRepository.save(aviso);
		return comentarioDto.creaDto(aviso);
	}
}