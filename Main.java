import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * 
 */

/**
 * @author EMenendez
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grafo grafo= new Grafo(); 
		Floyd floyd = new Floyd();
		int  matriz[][]= grafo.LlenarMatriz(); 
		String[] Nombres = grafo.RegresarNombres(); 
		Scanner readLine = new Scanner(System.in);
		String respuesta="";
		while(respuesta!="3") {
			System.out.println("Bienvenido al programa. Elija una de las opciones: ");
			System.out.println("1) imprimir la matriz de adyacencia con floyd");
			System.out.println("2) Cambiar valores del grafo");
			System.out.println("3) Salir ");
			System.out.println("Escriba el numero de elección");
			respuesta= readLine.nextLine();
			switch(respuesta) {
			case "1": System.out.println( "                 " + Nombres[0]+ "  " + Nombres[1]+ "  "+Nombres[2]+ "     "+Nombres[3]+ "     "+Nombres[4]+ " ");floyd.floydWarshall(matriz, matriz.length, Nombres); break; 
			case "2": 
				System.out.println("Ingrese el nombre del nodo de origen ");
				String respuesta2= readLine.nextLine();
				System.out.println("Ingrese el nombre del nodo de destino");
				String respuesta3= readLine.nextLine();
				System.out.println("Escriba el numero de elección");
				int distancia= Integer.parseInt(readLine.nextLine());
				matriz= grafo.CambiarValor(respuesta2, respuesta3, distancia);
				System.out.println( "                 " + Nombres[0]+ "  " + Nombres[1]+ "  "+Nombres[2]+ "     "+Nombres[3]+ "     "+Nombres[4]+ " ");floyd.floydWarshall(matriz, matriz.length, Nombres);
				break; 
			default:
				System.out.println("Ingrese una opción válida");
			}
				
		}
		
}
}

