
package actividad08.vehiculos;

import actividad07.vehiculos.IVehiculo;
import java.io.IOException;

// Implementa la interfaz "IVehiculo". Representa un vehículo
// dentro de una empresa de alquiler de vehículos.
public abstract class Vehiculo implements IVehiculo{
    // Número de plazas del vehículo
    private int numPlazas;
    // Modelo del vehículo
    private String modelo;
    // Matrícula del vehículo
    private String matricula;
    // Número de días que está alquilado el vehículo
    private int numDias;
    // Precio base de alquiler del vehículo por cada día
    private static final double PRECIO_BASE = 50;
    
    // Devuelve el coste total del alquiler del vehículo
    @Override
    public abstract double getPrecioTotalAlquilerPorDias();
    
    // Devuelve el precio base de alquiler por cada día.
    public double getPrecioBase(){
        return PRECIO_BASE;
    }
    
    // Devuelve el número de plazas del "Vehiculo"
    public int getNumPlazas() {
        return numPlazas;
    }
    
    // Devuelve el número de días que está alquilado el "Vehiculo"
    public int getNumDias() {
        return numDias;
    }
    
    // Muestra en consola todos los datos del vehículo incluido su precio
    // total de alquiler.
    // Sin retorno valores.
    @Override
    public abstract void showInformacion();
    
    // Establece el número de días que está alquilado el vehículo.
    // Parámetro número de días de alquiler.
    // Sin retorno valores.
    @Override
    public void setNumeroDias(int numDias){
        this.numDias = numDias;
    }
    
    // Pide y establece todos los datos del vehículo.
    // Sin retorno valores.
    @Override
    public void pideDatos(){
        String mensaje= "Introduzca matrícula : ";
        this.matricula = Utilidades.pedirString(mensaje);
        mensaje = "Introduzca modelo : ";
        this.modelo = Utilidades.pedirString(mensaje);
        mensaje =  "Introduzca número plazas : ";
        try{
            this.numPlazas = Utilidades.pedirEntero(mensaje, 1);
            mensaje =  "Introduzca nº días alquiler : ";
            this.numDias =  Utilidades.pedirEntero(mensaje, 1);
        }catch (IOException e){
            mensaje = "Error en la lectura de los datos.";
            throw new ErrorLectura(mensaje);
        }
    }
    
    // Devuelve un string que representa los valores contenidos en los
    // atributos del "Vehiculo"
    @Override
    public String toString(){        
        return  "\n\tMatrícula  =>  " + matricula
              + "\n\tModelo  =>  " + modelo
              + "\n\tNúmero plazas  =>  " + numPlazas  
              + "\n\tPrecio base  =>  " + String.format("%.2f",PRECIO_BASE) 
              + " €" 
              + "\n\tNúm. días alquiler  =>  " + numDias;
        
    }
}
