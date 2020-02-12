
package actividad05;

public class Menu {
    // Muestra en consola un menú de opciones
    // Parámetro "titulo" tipo "String" que contiene el título del menú
    // Parámetro "opciones" tipo array de "String" que contiene el texto
    // de cada una de las opciones del menú
    // No devuelve valores
    public static void mostrarMenu (String titulo, String[] opciones){
        
        // Muestra en consola el título del menú
        System.out.print("\n\t\t---- " + titulo + " ----\n\n");
        
        // Recorre el array que contiene las opciones del menú y muestra
        // en consola el texto correspondiente a cada una de ellas
        for (int i=1; i<= opciones.length; i=i+1){
            System.out.print("\t" + i + ". " + opciones[i-1] + ".\n");            
        }
        System.out.println();
    }
}
