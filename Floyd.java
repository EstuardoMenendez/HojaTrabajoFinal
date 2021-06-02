/**
 * 
 */
import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * @author EMenendez
 *
 */
public class Floyd {
	 
	    void floydWarshall(int graph[][], int V, String[] names)
	    {
	        int dist[][] = new int[V][V];
	        int i, j, k;
	 
	        // Al comienzo la matriz es la misma, despues se iterará 
	        for (i = 0; i < V; i++)
	            for (j = 0; j < V; j++)
	                dist[i][j] = graph[i][j];
	 
	        for (k = 0; k < V; k++)
	        {
	            // Pick all vertices as source one by one
	            for (i = 0; i < V; i++)
	            {
	                // Se eligen los vértices particulares
	                for (j = 0; j < V; j++)
	                {
	                    // Si el vertice esta en el camino más corto, reemplazar
	                    if (dist[i][k] + dist[k][j] < dist[i][j])
	                        dist[i][j] = dist[i][k] + dist[k][j];
	                }
	            }
	        }
	 
	        // print
	        printSolution(dist, V, names);
	    }
	 
	    void printSolution(int dist[][], int V, String[] names)
	    {
	        for (int i=0; i<V; ++i)
	        {
	        	String space = " ";
	        	System.out.print(names[i]+space.repeat(15-names[i].length())); 
	        	
	            for (int j=0; j<V; ++j)
	            {
	            	
	                if (dist[i][j]>=99999)
	                    System.out.print("INF ");
	                else
	                    System.out.print( "     "+dist[i][j]+"     ");
	            }
	            System.out.println();
	        }
	    }
	}
