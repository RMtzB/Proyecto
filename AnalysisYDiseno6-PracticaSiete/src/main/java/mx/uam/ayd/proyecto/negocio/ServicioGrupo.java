package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.GrupoRepository;
import mx.uam.ayd.proyecto.dto.GrupoDto;
import mx.uam.ayd.proyecto.negocio.modelo.Grupo;

@Service
public class ServicioGrupo {
	
	@Autowired 
	GrupoRepository grupoRepository;
	
	
	/**
	 * 
	 * Recupera todos los grupos
	 * 
	 * @return
	 */
	public List <GrupoDto> recuperaGrupos() {		
		List <GrupoDto> grupos = new ArrayList<>();
		
		for(Grupo grupo:grupoRepository.findAll()) {
			grupos.add(GrupoDto.creaDto(grupo));
		}
				
		return grupos;
	}

}
