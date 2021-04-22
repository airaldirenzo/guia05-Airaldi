package tp.Repara.Fix;

import java.util.ArrayList;
import tp.ReparaFix.exceptions.*;

public class Trabajador {

	protected ArrayList <Trabajo> trabajos;
	protected String nombre;
	protected String email;
	protected Oficio oficio;
	protected double costoPorHr;
	protected double porcentajeComision;
	
	
	public Trabajador(String unNombre, String unEmail, Oficio unOficio, double unCostoPorHr, double unPorcentajeComision) {
		
		this.trabajos = new ArrayList <Trabajo>();
		this.nombre = unNombre;
		this.email = unEmail;
		this.oficio = unOficio;
		this.costoPorHr = unCostoPorHr;
		this.porcentajeComision = unPorcentajeComision;
		
	}
	
	public double obtenerCobro(Trabajo unTrabajo) {
		
		return (unTrabajo.tiempoTrabajado() * costoPorHr);
		
	}
	
	
	public void agregarTarea(Servicio unServicio) throws OficioNoCoincideException, AgendaOcupadaException {
		
		 
		if (this.oficio != unServicio.oficio)
			throw new OficioNoCoincideException();
		
		else if(this.trabajos != null) {
			
			boolean ocupado = false;	
			
			for(Trabajo unTrabajo : this.trabajos) {
				if (unTrabajo.servicio.fechaInicio.compareTo(unServicio.fechaInicio) == 0) {
					ocupado = true;
					throw new AgendaOcupadaException();
				}
			}
			
			if (!ocupado)
				trabajos.add(new Trabajo(this, unServicio));
			
		}
		
		
	}
	
}
