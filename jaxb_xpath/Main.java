
package Actividad01;

import java.io.File;

/**
 * Transformar un archivo .txt a un archivo .xml y
 * hacer una consulta ( XPATH ) sobre el archivo xml obtenido.
 * @author Mam
 */
public class Main {

    private static final String ARCHIVO_TEXTO = "incidencias.txt";
    private static final String ARCHIVO_XML = "incidencias.xml";
    private static final String ARCHIVO_SCHEMA = "incidenciasEsquema.xsd";
    private static final String DIRECTORIO_PROYECTO = 
                                                System.getProperty("user.dir");
    
    private static final String SEPARADOR = File.separator;
      
    private static final String URL_ARCHIVO_TEXTO = 
            DIRECTORIO_PROYECTO + SEPARADOR + ARCHIVO_TEXTO; 
    private static final String URL_ARCHIVO_XML = 
            DIRECTORIO_PROYECTO + SEPARADOR + ARCHIVO_XML; 
    private static final String URL_SCHEMA_XML =  
            DIRECTORIO_PROYECTO + SEPARADOR + ARCHIVO_SCHEMA; 
    
    private static final String NOMBRE_USUARIO = "jramirez";
    private static final String TITULO_CONSOLA = 
                                    "\t******  Contenido %s  ******\n\n";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        
        // Crear archivo xml (validando con esquema) a partir
        // del archivo texto especificado
        Traspaso.crearArchivoXML( URL_ARCHIVO_TEXTO, 
                                  URL_ARCHIVO_XML,
                                  URL_SCHEMA_XML );
        
        // Muestra en consola el contenido del archivo xml creado
        System.out.printf( TITULO_CONSOLA, ARCHIVO_XML);  
        
        System.out.println ( Traspaso.getContenidoArchivo( URL_ARCHIVO_XML ) );
        
        // Consulta archivo xml y muestra las incidencias 
        // asignadas a un determinado usuario
        Buscador.mostrarIncidenciasAsignadasA( NOMBRE_USUARIO, URL_ARCHIVO_XML );
               
    }    
}
