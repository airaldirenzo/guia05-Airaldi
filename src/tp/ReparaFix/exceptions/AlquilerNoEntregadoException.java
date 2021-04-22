package tp.ReparaFix.exceptions;

public class AlquilerNoEntregadoException extends Exception{

	public AlquilerNoEntregadoException() {
		super("Tiene mas de dos alquileres sin devolver. Devuelva uno para poder alquilar");
	}
	
}
