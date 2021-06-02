import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 */

/**
 * @author EMenendez
 *
 */
public class Grafo {
	private int[][] matrix; 
	private Lector lector = new Lector(); 
	private Map<String, Integer> localizador = new HashMap<String, Integer>(); 
	
	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public Map<String, Integer> getLocalizador() {
		return localizador;
	}

	public void setLocalizador(Map<String, Integer> localizador) {
		this.localizador = localizador;
	}

	
	
	public  int[][] LlenarMatriz() {
		//Se lee el archivo
		String codigo = lector.leerArchivo("guategrafo.txt");
		//Se separa en enters
		String[] lista = codigo.split("\n");
		
		//Se hace una lista donde se sepa que sus valores serán los importantes
		Set<String> ListaNombres = new HashSet<String>();
		String[] elemento; 
		//Ciclo for para llenar la nueva lista
		for(int i = 0; i < lista.length; i++) {
			elemento = lista[i].split(" ");
			ListaNombres.add(elemento[0]); 
			ListaNombres.add(elemento[1]);
		}
		
		int k=0; 
		for (String x : ListaNombres) {
			 localizador.put(x, k); 
			 k++;
		 }
		matrix = new int[ListaNombres.size()][ListaNombres.size()];
		//Ciclo for para llenar la matriz
		for(int i = 0; i < lista.length; i++) {
			elemento = lista[i].split(" ");
			int a= localizador.get(elemento[0]); 
			int b= localizador.get(elemento[1]);
			int distancia = Integer.parseInt( elemento[2]);
			matrix[a][b] = distancia;
		}
		// Poner infinitos
		for (int i = 0; i < ListaNombres.size(); i++) {
			for (int j = 0; j < ListaNombres.size(); j++) {
				if (matrix[i][j]==0) {
					if(i!=j) {
						matrix[i][j]=99999;
					}
				}
			}
		}
		
		//Devolver el mapa lleno
		return matrix;
		
	}
	public int[][] CambiarValor(String a, String b, int distancia){
		
		int val1 = localizador.get(a); 
		int val2 = localizador.get(b); 
		matrix[val1][val2]= distancia; 
		return matrix;
	}
	public String[] RegresarNombres(){
		//Se lee el archivo
			String codigo = lector.leerArchivo("guategrafo.txt");
			//Se separa en enters
			String[] lista = codigo.split("\n");
							//Se hace una lista donde se sepa que sus valores serán los importantes
			Set<String> ListaNombres = new HashSet<String>();
			String[] elemento; 
			//Ciclo for para llenar la nueva lista
			for(int i = 0; i < lista.length; i++) {
				elemento = lista[i].split(" ");
				ListaNombres.add(elemento[0]); 
				ListaNombres.add(elemento[1]);
			}
			String[] Nombres= new String[ListaNombres.size()];
			int k=0; 
			
			for(String s: ListaNombres) {
				Nombres[k]=s; 
				k++; 
			}
			return Nombres; 
	}
}
