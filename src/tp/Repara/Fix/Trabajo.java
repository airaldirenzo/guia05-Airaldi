package tp.Repara.Fix;
import java.time.*;
import java.time.temporal.ChronoUnit;
import tp.ReparaFix.exceptions.*;

public class Trabajo {
	
	protected Instant tiempoInicio;
	protected Instant tiempoFin;
	protected Trabajador trabajador;
	protected Servicio servicio; 
	
	
	public Trabajo(Trabajador unTrabajador, Servicio unServicio) {
		
		tiempoInicio = Instant.now();
		tiempoFin = null;
		trabajador = unTrabajador;
		servicio = unServicio;
		//tiempoFin = tiempoInicio.plus(5, ChronoUnit.HOURS); para test
	}


	public double costoTrabajador() throws TrabajoNoFinalizadoException{
		
		if (tiempoTrabajado() != -1)
			return (tiempoTrabajado() * trabajador.costoPorHr);
		
		else
			throw new TrabajoNoFinalizadoException();
			
	}

	public int tiempoTrabajado () {
		
		   if (this.tiempoFin != null)
			   return (Duration.between(tiempoInicio, tiempoFin).toHoursPart());
		   
		   else 
			   return -1;
	}
	
	
	public void finalizarTrabajo() {
		
		this.tiempoFin = Instant.now(); // esta es la instruccion "real"
		//this.tiempoFin= this.tiempoInicio.plus(8, ChronoUnit.HOURS); //test, con esta instruccion simulamos que paso un tiempo
		
		
	}
	
	
	public boolean finalizado() {
		return (tiempoFin != null);
	}
	
}
