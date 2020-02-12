
package actividad05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Clase que define funciones para trabajar con un directorio y realizar 
// diferentes acciones con los archivos contenidos en un directorio : crear  
// un directorio en la carpeta del proyecto, crear un archivo en un directorio,
// mostrar los archivos contenidos en un directorio, modificar archivo 
// contenido en un directorio, renombrar archivo contenido en un directorio, 
// borrar un archivo contenido en un directorio
public class Archivos {
 
    // Pide por consola un nombre de archivo y crea un nuevo archivo con el
    // nombre indicado.
    // Parámetro "directorio" tipo "File" que referencia la carpeta en la 
    // que se va a crear el nuevo archivo.
    // Sin retorno de valores.
    public static void nuevoArchivo(File directorio){
        
        // Texto que solicita nombre para el archivo que se va a crear
        String nombreArchivo = 
               Lectura.pedirString("Introduzca nombre del nuevo archivo : ");
        // Referencia al nuevo archivo
        File nuevoArchivo = new File (directorio, nombreArchivo);
        
        try { // tratamiento de excepciones
            
            // Si ya existe un arvhivo con el mismo nombre que el arvhivo 
            // a crear
            if (!nuevoArchivo.createNewFile())
                // Mostrar mensaje error de arvhico ya existente
                System.out.println( "Error. Ya existe el archivo : " +
                                     nombreArchivo);
            else {
                // El nuevo archivo se ha creado correctamente y se rellena
                // con un texto introducido por el usuario
                rellenarArchivo(nuevoArchivo);
            }
        }catch (IOException e){ // Error entrada/salida
            System.out.println("\n\tError entrada/salida. Archivo no creado.");
        }
    }
 
    // Pide un texto por consola, lee el texto introducido y lo utiliza para 
    // sustituir el contenido de un fichero.
    // Parámetro "archivo" que referencia al fichero cuyo texto se va a 
    // sustituir.
    // Sin retorno de valores.
    public static void rellenarArchivo(File archivo){
        
        try { //control de excepciones
            
            //Stream conectado al fichero "archivo"
            FileWriter fw = new FileWriter(archivo);
            //Buffer que almacena datos hacia el stream "fw"
            BufferedWriter bw = new BufferedWriter(fw);
            
            // Pedir por consola al usuario el texto que quiere introducir en  
            // el fichero, leer dicho texto y guardarlo en la variable 
            // "texto" de tipo "String"
            String texto = Lectura.pedirString("\n\tTexto a introducir en el " 
                                                 + "archivo : " );
            
            // Guarda en el buffer el texto a escribir en el fichero
            bw.write(texto);
            
            // Escribir en el fichero todo el texto que queda pendiente y 
            // vaciar el buffer
            bw.flush();
            
            // Finalizar comunicación con el fichero        
            bw.close();
            
        }catch (IOException e){ // Error de entrada/salida
          System.out.println("Error. No se ha podido escribir en el archivo.\n");
        }
    }
 
    // Muestra por consola los nombres de los archivos contenidos en un
    // directorio (sólo los ficheros, no directorios).
    // Parámetro "directorio" tipo "File" referencia al directorio que contiene
    // los archivos que se van a mostrar.
    // Retorna un "array" de elementos "String" que contiene las rutas de los
    // ficheros contenidos en el directorio.
    // Lanza excepcion "SecurityException" si no tenemos permiso para leer
    // el directorio que se pasa como parámetro
    public static File[] listarArchivos(File directorio)
                                        throws SecurityException {
      
        
        // Array que contiene las rutas de los archivos contenidos en el
        // directorio
        File[] contenido = directorio.listFiles();
        
        // Número de archivos(no directorios) que contiene el directorio.
        // Variable entera inicializada a 0
        int numArchivos = 0;
        
        // No tenemos permisos para leer el directorio
        if (contenido == null)
            throw new SecurityException();
        
        // Titulo del listado nombres que se va a mostrar en pantalla 
        System.out.println("\tArchivos disponibles : \n");
        
        // Recorre el array "contenido" y para cada ruta de archivo comprueba
        // si dicha ruta referencia a un archivo (no directorio). Si una ruta
        // corresponde a archivo muestra en consola el nombre del archivo e 
        // incrementa en 1 el contador de número de archivos ( variable 
        // "numArchivos"
        for (int i=0; i<contenido.length; i = i+1){            
            if ( contenido[i].isFile() ){
                numArchivos = numArchivos + 1;
                System.out.println ("\t\t" + numArchivos + ".- " + 
                                            contenido[i].getName());
            }
        }
        
        // Array tipo "File" que guarda la ruta de los archivos(no directorios)
        // contenidos en el directorio que se pasa como parámetro
        File[] soloArchivos = new File[numArchivos];
        
        // Si carpeta "directorio" contiene algún archivo que no es directorio, 
        // guarda en el array "soloArchivos" los archivos(no directorios)        
        // contenidos en lacarpeta "directorio" que se pasa como parámetro
        if (numArchivos > 0)
            for (int i=0, j=0; i<contenido.length; i = i+1){   
                if (contenido[i].isFile()){
                    soloArchivos[j] = contenido[i];
                    j = j+1;
                }   
            }
        else
            // La carpeta "directorio" que se pasa como parámetro está vacía o 
            // no contiene archivos que no sean directorios
            System.out.println("\t\tAviso. Directorio sin archivos.\n");
        
        // Retorna el array tipo "File" que contiene la ruta de los archivos
        // (no directorios) contenidos en la carpeta "directorio" que se pasa 
        // como parámetro.          
        return soloArchivos;
    }
    
