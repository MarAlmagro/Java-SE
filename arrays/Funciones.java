
package actividad04;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// Clase que define diferentes funciones para operar sobre un array que 
// contiene las puntuaciones de una película

public class Funciones {
    
    
    /* Solicita por consola al usuario las puntuaciones que ha obtenido 
       una película. Las puntuaciones pueden contener decimales.
       Parámetro "puntuaciones" array de tipo "double" que va a guardar las 
       puntuaciones de la película.
       Parámetro "min" de tipo "double" que indica el valor mínimo(incluido) 
       que puede tener la puntuación de una película.
       Parámetro "max" de tipo "double" que indica el valor máximo(incluido) 
       que puede tener la puntuación de una película.
       Lanza expeción "IOException" si se produce un error al leer los datos
       de la consola.  
       No se realiza el tratamiento de la excepción IOException, que debe ser 
       tratada en el bloque externo de código que ha llamado a esta función 
       No devuelve valores */
    public static void solicitarPuntuaciones (double[] puntuaciones,
                                              double min,
                                              double max )
                                                         throws IOException {      
        // Texto que pide introducir una puntuación
        System.out.println("Introduzca puntuaciones de la película.\n");    
        
        // Solicitar al usuario cada una de las puntuaciones y guardar sus 
        // valores en el array "puntuaciones". La puntuación introducida por
        // el usuario debe ser un valor decimal comprendido entre el valor
        // del parámetro "min" y el valor del parámetro "max"
        for (int i=0; i<puntuaciones.length; i = i+1){                    
          puntuaciones[i] = 
            Lectura.pideDecimal("\tPuntuación_" + (i+1) + " : ", min, max);
        }
    }


    // Solicita al usuario el número de elemento de un array que desea 
    // modificar y cual debe ser el nuevo valor de dicho elemento y asigna
    // el nuevo valor al elemento especificado por el usuario.
    // Parámetro "puntuaciones" array de tipo "double" que contiene las 
    // puntuaciones de una película que se van a modificar.  
    // Parámetro "min" de tipo "double" que indica el valor mínimo(incluido) 
    // que puede tener la puntuación de una película.
    // Parámetro "max" de tipo "double" que indica el valor máximo(incluido) 
    // que puede tener la puntuación de una película. 
    // Lanza expeción "IOException" si se produce un error al leer los datos
    // de la consola.    
    // No se realiza el tratamiento de la excepción IOException, que debe ser 
    // tratada en el bloque externo de código que ha llamado a esta función 
    // Sin retorno de valores 
    public static void modificarPuntuacion( double[] puntuaciones,
                                            double min,
                                            double max ) throws IOException{ 
                                                            
        
        // Muestra en consola el contenido el array "puntuaciones"
        mostrarPuntuaciones(puntuaciones);
        
        // Texto que solicita al usuario el número de elemento del array
        // "puntuaciones" que desea modificar
        String mensaje = "\n\tNúmero de puntuación a modificar (entre 1 y " +
                          (puntuaciones.length) + ") : ";
        
        // Solicita al usuario el número de elemento del array "puntuaciones" 
        // que desea modificar y lo almacena en la variable "posicion" de tipo 
        // "int" 
        int posicion = Lectura.pideEntero(mensaje, 1, puntuaciones.length);
        
        // Texto para solicitar al usuario la nueva puntuación cuyo valor sea
        // >= que el valor del parámetro "min" y <= que el valor del 
        // parámetro "max"
        mensaje = "\tValor nuevo de la puntuación (entre " + min 
                                                        + " y " + max + ") : ";     
        
        // Solicita al usuario el nuevo valor decimal del elemento a modificar 
        // y guarda el valor introducido en la variable "nuevoValor" de tipo 
        // "double". El nuevo valor debe ser >= que el valor del parámetro
        // "min" y <= que el valor del parámetro "max"
        double nuevoValor = Lectura.pideDecimal(mensaje, min, max);
        
        // Asigna el nuevo valor al número de elemento del array "puntuaciones"
        // que ha especificado el usuario
        puntuaciones[posicion - 1] = nuevoValor;        
    } 
    
