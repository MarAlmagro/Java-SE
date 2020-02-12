package uf05.actividad01;

import java.util.HashMap;
import java.util.Map;

public class Tienda {

	// Datos del stock de productos
	// La clave es un objeto Producto y el valor es el 
	// stock en tienda de dicho Producto
	private static HashMap<Producto, Integer> inventario = new HashMap<Producto,Integer>();
	
	// Da de alta un producto en el inventario
	public static void alta (Producto p, int unidades){
		inventario.put(p, unidades);
	}
	
	// elimina un producto del inventario
	public static void borrar (Producto p){
		inventario.remove(p);
	}
	
	// Modifica el número de unidades/stock de un producto
	public static void modificar (Producto p, int unidades) {
		inventario.replace(p, unidades);		
	}
	
	// Muestra todos los elementos del inventario
	public static void mostrarInventario() {
		for (Map.Entry<Producto,Integer> entry : inventario.entrySet()){
			System.out.println( "Clave = " + entry.getKey() + 
					            ", Stock = " + entry.getValue());
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		// Crear tres productos
		Producto peluche = new Producto ("Peluche", 21.92f);
		Producto bicicleta = new Producto ("Bicicleta", 170f);
		Producto puzzle = new Producto ("Puzzle", 12.75f);
		System.out.println("\n\tCrear tres productos\r\n" + 
				"\n		Producto peluche = new Producto (\"Peluche\", 21.92f);\r\n" + 
				"		Producto bicicleta = new Producto (\"Bicicleta\", 170f);\r\n" + 
				"		Producto puzzle = new Producto (\"Puzzle\", 12.75f);\n");
		// Dar de alta los tres productos
		alta(peluche,16);
		alta(bicicleta, 3);
		alta(puzzle,8);
		
		System.out.println("\t Dar de alta los tres productos\r\n" + 
				"\n		alta(peluche,16);\r\n" + 
				"		alta(bicicleta, 3);\r\n" + 
				"		alta(puzzle,8);\n");
		
		// Mostrar inventario
		System.out.println ("\t Inventario Inicial\n");
		mostrarInventario();
		
		// Modificar stock de Peluche
		modificar(peluche, 11);
		System.out.println("\t Modificar stock de Peluche\r\n" + 
				"\n		modificar(peluche, 11);");
		
		// Mostrar inventario después de cambiar stock Peluche	
		System.out.println ("\n\t Inventario al cambiar stock Peluche\n");
		mostrarInventario();
		
		// Quitar Peluche del inventario
		borrar(peluche);
		System.out.println("\t Quitar Peluche del inventario\r\n" + 
				"\n		borrar(peluche);\n");
		
		// Mostrar inventario después de borrar Peluche	
		System.out.println ("\n\t Inventario al borrar Peluche\n");
		mostrarInventario();
		
		// Comparar bicicleta con Puzzle
		System.out.println ("\nComparar bicicleta con puzzle: ");
		System.out.println ("\n\tbicicleta.equals(puzzle) ? => " +
		                     bicicleta.equals(puzzle));
		
		// Creo un nuevo producto, mismo nombre y precio que puzzle
		Producto rompecabezas = new Producto("Puzzle", 12.75f);
		
		System.out.println ("\n\nCrear nuevo producto, mismo nombre y precio que puzzle\r\n" + 
				"\n\tProducto rompecabezas = new Producto(\"Puzzle\", 12.75f);\n");
		
		// Comparar rompecabezas con puzzle
		System.out.println ("\nComparar rompecabezas con puzzle: ");
		System.out.println ("\n\trompecabezas.equals(puzzle) ? => " +
               rompecabezas.equals(puzzle));
		
	}

}