    // Muestra por consola los nombres de los archivos contenidos en un
    // directorio y permite al usuario elegir un archivo para borrarlo.
    // Parámetro "directorio" tipo "File" que referencia al directorio que 
    // contiene el archivo a borrar.
    // Sin retorno de valores.
    // Lanza expeción "IOException" si se produce un error al leer los datos
    // de la consola.
    // No se realiza el tratamiento de la excepción "IOException", que debe ser 
    // tratada en el bloque externo de código que ha llamado a esta función.
    public static void borrarArchivo(File directorio) throws IOException{
        
        // Ficheros contenidos en el directorio que se pasa como parámetro.
        // No incluye directorios
        File[] contenido = listarArchivos(directorio);
        
        // Si el directorio contiene al menos un fichero que no sea directorio
        if (contenido.length >0){
           // Texto para pedir al usuario el número de archivo que desea
           // borrar
           String mensaje = "\n\tIntroduzca número de fichero a borrar (del 1 "
                            + "al " + contenido.length + ") : ";
           
           // Pedir el número de archivo que desea borrar el usuario
           // y guardar el valor en la variable "numArchivo"
           int numArchivo = Lectura.pideEntero(mensaje, 1, contenido.length);
           
           // Muestra mensaje de error si no se ha podido borrar archivo
           if (!contenido[numArchivo - 1].delete())
               System.out.println("Error. No se ha podido borrar el archivo\n");
        }
     }
  
    // Muestra por consola los nombres de los archivos contenidos en un
    // directorio y permite al usuario elegir uno de los archivos para 
    // renombrarlo.
    // Parámetro "directorio" tipo "File" que referencia al directorio que 
    // contiene el archivo que se va a renombrar.
    // Sin retorno de valores.
    // Lanza expeción "IOException" si se produce un error al leer los datos
    // de la consola.
    // No se realiza el tratamiento de la excepción "IOException", que debe ser 
    // tratada en el bloque externo de código que ha llamado a esta función.
    public static void renombrarArchivo(File directorio) throws IOException{
        
        // Ficheros contenidos en el directorio que se pasa como parámetro.
        // No incluye los directorios.
        File[] contenido = listarArchivos(directorio);
        
        // Si el directorio contiene al menos un fichero que no sea directorio
        if (contenido.length >0){
           // Texto para pedir al usuario el número de archivo que desea
           // renombrar
           String mensaje = "\n\tIntroduzca número de fichero para cambiar"
                   + " nombre (del 1 al " + contenido.length + ") : ";           
           // Pedir por consola el número de archivo que desea borrar el usuario
           // y guardar el valor en la variable "numArchivo"
           int numArchivo = Lectura.pideEntero(mensaje, 1, contenido.length);
           // Texto para pedir al usuario el nuevo nombre del archivo
           mensaje = "\tIntroduzca nuevo nombre del fichero : ";
           // Pedir por consola el nuevo nombre del archivo y guardarlo en la
           // variable "nuevoNombre"
           String nuevoNombre = Lectura.pedirString(mensaje);
           // Crear una ruta al archivo con el nuevo nombre de archivo
           File nuevoArchivo = new File (directorio, nuevoNombre);
           // Cambiar el nombre del archivo
           // Si no se puede renombrar se muestra mensaje error en consola
           if (!contenido[numArchivo - 1].renameTo(nuevoArchivo)){
              System.out.println("\nError. No se ha podido renombrar "
                                    + "el archivo\n");
           }
        }
    }
    
    
    // Muestra en consola los archivos(no directorios) contenidos en una 
    // carpeta y permite al usuario elegir un documento para mostrar 
    // su contenido en la consola.
    // Parámetro "directorio" tipo "File" que referencia a la carpeta que 
    // contiene el documento cuyo contenido se va a mostrar  en consola.
    // Sin retorno de valores.
    // Lanza expeción "IOException" si se produce un error al leer los datos
    // de la consola. La excepción debe ser tratada en el bloque externo de 
    // código que ha llamado a esta función.
    public static void mostrarContenidoArchivo(File directorio) 
                                                           throws IOException{
        // Ruta de los ficheros contenidos en la carpeta que se pasa 
        // como parámetro. No incluye los directorios.
        File[] contenido = listarArchivos(directorio);
        
        if (contenido.length >0){
           // Texto que solicita el número de fichero cuyo contenido se desea
           // mostrar 
           String mensaje = "\n\tIntroduzca número fichero para ver contenido"
                   + "(del 1 al " + contenido.length + ") : ";
           // Pedir por consola el número de archivo que el usuario desea m
           // mostrar y guardar el valor en la variable "numArchivo"
           int numArchivo = Lectura.pideEntero(mensaje, 1, contenido.length);
           try { //control de excepciones
            
                //Stream conectado al fichero "archivo"
                FileReader fr = new FileReader(contenido[numArchivo-1]);
                //Buffer que almacena datos hacia el stream "fw"
                BufferedReader br= new BufferedReader(fr);
                // Lee una línea del fichero
                String linea = br.readLine();
                // Si el documento no está vacío
                if (linea != null)
                    // Leer una línea del documento y mostrarla en consola
                    // hasta que se alcance el final del documento
                    while (linea != null){
                        System.out.println(linea);
                        linea = br.readLine();
                    }
                else
                    // Mostrar mensaje indicando que el documento está vacío
                    System.out.println("\tEl archivo esta vacío.");
                
                // Finalizar comunicación con el fichero
                br.close();
            
            }catch (IOException e){ // Error entrada salida al leer documento
                System.out.println("\tError. No se ha podido leer el archivo.\n");
            }
        }
    }
   
