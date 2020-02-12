package uf05.actividad02;

public class RepChapaPintura extends Reparacion {
	
	// Factor utilizado para calcular el precio reparaci�n
	private static final float FACTOR = 1.3f;
	
	// Constructor por defecto
	public RepChapaPintura(){
		super();
	}
	
	// Constructor que recibe como par�metro un String 
	// con la descripci�n de la reparacion a realizar
	public RepChapaPintura (String descripcion){
		super(descripcion);
	}

	// Devuelve el precio de la reparaci�n
	@Override
	public float getPrecioTrabajo() {		
		return getParteFija() + getCosteMaterial() * FACTOR;
	}

}
