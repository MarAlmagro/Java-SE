 
package actividad05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// Define funciones con utilidades para leer datos que ha introducido 
// el usuario en la consola
public class Lectura {
    
    /* Función que devuelve valor entero.
       Solicita por consola un número entero. El mensaje que se muestra al 
       usuario para solicitar el valor entero es que se pasa como parámetro 
       "mensajeUsuario" . Si el usuario introduce un valor no entero, muestra 
       un aviso y vuelve solicitar número entero por consola hasta que el valor 
       introducido sea un número entero.
       No se realiza el tratamiento de la excepción IOException, que debe ser 
       tratada en el bloque externo de código que ha llamado a esta función */      
    public static int pideEntero(String mensajeUsuario)throws IOException{
        
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
            System.out.println();
            try{
                //Convertir variable "valor_introducido" a un entero
                numEntero = Integer.parseInt(valor_introducido);                
                // El usuario ha introducido un valor entero correcto. 
                // Asignamos valor true a la variable "esEntero"
                esEntero = true;
            }catch (NumberFormatException e){
                // El usuario ha introducido por consola un valor que no 
                // es un número entero. Mostramos mensaje de aviso.
                System.out.println("Error. Valor introducido no es un " +
                                                          "número entero.\n");
            }
        }
        
        // Devuelve el valor entero introducido por el usuario
        return numEntero;
    }
    
    /* Función que devuelve valor double.
       Solicita por consola un número double. El mensaje que se muestra al 
       usuario para solicitar el valor double es que se pasa como parámetro 
       "mensajeUsuario" . Si el usuario introduce un valor que no es double, 
       muestra un aviso y vuelve solicitar número double por consola hasta que 
       el valor introducido sea un número double.
       No se realiza el tratamiento de la excepción IOException, que debe ser 
       tratada en el bloque externo de código que ha llamado a esta función */
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
                System.out.println("Error. Valor introducido no es un " +
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
    // parámetro "max"(valor incluido)  
    // No se realiza el tratamiento de la excepción IOException, que debe ser 
    // tratada en el bloque externo de código que ha llamado a esta función 
    public static int pideEntero (String mensaje, int min, int max)
                                                            throws IOException{        
        
        // Mensaje de alerta que se muestra al usuario cuando introduce un valor 
        // entero que no está contenido entre el valor mínimo (parámetro "min")
        // y el máximo (parámetro "max)
        String alerta ="Error. Valor introducido debe ser del " + min + 
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
            valor = pideEntero(mensaje);
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
    
    // Muestra en consola un mensaje al usuario solicitando un número 
    // decimal comprendido entre un valor mínimo(incluido) y un valor 
    // máximo(incluido).
    // Parámetro "mensaje" que contiene el texto que se muestra por consola
    // al usuario para solicitar el número decimal.
    // Parámetro "min" de tipo "double" que establece el valor decimal 
    // mínimo(incluido) que puede introducir el usuario.
    // Parámetro "max" de tipo "double" que establece el valor decimal
    // máximo(incluido) que puede introducir el usuario.
    // Devuelve el valor decimal(tipo "double") que ha introducido el usuario y 
    // que está comprendido entre valor parámetro "min"(valor incluido) y valor 
    // parámetro "max"(valor incluido)  
    // No se realiza el tratamiento de la excepción IOException, que debe ser 
    // tratada en el bloque externo de código que ha llamado a esta función 
    public static double pideDecimal (String mensaje, double min, double max)
                                                            throws IOException{        
        
        // Mensaje de alerta que se muestra al usuario cuando introduce un valor 
        // decimal que no está contenido entre el valor mínimo (parámetro "min")
        // y el máximo (parámetro "max)
        String alerta ="Error. Valor introducido debe ser del " + min + 
                             " al " + max + " (ambos incluidos)\n";
        
        
        // Valor "true" si el valor decimal introducido por el usuario no está 
        // comprendido entre los valores de los parámetros "min" y "max". Valor 
        // "false" en otro caso. Inicializada a "true".
        boolean valorNoValido = true;
        
        // Variable tipo "double" que guarda el valor decimal que introduce por 
        // consola el usuario. Inicializada a -1.0.
        double valor = -1.0;
        
        // Bucle que muestra por consola el texto contenido en el parámetro 
        // "mensaje" para solicitar al usuario un número decimal
        // y lee el valor introducido por el usuario y lo almacena en la 
        // variable decimal "valor". El bucle se repite hasta que el número 
        // introducido por el usuario esté comprendido entre el valor del 
        // parámetro "min"  y el valor del parámetro "max" 
        while (valorNoValido){
            // muestra por consola el mensaje solicitando un valor entero
            valor = pideDouble(mensaje);
            // Si el usuario ha introducido un número decimal comprendido 
            // entre el valor del parámetro "min" y el valor del parámetro 
            // "max".
            if ((valor >= min)&&(valor <= max)){
                // Asigna valor "false" a la variable "valorNoValido" para 
                // terminar el bucle "while"
                valorNoValido = false;
            }else{
                // el usuario ha introducido un número decimal que no está 
                // comprendido entre el valor del parámetro "min" y el valor 
                // del parámetro "max". Muestra un mensaje de alerta.
                System.out.println(alerta);
            }
        }
        // Devuelve el valor decimal introducido por el usuario y que está 
        // comprendido entre valor del parámetro "min"(incluido) y valor del
        // parámetro "max"(incluido)  
        return valor;
    }   
    
    // Solicita al usuario introducir un texto a través de la consola, lee 
    // dicho texto y lo devuelve en formato "String"
    // Parámetro "mensajeUsuario" de tipo "String" que contiene el texto que
    // se muestra en consola para solicitar los datos al usuario
    // Devuelve un "String" que contine el texto que ha introducido el 
    // usuario en la consola
    public static String pedirString(String mensajeUsuario){
        System.out.print(mensajeUsuario);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
