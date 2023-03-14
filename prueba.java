package laberinto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class prueba {
	private static final double PorcMUROS = 0.3;
	private static final int FILAS = 60;
	private static final int COLUMNAS = 80;
	private static final char OBSTACULO = '■';
	private static final char CAMINO = '+';
	
	public static void main(String[] args) {
		Laberinto2 lab2 = new Laberinto2(FILAS,COLUMNAS,PorcMUROS,OBSTACULO,CAMINO);
		lab2.mostrar();
		System.out.println("------------------------");
		AEstrella prueba= new AEstrella(lab2);
		prueba.buscar();
	}
}
