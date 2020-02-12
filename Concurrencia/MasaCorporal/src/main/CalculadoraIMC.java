package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Calcular índice masa corporal(IMC) a partir del 
// peso y la estatura que nos envía el proceso
// "Principal". Devuelve al proceso Principal
// el resultado del cálculo y el comentario según la OMS
public class CalculadoraIMC {

	private static final String BAJO_PESO = "Bajo Peso";
	private static final String NORMAL = "Normal";
	private static final String SOBREPESO = "Sobrepeso";
	private static final String OBESIDAD = "Obesidad";
	private static final String OBESIDAD_MORBIDA = "Obesidad Mórbida";
	
	private static float VALOR_NORMAL = 18.50f;
	private static float VALOR_SOBREPESO = 25f;
	private static float VALOR_OBESIDAD = 30f;
	private static float VALOR_MORBIDA = 40f;
	
	public static void main(String[] args) { 
				
		float peso, estatura, imc;
		
        try {
        	
            // Recuperar peso y altura enviados por el proceso padre "Principal"
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));            
            estatura = Float.parseFloat( br.readLine());            
            peso = Float.parseFloat( br.readLine() );
            
            // Calcular índice masa corporal
            imc =  (float) ( peso / Math.pow(estatura / 100, 2) );   
            
            // Valoración OMS para el imc
            String valoracion;
            if ( imc >= VALOR_MORBIDA)
            	valoracion = OBESIDAD_MORBIDA;
            else if ( imc >= VALOR_OBESIDAD)
            	valoracion = OBESIDAD;
            else if ( imc > VALOR_SOBREPESO)
            	valoracion = SOBREPESO;
            else if ( imc >= VALOR_NORMAL)
            	valoracion = NORMAL;
            else 
            	valoracion = BAJO_PESO;
            
            // Enviar resultado al proceso padre
            System.out.println("Valor IMC es => " + imc + " => " + valoracion);
         
        } catch (IOException e) { 
            System.out.println("Error: " + e.getMessage());
        }catch (NumberFormatException e) { 
            System.out.println("Error: " + e.getMessage());
        }
    }

}
