package uf05.actividad01;

import java.util.Objects;

public class Producto {
	// nombre del producto
	private String nombre;
	//precio del producto
	private float precio;
	
	// constructor que establece el valor del nombre y
	// precio del producto
	public Producto (String nombre, float precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	// Devuelve el HashCode del objeto Producto
	@Override
	public int hashCode() {
		return (int) (nombre.hashCode() + precio);
	}

	// Compara este objeto con otro producto, devuelve
	// true si los dos objetos son iguales y false en 
	// otro caso
	// Dos productos son iguales si tienen el mismo
	// nombre y el mismo precio
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Producto)) {
			return false;
		}
		Producto other = (Producto) obj;
		return Objects.equals(nombre, other.nombre)
				&& Float.floatToIntBits(precio) == Float.floatToIntBits(other.precio);
	}

	// Devuelve una cadena con el contenido del Producto
	@Override
	public String toString() {
		return "Producto [ " + nombre + ", " + precio + " € ]";
	}
	
	
	
	
	
}
