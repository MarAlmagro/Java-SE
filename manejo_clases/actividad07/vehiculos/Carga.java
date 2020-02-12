
package actividad07.vehiculos;

import actividad08.vehiculos.ErrorLectura;
import actividad08.vehiculos.Utilidades;
import actividad08.vehiculos.Vehiculo;
import java.io.IOException;

// Hereda de la clase "Vehiculo" y representa la carga de un vehículo
public class Carga extends Vehiculo{
    // Peso máximo autorizado en toneladas 
    private double pma;
    
    // Sobreescribe el método heredado de la  superclase "Vehiculo". Retorna
    // el precio del alquiler, para ello se suma al precio base la cantidad 
    // de 20€ por el "pma".
    // Retorna el coste total del alquiler de la  "Carga".
    @Override
    public double getPrecioTotalAlquilerPorDias() {
        return (super.getPrecioBase() + 20 * pma) * getNumDias();
    }
    
    // Sobreescribe método heredado de la  superclase "Vehiculo".
    // Muestra en consola todos los datos de la carga incluyendo el precio
    // total de alquiler.
    // Sin retorno valores.    
    @Override
    public void showInformacion() {
        
        System.out.println(  
                          "\n\t\t-- Datos Carga --" 
                        + this 
                        + "\n\tTotal alquiler => " 
                        + String.format("%.2f", getPrecioTotalAlquilerPorDias()) 
                        + " €\n" );   
    }
    
    // Sobreescribe método heredado de la  superclase "Vehiculo".    
    // Pide y establece todos los datos de la "Carga".
    // Sin retorno valores.
    @Override
    public void pideDatos(){
        super.pideDatos();
        pidePma();
    }
    
    // Pide y establece el valor del atributo "pma".
    // Sin retorno valores.
    private void pidePma(){
        String mensaje = "Introduce Peso Máximo Autorizado : ";
        // Valor introducido por el usuario cuando se le solicita el pma.
        double num;
        boolean errorNum = true;
        // Pedimos al usuario que introduzca el valor del PMA. Si introduce 
        // un valor erroneo (menor o igual que cero) mostramos un mensaje
        // error y volvemos a solicitar el valor hasta que introduzca un PMA
        // correcta.
        try { 
            while (errorNum){
                num = Utilidades.pideDouble(mensaje);
                if (num > 0){
                    this.pma = num;
                    errorNum = false;
                }else
                    System.out.println(
                            "\n\tError. El PMA debe ser mayor que cero.\n" );
            }          
        }catch (IOException e){
            mensaje = "Error en la lectura de los datos.";
            throw new ErrorLectura(mensaje);            
        }       
    }
    
    
    // Devuelve un string que representa los valores contenidos en los
    // atributos de la "Carga".
    @Override
    public String toString(){
       return  (super.toString() + "\n\tPMA  =>  " + String.format("%.2f",pma));
        
    }
}
