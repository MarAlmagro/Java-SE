
package actividad05;

import java.io.IOException;
import java.io.File;

// Programa que crea una carpeta dentro del directorio del proyecto y muestra
// en consola un menú de opciones que permite al usuario elegir una acción a
// realizar con los archivos contenidos dentro de dicha carpeta o crear nuevos 
// archivos y añadirlos a la carpeta
public class Ejercicio01 {     
     
    // "Array" de "String" que guarda el texto de las opciones del menú 
    private static final  String[] OPCIONES_MENU = {
                                                    "Nuevo Archivo", 
                                                    "Listar Archivos",
                                                    "Mostrar Contenido Archivo",
                                                    "Borrar Archivo",
                                                    "Modificar Archivo",
                                                    "Renombrar Archivo",
                                                    "Salir" 
                                                   };
    
    // Número que corresponde a la primera opción del menú
    private static final int MIN_OPCION_MENU = 1; 
    
    // Numero de opciones que tiene el menú
    private static final int MAX_OPCION_MENU = OPCIONES_MENU.length;  

    // Nombre de la carpeta que se crea(si no existe) dentro del directorio 
    // del proyecto y que se va a utilizar como ruta relativa para realizar 
    // todas las acciones que se ofrecen al usuario en el menú de opciones
    private static final String NOMBRE_CARPETA = "archivos"; 

    // Ruta absoluta a la carpeta "NOMBRE_CARPETA" ubicada en el directorio del
    // proyecto
    private static final String RUTA_CARPETA = System.getProperty("user.dir") +
                                               File.separator + 
                                               NOMBRE_CARPETA;
    // Función principal del programa.
    // Crea una carpeta en el directorio del proyecto.
    // Muestra por consola un menú de opciones para realizar diferentes acciones 
    // dentro de la carpeta creada. Permite al usuario elegir una de las 
    // opciones. El programa no finaliza hasta que el usuario seleccione la 
    // opción de Salir/Terminar programa.    
    public static void main(String[] args){   
        
        // variable entera que guarda la opción del menú que ha seleccionado
        // el usuario
        int opcionSeleccionada;    
        // Variable tipo "File" que hace referencia al directorio especificado
        // en "NOMBRE_CARPETA"
        File carpeta = new File (RUTA_CARPETA); 
        
        // Variable booleana con valor true hasta que el usuario teclee la 
        // opción 5 de finalizar programa / Salir
        boolean seguir;
               
        try{ // tratamiento de excepciones 
            // Crea el directorio "carpeta" si no existe previamente.
            // Se asigna a la variable "seguir" valor true si se ha podido crear
            // el directorio. Si no se ha podido crear el directorio se asigna
            // valor "false" a la variable "seguir"           
            seguir = Archivos.crearDirectorio(carpeta);
            // Si se ha podido crear el directorio : Mientras que el usuario 
            // no seleccione opción 7 / Salir
            while (seguir){
                
                // Mostrar en consola el menú de opciones 
                Menu.mostrarMenu("Menú Principal", OPCIONES_MENU);
                
                // Texto que solicita al usuario introducir un número de opción
                // del menú que sea >= que el número de la primera opción del
                // menú y <= que el número de la última opción del menú
                String mensajeUsuario = "Seleccione una opción del menú (de " +
                        MIN_OPCION_MENU + " a " + MAX_OPCION_MENU + ") : ";
                
                // Utiliza función "pideEntero(String)" 
                // que muestra en consola el texto "mensajeUsuario" que se pasa 
                // como parámetro para pedir al usuario un número de opción 
                // del menú. El valor introducido por el usuario se almacena 
                // en la variable "opcionSeleccionada"           
                opcionSeleccionada =
                        Lectura.pideEntero(mensajeUsuario);
                
                // Si el usuario ha introducido un número de opción del menú 
                // que sea correcto (de "MIN_OPCION_MENU" a "MAX_OPCION_MENU")
                if ( ( opcionSeleccionada >= MIN_OPCION_MENU)&&
                     (opcionSeleccionada <=MAX_OPCION_MENU)){
                    
                    switch(opcionSeleccionada){
                        // Según la opción del menú seleccionada, realizamos 
                        // las acciones correspondientes
                        case 1 : 
                            // Pide un nombre de archivo al usuario y crea un
                            // archivo con el nobre indicado dentro del
                            // directorio "carpeta"
                            Archivos.nuevoArchivo(carpeta);
                            break;
                        case 2 :  
                            // Muestra los archivos disponibles en el directorio
                            // "carpeta"
                            Archivos.listarArchivos(carpeta);
                            break;
                        case 3: 
                            // Muestra los archivos disponibles en el directorio
                            // "carpeta" y permite al usuario elegir un archivo
                            // para ver su contenido por consola
                            Archivos.mostrarContenidoArchivo(carpeta);
                            break;
                        case 4:  
                            // Muestra los archivos contenidos en el directorio
                            // "carpeta" y permite al usuario elegir un
                            // documento para borrarlo                          2 
                            Archivos.borrarArchivo(carpeta);
                            break;
                        case 5:   
                            // Muestra los archivos contenidos en el directorio
                            // "carpeta" y permite al usuario elegir un
                            // documento y después le pide un texto para 
                            // sustituir el contenido del archivo seleccionado
                            Archivos.modificarArchivo(carpeta);
                            break;
                        case 6:
                            // Muestra los archivos contenidos en el directorio
                            // "carpeta" y permite al usuario elegir un
                            // documento para renombrarlo
                            Archivos.renombrarArchivo(carpeta);
                            break;
                        case 7:
                            // El usuario ha introducido opción siete para 
                            // terminar el programa. Se muestra mensaje aviso  
                            // de fin de programa y asignamos valor false a 
                            // la variable "seguir"
                            System.out.println("Fin programa.");
                            seguir = false;
                            break;
                    }
                }else {
                    // El usuario ha introducido un número opción distinta de
                    // 1, 2, 3, 4, 5, 6, 7. Muestra un aviso y vuelve
                    // a visualizar el menú de opciones
                    System.out.println("Número de opción no válido.");
                }
            }
        
        }catch (IOException e){ // error en br.readLine()
            System.out.println("Error de lectura");
        }catch (SecurityException e){ 
           // El usuario no tiene permiso de lectura y/o escritura en el 
           // directorio del proyecto
            System.out.println("No tiene permiso lectura y/o escritura en " +
                                "el directorio del proyecto.\n");   
        }
    }
}
