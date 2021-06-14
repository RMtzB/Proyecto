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
		b.setDeposito("1 mes");
		b.setDescripcion("Cuarto independiente con servicios incluidos");
		b.setHoraEtntrada("2");
		b.setMascotas(true);
		b.setNumeroTelefono("55-1234-5678");
		b.setPrecio("$8,000");
		b.setRestriccionGenero("Solo mujeres");
		b.setServicios("Incluidos");
		b.setTitulo("Renta de cuarto independiente");
		b.setUbicacion("URL Google");
		b.setComentarios("Excelente lugar y muy limpio");
		publicacionRepository.save(b);
		
		b= new Publicacion();
		b.setIdUsuario((long) 2);
		b.setAmueblado(true);
		b.setAval(true);
		b.setDeposito("4500");
		b.setDescripcion("Increible depa amueblado con todos los servicios incluidos");
		b.setHoraEtntrada("Antes de las 11 pm");
		b.setMascotas(true);
		b.setNumeroTelefono("55-123-123-123");
		b.setPrecio("$6,500");
		b.setRestriccionGenero("Sin reestriccion");
		b.setServicios("Todo incluido");
		b.setTitulo("Minidepartamento para 1 persona");
		b.setUbicacion("UR: Google");
		b.setComentarios("Lugar perfecto para estudiantes");
		publicacionRepository.save(b);
	
		
		b= new Publicacion();
		b.setAmueblado(true);
		b.setAval(true);
		b.setDeposito("$7,000");
		b.setDescripcion("Increible casa para 4 estudiantes");
		b.setHoraEtntrada("Sin hora");
		b.setMascotas(true);
		b.setNumeroTelefono("55-321-321-123");
		b.setPrecio("$7,000");
		b.setRestriccionGenero("Sin reestriccion");
		b.setServicios("Todo incluido");
		b.setTitulo("Casa en renta todo incluido");
		b.setUbicacion("UR: Google");
		b.setComentarios("Lugar perfecto para estudiantes y parejas");
		publicacionRepository.save(b);
		
		Aviso c= new Aviso();
		c.setTitulo("Cuarto en renta");
		c.setComentarios("MaravillosaJugada");
		c.setDireccion("Calle Siempre Viva #123");
		avisoRepository.save(c);
		
		c= new Aviso();
		c.setTitulo("Casa en renta");
		c.setComentarios("wooow");
		c.setDireccion("Calle #00 ");
		avisoRepository.save(c);
		
		c= new Aviso();
		c.setTitulo("Renta en casa");
		c.setComentarios("MaravillosaJugada");
		c.setDireccion("Frente a la uami");
		avisoRepository.save(c);
		
		c= new Aviso();
		c.setTitulo("Se busca roomie");
		c.setComentarios("Buena onda ");
		c.setDireccion("Calle Atlixco 123 ");
		avisoRepository.save(c);
		
		c= new Aviso();
		c.setTitulo("Cuarto para compartir con pareja");
		c.setComentarios("MaravillosaJugada");
		c.setDireccion("Frente a la gasolineria iztapalapa");
		avisoRepository.save(c);
		
		c= new Aviso();
		c.setTitulo("Depto en renta");
		c.setComentarios("wooow");
		c.setDireccion("Calle #987 ");
		avisoRepository.save(c);
		
		c= new Aviso();
		c.setTitulo("Habitacion amueblada");
		c.setComentarios("MaravillosaJugada");
		c.setDireccion("Calle#132");
		avisoRepository.save(c);
		
		c= new Aviso();
		c.setTitulo("Cuarto en renta");
		c.setComentarios("wooow");
		c.setDireccion("Calle #777 ");
		avisoRepository.save(c);
		
		c= new Aviso();
		c.setTitulo("Habitacion en renta");
		c.setComentarios("MaravillosaJugada");
		c.setDireccion("Calle#999");
		avisoRepository.save(c);
		
	

	}
}
