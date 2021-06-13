package mx.uam.ayd.proyecto;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import mx.uam.ayd.proyecto.datos.PublicacionRepository;
import mx.uam.ayd.proyecto.datos.UsuarioRepository;
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
		System.out.println("DB Cargada");
		
		Publicacion b= new Publicacion();
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
		b.setUbicacion("En tu casa");
		publicacionRepository.save(b);
		
		b= new Publicacion();
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
		b.setUbicacion("En tu casa1");
		publicacionRepository.save(b);
	}
}
