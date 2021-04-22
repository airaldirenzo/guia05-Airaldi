package tp.Repara.Fix;
import java.time.*;
import java.time.format.*;

public class Alquiler implements Contratable{

	protected DateTimeFormatter formatter;
	protected LocalDate fechaInicio;
	protected LocalDate fechaFin;
	protected LocalDate fechaDevolucion;
	protected Herramienta herramienta;
	protected double costoTotal;
	
	
	
	public Alquiler(LocalDate fFin, Herramienta unaHerramienta) {
		
		fechaDevolucion = null;
		fechaInicio = LocalDate.now();
		fechaFin = fFin;
		herramienta = unaHerramienta;
		costoTotal = 0;
		//System.out.println(fechaFin); test
		
	}
	
	
	
	
	public double obtenerCosto() {
		
		LocalDate fechaAux;
		
		if (fechaDevolucion == null)
			fechaAux = LocalDate.now();
		
		else
			fechaAux = fechaDevolucion;
		
		Duration duracion = Duration.between(fechaInicio, fechaAux);
		
		this.costoTotal = duracion.toDaysPart() * herramienta.costoPorDia;
		
		return this.costoTotal;
	}
	
	
	public boolean enMora() {
		
		if (this.fechaDevolucion != null)
			return (fechaDevolucion.isAfter(fechaFin));
			
		else 
			return (LocalDate.now().isAfter(fechaFin));
	}
	
	
	public boolean finalizado () {
		
		return (fechaDevolucion != null);
		
	}
	
	
}
