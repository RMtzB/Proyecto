package mx.uam.ayd.proyecto.negocio.modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
					direccion,
					urlUbicacion,
					comentarios;
	private boolean amueblado,mascotas,aval;
}
