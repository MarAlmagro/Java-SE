package uf05.actividad02;

public abstract class Reparacion extends Trabajo {
	
	// Coste de las piezas utilizadas en la reparaci�n
	private float costePiezas = 0;
	
	// Constructor por defecto
	public Reparacion(){
		super();
	}
	
	// Constructor que recibe como par�metro un String 
	// con la descripci�n de la reparacion a realizar
	public Reparacion (String descripcion){
		super(descripcion);
	}
	
	// Devuelve el precio de la reparaci�n
	@Override
	public abstract float getPrecioTrabajo();
	

	// Suma al coste piezas utilizadas la cantidad 
    // de horas que se pasa como par�metro
	// Devuelve true si se ha podido realizar la operaci�n y 
	// false en otro caso
	public boolean sumar_coste_piezas (float coste) {
		// S�lo se modifica el coste piezas si la reparaci�n
		// a�n no ha finalizado
		if (!finalizado()) {
			this.costePiezas += coste;
			return true;
		}
		// Reparaci�n finalizada
		// Muestra mensaje indicando que no se ha modificado el coste piezas
		System.out.println("Trabajo finalizado. Coste piezas no modificado ");
		return false;
	}
	
	// Devuelve el coste del material utilizado en la reparaci�n
	public float getCosteMaterial() {
		return costePiezas;
	}

}
