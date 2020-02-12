
package actividad07;

import actividad08.vehiculos.Vehiculo;
import actividad07.vehiculos.IVehiculo;
import actividad08.vehiculos.Utilidades;
import actividad08.vehiculos.ErrorLectura;
import actividad08.vehiculos.Coche;
import actividad07.vehiculos.Carga;
import actividad07.vehiculos.Camion;
import java.io.IOException;
import java.util.Locale;

// Programa que crea un array de objetos "Vehiculo" y muestra en consola un
// menú de opciones que permite al usuario elegir una acción a realizar
// con dicho array y los vehículos que contiene.
public class GestionVehiculos {
    
    // Número de vehículos que vamos a gestionar
    private static final int NUM_VEHICULOS = 4;
    
    // "Array" de "String" que guarda el texto de las opciones del menú 
    private static final  String[] OPCIONES_MENU = {
                                                    "Añadir coche", 
                                                    "Añadir carga",
                                                    "Añadir camión",
                                                    "Mostrar vehículo",
                                                    "Cambiar días de alquiler",
                                                    "Mostrar flota", 
                                                    "Salir" 
                                                   };
    
    // Número que corresponde a la primera opción del menú
    private static final int MIN_OPCION_MENU = 1; 
    
    // Numero de opciones que tiene el menú
    private static final int MAX_OPCION_MENU = OPCIONES_MENU.length;  
    
    public static void main(String[] args) {
        // para que al mostrar los valores por consola el separador decimal 
        // sea el punto.
        Locale.setDefault(Locale.ENGLISH);
        
        // Array que almacena los vehículos
        IVehiculo[] flota = new Vehiculo [NUM_VEHICULOS]; 
        
        // variable entera que guarda la opción del menú que ha seleccionado
        // el usuario
        int opcionSeleccionada;    
        
        // Texto que solicita al usuario introducir un número de opción
        // del menú que sea >= que el número de la primera opción del
        // menú y <= que el número de la última opción del menú
        String mensajeUsuario = "Seleccione una opción del menú (de " +
                        MIN_OPCION_MENU + " a " + MAX_OPCION_MENU + ") : ";
        
        // Variable booleana con valor true hasta que el usuario teclee la 
        // opción 7 de finalizar programa / Salir. Inicializada a true;
        boolean seguir = true;
        
        try{ // tratamiento de excepciones 
            
            //Mientras que el usuario no seleccione opción 7 / Salir
            while (seguir){
                
                // Mostrar en consola el menú de opciones 
                Menu.mostrarMenu("Menú Principal", OPCIONES_MENU);                
                               
                // Muestra en consola un mensaje solicitando al usuario que 
                // introduzca un número de opción del menú y guarda dicho 
                // valor en la variable "opcionSeleccionada"
                // El número de opción del menú introducido debe ser 
                // >= que "MIN_OPCION_MENU" y <= que "MAX_OPCION_MENU"
                opcionSeleccionada = 
                                   Utilidades.pedirEntero( mensajeUsuario, 
                                                           MIN_OPCION_MENU, 
                                                           MAX_OPCION_MENU); 
                
                System.out.println();
                
                switch(opcionSeleccionada){
                    // Según la opción del menú seleccionada, realizamos 
                    // las acciones correspondientes.
                    case 1 :   
                        // Crea una variable de tipo "Coche" y la añade a 
                        // la flota.
                        Gestiones.agregarVehiculo(flota, new Coche());
                        break;
                    case 2 :       
                        // Crea una variable de tipo "Carga" y la añade a 
                        // la flota.
                        Gestiones.agregarVehiculo(flota, new Carga());
                        break;
                    case 3:      
                        // Crea una variable de tipo "Camión" y la añade a 
                        // la flota.
                        Gestiones.agregarVehiculo(flota, new Camion());
                        break;
                    case 4:     
                        // Muestra la información de cualquier vehículo de la
                        // flota.
                        Gestiones.mostrarInfoVehiculo(flota);
                        break;
                    case 5:     
                        // Modifica los días de alquiler de un vehículo de la
                        // flota y muestra el precio de su alquiler.
                        Gestiones.modificarDiasAlquiler(flota);
                        break;
                    case 6:     
                        // Mostrar la información de todos los vehículos de 
                        // la flota
                        Gestiones.mostrarInfoFlota(flota);
                        break;
                    case 7:
                        // El usuario ha introducido opción siete para 
                        // terminar el programa. Se muestra mensaje aviso  
                        // de fin de programa y asignamos valor false a 
                        // la variable "seguir".
                        System.out.println("\tFin programa.\n");
                        seguir = false;
                        break;
                }
            }        
        }catch (IOException | ErrorLectura e){ 
            System.out.println("\nError de lectura\n");
        }
    }  
 
}
