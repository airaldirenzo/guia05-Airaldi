package tp.Repara.Fix;

import java.time.LocalDate;

public abstract class Servicio implements Contratable {

	protected Oficio oficio;
	protected double costo;
	protected boolean urgente;
	protected LocalDate fechaInicio;
	protected double costoFinal;
	
	
	
	// Si el servicio es urgente se ejecutará este método * el costo del servicio
	
	public double obtenerCosto() {
		
		double costo = 1.5;
		
		return costo;
		
	}
	
	
	
}
