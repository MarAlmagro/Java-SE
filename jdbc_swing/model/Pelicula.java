
package filmoteca02.model;

public class Pelicula {
  
    private String titulo;
    private Director director;
    private String pais;
    private int duracion;
    private String genero;   

    
    public Pelicula() {
    }

    public Pelicula( String titulo, Director director, String pais, 
                     int duracion, String genero) {
        this.titulo = titulo;
        this.director = director;
        this.pais = pais;
        this.duracion = duracion;
        this.genero = genero;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
            return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
            this.titulo = titulo;
    }

    /**
     * @return the director
     */
    public Director getDirector() {
            return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(Director director) {
            this.director = director;
    }

    /**
     * @return the pais
     */
    public String getPais() {
            return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
            this.pais = pais;
    }

    /**
     * @return the duracion
     */
    public int getDuracion() {
            return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(int duracion) {
            this.duracion = duracion;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
            return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
            this.genero = genero;
    }

    @Override
    public String toString() {
            return "Pelicula [titulo=" + titulo + ", director=" + 
                    director + ", pais=" + pais + ", duracion=" + 
                    duracion + ", genero=" + genero + "]";
    }
      
}
