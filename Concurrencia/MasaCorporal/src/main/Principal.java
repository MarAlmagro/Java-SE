package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

// Utiliza la consola para leer y pedir los valores decimales 
// del peso y altura y los utiliza para calcular el �ndice de 
// masa corporal (IMC)
public class Principal {

	
	private static String RUTA_JAR = 
			System.getProperty("user.dir") + "\\CalculadoraIMC.jar"; 
	
	private static String TITULO = 
			"\n\t\t\t**** Calculadora IMC ***\n";
	private static String PEDIR_ALTURA = 
			"Escribe la altura en cm ( 0 para FIN)";
	
	private static String RECORDATORIO = 
			"\tRECUERDA = valores positivos y '.' para separador decimal.\n";
	
	private static String PEDIR_PESO = 
			"Escribe el peso en kg ( 0 para FIN)";
	
	private static String ERROR_FORMATO =
			"\t--- Valor introducido no es n�mero decimal v�lido\n";
	
	private static float ALTURA_MAXIMA = 300f;
	
	private static float PESO_MAXIMO = 700f;
	
	public static void main(String[] args) {
		
		System.out.println(TITULO);		
		System.out.println(RECORDATORIO);
		
		// True si usuario introduce 0 para terminar programa
		boolean finalizar = false;
		
		do {
			try {		
				
				// Obtener(desde la consola) los datos de peso y altura
				float altura = leerFloat ( PEDIR_ALTURA, ERROR_FORMATO,
										   0, ALTURA_MAXIMA );
				if (altura != 0) 
				{
					float peso = leerFloat ( PEDIR_PESO, ERROR_FORMATO,
						  				 	 0, PESO_MAXIMO );
					
					if ( peso != 0 ) 
					{		
						
						// Crear proceso hijo
						Process calcularIMC = 
							new ProcessBuilder( "java", "-jar", RUTA_JAR ).start();
						 
						// Conectar con proceso hijo y enviarle datos del peso y altura 
						enviarDatos(calcularIMC, altura, peso ); 
						
						// Obtener la respuesta enviada por el proceso hijo y mostrarla en la consola
						String respuesta = getRespuesta ( calcularIMC );
						 
						System.out.println ( "\n\t" + respuesta + "\n"); 
					}
					else 
					{
						finalizar = true;
					}				
				}
				else 
				{
					finalizar = true;
				}
				if (finalizar)
					System.out.println("\n\t--- Finalizado por usuario");
			}
			catch (IOException e) 
			{
				System.out.println(e.getMessage());
			}		

			
		}while( !finalizar );
		
	}
	
	// Conectar a la salida estandar del proceso que se pasa como par�metro
	// y devolver su respuesta
	private static String getRespuesta (Process proceso) throws IOException {
		
		BufferedReader br = 
				 new BufferedReader( new InputStreamReader( proceso.getInputStream() ) );	
		
		return br.readLine();
	}
	
	// Conectar a la entrada estandar del proceso que se pasa como par�metro
	// y enviarle el valor de los par�metros "altura" y "peso"
	private static void enviarDatos (Process proceso, float altura, float peso) {
		
		 PrintStream ps = new PrintStream( proceso.getOutputStream(), true );	
		 ps.println( altura );
		 ps.println( peso );
	}
	
	/**
	 * Pedir y leer de la consola un n�mero decimal (float)
	 * @param mensajePeticion Texto que se muestra para pedir el valor
	 * @param mensajeError Texto que se muestra si el valor introducido
	 *                     no es un n�mero decimal v�lido
	 * @param minimo m�nimo valor que puede tener el n�mero decimal
	 * @param maximo m�ximo valor que puede tener el n�mero decimal
	 * @return valor leido
	 * @throws IOException
	 */
	private static float leerFloat( String mensajePeticion, 
							 		String mensajeError, 
							 		float minimo,
							 		float maximo) throws IOException {
		float valorFloat = -1;
		boolean floatNoValido = true;
		
		while (floatNoValido) {
			
			try {
				
				System.out.println(mensajePeticion);
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
				valorFloat = Float.parseFloat( in.readLine() );
				if (valorFloat < minimo || valorFloat > maximo) {
					System.out.println(
							"\t--- Valor debe ser >= " + minimo + " y <= " + maximo + "\n");
				}
				else { 
					floatNoValido = false; 
			    }				
				
			}catch(NumberFormatException e) {
				System.out.println(mensajeError);
			}
			
		}
		
		return valorFloat;
	}

}
