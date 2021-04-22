package tp.Repara.Fix;

import java.time.LocalDate;

import tp.ReparaFix.exceptions.TrabajoNoFinalizadoException;

public class ServicioPersonalizado extends Servicio{

	
	protected double costoPresupuesto;
	protected double costoMateriales;
	protected double costoTransporte;
	
	
	public ServicioPersonalizado(Oficio unOficio) {
		
		oficio = unOficio;
		costoPresupuesto = 0;
		costoMateriales = 0;
		costoTransporte = 0;
		costoFinal = 0;
		urgente = false;
		fechaInicio = LocalDate.now();
		
	}

	public ServicioPersonalizado(Oficio unOficio, boolean vUrgente) {
	
		urgente = vUrgente;
		oficio = unOficio;
		costoPresupuesto = 0;
		costoMateriales = 0;
		costoTransporte = 0;
		costoFinal = 0;
		urgente = false;
		fechaInicio = LocalDate.now();
	
	}
	
	public void presupuestar(double presupuesto, double costoM, double costoT) {
		
		this.costoPresupuesto = presupuesto;
		this.costoMateriales = costoM;
		this.costoTransporte = costoT;
		
	}
	

	public void obtenerCosto(Trabajo unTrabajo) {
		
		try {
			
			this.costoFinal = 	this.costoPresupuesto +  
							this.costoMateriales + 
							this.costoTransporte +
							unTrabajo.costoTrabajador();
			
			if (this.urgente)
				this.costoFinal *= (super.obtenerCosto());
			
		}
		
		catch (TrabajoNoFinalizadoException e){
				e.printStackTrace();
		}
		
	}
	
	
	
}
