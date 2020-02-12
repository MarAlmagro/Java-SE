
package filmoteca02.main;


import filmoteca02.bdd.FilmotecaBDD;
import filmoteca02.bdd.GestionBDD;
import filmoteca02.views.VentanaFilmoteca;
import java.sql.SQLException;

public class Filmoteca {

    
    private static GestionBDD baseDatos = new GestionBDD();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            
            // Crear la base datose insertar datos en sus tablas
            FilmotecaBDD.crear();
            
            // Abrir conexión con base datos
            GestionBDD.conectar();
            
            // Mostrar ventana para interactuar con la base datos           
            new VentanaFilmoteca(baseDatos).setVisible(true);
            
        }catch (SQLException ex) {
            System.out.println("Error conexión base datos: " + ex.getMessage());
        }catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }    
}
