package uf05.actividad02;

public abstract class Trabajo {
	
	// Contador de objetos Trabajo creados
	private static int numObjetos = 0;
	
    // Precio de una hora de mano de obra
	private static final float PRECIO_HORA = 30f;
	
	// Identificador �nico del Trabajo
	private int ID;
	
	// Descripci�n de la revisi�n o reparaci�n a realizar
	private String descripcion;

	// Indica si el Trabajo ha finalizado (valor true)
	// o no (valor false)
	private boolean finalizado;
	
	// N�mero de horas que son necesarias para realizar
	// el Trabajo
	private float horas_realizadas;
	
		
	// constructor por defecto, no se puede invocar directamente
	// porque es una clase abstracta pero se ejecutar� cuando 
	// se creen objetos de clases hijas que hereden de Trabajo
	Trabajo(){
		this.ID = numObjetos;
		Trabajo.numObjetos++;
		this.horas_realizadas = 0;
		this.finalizado = false;
		this.descripcion = "";
	}
	
	// Constructor que recibe como par�metro un String con la
	// descripci�n del trabajo a realizar
	Trabajo (String descripcion){
		this();
		if ( descripcion != null)
			this.descripcion = descripcion;
	}
	
	// Devuelve el ID del Trabajo
	public int getID() {
		return this.ID;
	}
	
	
	// Devuelve el precio del Trabajo
	public abstract float getPrecioTrabajo();
	
	// Devuelve la parte fija del precio a cobrar 
	// para cada Trabajo
	protected float getParteFija() {
		return horas_realizadas * PRECIO_HORA;
	}

	// Devuelve un String con identificador, descripci�n y 
	// precio de la reparaci�n chapa y pintura
	@Override
	public String toString() {
		return "Trabajo ID  => " + ID + 
			   ", descripcion => " + descripcion + 
			   ", Precio => " + getPrecioTrabajo();
	}
	
	// Devuelve true si el trabajo est� finalizado y 
	// false en otro caso
	public boolean finalizado() {
		return this.finalizado;
	}
	
	// Suma al atributo horas_realizadas la cantidad 
	// de horas que se pasa como par�metro
	// Devuelve true si se ha podido realizar la operaci�n y 
	// false en otro caso
	public boolean sumaHoras(float horas) {
		if (finalizado()) {
			// Trabajo finalizado
			// Muestra mensaje indicando que no se ha modificado n�mero horas
			System.out.println("Trabajo finalizado. N�mero horas no modificado ");
			return false;
		}else {
			this.horas_realizadas += horas;
			return true;
		}
	}
	
	// Finaliza el Trabajo 
	// (asigna valor true al atributo finalizado)
	public void finalizar() {
		this.finalizado = true;
	}
	
}
