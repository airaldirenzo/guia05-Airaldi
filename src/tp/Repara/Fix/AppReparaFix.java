package tp.Repara.Fix;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import tp.ReparaFix.exceptions.*;

public class AppReparaFix {

	public static void main(String[] args) {
		
		// Una banda de fechas
		
		LocalDate fecha1 = LocalDate.now().plus(1, ChronoUnit.DAYS); 
		LocalDate fecha2 = fecha1.plus(10, ChronoUnit.DAYS);
		LocalDate fecha3 = fecha1.plus(5, ChronoUnit.DAYS);
		LocalDate fecha4 = fecha1.plus(2, ChronoUnit.DAYS);
		LocalDate fecha5 = fecha1.minus(3, ChronoUnit.DAYS);
		
		Usuario user = new Usuario("Airaldi Renzo", "airaldirenzo@gmail.com");
		
		Servicio servicioPersonalizado1 = new ServicioPersonalizado(Oficio.ALBANIL);
		Servicio servicioPersonalizado2 = new ServicioPersonalizado(Oficio.CARPINTERO, true);	//Urgente = true;
	
		Servicio servicioEstandar1 = new ServicioEstandar(Oficio.PINTOR);
		Servicio servicioEstandar2 = new ServicioEstandar(Oficio.ALBANIL, true);	//Urgente = true;
		Servicio servicioEstandar3 = new ServicioEstandar(Oficio.ALBANIL, fecha2);
		
		Herramienta herramienta1 = new Herramienta("Martillo",10);
		Herramienta herramienta2 = new Herramienta("Serrucho",30);
		Herramienta herramienta3 = new Herramienta("Brocha",15);
		Herramienta herramienta4 = new Herramienta("Tenaza",20);
		Herramienta herramienta5 = new Herramienta("Rodillo",25);
		
		Alquiler alquiler1 = new Alquiler(fecha2,herramienta1);
		Alquiler alquiler2 = new Alquiler(fecha3, herramienta2);
		Alquiler alquiler3 = new Alquiler(fecha4, herramienta3);
		Alquiler alquiler4 = new Alquiler(fecha5, herramienta4);
		Alquiler alquiler5 = new Alquiler(fecha1, herramienta5);
		
		Trabajador trabajador1 = new Trabajador("Carlos", "carlos@email.com", Oficio.ALBANIL, 50,25);
		Trabajador trabajador2 = new Trabajador("Pedro", "pedro@email.com", Oficio.PINTOR, 35,40);
		
		Trabajo trabajo1 = new Trabajo(trabajador1, servicioEstandar2);
		
		//El usuario intenta contratar servicios, sino tira exception
		
		try { 
			user.contratar(servicioPersonalizado1);
			System.out.println("Se contrato el servicio");
		}
		catch (AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
		
		try { 
			user.contratar(servicioPersonalizado2);
			System.out.println("Se contrato el servicio");
		}
		catch (AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
		
		try { 
			user.contratar(servicioEstandar1);
			System.out.println("Se contrato el servicio");
		}
		catch (AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
		
		try { 
			user.contratar(servicioEstandar2);
			System.out.println("Se contrato el servicio");
		}
		catch (AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
		
		
		// si puede, agrega tareas a trabajadores, sino tira exception
		
		try {
			trabajador1.agregarTarea(servicioPersonalizado1);
			System.out.println("Trabajo agregado al trabajador 1");
		} 
		catch (AgendaOcupadaException | OficioNoCoincideException e) {
			e.printStackTrace();
		}

		//OficioNoCoincideException
		try { 
			trabajador2.agregarTarea(servicioEstandar2);
			System.out.println("Trabajo agregado al trabajador 2");
		} 
		catch (AgendaOcupadaException | OficioNoCoincideException e) {
			e.printStackTrace();
		}
		
		
		/* 
		 * SOLAMENTE Al servicio estandar NO urgente le agregue un constructor
		 * para poder instanciarlo con una fecha de inicio y asi chequear
		 * mas comodamente la excepcion de agenda ocupada
		*/
		
		LocalDate servicioEstandar2LD = servicioPersonalizado1.fechaInicio;
		Servicio servicioEstandar4 = new ServicioEstandar(Oficio.ALBANIL, servicioEstandar2LD);
		
		// AgendaOcupadaException
		try {
			trabajador1.agregarTarea(servicioEstandar4);
			System.out.println("Trabajo agregado al trabajador 2");
		}
		catch (AgendaOcupadaException | OficioNoCoincideException e) {
			e.printStackTrace();
		}
		
		// se almacenan mas tareas en el trabajador1 sin problemas
		
		try {
			trabajador1.agregarTarea(servicioEstandar3);
			System.out.println("Trabajo agregado al trabajador 1");
		}
		catch(AgendaOcupadaException | OficioNoCoincideException e) {
			e.printStackTrace();
		}
		

		// Se alquilan herramientas
		
		try {
			user.contratar(alquiler1);
			System.out.println("Herramienta 1 alquilada");
		}
		catch(AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
		
		try {
			user.contratar(alquiler2);
			System.out.println("Herramienta 2 alquilada");
		}
		catch(AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
		
		try {
			user.contratar(alquiler3);
			System.out.println("Herramienta 3 alquilada");
		}
		catch(AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
		
		// AlquierNoEntregadoException
		try {
			user.contratar(alquiler4);
			System.out.println("Herramienta 3 alquilada");
		} 
		catch (AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
		
		// devolvemos una herramienta
		user.devolverHerramienta(alquiler1);
		System.out.println("La herramienta 1 fue devuelta");
		
		// volvemos a tener permiso para alquilar una nueva herramienta
		try {
			user.contratar(alquiler5);
			System.out.println("Herramienta 5 alquilada");
		}
		catch(AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
	
		// Intentamos calcular el costo de un trabajador cuando el trabajo todavia no finalizo
		
		try { 
			System.out.println(trabajo1.costoTrabajador());
		}
		catch (TrabajoNoFinalizadoException e) {
			e.printStackTrace();
		}
		
		// Finalizamos un trabajo
		trabajo1.finalizarTrabajo();
		System.out.println("El trabajo fue finalizado");
		
		// Intentamos calcular el costo de un trabajador cuando el trabajo finalizo
		
		/*
		 *  ACLARACION: Si el metodo costoTrabajador() devuelve 0, comentar en la clase Trabajo
		 *  en el metodo finalizarTrabajo() su 1era linea y descomentar la 2da linea
		 */
		
		try { 
			System.out.println(trabajo1.costoTrabajador());
		}
		catch (TrabajoNoFinalizadoException e) {
			e.printStackTrace();
		}
		
		
	}

}
