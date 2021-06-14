package mx.uam.ayd.proyecto;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import mx.uam.ayd.proyecto.datos.AvisoRepository;
import mx.uam.ayd.proyecto.datos.PublicacionRepository;
import mx.uam.ayd.proyecto.datos.UsuarioRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Aviso;
import mx.uam.ayd.proyecto.negocio.modelo.Publicacion;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

/**
 * Clase principal que arranca la aplicación construida usando el principio de
 * inversión de control
 * 
 * Ejemplo de cambio en Rama
 * 
 * @author humbertocervantes
 */
@SpringBootApplication
public class ProyectoApplication {
	/**
	 * Método principal
	 * 
	 */
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	PublicacionRepository publicacionRepository;
	
	@Autowired
	AvisoRepository avisoRepository;
	public static void main(String[] args) {

		SpringApplicationBuilder builder = new SpringApplicationBuilder(ProyectoApplication.class);

		builder.headless(false);

		builder.run(args);
	}

	/**
	 * Metodo que arranca la aplicacion inicializa la bd y arranca el controlador
	 * otro comentario
	 */
	@PostConstruct
	public void inicia() {
		inicializaBD();
	}

	/**
	 * Inicializa la BD con datos
	 */
	public void inicializaBD() {
		Usuario a= new Usuario();
		a.setNombre("CCLOM");
		a.setContra("CCLOM1");
		usuarioRepository.save(a);
			
		Publicacion b= new Publicacion();
		b.setIdUsuario((long) 1);
		b.setAmueblado(true);
		b.setAval(true);
		b.setDeposito("500");
		b.setDescripcion("Mamastroso");
		b.setHoraEtntrada("2");
		b.setMascotas(true);
		b.setNumeroTelefono("T");
		b.setPrecio("Caro");
		b.setRestriccionGenero("Solo gays");
		b.setServicios("Nel");
		b.setTitulo("Vente perra");
		b.setUrlUbicacion("En tu casa");
		b.setDireccion("direccioooon");
		b.setComentarios("comentario1--zsdasdasd--dddddddddd--ssssss");
		publicacionRepository.save(b);
		
		b= new Publicacion();
		b.setIdUsuario((long) 2);
		b.setAmueblado(true);
		b.setAval(true);
		b.setDeposito("5001");
		b.setDescripcion("Mamastroso1");
		b.setHoraEtntrada("21");
		b.setMascotas(true);
		b.setNumeroTelefono("T1");
		b.setPrecio("Caro1");
		b.setRestriccionGenero("Solo gays1");
		b.setServicios("Nel1");
		b.setTitulo("Vente perra1");
		b.setUrlUbicacion("En tu casa1");
		b.setDireccion("direcciooon");
		b.setComentarios("comentario2");
		publicacionRepository.save(b);
	
		
		Aviso c= new Aviso();
		c.setTitulo("Cristo es tu amigo");
		c.setDescripcion("Cristo es malo");
		c.setComentarios("MaravillosaJugada");
		c.setDireccion("En tu corazon");
		avisoRepository.save(c);
		System.out.println("DB Cargada");
	}
}
