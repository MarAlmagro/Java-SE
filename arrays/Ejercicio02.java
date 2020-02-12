 
package actividad04;

import java.io.IOException;

// Programa que almacena en un array bidimensional tipo "String" el nombre
// y tres puntuaciones de 5 películas y muestra un menú de opciones al usuario 
// para que pueda elegir una acción a realizar con las películas y sus 
// puntuaciones.
public class Ejercicio02 {    

    // Número de puntuaciones que tiene una película
    private static final int NUM_PUNTUACIONES = 3;
    
    // Número de filas que tiene el array bidimensional que almacena los
    // nombres de las películas y sus puntuaciones
    private static final int NUM_FILAS = NUM_PUNTUACIONES + 1;
    
    // Número de películas que vamos a almacenar
    private static final int NUM_PELICULAS = 5;
    
    // Valor mínimo que puede tener la puntuación de una película
    private static final double MIN_PUNTUACION = 0.0;
    
    // Valor máximoo que puede tener la puntuación de una película
    private static final double MAX_PUNTUACION = 10.0;

    // Texto que contiene el título del menú de opciones
    private static final String TITULO_MENU = "Menú Principal";
    
    // "Array" de "String" que guarda el texto de las opciones del menú 
    private static final String[] OPCIONES_MENU = {
                                  "Mostrar nombre películas", 
                                  "Mostrar puntuaciones película",
                                  "Modificar nombre película",
                                  "Modificar puntuación película",
                                  "Mostrar puntuación más alta película",
                                  "Películas con puntuación media mayor que..",
                                  "Salir" };
    
    // Número que corresponde a la primera opción del menú
    private static final int MIN_OPCION_MENU = 1; 
    
    // Numero de opciones que tiene el menú
    private static final int MAX_OPCION_MENU = OPCIONES_MENU.length; 
    
    // Array bidimiensional tipo "String" que almacena el nombre de las 
    // películas y sus puntuaciones
    private static String[][] peliculas = new String[NUM_PELICULAS][NUM_FILAS];
    
   
    
    // Función principal del programa. Pide al usuario los nombres de 5 
    // películas y 3 puntuaciones decimales para cada película. Almacena esos 
    // valores en un array bidimensional tipo "String". Muestra un menú de 
    // opciones para que el usuario pueda elegir una acción realizar con el 
    // nombre de unapelícula o sus puntuaciones. El programa no termina hasta 
    // que el usuario seleccione la opcióndel menú de finalizar programa.
    public static void main(String[] args) {
        
    
        // Variable booleana con valor true hasta que el usuario teclee la 
        // opción 7 de finalizar programa/Salir
        boolean seguir=true;
        
        // variable entera que guarda la opción del menú que ha seleccionado
        // el usuario
        int opcionSeleccionada;   
        
        try{ // tratamiento de excepciones
            
            // Pedimos al usuario los nombres y puntuaciones de las películas y
            // almacenamos los valores introducidos en la variable "peliculas"
            Funciones.rellenarPeliculas(peliculas);        
            
            // Mientras que el usuario no seleccione opción 7 / Salir, 
            // mostramos el menú de opciones, pedimos al usuario un  número de 
            // opción y  ejecutamos la acción que corresponda a dicha opción
            while (seguir){
                
                //Mostrar el menú opciones 
                Menu.mostrarMenu(TITULO_MENU, OPCIONES_MENU);
                
                // Texto que pide al usuario introducir el número de opción 
                // del menú 
                String mensajeUsuario = "Seleccione opción del menú " +
                   "(de " + MIN_OPCION_MENU + " a " + MAX_OPCION_MENU + ") : ";
                
                // Muestra en consola un mensaje solicitando al usuario que 
                // introduzca un número de opción del menú y guarda la opción
                // introducida en la variable "opcionSeleccionada"
                opcionSeleccionada = 
                  Lectura.pideEntero( mensajeUsuario, 
                                        MIN_OPCION_MENU, MAX_OPCION_MENU);                
               
                switch(opcionSeleccionada){
                    // Según la opción del menú seleccionada, realizamos 
                    // las acciones correspondientes
                    case 1 : 
                        // Mostrar el nombre de todas las películas.
                        Funciones.mostrarNombres(peliculas);
                        break;
                    case 2 :
                        // Mostrar las puntuaciones de una película.
                        Funciones.mostrarPuntuacionPelicula(peliculas); 
                        break;
                    case 3:  
                        // Modifica el nombre de una película
                        Funciones.cambiarNombre(peliculas);
                        break;
                    case 4:  
                        // Modificar una puntuación de una película
                        Funciones.modificarPuntos(  peliculas, 
                                                    MIN_PUNTUACION, 
                                                    MAX_PUNTUACION); 
                        break;
                    case 5:   
                        // Mostrar la puntuación más alta de una película
                        Funciones.mostrarPuntuacionMasAlta(peliculas);
                        break;
                    case 6:  
                        // Pide un número al usuario y muestra el nombre de
                        // las películas cuya puntuación media sea como 
                        // mínimo el número indicado por el usuario.
                        Funciones.mediaMayorQue( peliculas, 
                                                 MIN_PUNTUACION, 
                                                 MAX_PUNTUACION); 
                        break;
                    case 7:
                        // El usuario ha introducido opción cinco para 
                        // terminar el programa. Se muestra mensaje aviso  
                        // de fin de programa y asignamos valor false a 
                        // la variable "seguir" y finalizar el bucle "while"
                        System.out.println("Fin programa. ");
                        seguir = false;
                        break;
                }
            }
        
        }catch (IOException e){ // error en br.readLine()
            System.out.println("Error de lectura");
        }
    }

}
