package mx.uam.ayd.proyecto.negocio.modelo;

import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Publicacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPublicacion;
	private String titulo,
					precio,
					servicios,
					horaEtntrada,
					restriccionGenero,
					deposito,
					numeroTelefono,
					descripcion,
					ubicacion;
	private boolean amueblado,mascotas,aval;
	private LinkedList<Comentario> comentarios= new LinkedList<>();
	
	public String prepararComentarios(){
		String todosComentarios="";
		for (Comentario comentario : comentarios) {
			todosComentarios+=comentario.getCom()+"--"+comentario.getFecha()+"finC";
		}
		return todosComentarios;
	}
}
