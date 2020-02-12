 
package actividad07;

import actividad08.vehiculos.Vehiculo;
import actividad07.vehiculos.IVehiculo;
import actividad08.vehiculos.Utilidades;
import java.io.IOException;

// Define métodos que realizan diferentes operaciones sobre una flota de 
// vehículos ( array de tipo datos "Vehiculo" )
public class Gestiones {
    
    // Solicita al usuario un número de vehículo de la flota y muestra la
    // información del vehículo seleccionado.
    // Parámetro "flota" con los vehículos disponibles.
    // Sin retorno valores.
    // Lanza excepción "IOException" si se produce un error en la lectura datos 
    // de la consola. 
    public static void mostrarInfoVehiculo(IVehiculo[] flota) throws IOException{
        // Texto que se muestra al usuario para solicitar los datos
        String mensaje = "\tNúmero de vehículo para mostrar información " + 
                         "(entre 1 y " + flota.length + ") : ";  
        // Solicita al usuario el número de vehiculo y guarda el valor 
        // introducido en la variable entera "numVehiculo"
        int numVehiculo = Utilidades.pedirEntero(mensaje, 1, flota.length); 
        // Muestra información del vehículo seleccionado por el usuario
        System.out.println("\n\tVehículo_" + (numVehiculo) + " : " );
        if (flota[numVehiculo -1] != null ){
            flota[numVehiculo -1].showInformacion();
        }else
            System.out.println("\t\tNo existe dicho vehículo.\n");
    }
    
    // Muestra la información de todos los vehículos de la flota.
    // Parámetro "flota" vehículos cuya información se va a mostrar.
    // Sin retorno valores.
    public static void mostrarInfoFlota(IVehiculo[] flota){
        int numVehiculos = 0;
        for (IVehiculo v : flota){
            if (v != null){
                v.showInformacion();
                System.out.println();
                numVehiculos = numVehiculos + 1;
            }
        }
        if (numVehiculos == 0)
                System.out.println("\n\tNo hay vehículos en la flota.\n");
    }
    
    // Añade un vehículo a una flota de vehículos.
    // Parámetro "flota" flota de vehículos.
    // Parámetro "vehiculo" nuevo vehiculo a añadir a la flota.
    // Sin retorno valores.
    // Lanza excepción "IOException" si se produce un error en la lectura datos 
    // de la consola. 
    public static void agregarVehiculo(IVehiculo[] flota, Vehiculo vehiculo)
                                                            throws IOException{
        
        // Pide y establece todos los datos del vehículo.
        vehiculo.pideDatos();        
        // Texto que se muestra al usuario para solicitar los datos
        String mensaje = "\n\tPosición en la flota " + 
                         "(entre 1 y " + flota.length + ") : ";  
        // Solicita al usuario el número de posición que va a ocupar el nuevo 
        // vehículo en la flota y guarda el valor introducido en la variable
        // entera "posicion"
        int posicion = Utilidades.pedirEntero(mensaje, 1, flota.length); 
        // Añade el nuevo vehículo en la posición de la flota que ha introducido 
        // el usuario
        flota[posicion - 1] = vehiculo;
    }
  
    // Solicita al usuario un número de vehículo de la flota y un número de 
    // días para modificar el número de días que está alquilado. Después de
    // modificar muestra el precio del alquiler.
    // Parámetro "flota" con los vehículos disponibles.
    // Sin retorno valores.
    // Lanza excepción "IOException" si se produce un error en la lectura datos 
    // de la consola. 
    public static void modificarDiasAlquiler(IVehiculo[] flota) throws IOException{
        // Texto que se muestra al usuario para solicitar los datos
        String mensaje = "\tNúmero de vehículo a modificar " + 
                         "(entre 1 y " + flota.length + ") : ";  
        // Solicita al usuario el número de vehiculo y guarda el valor 
        // introducido en la variable entera "numVehiculo"
        int numVehiculo = Utilidades.pedirEntero(mensaje, 1, flota.length); 
        // Vehiculo de la flota que ha seleccionado el usuario.
        IVehiculo v = flota[numVehiculo -1];
        // Muestra información del vehículo seleccionado por el usuario
        System.out.print("\n\tVehículo_" + (numVehiculo) 
                           + ", número días : " );     
        if (v != null ){
            System.out.println(((Vehiculo)v).getNumDias());
            mensaje =  "\n\tIntroduce nuevo nº días alquiler : ";
            v.setNumeroDias(Utilidades.pedirEntero(mensaje, 1));
            System.out.println(
                    "\n\t\tNuevo precio del alquiler : " 
                    + String.format( "%.2f", v.getPrecioTotalAlquilerPorDias()) 
                    + " €"
            );     
        }else
            System.out.println("\n\t\tNo existe dicho vehículo.\n");
        
    }
      
}
