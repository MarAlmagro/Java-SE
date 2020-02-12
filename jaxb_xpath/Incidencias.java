package Actividad01;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase auxiliar creada para que JAXB pueda transformar
 * directamente a xml un ArrayList de objetos Incidencia
 * @author Mam
 */

@XmlRootElement(name = "incidencias")
@XmlAccessorType(XmlAccessType.FIELD)
public class Incidencias implements Serializable {

    @XmlElement(name = "incidencia")
    private ArrayList<Incidencia> incidencias = new ArrayList();

    public Incidencias() {
    }

    public Incidencias(ArrayList<Incidencia> incidencias) {
        if (incidencias != null) {
            this.incidencias = incidencias;
        }
    }

    public ArrayList<Incidencia> getIncidencias() {
        return this.incidencias;
    }

    public void setIncidencias(ArrayList<Incidencia> incidencias) {
        this.incidencias = incidencias;
    }

    @Override
    public String toString() {
        return "Incidencias{" + "incidencias=" + incidencias + '}';
    }
}
