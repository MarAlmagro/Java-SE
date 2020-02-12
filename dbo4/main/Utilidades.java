
package discoteca.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// Clase que define funciones con utilidades para leer datos que ha introducido 
// el usuario en la consola
public class Utilidades {   
    
    /* Función que devuelve valor entero.
       Solicita por consola un número entero. El mensaje que se muestra al 
       usuario para solicitar el valor entero es que se pasa como parámetro 
       "mensajeUsuario" . Si el usuario introduce un valor no entero, muestra 
       un aviso y vuelve solicitar número entero por consola hasta que el valor 
       introducido sea un número entero.
       Devuelve el valor entero introducido por el usuario
       Lanza excepción IOException si se produce un error al leer los datos
       de la consola, debe ser tratada en el bloque externo de código que llama
       a esta función */
    public static int pedirEntero(String mensajeUsuario)throws IOException{
        
        //Creo variable tipo BufferedReader para leer datos por consola
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Variable booleana que indica si el valor que introduce el usuario 
        // por consola es un número entero (valor true) o no (valor false).       
        // Se inicializa a false.
        boolean esEntero = false;
        
        // Variable entera que guarda el valor entero que ha introducido el
        // usuario por consola. Inicializada a cero.
        int numEntero  = 0;
        
        // Mientras que el valor introducido por el usuario no sea un 
        // número entero
        while (!esEntero){
            //Muestra al usuario el mensaje texto que se le pasa como 
            //parámetro, "mensajeUsuario"
            System.out.print(mensajeUsuario);

            //Leo el valor que ha indicado el usuario en la consola y lo 
            //guardo en la variable "valor_introducido"
            String valor_introducido = br.readLine();
            try{
                //Convertir variable "valor_introducido" a un entero
                numEntero = Integer.parseInt(valor_introducido);                
                // El usuario ha introducido un valor entero correcto. 
                // Asignamos valor true a la variable "esEntero"
                esEntero = true;
            }catch (NumberFormatException e){
                // El usuario ha introducido por consola un valor que no 
                // es un número entero. Mostramos mensaje de aviso.
                System.out.println("\n\tError. Valor introducido no es un " +
                                                          "número entero.\n");
            }
        }
        
        // Devuelve el valor entero introducido por el usuario
        return numEntero;
    }
    
    /* Solicita por consola un número double. El mensaje que se muestra al 
       usuario para solicitar el valor double es que se pasa como parámetro 
       "mensajeUsuario" . Si el usuario introduce un valor que no es double, 
       muestra un aviso y vuelve solicitar número double por consola hasta que 
       el valor introducido sea un número double.
       Devuelve el valor double que ha introducido el usuario.
       Lanza excepción IOException si se produce un error al leer los datos
       de la consola, debe ser tratada en el bloque externo de código que ha
       llamado a esta función */
    public static double pideDouble(String mensajeUsuario)throws IOException{
        
        //Creo variable tipo BufferedReader para leer datos por consola
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Variable double que guarda el valor decimal/double que ha 
        // introducido elusuario por consola. Inicializada a 0.0
        double numDouble=0.0;
        
        // Variable booleana que indica si el valor que introduce el usuario 
        // por consola es un número decimal/double (valor true)     
        // o no (valor false). Se inicializa a false.
        boolean esDouble = false;
        
        // Mientras que el valor introducido por el usuario no sea un 
        // número decimal/double
        while (!esDouble){
            //Muestra al usuario el mensaje texto que se le pasa como 
            //parámetro, "mensajeUsuario"
            System.out.print(mensajeUsuario);

            //Leo el valor que ha indicado el usuario en la consola y lo 
            //guardo en la variable "valor_introducido"
            String valor_introducido = br.readLine();
            System.out.println();
            try{
                //Convertir variable "valor_introducido" a un double
                numDouble = Double.parseDouble(valor_introducido);
                // El usuario ha introducido un valor decimal/double correcto. 
                // Asignamos valor true a la variable "esDouble"
                esDouble = true;
            }catch (NumberFormatException e){
                // El usuario ha introducido por consola un valor que no 
                // es un número double/decimal. Mostramos mensaje de aviso.
                System.out.println("\n\tError. Valor introducido no es un " +
                                                          "número decimal.\n");
            }
        }
        // Devuelve el valor double introducido por el usuario
        return numDouble;
    }    
    
