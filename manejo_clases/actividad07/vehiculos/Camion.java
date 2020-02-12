 
package actividad07.vehiculos;

import actividad08.vehiculos.ErrorLectura;
import actividad08.vehiculos.Utilidades;
import java.io.IOException;

// Hereda de la clase "Carga" y representa la estructura de un camión
// dentro de una empresa de alquiler de vehículos.
public class Camion  extends Carga{
    // Tipo de estructura que puede ser : rigido, remolque, semirremolque.
    private TipoEstructura estructura;
        
    // Sobreescribe el método heredado de la  superclase "Carga". Retorna
    // el precio del alquiler, para ello se suma al precio del alquiler de la
    // de la superclase "Carga" una cantidad fija de 40€.
    // Retorna el coste total del alquiler del  "Camión".
    @Override
    public double getPrecioTotalAlquilerPorDias() {
        return super.getPrecioTotalAlquilerPorDias() + 40;
    }
    
    // Sobreescribe método heredado de la  superclase "Vehiculo".
    // Muestra en consola todos los datos de la carga incluyendo el precio
    // total de alquiler.
    // Sin retorno valores.    
    @Override
    public void showInformacion() {
        
        System.out.println(  
                          "\n\t\t-- Datos Camión --" 
                        + this 
                        + "\n\tTotal alquiler => "
                        + String.format("%.2f", getPrecioTotalAlquilerPorDias()) 
                        + " €\n" );   
    }
    
    // Sobreescribe método heredado de la  superclase "Carga".    
    // Pide y establece todos los datos del "Camión".
    // Sin retorno valores.
    @Override
    public void pideDatos(){
        super.pideDatos();
        pideEstructura();
    }
    // Pide y establece el valor del atributo "estructura".
    // Sin retorno valores.
    private void pideEstructura(){
        System.out.println( "\tEstructuras disponibles :  ");
        TipoEstructura[] valores = TipoEstructura.values();
        for (int i=1; i<=valores.length ; i++){
            System.out.println("\t\t" + i +".- " + valores[i-1].name());            
        }
        String mensaje = "\nElija tipo de estructura (del 1 al " 
                + valores.length + ") : ";
        try {
            int numValor = Utilidades.pedirEntero(mensaje, 1, valores.length);
            estructura = valores[numValor-1];
        }catch (IOException e){
            mensaje = "Error en la lectura de los datos.";
            throw new ErrorLectura(mensaje);            
        }    
    }
    // Devuelve un string que representa los valores contenidos en los
    // atributos del "Camión".
    @Override
    public String toString(){
       return  (super.toString() + "\n\tTipo estructura  =>  " + estructura);
        
    }
}
