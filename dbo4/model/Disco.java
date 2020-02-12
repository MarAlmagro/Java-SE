/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discoteca.model;

import java.util.Objects;

/**
 *
 * @author Mam
 */
public class Disco {
    private String grupo;
    private String titulo;
    private int numCanciones;
    private int anyo;
    private Estilos estilo;

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo.toUpperCase();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo.toUpperCase();
    }

    public int getNumCanciones() {
        return numCanciones;
    }

    public void setNumCanciones(int numCanciones) {
        this.numCanciones = numCanciones;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public Estilos getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilos estilo) {
        this.estilo = estilo;
    }

    @Override
    public String toString() {
        return "Disco{ " + "grupo = " + grupo + ", titulo = " + titulo + 
               ", canciones = " + numCanciones + ", anyo = " + anyo + 
               ", estilo = " + estilo + " }";
    }
    /**
    * @param grupo  Nombre del grupo
    * @param titulo Título del Disco
    * @param numCanciones Número canciones que contiene el Disco
    * @param anyo Año publicación Disco
    * @param estilo Estilo música del Disco */
    public Disco( 
        String grupo, String titulo, int numCanciones,int anyo, Estilos estilo)
    {        
        this.grupo = grupo;
        this.titulo = titulo;
        this.numCanciones = numCanciones;
        this.anyo = anyo;
        this.estilo = estilo;
    }
    
    // Se considera que un disco es igual a otro si el nombre del grupo 
    // y el título del disco son iguales
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.grupo);
        hash = 19 * hash + Objects.hashCode(this.titulo);
        return hash;
    }
    
    // Se considera que un disco es igual a otro si el nombre del grupo 
    // y el título del disco son iguales
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disco other = (Disco) obj;
        if (!this.grupo.equalsIgnoreCase(other.grupo)) {
            return false;
        }
        if (!this.titulo.equalsIgnoreCase(other.titulo)) {
            return false;
        }
        return true;
    }
    
    
    
            
    
}
