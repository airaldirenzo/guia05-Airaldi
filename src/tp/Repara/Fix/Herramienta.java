package tp.Repara.Fix;
//import java.time.LocalDate;

public class Herramienta {

	protected String nombre;
	protected double costoPorDia;
	//protected LocalDate fechaDevolucion;
	
	public Herramienta(String unNombre, double costoD) {
		
		nombre = unNombre;
		costoPorDia = costoD;
		
	}
	
}
