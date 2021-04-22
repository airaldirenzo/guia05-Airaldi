package tp.ReparaFix.exceptions;

public class OficioNoCoincideException extends Exception{

	public OficioNoCoincideException() {
		super("El trabajador no puede realizar este servicio. Intente con otro.");
	}
}
