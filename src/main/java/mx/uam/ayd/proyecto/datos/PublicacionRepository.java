package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Publicacion;

public interface PublicacionRepository extends CrudRepository <Publicacion, Long>{

}
