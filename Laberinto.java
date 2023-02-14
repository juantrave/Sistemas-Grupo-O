package laberinto;
import java.lang.constant.Constable;
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
	}
	
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
