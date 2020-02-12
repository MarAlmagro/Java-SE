
package Actividad01;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.MarshalException;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Mam
 */
public class Traspaso 
{
    /**
     * Devuelve un String con todo el contenido de un archivo
     * @param urlArchivo Archivo del que se extrae contenido
     * @return Cadena caracteres con el contenido del archivo
     */
    public static String getContenidoArchivo (String urlArchivo){
        String contenidoArchivo = "";
        try
        {            
            contenidoArchivo = 
                    new String( Files.readAllBytes( Paths.get(urlArchivo) ) );
        } 
        catch (IOException e) 
        {
            System.out.println("Error leyendo archivo : " + urlArchivo);
        }
        return contenidoArchivo;
    }
    
    /**
     * Obtiene objetos Incidencia a partir de los datos contenidos en un
     * archivo texto que tiene un formato previamente conocido
     * @param urlArchivo url archivo texto origen
     * @return Objetos Incidencia obtenidos 
     */
    public static ArrayList<Incidencia> getIncidencias(String urlArchivo)
    {
        ArrayList<Incidencia> incidencias = new ArrayList();
        
        // Guarda el contenido del archivo en un String. Divide el String
        // en bloques, cada bloque contiene el texto que describe una incidencia
        String contenidoArchivo = getContenidoArchivo(urlArchivo);
        ArrayList<String> textoIncidencias = 
                new ArrayList (Arrays.asList(contenidoArchivo.split("% "))); 
        
        // Convierte los bloques texto que describen la incidencia 
        // en objetos Incidencia
        for (String txtIncidencia : textoIncidencias)
        {    
            Incidencia incidencia = getIncidencia(txtIncidencia);
            if (incidencia != null)
            {
                incidencias.add(getIncidencia(txtIncidencia));
            }                
        }
        return incidencias;
    }
    
    /**
     * Obtiene un objeto Incidencia a partir de un String que contiene las
     * líneas de texto que describen una incidencia
     * @param textoIncidencia Texto que describe la incidencia
     * @return Objeto Incidencia creado a partir del texto incidencia
     */    
    private static Incidencia getIncidencia (String textoIncidencia)
    {
        Incidencia incidencia = null;
        // Separar el bloque texto en líneas
        String[] lineas = textoIncidencia.split("\\r?\\n");
        
        // Verificar que bloque texto contiene exactamente 3 líneas 
        // describiendo la incidencia
        if (lineas.length == 3)
        {
            // Dividir el contenido de la primera linea texto para obtener
            // los datos de la fecha y hora incidencia, usuario que la ha
            // creado y el usuario que debe resolverla
            String[] tokensPrimeraLinea = lineas[0].split(" ");
            
            // Comprobar que la primera línea tiene formato correcto
            // pero sin validar si el contenido de sus datos es correcto
            if (tokensPrimeraLinea.length == 4)
            {
                incidencia = new Incidencia();
                incidencia.setFechahora(
                        tokensPrimeraLinea[0] + " " + tokensPrimeraLinea[1] );
                incidencia.setOrigen( tokensPrimeraLinea[2]);
                incidencia.setDestino( tokensPrimeraLinea[3]);
                incidencia.setDetalle( lineas[1]);
                incidencia.setPrioridad( lineas[2]);
            }
        }
        return incidencia;
    }
    
    /**
     * A partir de un archivo de texto que contiene incidencias, obtiene objetos
     * tipo Incidencia y los traspasa a un archivo XML validado por un schema
     * @param urlArchivoOrigen url archivo texto con datos a transformar a XML
     * @param urlArchivoDestino url archivo .xml resultado
     * @param urlSchema Schema para validar el contenido del archivo xml destino
     */
    public static void crearArchivoXML ( String urlArchivoOrigen, 
                                         String urlArchivoDestino,
                                         String urlSchema)
    { 
        try
        {
            // Crear objeto Schema para validar el xml generado
            SchemaFactory generadorSchemas = 
                SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            
            Schema schemaXMLIncidencias = 
                    generadorSchemas.newSchema(new File(urlSchema));
            
            // Crear objeto Marshaller para la clase Incidencias y asignarle 
            // esquema validación xml
            Marshaller marshallerIncidencias = 
                JAXBContext.newInstance(Incidencias.class).createMarshaller();
            marshallerIncidencias.setSchema(schemaXMLIncidencias);            
            
            // Para formatear a xml con saltos de linea y tabulaciones
            marshallerIncidencias.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, 
                                               Boolean.TRUE); 
            // Añadir al xml el atributo xsi:noNamespaceSchemaLocation
            // del elemento raiz <incidencias>
            marshallerIncidencias.setProperty( 
                                 Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, 
                                 new File(urlSchema).getName()); 
            // Referencia al archivo .xml destino
            File archivoXML = new File(urlArchivoDestino);             
            
            // Obtener los objetos Incidencia a partir del archivo de texto 
            // origen y guardarlas en el archivo xml con el formato especificado 
            // en el esquema. El método marshal crea el archivo xml destino
            // si no existe
            Incidencias incidencias = 
                            new Incidencias (getIncidencias(urlArchivoOrigen));
            marshallerIncidencias.marshal (incidencias, archivoXML);
            
        }
        catch(SAXException sax)
        {
            System.out.println("Error al generar instancia schema validación");
        }
        catch(NullPointerException n)
        {
            System.out.println("Error abriendo archivo que contiene el schema");
        }
        catch (MarshalException m)
        {   
            System.out.println(m.getMessage());
        }
        catch (JAXBException j)
        {            
            System.out.println("Error al crear objeto JAXBContext");
        }
        catch (SecurityException sec)
        {            
            System.out.println("Sin permisos acceso al fichero" );
        }
        catch (Exception ex)
        {            
            System.out.println( ex.getMessage() );
        }
    }
            
}