    // Muestra la puntuación más alta de los valores contenidos en el array
    // que se pasa como parámetro
    // Parámetro "puntuaciones" array tipo "double" del que se va a mostrar 
    // el mayor valor
    // No retorna valores
    public static void puntuacionMasAlta(double[] puntuaciones){
        double max = puntuaciones[0];
        for (int i=1; i<puntuaciones.length; i = i + 1){
            if (max < puntuaciones[i]){
                max = puntuaciones[i];
            }
        }
        System.out.println("\t\tLa puntuación más alta es : " + max);
    }
    
    
    // Devuelve la media aritmética de los valores contenidos en el array
    // que se pasa como parámetro
    // Parámetro "puntuaciones" array tipo "double" que contiene los valores
    // para calcular la media aritmética
    // Retorna un valor "double" que contiene la media aritmética 
    public static double media ( double[] puntuaciones){
        double suma = 0.0;
        for (int i=0; i<puntuaciones.length; i = i+1){
            suma = suma + puntuaciones[i];
        }        
        return ( suma / puntuaciones.length );
    }
    
  
    // Muestra en consola la media de los valores tipo "double" contenidos en
    // array que se pasa como parámetro
    // Parámetro "puntuaciones" array tipo "double" que contiene los valores
    // para calcular la media
    // No devuelve valores
    public static void puntuacionMedia(double[] puntuaciones){
     
        System.out.println("\t\tLa puntuación media es : " +
                                                media(puntuaciones));
    }
    
 
    // Muestra en consola los valores tipo "double" contenidos en el
    // array que se pasa como parámetro
    // Parámetro "puntuaciones" array tipo "double" que contiene los valores
    // que se van a mostrar en la consola
    // No retorna valores
    public static void mostrarPuntuaciones(double[] puntuaciones){
        System.out.print("\tPuntuaciones : ");
        for (double d : puntuaciones ){
            System.out.print(d + ", ");
        }
        System.out.println();
    }
    
 
    // Muestra en consola los valores contenidos en el array que se pasa como
    // parámetro
    // Parámetro "puntuaciones" array tipo "String" que contiene los valores
    // que se van a mostrar en la consola
    // Sin retorno de valores
    public static void mostrarPuntuaciones(String[] puntuaciones){
        System.out.print("\t\tPuntuaciones : ");
        for (String s : puntuaciones ){
            System.out.print(s + ", ");
        }
        System.out.println();
    }  
       
  
    // Pide un número decimal al usuario y muestra los valores contenidos en
    // un array y que son menores que el valor introducido por el usuario.
    // Parámetro "puntuaciones" array tipo "double" con los valores
    // decimales que se van a comparar con el número introducido por el 
    // usuario.
    // Parámetro "min" de tipo "double" que indica el valor mínimo(incluido) 
    // que puede tener la puntuación de una película.
    // Parámetro "max" de tipo "double" que indica el valor máximo(incluido) 
    // que puede tener la puntuación de una película.
    // Sin retorno de valores.
    // Lanza expeción "IOException" si se produce un error al leer los datos
    // de la consola. La excepción debe ser tratada en el bloque externo de 
    // código que ha llamado a esta función. 
    public static void puntuacionesMenoresQue( double[] puntuaciones,
                                               double min,
                                               double max ) throws IOException{ 
        
        // Texto para solicitar al usuario el valor decimal con el que 
        // se van a comparar los elementos del array 
        String mensaje = "\tValor puntuación a comparar (entre " + min 
                                                        + " y " + max + ") : ";    
        
        // Solicita al usuario el valor decimal con el que se van a comparar
        // los elementos del array "puntuaciones" que se pasa como parámetro 
        // y guarda el valor introducido en la variable "valor" de tipo 
        // "double". El valor introducido debe ser >= que el valor del parámetro
        // "min" y <= que el valor del parámetro "max"
        double valor = Lectura.pideDecimal(mensaje, min, max); 
        
        // Ordenamos los elementos del array "puntuaciones" de menor a
        // mayorr valor
        Arrays.sort(puntuaciones);        
           
        // Variable tipo String que contiene un texto con los valores del 
        // array "puntuaciones" que son menores que el valor especificado
        // por el usuario. Se utiliza para mostrar el resultado en la consola
        String valoresMenores = "";
        
        // Vamos recorriendo los elementos del array "ordenado" y añadimos al 
        // String "valoresMenores" los elementos cuyo valor sea menor que 
        // el valor  introducido por el usuario(variable "valor")
        for ( int i=0; 
              (i < puntuaciones.length)&& (puntuaciones[i] < valor); 
               i = i +1) {
            
            valoresMenores = valoresMenores + puntuaciones[i] + ", ";
        }
        
        // Mostrar en consola el resultado de la consulta
        System.out.print("\tPuntuaciones menores que " +  valor + " : ");
        if (valoresMenores.length() > 0) 
            // Mostrar puntuaciones menores que el valor indicado por el
            // usuario
            System.out.println(valoresMenores);
        else
            // No hay puntuaciones que sean menores que el valor indicado
            // por el usuario. Mostrar mensaje indicando que "No existen"
            System.out.println("No existen");
    }
        
