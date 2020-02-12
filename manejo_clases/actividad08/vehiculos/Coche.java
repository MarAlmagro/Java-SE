 
package actividad08.vehiculos;

// Hereda de la clase "Vehiculo" y representa la estructura de un coche 
// dentro de una empresa de alquiler de vehículos.
public class Coche extends Vehiculo{
    
    // Gama del coche (A, B, C, D)
    private char gama;
    
    // Sobreescribe el método heredado de la superclase "Vehiculo". Pide y
    // establece todos los datos del "Coche".
    // Sin retorno valores.
    @Override
    public void pideDatos(){
        super.pideDatos();
        pideGama();        
    }
    
    // Pide y establece el valor del atributo "gama".
    // Sin retorno valores.
    private void pideGama(){
        String mensaje = "Introduzca gama (A, B, C, D) : ";
        String valoresGama = "ABCDabcd";
        // Texto introducido por el usuario cuando se le solicita la gama.
        String texto;
        boolean errorGama = true;
        // Pedimos al usuario que introduzca el valor de la gama, si introduce 
        // un valor erroneo (distinto de A, B, C, D) mostramos un mensaje
        // error y volvemos a solicitar el valor hasta que introduzca una gama
        // correcta.
        while (errorGama){
            texto = Utilidades.pedirString(mensaje);
            if (texto.length()==1 && valoresGama.contains(texto)){
                this.gama = texto.toUpperCase().charAt(0);
                errorGama = false;
            }else
                System.out.println(
                              "\n\tError. La gama debe ser : A, B, C ó D.\n" );
        }        
    }
    
    // Sobreescribe el método heredado de la  superclase "Vehiculo". Retorna
    // el precio del alquiler, para ello se suma al precio base la cantidad 
    // de 1.5€ por plaza y día.
    // Retorna el coste total del alquiler del "Coche".
    @Override
    public double getPrecioTotalAlquilerPorDias(){
        return getNumDias() * ( getPrecioBase() + ( 1.5 * getNumPlazas() ) );
    }
    
    // Muestra en consola todos los datos del vehículo incluido su precio
    // total de alquiler.
    // Sin retorno valores.    
    @Override
    public void showInformacion(){
        System.out.println( 
                          "\n\t\t-- Datos Coche --" 
                        + this 
                        + "\n\tTotal alquiler => " 
                        + String.format("%.2f", getPrecioTotalAlquilerPorDias()) 
                        + " €\n" );   
    }
    
    // Devuelve un string que representa los valores contenidos en los
    // atributos del "Coche"
    @Override
    public String toString(){
       return  (super.toString() + "\n\tGama  =>  " + gama);
        
    }
    
}
