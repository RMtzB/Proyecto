package mx.uam.ayd.proyecto.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.AvisoRepository;
import mx.uam.ayd.proyecto.dto.AvisoDto;
import mx.uam.ayd.proyecto.dto.AvisoidDto;
import mx.uam.ayd.proyecto.negocio.modelo.Aviso;

@Slf4j
@Service
public class ServicioAviso {
	@Autowired
	private AvisoRepository avisoRepository;

	public AvisoidDto crearAviso(AvisoDto avisodto) {
		
		Aviso aviso = avisoRepository.save(aviso.getTitulo());

		
		return AvisoidDto.creaDto(aviso);
	}
}
