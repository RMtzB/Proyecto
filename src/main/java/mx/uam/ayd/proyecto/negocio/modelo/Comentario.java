package mx.uam.ayd.proyecto.negocio.modelo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Comentario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idComentario;
	
	private String com, fecha;
	public Comentario(String com, String fecha) {
		this.com = com;
		this.fecha = fecha;
	}

}