    // Solicita al usuario introducir los nombres y puntuaciones de las
    // películas y guarda los valores introducidos en el array bidimensional
    // tipo "String" que se pasa como parámetro.
    // Parámetro "peliculas" array bidimensional tipo "String" que guarda
    // el nombre y las puntuaciones de las películas.
    // No retorna valores.
    // Lanza expeción "IOException" si se produce un error al leer los datos
    // de la consola. La excepción debe ser tratada en el bloque externo de 
    // código que ha llamado a esta función. 
    public static void rellenarPeliculas(String[][] peliculas) 
                                                            throws IOException{
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<peliculas.length; i= i+1){
            // Mensaje solicitando el nombre de la película.
            System.out.print("\nIntroduce nombre pelicula " + (i+1) + " : "); 
            // Leer el nombre película introducido por el usuario y guardarlo
            // en el array "peliculas"
            peliculas[i][0] = sc.next();
            // Mensaje solicitando introducir las puntuaciones de las películas.
            System.out.println("\n\tIntroduce puntuaciones de la película '" + 
                    peliculas[i][0] + "'\n");
            // Variable que guarda una puntuación decimal
            double puntos;
            // Solicitar las puntuaciones de la película, leerlas y guardarlas 
            // en el array "peliculas"
            for (int j=1; j<peliculas[0].length; j= j+1){
                puntos = 
                        Lectura.pideDecimal("\t\tPuntuación " + j + " : ",
                                              0.0, 10.0);
                peliculas[i][j] = Double.toString(puntos);
            }
            // Texto para formatear la salida.
            System.out.println("\t\t      -----------------------------");
        }
    }
 
    // Permite al usuario elegir una película contenida en el array que se 
    // pasa como parámetro y muestra las puntuaciones de la película que ha
    // seleccionado el usuario.
    // Parámetro "peliculas" array bidimensional tipo "String" que contiene las 
    // películas  y sus correspondientes puntuaciones.
    // No retorna valores.
    // Lanza expeción "IOException" si se produce un error al leer los datos
    // de la consola. La excepción debe ser tratada en el bloque externo de 
    // código que ha llamado a esta función. 
    public static void mostrarPuntuacionPelicula(String[][] peliculas)
                                                           throws IOException{
        // Texto que solicita número de película para mostrar sus puntuaciones
        String mensaje = "\tNúmero de película para mostrar puntuación " + 
                         "(entre 1 y " + peliculas.length + ") : ";
        // Solicita al usuario el número de película para mostrar sus
        // puntuaciones y guarda el valor introducido en la variable entera 
        // "numPelicula"
        int numPelicula = Lectura.pideEntero(mensaje, 1, peliculas.length); 
        // Muestra el nombre de la película que ha seleccionado el usuario
        System.out.println("\tPelicula_" + (numPelicula) + " => " + 
                            peliculas[numPelicula-1][0]);
        // Array que contiene las puntuaciones de la película seleccionada
        String[] puntos = Arrays.copyOfRange(peliculas[numPelicula-1], 1,4);
        // Mostrar las puntuaciones contenidas en el array "puntos" 
        Funciones.mostrarPuntuaciones(puntos);
    }
 
    // Muestra en consola el nombre de todas las películas contenidas en el
    // array bidimensional que se pasa como parámetro.
    // Parámetro "unArray" array bidimensional de tipo "String" del que 
    // se obtienen los valores a mostrar.
    // No retorna valores.
    // Lanza expeción "IOException" si se produce un error al leer los datos
    // de la consola. La excepción debe ser tratada en el bloque externo de 
    // código que ha llamado a esta función. 
    public static void mostrarNombres(String[][] peliculas){
        // Título del texto que se va a mostrar en consola
        System.out.println("\nNombre de las películas : ");
        // Recorre el array "películas" y muestra en consola el nombre de 
        // las películas que contiene
        for (int i=0; i<peliculas.length; i=i+1){
            System.out.println("\n\tPelicula_" +  (i + 1) + " => " + 
                            peliculas[i][0]);
        }
        System.out.println();        
    }
 
    // Pide al usuario un número de película contenida en el array que se 
    // pasa como parámetro y un número de puntuación de dicha película para 
    // modificar su valor.
    // Parámetro "peliculas" array bidimensional tipo "String" que contiene las 
    // películas  y sus correspondientes puntuaciones.
    // Parámetro "min" tipo "double" valor decimal mínimo que puede tener la
    // puntuación de una película.
    // Parámetro "max" tipo "double" valor decimal máximo que puede tener la
    // puntuación de una película.
    // No retorna valores.
    // Lanza expeción "IOException" si se produce un error al leer los datos
    // de la consola. La excepción debe ser tratada en el bloque externo de 
    // código que ha llamado a esta función. 
    public static void modificarPuntos(String[][] peliculas, 
                                    double min, double max) throws IOException{
      // Texto solicitando número de película de la que desea cambiar alguna
      // puntuación
      String mensaje = "\tNúmero de película para modificar puntuación " + 
              "(entre 1 y " + peliculas.length + ") : ";
      // Solicita al usuario el número de película para cambiar alguna de sus
      // puntuaciones y guarda el valor introducido en la variable entera 
      // "numPelicula"
      int numPelicula = Lectura.pideEntero( mensaje, 1, peliculas.length);
      // Texto solicitando el número de puntuación de la película que se va a
      // cambiar
      mensaje = "\tNúmero de puntuación a modificar (del 1 al 3) : ";
      // Solicita al usuario el número de puntuación de la película cuyo valor  
      // quiere cambiar y guarda el valor introducido en la variable entera 
      // "numPuntuacion"
      int numPuntuacion = 
              Lectura.pideEntero(mensaje, 1, peliculas[0].length-1);
      // Solicita al usuario el nuevo valor decimal de la puntuación de la
      // película y guarda el valor introducido en la variable "double"
      // "nuevaPuntuacion"
      double nuevaPuntuacion = 
              Lectura.pideDecimal("\tIntroduzca la nueva puntuación : ",
                      min, max);  
      // Modifica el valor de la puntuación seleccionada
      peliculas[numPelicula - 1][numPuntuacion] = 
                                               Double.toString(nuevaPuntuacion);
    }
 
    // Pide al usuario un número de película contenida en el array que se 
    // pasa como parámetro y un nombre para cambiar el nombre de la película que
    // ha seleccionado el usuario.
    // Parámetro "peliculas" array bidimensional tipo "String" que contiene las 
    // películas  y sus correspondientes puntuaciones.
    // No retorna valores.
    // Lanza expeción "IOException" si se produce un error al leer los datos
    // de la consola. La excepción debe ser tratada en el bloque externo de 
    // código que ha llamado a esta función. 
    public static void cambiarNombre(String[][] peliculas) throws IOException{
      // Texto solicitando número de película cuyo nombre se va a cambiar
      String mensaje = "\tNúmero de película para modificar nombre " + 
              "(entre 1 y " + peliculas.length + ") : ";
      // Solicita al usuario el número de película cuyo nombre desea cambiar y 
      // guarda el valor introducido en la variable entera "numPelicula"
      int numPelicula = Lectura.pideEntero(mensaje, 1, peliculas.length); 
      // Solicita al usuario un nuevo nombre para la película seleccionada y
      // guarda el nombre introducido en la variable "nuevoNombre"
      String nuevoNombre = Lectura.pedirString("\tIntroduzca nuevo nombre para " + 
              "película '" + peliculas[numPelicula-1][0] + "' : ");      
      // Cambia el nombre de la película seleccionada por el usuario.
      peliculas[numPelicula - 1][0] = nuevoNombre;
    }
    
    // Pide al usuario un número de película contenida en el array que se 
    // pasa como parámetro y muestra la puntuación más alta de la película
    // seleccionada.
    // Parámetro "peliculas" array bidimensional tipo "String" que contiene las 
    // películas  y sus correspondientes puntuaciones.
    // No retorna valores.
    // Lanza expeción "IOException" si se produce un error al leer los datos
    // de la consola. La excepción debe ser tratada en el bloque externo de 
    // código que ha llamado a esta función. 
    public static void mostrarPuntuacionMasAlta(String[][] peliculas)
                                                        throws IOException{
        // Texto solicitando número de película para ver su puntuación más alta
        String mensaje = "Número de película para ver puntuación más alta " + 
                         "(entre 1 y " + peliculas.length + ") : ";
        // Solicita al usuario el número de película para mostrar su puntuación
        // más alta y guarda el valor introducido en la variable entera 
        // "numPelicula"
        int numPelicula = Lectura.pideEntero(mensaje, 1, peliculas.length); 
        // Puntuaciones de la película en formato "double" / número decimal.
        double[] puntuaciones = new double[peliculas[0].length-1];
        // Convierte las puntuaciones de la película de "String" a tipo "double"
        // y las almacena en el array "puntuaciones".
        for (int i=1; i<peliculas[0].length; i = i+1){
           puntuaciones[i-1] = Double.parseDouble(peliculas[numPelicula-1][i]); 
        }
        // Muestra la puntuación más alta de la película seleccionada.
        System.out.println("\t" + peliculas[numPelicula-1][0] + " => " );
        Funciones.puntuacionMasAlta(puntuaciones);
    }
       
    // Pide al usuario un número y muestra el nombre de las películas contenidas 
    // en el array que se pasa como parámetro y cuya puntuación media sea como
    // mínimo el número indicado por el usuario.
    // Parámetro "peliculas" array bidimensional tipo "String" que contiene las 
    // películas  y sus correspondientes puntuaciones.
    // Parámetro "min" tipo "double" valor decimal mínimo que puede tener la
    // puntuación de una película.
    // Parámetro "max" tipo "double" valor decimal máximo que puede tener la
    // puntuación de una película.
    // No retorna valores.
    // Lanza expeción "IOException" si se produce un error al leer los datos
    // de la consola. La excepción debe ser tratada en el bloque externo de 
    // código que ha llamado a esta función. 
    public static void mediaMayorQue(String[][] peliculas,
                                    double min, double max)throws IOException{
        // Texto solicitando el número con el que se va a comparar la puntuación
        // media de las películas
        String mensaje = "Introduzca valor decimal para comparar (entre " +
                         min + " y " + max + ") : ";
        // Solicita al usuario el valor para comparar la puntuación media 
        // de las películas y guarda el valor indicado en la variable "valor"
        double valor = 
              Lectura.pideDecimal(mensaje, min, max); 
        // Guarda las puntuaciones de una película en formato número decimal
        double[] puntuaciones = new double[peliculas[0].length-1];
        // Título del texto que se va a mostrar en consola.
        System.out.print("\tPelículas con puntuación media mayor o igual " +
                  "que " + valor + " : \n\t\t");
        // Número de películas cuya puntuación media es como mínimo el número
        // indicado por el usuario (variable "valor").
        int contador = 0;
        // Para cada una de las películas del array "películas" cambiamos el 
        // valor "String" de sus puntuaciones a valor tipo "double" para poder 
        // calcular su media y realizar las comparaciones con el valor indicado
        // por el usuario.
        for (int j=0; j<peliculas.length; j = j+1){
            for (int i=1; i<peliculas[0].length; i = i+1){
                puntuaciones[i-1] = 
                        Double.parseDouble(peliculas[j][i]); 
            }
            // Si la media de las puntuaciones de esta película es como mínimo
            // el valor indicado por el usuario, mostramos en consola el nombre 
            // de la película
            if (Funciones.media(puntuaciones) >= valor){
                System.out.print(peliculas[j][0] + ", ");   
                contador = contador + 1;
            }
        }
        // Si no hay películas cuya puntuación media sea como mínimo el valor 
        // indicado por el usuario se muestra mensaje aviso al usuario
        if (contador < 1){
            System.out.print("Ninguna");
        }
        System.out.println();
    }
    
}
