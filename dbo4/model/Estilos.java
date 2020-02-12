
package discoteca.model;

import java.util.ArrayList;

/**
 * Estilos música
 * @author Mam
 */
public enum Estilos {
    AMBIENT , BLUES, CLASSICAL, COUNTRY, DANCE, DISCO,
    HEAVY, HOUSE, JAZZ, OPERA, POP, PUNK, 
    REGGAE, ROCK, TECHNO;
    
    public static String[] getEstilos(){
        Estilos[] estilos = Estilos.values();
        ArrayList<String> nombres = new ArrayList();
        for (Estilos e : estilos){ 
            nombres.add(e.toString());
        }
        String[] aux = {};
        return nombres.toArray(aux);
    }                             
}
