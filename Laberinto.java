package laberinto;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.zip.Inflater;
public class Laberinto {

	private static final double FMUROS = 0.3;
	private static final int FILAS = 60;
	private static final int COLUMNAS = 80;
	private char[][] laberinto;
	 
	
	public Laberinto() {
		laberinto = new char[FILAS][COLUMNAS];
		for(char[] f : laberinto) {
			for(char c: f) {
				c =' ';
			}
		}
		escribir();
	}
	
//	public int getGPosition(Laberinto lab) {
//		for(char[] f : laberinto) {
//			for(char c: f) {
//				if (c=='G') {
//					lab[].;
//				}
//			}
//		}
//	}
	
	public char[][]  getNodosEvaluados(char[][] lab) {
		char[][] aux= new char [FILAS][COLUMNAS];
		for (char[] cs : laberinto) {
			for (char c : cs) {
				if (c!=' ') {
					char[] getPosfila= Arrays.asList(lab).get(c);
					int getePoscolumna= Arrays.asList(lab).indexOf(getPosfila);
					
				}
			}
		}
		return aux;
	}
	
//	private void Aestrella() {
//		char[][] closedset= new char[][];// The set of nodes already evaluated
//		openset := {start} // The set of tentative nodes to be evaluated
//		parent := the empty map // The map of navigated nodes
//		g[start] := 0 // Cost from start along best known path
//		f[start] := g[start] + h(start) // Estimated total cost from start to nearest goal through y
//		while openset is not empty
//			current := the node in openset having the lowest f[] value
//			if is_goal(current)
//				return reconstruct_path(parent, current)
//			remove current from openset
//				add current to closedset
//				for each neighbor in neighbor_nodes(current)
//				if neighbor in closedset continue
//				tentative_g := g[current] + dist_between(current,neighbor)
//				if neighbor not in openset or tentative_g < g[neighbor]
//				parent[neighbor] := current
//				g[neighbor] := tentative_g
//				f[neighbor] := g[neighbor] + h(neighbor)
//				if neighbor not in openset
//				add neighbor to openset
//				return failure
//	}
	
	public void escribir() {
		double muros = (FILAS*COLUMNAS)*FMUROS;
		Random f = new Random();
		Random c = new Random();
		int posc,posf;
		while (muros >0 ) {
			posf = f.nextInt(FILAS);
			posc = c.nextInt(COLUMNAS);
			
			if(laberinto[posf][posc]!='#') {
				laberinto[posf][posc] = '#';
				muros--;
			}
		}
		
		do{
			posf= f.nextInt(FILAS);
			posc= c.nextInt(COLUMNAS);
			if(laberinto[posf][posc]!='#') {
				laberinto[posf][posc] = 'I';
			} 
		}while(laberinto[posf][posc]!='I');
		
		do{
			posf= f.nextInt(FILAS);
			posc= c.nextInt(COLUMNAS);
			if(laberinto[posf][posc]!='#' && laberinto[posf][posc]!='I') {
				laberinto[posf][posc] = 'G';
			} 
		}while(laberinto[posf][posc]!='G');
	}
	
	public int contar() {
		int cont = 0;
		for(char[] f : laberinto) {
			for(char c: f) {
				if (c=='#') {
					cont++;
				}
			}
		}	
		return cont;
	}

	public void mostrar() {
		for(char[] f : laberinto) {
			for(char c: f) {
				System.out.print(c);
			}
			System.out.println();
	}	
	
	}
	
	
}