    // Muestra en consola un mensaje al usuario solicitando un número 
    // entero comprendido entre un valor mínimo(incluido) y un valor 
    // máximo(incluido).
    // Parámetro "mensaje" que contiene el texto que se muestra por consola
    // al usuario para solicitar el número entero.
    // Parámetro "min" de tipo "int" que establece el valor entero 
    // mínimo(incluido) que puede introducir el usuario.
    // Parámetro "max" de tipo "int" que establece el valor entero 
    // máximo(incluido) que puede introducir el usuario.
    // Devuelve el valor entero(tipo "int") que ha introducido el usuario y que 
    // está comprendido entre valor parámetro "min"(valor incluido) y valor 
    // parámetro "max"(valor incluido).
    // Lanza expeción "IOException" si se produce un error al leer los datos
    // de la consola. La excepción debe ser tratada en el bloque externo de 
    // código que ha llamado a esta función 
    public static int pedirEntero (String mensaje, int min, int max)
                                                            throws IOException{        
        
        // Mensaje de alerta que se muestra al usuario cuando introduce un valor 
        // entero que no está contenido entre el valor mínimo (parámetro "min")
        // y el máximo (parámetro "max)
        String alerta ="\n\tError. Valor introducido debe ser del " + min + 
                             " al " + max + "(ambos incluidos)\n";
        
        
        // Valor "true" si el valor entero introducido por el usuario no está 
        // comprendido entre los valores de los parámetros "min" y "max". Valor 
        // "false" en otro caso. Inicializada a "true".
        boolean valorNoValido = true;
        
        // Variable tipo "int" que guarda el valor entero que introduce por 
        // consola el usuario. Inicializada a -1.
        int valor = -1;
        
        // Bucle que muestra por consola el texto contenido en el parámetro 
        // "mensaje" para solicitar al usuario un número entero
        // y lee el valor introducido por el usuario y lo almacena en la 
        // variable entera "valor". El bucle se repite hasta que el número 
        // introducido por el usuario esté comprendido entre el valor del 
        // parámetro "min"  y el valor del parámetro "max" 
        while (valorNoValido){
            // muestra por consola el mensaje solicitando un valor entero
            valor = pedirEntero(mensaje);
            // Si el usuario ha introducido un número entero comprendido 
            // entre el valor del parámetro "min" y el valor del parámetro 
            // "max".
            if ((valor >= min)&&(valor <= max)){
                // Asigna valor "false" a la variable "valorNoValido" para 
                // terminar el bucle "while"
                valorNoValido = false;
            }else{
                // el usuario ha introducido un número entero que no está 
                // comprendido entre el valor del parámetro "min" y el valor 
                // del parámetro "max". Muestra un mensaje de alerta.
                System.out.println(alerta);
            }
        }
        // Devuelve el valor entero introducido por el usuario y que está 
        // comprendido entre valor del parámetro "min"(incluido) y valor del
        // parámetro "max"(incluido)  
        return valor;
    }
    
