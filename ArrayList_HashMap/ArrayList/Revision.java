package uf05.actividad02;

public class Revision extends Trabajo {
	
	// Cantidad fija para calcular el precio de la
	// revisi�n
	private static final int EXTRA = 20;
	
	// Constructor por defecto
	public Revision(){
		super();
	}
	
	// Constructor que recibe como par�metro un String 
	// con la descripci�n de la revisi�n a realizar
	public Revision (String descripcion){
		super(descripcion);
	}


	// Devuelve el precio de la revisi�n
	@Override
	public float getPrecioTrabajo() {		
		return getParteFija() + EXTRA;
	}

}
