package tp.Repara.Fix;
import java.time.LocalDate;
import java.util.ArrayList;

import tp.ReparaFix.exceptions.AlquilerNoEntregadoException;

public class Usuario {

	protected ArrayList <Contratable> contratos;
	protected String nombre;
	protected String email;
	protected int idUsuario;
	protected static int idCounter;
	
	public Usuario(String unNombre, String unEmail) {
		
		nombre = unNombre;
		this.contratos = new ArrayList <Contratable>();
		this.idUsuario = idCounter++;
		
	}
	
	
	
	public void devolverHerramienta(Alquiler unAlquiler) {
		
		unAlquiler.fechaDevolucion = LocalDate.now();
		contratos.remove(unAlquiler);
		
	}
	
	
	
	public void contratar(Contratable contrato) throws AlquilerNoEntregadoException {
			
			int contador = 0;
			
			for(Contratable unContrato : this.contratos) {
				
				if(unContrato instanceof Alquiler && !(((Alquiler) unContrato).finalizado()))
					contador++;
				if(contador > 2)
					throw new AlquilerNoEntregadoException();
			}
				
			if (contador <= 2)
				this.contratos.add(contrato);
						
	}
	
	
}
