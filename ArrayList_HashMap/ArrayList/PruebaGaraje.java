package uf05.actividad02;

public class PruebaGaraje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Garaje garaje = new Garaje();
		
		System.out.println("\n\tAñadir tres nuevos trabajos al garaje\r\n\n" + 
				"		int idRepChapa = \r\n" + 
				"				garaje.registrar_trabajo(TipoTrabajo.REP_CHAPA_PINTURA, \"REP_CHAPA_PINTURA\");\r\n" + 
				"		int idRevision = \r\n" + 
				"				garaje.registrar_trabajo(TipoTrabajo.REVISION, \"REVISION\");\r\n" + 
				"		int idRepMec01 = \r\n" + 
				"				garaje.registrar_trabajo(TipoTrabajo.REP_MECANICA, \"REP_MECANICA_01\");\r\n" +
				"		int idRepMec02 = \r\n" + 
				"				garaje.registrar_trabajo(TipoTrabajo.REP_MECANICA, \"REP_MECANICA_02\");\n\n");

		// Añadir cuatro nuevos trabajos al garaje
		int idRepChapa = 
				garaje.registrar_trabajo(TipoTrabajo.REP_CHAPA_PINTURA, "REP_CHAPA_PINTURA");
		int idRevision = 
				garaje.registrar_trabajo(TipoTrabajo.REVISION, "REVISION");
		int idRepMec01 = 
				garaje.registrar_trabajo(TipoTrabajo.REP_MECANICA, "REP_MECANICA_01");
		int idRepMec02 = 
				garaje.registrar_trabajo(TipoTrabajo.REP_MECANICA, "REP_MECANICA_02");
		
		System.out.println("\n\t\tListado trabajos : \n");
		garaje.mostrarTodos();
		
		System.out.println("\n\t\tMostrar trabajo con ID 2 : \n");
		garaje.mostrar_trabajo(2);
		
		System.out.println("\n\t\tMostrar trabajo con ID 10 : \n");
		garaje.mostrar_trabajo(10);
		
		System.out.print("\n\nFinalizado trabajo con ID 3 ? => ");
		System.out.println(garaje.estaFinalizado(3));
		
		System.out.print("\nFinalizado trabajo con ID 10 ? => ");
		System.out.println(garaje.estaFinalizado(10));
		
		System.out.println("\n\t\tFinalizamos trabajo con ID 3 : \n");
		System.out.println("\tgaraje.finalizar_trabajo(3);\n");
		garaje.finalizar_trabajo(3);
				
		System.out.print("\tFinalizado trabajo con ID 3 ? => ");
		System.out.println(garaje.estaFinalizado(3));

		// Modificar numero horas de un trabajo terminado
		System.out.println("\n\n\tModificar numero horas de un trabajo terminado\r\n" + 
				"		garaje.aumentar_horas(3, 1);\n"); 
		garaje.aumentar_horas(3, 1);
		
		// Modificar coste piezas de una reparación terminada	
		System.out.println("\n\tModificar coste piezas de reparación terminada\r\n" + 
				"		garaje.aumentar_coste_piezas (3, 1.0f);\n"); 
		garaje.aumentar_coste_piezas (3, 1.0f);
		
		// Modificar numero horas de un trabajo no terminado
		System.out.println("\n\n\tModificar numero horas de un trabajo no terminado\r\n" + 
				"		garaje.aumentar_horas(2, 1);\n"); 
		garaje.aumentar_horas(2, 1);
		
		// Modificar coste piezas de una reparación no terminada	
		System.out.println("\n\tModificar coste piezas de reparación no terminada\r\n" + 
				"		garaje.aumentar_coste_piezas (2, 1.0f);\n"); 
		garaje.aumentar_coste_piezas (2, 1.0f);
		
		// Mostrar datos de la reparación que acaba de modificarse

		System.out.println("\n\tMostrar datos de la reparación que acaba de modificarse\r\n" + 
				"		garaje.mostrar_trabajo(2);\n");
		garaje.mostrar_trabajo(2);
		
		// Aumentar coste piezas de un trabajo que NO es reparación		
		System.out.println("\n\n\tAumentar coste piezas de un trabajo que NO es reparación\r\n" + 
				"		garaje.aumentar_coste_piezas (1, 1.0f);\n");
		
		// Comprobar cálculo del precio trabajo. Establecer 1 hora y precio 1.0f
		// en los 3 primeros trabajos
		garaje.aumentar_coste_piezas (0, 1.0f);
		garaje.aumentar_horas(0, 1);
		garaje.aumentar_horas(1, 1);
		
		System.out.println("\n\tComprobar cálculo del precio trabajo." + "\n Establecer 1 hora y precio 1.0f" + 
				" en los 3 primeros trabajos\r\n\n" + 
				"		garaje.aumentar_coste_piezas (0, 1.0f);\r\n" + 
				"		garaje.aumentar_horas(0, 1);\r\n" + 
				"		garaje.aumentar_horas(1, 1);\n");
		
		// Mostrar los trabajos
		System.out.println("\n\t\tListado trabajos : \n");
		garaje.mostrarTodos();
		
		
	}

}
