package uf05.actividad02;

public abstract class Reparacion extends Trabajo {
	
	// Coste de las piezas utilizadas en la reparación
	private float costePiezas = 0;
	
	// Constructor por defecto
	public Reparacion(){
		super();
	}
	
	// Constructor que recibe como parámetro un String 
	// con la descripción de la reparacion a realizar
	public Reparacion (String descripcion){
		super(descripcion);
	}
	
	// Devuelve el precio de la reparación
	@Override
	public abstract float getPrecioTrabajo();
	

	// Suma al coste piezas utilizadas la cantidad 
    // de horas que se pasa como parámetro
	// Devuelve true si se ha podido realizar la operación y 
	// false en otro caso
	public boolean sumar_coste_piezas (float coste) {
		// Sólo se modifica el coste piezas si la reparación
		// aún no ha finalizado
		if (!finalizado()) {
			this.costePiezas += coste;
			return true;
		}
		// Reparación finalizada
		// Muestra mensaje indicando que no se ha modificado el coste piezas
		System.out.println("Trabajo finalizado. Coste piezas no modificado ");
		return false;
	}
	
	// Devuelve el coste del material utilizado en la reparación
	public float getCosteMaterial() {
		return costePiezas;
	}

}
