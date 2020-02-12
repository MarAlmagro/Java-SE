package uf05.actividad02;

public class Revision extends Trabajo {
	
	// Cantidad fija para calcular el precio de la
	// revisión
	private static final int EXTRA = 20;
	
	// Constructor por defecto
	public Revision(){
		super();
	}
	
	// Constructor que recibe como parámetro un String 
	// con la descripción de la revisión a realizar
	public Revision (String descripcion){
		super(descripcion);
	}


	// Devuelve el precio de la revisión
	@Override
	public float getPrecioTrabajo() {		
		return getParteFija() + EXTRA;
	}

}
