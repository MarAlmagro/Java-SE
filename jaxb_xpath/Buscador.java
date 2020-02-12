
package Actividad01;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Mam
 */
public class Buscador { 
    
    /** Busca en un archivo xml, mediante XPATH, las incidencias destinadas 
     *  a un determinado empleado. Muestra resultado consulta en la consola
     * @param nombreUsuario nombre del usuario destino de las incidencias
     * @param urlArchivoXML archivo XML que se consulta
     */
    public static void mostrarIncidenciasAsignadasA (  String nombreUsuario,
                                                       String urlArchivoXML)
    {
        // Consulta a realizar
        String consulta = "/incidencias/incidencia[./destino='"
                + nombreUsuario + "']";
        
        // Personalizar texto mostrado en consola
        System.out.println( "\n\t******  XPATH  ******");  
        System.out.println( "\nConsulta => " + consulta + "\n");  
        
        try
        {
            // Cargar en memoria el árbol DOM obtenido del archivo xml
            DocumentBuilderFactory factory = 
                                        DocumentBuilderFactory.newInstance();
            Document arbolDOM = 
                              factory.newDocumentBuilder().parse(urlArchivoXML);
            
            // Crear y ejecutar la consulta
            XPath consultaXPath = 
                    XPathFactory.newInstance().newXPath();           
                    
            NodeList nodosIncidencia = 
                    (NodeList) consultaXPath.evaluate( consulta, 
                                                       arbolDOM, 
                                                       XPathConstants.NODESET);
            
            // Mostrar contenido de nodos incidencia resultado de la consulta
            for ( int i = 0; i < nodosIncidencia.getLength(); i++ )
            {
                mostrarNodoIncidencia (nodosIncidencia.item(i));   
            }           
                      
        }
        catch(SAXException sax)
        {
            System.out.println("Error al cargar árbol DOM");
        }
        catch(IllegalArgumentException n)
        {
            System.out.println("Archivo xml a parsear no puede ser null");
        }
        catch (ParserConfigurationException m)
        {   
            System.out.println("Error creando el objeto DocumentBuilder");
        }
        catch (IOException io)
        {   
            System.out.println("Error entrada/salida");
        }
        catch (NullPointerException ne)
        {   
            System.out.println("Error, ruta archivo xml es null");
        }
        catch (XPathExpressionException xp)
        {   
            System.out.println(  "No se puede compilar la expresion : "
                                 + consulta );
        }
    }
    /**
     * Muestra en consola el contenido de un elemento xml "<incidencia>"
     * @param nodo Nodo con el contenido a mostrar
     */
    private static void mostrarNodoIncidencia (Node nodoIncidencia)
    {  
        // Mostrar contenido del atributo fechahora
        System.out.print(
                   "\t" + nodoIncidencia.getAttributes().item(0).getNodeName());
        
        System.out.println(
                " => " +nodoIncidencia.getAttributes().item(0).getNodeValue());
        
        // Obtener y recorrer la lista nodos hijos
        NodeList hijos = nodoIncidencia.getChildNodes();
        
        for ( int i = 0; i < hijos.getLength(); i++ )
        {
              // Sólo mostrar el contenido de los nodos hijos que sean de 
              // tipo element ( node type = 1 )
              Node nodoActual = hijos.item(i);
              if ( nodoActual.getNodeType() == 1)
              {
                  System.out.print( "\t" +nodoActual.getNodeName() + " => ");
                  System.out.println( nodoActual.getTextContent());
              }
        } 
        System.out.println("\n------------\n");     
    }
}
