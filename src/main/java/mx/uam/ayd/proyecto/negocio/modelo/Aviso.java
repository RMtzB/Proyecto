package mx.uam.ayd.proyecto.negocio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Aviso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAviso;
	private String titulo,
					descripcion,
					direccion,
					comentarios;
}
