
package actividad08.vehiculos;

// Excepción personalizada que se utiliza para envolver a "IOException"
public class ErrorLectura extends RuntimeException{
  public ErrorLectura (String mensajeError){
      super(mensajeError);
  }
    
}
