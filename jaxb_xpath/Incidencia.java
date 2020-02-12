
package Actividad01;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mam
 */

@XmlRootElement(name = "incidencia")
@XmlAccessorType(XmlAccessType.FIELD)
public class Incidencia implements Serializable{
    
    // Empleado que crea la incidencia
    private String origen;
    // Empleado que debe solucionar la incidencia
    private String destino;
    // Descripción de la incidencia
    private String detalle;
    // Prioridad de la incidencia (Urgente o Normal)
    private Prioridad tipo;
    // Fecha y hora de la creación de la incidencia
    @XmlAttribute
    private String fechahora;
    
    public Incidencia(){}

    public Incidencia( String fecha, String empleadoOrigen, 
                       String empleadoDestino, String detalle, 
                       Prioridad prioridad) {
        this.fechahora = fecha;
        this.origen = empleadoOrigen;
        this.destino = empleadoDestino;
        this.detalle = detalle;
        this.tipo = prioridad;
    }
    
    public Incidencia( String fecha, String empleadoOrigen, 
                       String empleadoDestino, String detalle, 
                       String prioridad) {
        this.fechahora = fecha;
        this.origen = empleadoOrigen;
        this.destino = empleadoDestino;
        this.detalle = detalle;
        setPrioridad(prioridad);
    }
    
    public final void setPrioridad (String prioridad){
        this.tipo = Prioridad.valueOf(prioridad.toUpperCase());
    }

    public String getFechahora() {
        return fechahora;
    }

    public void setFechahora(String fechahora) {
        this.fechahora = fechahora;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Prioridad getTipo() {
        return tipo;
    }

    public void setTipo(Prioridad tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return    "Incidencia{" + "fecha=" + fechahora + ", "
                + "empleadoOrigen=" + origen 
                + ", empleadoDestino=" + destino  
                + ", detalle=" + detalle + ", prioridad=" + tipo + '}';
    }           
}