    // Permite al usuario elegir un documento de la carpeta que se pasa como
    // parámetro y a continuación solicita un nuevo texto que va a sustituir
    // el texto contenido en el documento que ha seleccionado el usuario.
    // Parámetro "directorio" de tipo "File" que es una referencia a la carpeta
    // que contiene el archivo cuyo contenido se va a modificar.
    // Lanza expeción "IOException" si se produce un error al leer los datos
    // de la consola. La excepción debe ser tratada en el bloque externo de
    // código que ha llamado a esta función.
    // No retorna valores.
    public static void modificarArchivo(File directorio)throws IOException{
        // Ruta de los ficheros contenidos en el directorio que se pasa como 
        // parámetro. No incluye los directorios.
        File[] contenido = listarArchivos(directorio);
        // Si la carpeta "directorio" que se pasa como parámetro contiene algún
        // documento que no sea directorio
        if (contenido.length >0){
           // Texto solicitando al usuario el número de documento que quiere
           // modificar
           String mensaje = "\n\tIntroduzca número fichero a modificar"
                   + "(del 1 al " + contenido.length + ") : ";
           // Solicita al usuario el número de documento que quiere modificar
           // y guarda dicho número en la variable entera "numArchivo"
           int numArchivo = Lectura.pideEntero(mensaje, 1, contenido.length);
           // Modifica contenido del archivo seleccionado con el texto que 
           // escriba el usuario en la consola
           rellenarArchivo(contenido[numArchivo-1]);
        }
    }
  
    // Crea el directorio(si no existe)cuya ruta absoluta se pasa como parámetro.
    // Parámetro "directorio" de tipo "File" que contiene la ruta absoluta
    // del directorio que se va a crear.
    // Retorna un valor "boolean" que es "true" si se ha podido crear el 
    // y "false" en otro caso.    
    public static boolean crearDirectorio(File directorio){
        
        // Indica si el directorio se ha podido crear (valor "true") o 
        // no (valor "false"). Inicializada a "true"
        boolean directorioCreado = true;
        
        // Creamos el directorio si no existe
        if (!directorio.exists()){
              // Crea el directorio "carpeta" . Si se produce un error y no se 
              // puede crear se muestra mensaje de error y asigna el valor
              // "false" a la variable booleana  "directorioCreado" 
              if (!directorio.mkdir()){
                  System.out.println("Error. No se ha podido crear el " +
                                  "directorio '" + directorio.getName() + "'");
                  directorioCreado = false;
              }
           }  
        // retorna la variable booleana "directorioCreado" que es "true" sólo
        // si se ha podido crear la carpeta "directorio" que se pasa como
        // parámetro a esta función
        return directorioCreado;
    }
}