    // Solicita un número entero que sea mayor o igual que el valor mínimo 
    // que se pasa como parámetro.
    // Parámetro "mensaje" que contiene el texto que se muestra por consola
    // al usuario para solicitar el número entero.
    // Parámetro "min" de tipo "int" que establece el valor mínimo(incluido)
    // que debe tener el valor introducido por el ususario.
    // Devuelve el valor entero(tipo "int") que ha introducido el usuario y 
    // que es mayor o igual que el valor del parámetro "min"
    // Lanza expeción "IOException" si se produce un error al leer los datos
    // de la consola. La excepción debe ser tratada en el bloque externo de 
    // código que ha llamado a esta función 
    public static int pedirEntero (String mensaje, int min)
                                                            throws IOException{        
        
        // Mensaje de alerta que se muestra al usuario cuando introduce un valor 
        // entero que no es mayor o igual el valor mínimo (parámetro "min")
        String alerta ="\n\tError. Valor debe ser como mínimo " + min + "\n";
        
        
        // Valor "true" si el valor entero introducido por el usuario no es
        // mayor o igual que el parámetro "min". Valor "false" en otro caso.
        // Inicializada a "true".
        boolean valorNoValido = true;
        
        // Variable tipo "int" que guarda el valor entero que introduce por 
        // consola el usuario. Inicializada a -1.
        int valor = -1;
        
        // Bucle que muestra por consola el texto contenido en el parámetro 
        // "mensaje" para solicitar al usuario un número entero
        // y lee el valor introducido por el usuario y lo almacena en la 
        // variable entera "valor". El bucle se repite hasta que el número 
        // introducido por el usuario sea mayor o igual que el parámetro "min".
        while (valorNoValido){
            // muestra por consola el mensaje solicitando un valor entero
            valor = pedirEntero(mensaje);
            // Si el usuario ha introducido un número entero mayor o igual 
            // que el parámetro "min".
            if (valor >= min){
                // Asigna valor "false" a la variable "valorNoValido" para 
                // terminar el bucle "while"
                valorNoValido = false;
            }else{
                // El usuario ha introducido un número entero que no es
                // mayor o igual que el parámetro "min".
                // Muestra un mensaje de alerta.
                System.out.println(alerta);
            }
        }
        // Devuelve el valor entero introducido por el usuario y que es
        // mayor o igual que el valor del parámetro "min".
        return valor;
    }
    
    // Solicita al usuario introducir un texto a través de la consola, lee 
    // dicho texto y lo devuelve en formato "String"
    // Parámetro "mensajeUsuario" de tipo "String" que contiene el texto que
    // se muestra en consola para solicitar los datos al usuario
    // Devuelve un "String" que contine el texto que ha introducido el 
    // usuario en la consola
    public static String pedirString(String mensajeUsuario){
        Scanner sc = new Scanner(System.in);
        String texto = ""; 
        boolean textoVacio = true;
        // Pedimos al usuario que introduzca un texto/cadena, si introduce 
        // una cadena vacía se muestra un mensaje error y se vuelve a pedir
        // el texto hasta que introduzca una cadena válida
        while (textoVacio){            
            System.out.print(mensajeUsuario);
            texto = sc.nextLine().trim();
            if (texto.length()<1)
             System.out.println("\n\tError. Texto vacío.\n");
            else
                textoVacio = false;
        }        
        return texto;
    }
    // Devuelve el texto introducido por el usuario
    public static String continuar(String mensajeUsuario){
        System.out.print(mensajeUsuario);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    // Muestra en consola una serie de opciones y solicita al usuario que
    // seleccione una de ellas a través del teclado
    // Devuelve el valor seleccionado por el usuario
    // Parámetro "valores" contiene las opciones disponibles para seleccionar
    // Parámetro "nombre" nombre del tipo opciones, por ejemplo, si el usuario
    // tiene que seleccionar un grupo el valor pasado sería "grupo", si debe
    // seleccionar un estilo música el parámetro "nombre" sería "estilo"
    public static String getSeleccion(String nombre, String[] valores){
        String valor = null;
        try{
            int numValores = valores.length;
            if (numValores > 0){
                System.out.println( "\n\t" + nombre 
                                    + ", valores disponibles : \n");
                for (int i=1; i<=numValores; i = i+1){   
                    System.out.print ("\t\t");
                    if (i<10)
                        System.out.print ( " ");
                    System.out.print ( i + ".- " + valores[i-1]);
                    if ( i % 3 == 0)
                        System.out.println();
                }
                String mensaje = "\n\n\tIntroducir número de " + nombre  
                        + " (del 1 al " + numValores + ") : ";  
                // Obtener el valor seleccionado por el usuario
               int numSeleccion = Utilidades.pedirEntero(mensaje, 1, numValores);
               valor = valores[numSeleccion-1];  
            }
        } catch (IOException e){
            System.out.println( "Error lectura al obtener valor " + nombre );               
        }finally{
            return valor;
        }
    }
}