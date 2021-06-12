package mx.uam.ayd.proyecto.negocio.modelo;

import java.util.LinkedList;

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
	private Long idPublicacion;
	private String titulo,
					descripcion,
					ubicacion;
	private LinkedList<String> comentarios;
	private LinkedList<String> urlFotos;

}
