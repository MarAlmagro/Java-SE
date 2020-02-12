 
package actividad04;

import java.io.IOException;

// Programa que pide al usuario las puntuaciones decimales que ha obtenido
// una película y muestra un menú de opciones para que el usuario pueda 
// seleccionar diferentes acciones a realizar con las puntuaciones de la 
// película. El programa no termina hasta que el usuario seleccione la opción
// del menú de finalizar programa
public class Ejercicio01 {
    
    // Texto que contiene el título del menú de opciones
    private static final String TITULO_MENU = "Menú Principal";
    
    // Array de String que guarda el texto de las opciones del menú 
    private static final String[] OPCIONES_MENU = { 
                              "Modificar puntuación", 
                              "Ver puntuación más alta",
                              "Ver puntuación media",
                              "Puntuaciones menores que..",
                              "Salir" };      
    
    // Número que corresponde a la primera opción del menú
    private static final int MIN_OPCION_MENU = 1; 
    
    // Numero de opciones que tiene el menú
    private static final int MAX_OPCION_MENU = OPCIONES_MENU.length;  
    
    // Numero de puntuaciones que se guardan para la película
    private static final int NUM_PUNTUACIONES = 5;
    
    // Valor mínimo que puede tener la puntuación de una película
    private static final double MIN_PUNTUACION = 0.0;
    
    // Valor máximoo que puede tener la puntuación de una película
    private static final double MAX_PUNTUACION = 5.0;
    
    public static void main(String[] args) {
        
        // Variable booleana con valor true hasta que el usuario teclee la 
        // opción 5 de finalizar programa / Salir
        boolean seguir=true;
        
        // variable entera que guarda la opción del menú que ha seleccionado
        // el usuario
        int opcionSeleccionada;     
        
        // "Array" de tipo "double" que almacena los valores de las 
        // puntuaciones decimales que ha obtenido una película 
        double[] puntuaciones = new double[NUM_PUNTUACIONES];
        
        
        try{ // tratamiento de excepciones
            
            // Pedir al usuario las puntuaciones de una película y guardarlas en
            // el array "puntuaciones". Los valores de las puntuaciones deben 
            // ser >= que "MIN_PUNTUACION" y <= que "MAX_PUNTUACION"
            Funciones.solicitarPuntuaciones( puntuaciones, 
                                             MIN_PUNTUACION, 
                                             MAX_PUNTUACION);
            
            // Mostrar las puntuaciones de la película
            Funciones.mostrarPuntuaciones(puntuaciones);
            
            // Mientras que el usuario no seleccione opción 5 / Salir
            while (seguir){
                
                //Mostrar el menú opciones 
                Menu.mostrarMenu(TITULO_MENU, OPCIONES_MENU);
               
                // Texto que solicita al usuario introducir un número de opción  
                // del menú que sea >= que "MIN_OPCION_MENU" y 
                // <= que "MAX_OPCION_MENU"
                String mensajeUsuario = "Seleccione una opción del menú (" +
                     "de " + MIN_OPCION_MENU + " a " + MAX_OPCION_MENU + ") : ";
                
                // Muestra en consola un mensaje solicitando al usuario que 
                // introduzca un número de opción del menú y guarda dicho 
                // valor en la variable "opcionSeleccionada"
                // El número de opción del menú introducido debe ser 
                // >= que "MIN_OPCION_MENU" y <= que "MAX_OPCION_MENU"
                opcionSeleccionada = Lectura.pideEntero( mensajeUsuario, 
                                                           MIN_OPCION_MENU, 
                                                           MAX_OPCION_MENU);     
                
               
                switch(opcionSeleccionada){
                    // Según la opción del menú seleccionada, realizamos 
                    // las acciones correspondientes
                    case 1 : 
                        // Modificar una de las puntuaciones de la película
                        // Se solicita al usuario el número de puntuación
                        // que desea modificar y también cuál tiene que ser
                        // su nuevo valor. El nuevo valor de la puntuación
                        // es >= que "MIN_PUNTUACION" y <= que "MAX_PUNTUACION"
                        Funciones.modificarPuntuacion( puntuaciones,
                                                       MIN_PUNTUACION, 
                                                       MAX_PUNTUACION );
                        break;
                    case 2 :
                        // Mostar en consola la puntuación más alta
                        Funciones.puntuacionMasAlta(puntuaciones);
                        break;
                    case 3:  
                        // Mostar en consola la puntuación media
                        Funciones.puntuacionMedia(puntuaciones);
                        break;
                    case 4:  
                        // Pide un número al usuario y muestra las puntuaciones
                        // menores que el número indicado.
                        // El número indicado debe ser >= que "MIN_PUNTUACION"
                        // y <= que "MAX_PUNTUACION"
                        Funciones.puntuacionesMenoresQue( puntuaciones,
                                                          MIN_PUNTUACION, 
                                                          MAX_PUNTUACION );
                        break;
                    case 5:
                        // El usuario ha introducido opción cinco para 
                        // terminar el programa. Se muestra mensaje aviso  
                        // de fin de programa y asignamos valor false a 
                        // la variable "seguir"
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
