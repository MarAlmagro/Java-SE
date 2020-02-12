package uf05.actividad02;

public class RepMecanica extends Reparacion {
	
	// Factor utilizado para calcular el precio reparación
	private static final float FACTOR = 1.1f;
	
	// Constructor por defecto
	public RepMecanica(){
		super();
	}
	
	// Constructor que recibe como parámetro un String 
	// con la descripción de la reparacion a realizar
	public RepMecanica (String descripcion){
		super(descripcion);
	}
	
	// Devuelve el precio de la reparación
	@Override
	public float getPrecioTrabajo() {		
		return getParteFija() + getCosteMaterial() * FACTOR;
	}

}
