
package discoteca.main;

import discoteca.dao.GestionDao;
import discoteca.model.Disco;
import discoteca.model.Estilos;
import java.io.IOException;

public class GruposMusica {
    // "Array" de "String" que guarda el texto de las opciones del menú 
    private static final  String[] OPCIONES_MENU = {
                                        "Insertar nuevo disco", 
                                        "Mostrar todos",
                                        "Mostrar discos de un grupo",
                                        "Modificar disco",
                                        "Borrar disco",
                                        "Mostrar discos por estilo", 
                                        "Discos anteriores a un año",
                                        "Discos por estilo y número canciones",
                                        "Salir"
    };
    
    // Número de la primera opción del menú
    private static final int MIN_OPCION_MENU = 1; 
    
    // Numero de opciones que tiene el menú
    private static final int MAX_OPCION_MENU = OPCIONES_MENU.length;  
    
    // Máximo número canciones que puede tener un disco
    private static final int MAX_NUM_CANCIONES = 50; 
    // Mínimo número canciones que puede tener un disco
    private static final int MIN_NUM_CANCIONES = 1; 
    
    
    // Valor máximo del año publicación de un disco
    private static final int MAX_NUM_ANYO = 2020; 
    // Valor mínimo del año publicación de un disco
    private static final int MIN_NUM_ANYO = 1948; 
    

