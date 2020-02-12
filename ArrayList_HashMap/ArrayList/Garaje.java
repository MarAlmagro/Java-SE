package uf05.actividad02;

import java.util.ArrayList;

public class Garaje {
	
	// Trabajos que han sido realizados o est�n en proceso de 
	// realizaci�n en el Garaje
	// Los trabajos se guardan en la posici�n del ArrayList que
	// corresponde con la ID del trabajo, es decir, el Trabajo con
	// ID 3 se guarda en la posici�n 3
	private ArrayList<Trabajo> trabajos = new ArrayList<Trabajo>();
	
	// Crea un objeto Trabajo del tipo/subclase especificado en el
	// par�metro "tipo" y devuelve el identificador de dicho Trabajo
	// Si no se puede crear el Trabajo, devuelve -1
	public int registrar_trabajo (TipoTrabajo tipo, String descripcion) {
		Trabajo nuevoTrabajo;
		switch (tipo) {
			case REVISION:
				nuevoTrabajo = new Revision(descripcion);
				break;
			case REP_MECANICA:
				nuevoTrabajo = new RepMecanica(descripcion);
				break;
			case  REP_CHAPA_PINTURA:
				nuevoTrabajo = new RepChapaPintura(descripcion);
				break;
			default:
				// Si no es correcto el tipo de trabajo que
				// se pasa como par�metro devuelve -1
				System.out.println("Error. Tipo de Trabajo no v�lido.");
				return -1;
		}
		
		// A�adir nuevo trabajo al ArrayList trabajos
		int idTrabajo = nuevoTrabajo.getID();
		trabajos.add(idTrabajo, nuevoTrabajo);
		
		// Muestra el identificador asignado al nuevo trabajo
		System.out.println ("Creado " + tipo.toString() + " con ID " + idTrabajo);
		
		// devolver el ID del nuevo trabajo
		return idTrabajo;		
	}
	
	// Aumenta el n�mero de horas que los mec�nicos han dedicado al trabajo
	// Par�metro idTrabajo es el ID del trabajo a modificar
	// Par�metro numhoras es la cantidad de horas a aumentar
	// Devuelve true si se ha actualizado el n� horas y false en otro caso
	public boolean aumentar_horas (int idTrabajo, float numhoras) {
		// Si existe el trabajo y no ha finalizado, actualizamos las horas
		if ( existeId(idTrabajo)) {
			return trabajos.get(idTrabajo).sumaHoras(numhoras);	
		}
		return false;		
	}
	
   // Aumenta el coste de las piezas utilizadas en una reparaci�n
	// Par�metro idTrabajo es el ID del trabajo a modificar
	// Par�metro numhoras es la cantidad de horas a aumentar
	// Devuelve true si se ha actualizado el n� horas y false en otro caso
	public boolean aumentar_coste_piezas (int idTrabajo, float coste) {
		if ( !existeId (idTrabajo ) )		
			return false;
		
		Trabajo trabajo = trabajos.get(idTrabajo);
		
		// S�lo se puede aumentar el coste de las piezas si el trabajo
		// es una reparaci�n
		if ( !(trabajo instanceof Reparacion)) {
			System.out.println("Coste piezas no modificado "
					+ "porque el trabajo no es una reparaci�n");
			return false;
		}
		
		return ((Reparacion) trabajo).sumar_coste_piezas(coste);
	}
	
	// Devuelve true si existe el trabajo con el ID que se
	// pasa como par�metro y false en otro caso
	private boolean existeId (int idTrabajo) {
		if ( idTrabajo >= 0 && idTrabajo < trabajos.size() )
			return true;
		// Informa error : id trabajo incorrecto/no existe
		System.out.println("No existe trabajo con ID : " + idTrabajo);
		return false;
	}

	// Finaliza el trabajo cuya ID es la que se pasa como par�metro
	public void finalizar_trabajo (int idTrabajo) {
		// Si existe un trabajo con el id que se pasa como par�metro
		// lo finalizamos
		if (existeId (idTrabajo)) 
			trabajos.get(idTrabajo).finalizar();	
	}
	
	// Muestra la informaci�n del trabajo cuya ID es la 
	// que se pasa como par�metro
	public void mostrar_trabajo (int idTrabajo) {
		// Si existe un trabajo con el id que se pasa como par�metro
		// mostramos su informaci�n
		if (existeId (idTrabajo)) 
			System.out.println(trabajos.get(idTrabajo).toString());
	}
	
	// Muestra todos los trabajos
	public void mostrarTodos () {		
		for ( Trabajo t : trabajos ) 
			System.out.println("\t" + t.toString());
	}
	
	// Devuelve el trabajo cuya ID es el valor 
	// que se pasa como par�metro
	// Si el trabajo no existe devuelve null
	public Trabajo getTrabajo (int idTrabajo) {
		if (existeId (idTrabajo)) 
			return trabajos.get( idTrabajo );
		return null;
	}
	
	// Devuelve true si el trabajo existe y esta finalizado
	// Devuelve false en otro caso
	public boolean estaFinalizado(int idTrabajo) {
		if (existeId (idTrabajo))
			return trabajos.get(idTrabajo).finalizado();
		return false;
	}
}
