
package filmoteca02.model;


public class Director {
    private String nombre;
    private String apellidos;

    public Director() {
    }

    public Director(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    
    @Override
    public String toString() {
        return nombre + " " + apellidos;
    }
    
    
}