    public static void main(String[] args) {
        GestionDao gd = new GestionDao();
        
        // Insertar 10 discos en base datos si está vacía
        gd.prepararBD(10);
        
        // Opción del menú que ha seleccionado el usuario
        int opcionSeleccionada;    
        
        // Texto que solicita al usuario introducir un número de opción
        // del menú que sea >= que el número de la primera opción del
        // menú y <= que el número de la última opción del menú
        String mensajeUsuario = "Seleccione una opción del menú (de " +
                        MIN_OPCION_MENU + " a " + MAX_OPCION_MENU + ") : ";
        
        // Variable booleana con valor true hasta que el usuario teclee la 
        // opción de finalizar programa / Salir. 
        boolean seguir = true;
        
        try{ // tratamiento de excepciones 
            
            //Mientras que el usuario no seleccione opción de Salir
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
                        // Crea nuevo disco y lo almacena en la base datos
                        if ( gd.insertarDisco( getNuevoDisco() )){                            
                            System.out.println(
                                "\nBase Datos después de insertar disco :\t"
                            ); 
                            mostrarDiscos(gd.getDiscos());  
                        }                            
                        break;
                    case 2 :       
                        // Mostrar todos los discos de la base datos
                        mostrarDiscos(gd.getDiscos());
                        break;
                    case 3:      
                        // Mostrar los discos de un grupo que selecciona el
                        // usuario por teclado
                        mostrarDiscos ( gd.getDiscos( getNombreGrupo(gd) ) );
                        break;
                    case 4:     
                        // Modificar un disco
                        modificarPrimerDisco( gd );
                        break;
                    case 5:     
                        // Borrar disco
                        borrarPrimerDisco( gd );
                        break;
                    case 6:     
                        // Mostrar discos del estilo que selecciona el usuario
                        // por teclado
                        mostrarDiscos ( gd.getDiscos( getEstilo(gd) ) );
                        break;
                    case 7:     
                        // Mostrar, ordenados por año ascendente, los  discos 
                        // anteriores al año que introduce usuario por teclado
                        mostrarDiscos(gd.getDiscosAnterioreAnyo ( getAnyo(gd)));
                        break;
                    case 8:     
                        // Mostrar discos del estilo introducido por teclado y
                        // que tengan más de X canciones(el valor X lo introduce
                        // por teclado el usuario).
                        Estilos estilo = getEstilo(gd);
                        int numCanciones = 0;
                        if (estilo != null){
                            numCanciones = getNumCanciones( 
                                                            MIN_NUM_CANCIONES, 
                                                            MAX_NUM_CANCIONES
                                                           );
                        }
                        mostrarDiscos( gd.getDiscos( estilo, numCanciones ) );
                        break;
                    case 9:
                        // Usuario ha introducido opción de terminar programa.
                        // Se muestra mensaje aviso de fin de programa y 
                        // asigna valor false a la variable "seguir".
                        System.out.println("\tFin programa.\n");
                        seguir = false;
                        break;
                }
                if (seguir)
                     Utilidades.continuar(
                          "\n\t\t\tIntroduce cualquier tecla para continuar..."
                     );
            }    
        }catch (IOException e){ 
            System.out.println("\nError de lectura\n");
        }finally{
            gd.cerrarBaseDatos();
        }
    }  
 

    // Muestra el contenido del array que se pasa como parámetro
    private static void mostrarDiscos(Disco[] discos){  
        System.out.println();
        if ( discos.length < 1){
            System.out.println( "No hay discos para mostrar" );
        }else{
            for (Disco d : discos)
                System.out.println(d);
        }
    }
    // Devuelve un objeto Disco cuyos datos introduce el usuario por teclado
    private static Disco getNuevoDisco(){

        Disco disco = null;
        
        // Obtener nombre grupo del disco
        String grupo = Utilidades.pedirString("\tIntroduce nombre grupo : ");
        // Obtener título del disco
        String titulo = Utilidades.pedirString("\n\tIntroduce título disco : ");
        
        try{            
        
            // Obtener año publicación del disco
            String mensaje = "\n\tIndicar año publicación disco (de " 
                            + MIN_NUM_ANYO  + " a " + MAX_NUM_ANYO + ") : ";
            int anyo = 
                    Utilidades.pedirEntero(mensaje, MIN_NUM_ANYO, MAX_NUM_ANYO);
            
            // Obtener número canciones del disco
            mensaje = "\n\tIndicar número canciones disco (de " 
                            + MIN_NUM_ANYO  + " a " + MAX_NUM_ANYO + ") : ";
            int numCanciones = 
                    getNumCanciones(MIN_NUM_CANCIONES, MAX_NUM_CANCIONES);
            
            // Obtener estilo del disco
            Estilos estilo = null;
            String nombreEstilo = 
                Utilidades.getSeleccion ( "Estilo", Estilos.getEstilos());
            if (nombreEstilo != null)
                estilo = Estilos.valueOf(nombreEstilo);
           
            // Si los valores que indica el usuario son correctos se crea
            // un nuevo disco
            if ( !grupo.isEmpty() && !titulo.isEmpty() && estilo != null
                    && numCanciones > 0 ){
                disco = new Disco(grupo, titulo, numCanciones, anyo, estilo);
            }
        }catch (IOException e){
            System.out.println( "Error al obtener datos disco" );               
        }finally{
            return disco;
        }
    }
    // Devuelve el nombre grupo que selecciona el usuario por teclado
    private static String getNombreGrupo(GestionDao gd){
        String[] grupos = gd.getGrupos(); 
        return Utilidades.getSeleccion("Grupo", grupos);
    }
    // Devuelve el nombre estilo disco que selecciona el usuario por teclado
    private static Estilos getEstilo(GestionDao gd){
        Estilos estilo = null;
        String nombreEstilo = 
                Utilidades.getSeleccion ( "Estilo", gd.getEstilos() );
        if (nombreEstilo != null)
            estilo = Estilos.valueOf(nombreEstilo);
        return estilo;
    }
    // Devuelve el número canciones que introduce el usuario por teclado y está
    // comprendido entre los valores(incluidos) de los parámetros "min" y "max"
    private static int getNumCanciones(int min, int max){
        int numCanciones = 0;
        try{
            String mensaje = "\n\tIntroduzca número de canciones (del " + min 
                                + " al " + max + " ) : ";
            // Obtener el número de canciones
            numCanciones = Utilidades.pedirEntero(mensaje, min, max);
        }catch (IOException e){
            System.out.println( "Error lectura al obtener nombre grupo" );               
        }finally{
            return numCanciones;
        }
    }
    // Devuelve número año que introduce el usuario por teclado
    private static int getAnyo(GestionDao gd){ 
        int anyo = -1;
        try{
            int min = gd.getMinAnyo();
            // Si la base datos no está vacía
            if (min != -1){
                int max = gd.getMaxAnyo() + 1;
                String mensaje = "\n\tIntroduzca número año (del " 
                                 + min + " al " + max + " ) : ";
                // Obtener el año seleccionado por el usuario
                anyo = Utilidades.pedirEntero(mensaje, min, max);
            }
        }catch (IOException e){
            System.out.println( "Error lectura al obtener año" );               
        }finally{
            return anyo;
        }
    }
    
    // Modifica a 21 el número canciones del primer disco de la base datos
    private static void modificarPrimerDisco(GestionDao gd){
        Disco primero = gd.getPrimerDisco();
        if ( primero != null ){
            System.out.println( 
                "Modificar a 21 el número canciones del disco :\n\t" + primero
            );
            gd.modificarNumCanciones(primero, 21);
            System.out.println("\nBase Datos después de modificar :\t"); 
            mostrarDiscos(gd.getDiscos());
        } else {  
            System.out.println( "Base datos vacía. Sin discos para modificar" );
        }
    }
    // Borra el primer disco de la base datos
    private static void borrarPrimerDisco(GestionDao gd){
        Disco primero = gd.getPrimerDisco();
        if ( primero != null ){
            System.out.println( 
                "Se va a borrar el disco :\n\t" + primero
            );
            if ( !gd.borrar(primero) ){
                System.out.println( "Error. No se ha podido borrar el disco" );
            } else{
                System.out.println("\nBase Datos después de borrar disco :\t"); 
                mostrarDiscos(gd.getDiscos());                        
            }
        } else {  
            System.out.println( "Base datos vacía. Sin discos para borrar" );
        }
    }
}
