package tp.ReparaFix.exceptions;

public class AgendaOcupadaException extends Exception {
	
	public AgendaOcupadaException() {
		super("El trabajador ya tiene un trabajo asignado para este dia. Intente con otro dia");
	}
	
}
