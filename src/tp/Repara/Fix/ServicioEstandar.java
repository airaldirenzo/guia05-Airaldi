package tp.Repara.Fix;

import java.time.LocalDate;

import tp.ReparaFix.exceptions.TrabajoNoFinalizadoException;

public class ServicioEstandar extends Servicio{
	
	private double costoRF;
	
	
	public ServicioEstandar(Oficio unOficio) {
		
		oficio = unOficio;
		urgente = false;
		costoRF = 1000;
		fechaInicio = LocalDate.now();
		costoFinal = 0;
		
	}
	
	public ServicioEstandar(Oficio unOficio, LocalDate unaFechaInicio) {
		
		oficio = unOficio;
		urgente = false;
		costoRF = 1000;
		fechaInicio = unaFechaInicio;
		costoFinal = 0;
		
	}
	
	public ServicioEstandar(Oficio unOficio, boolean vUrgente) {
		
		this.urgente = vUrgente;
		oficio = unOficio;
		urgente = false;
		costoRF = 1000;
		fechaInicio = LocalDate.now();
		costoFinal = 0;
		
	}
	
	
	public void obtenerCosto(Trabajo unTrabajo) {
		
		try {
			
			this.costoFinal = this.costoRF + unTrabajo.costoTrabajador();
			
			if(this.urgente)
				costoFinal *= super.obtenerCosto();
			
		}
		
		catch (TrabajoNoFinalizadoException e){
			e.printStackTrace();
		}
		
	}
	
	
}
