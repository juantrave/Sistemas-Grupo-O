package laberinto;

import java.util.Random;

public class Laberinto2 {
	private char[][] laberinto;
	private double porcObs;
	private int filas;
	private int columnas;
	private char simboloObs;	
	private char simboloCam;
	private Nodo nodoIni, nodoFin;

	
	public Laberinto2(int filas, int columnas, double porcObs, char simboloObs, char simboloCam) {
		laberinto = new char[filas][columnas];		//creamos un laberinto de 60x80
		this.filas = filas;
		this.columnas = columnas;
		this.porcObs = porcObs;
		this.simboloObs = simboloObs;
		this.simboloCam = simboloCam;
		
		Random numRandom = new Random();

		int posf = numRandom.nextInt(filas);
		int posc = numRandom.nextInt(columnas);
		laberinto[posf][posc] = 'I';
		nodoIni = new Nodo(posf, posc);				//nodo inicial
		do {
			posf = numRandom.nextInt(filas);
			posc = numRandom.nextInt(columnas);
		} while (laberinto[posf][posc] == 'I');		//generamos una nueva posicion distinta a la del nodo inicial

		laberinto[posf][posc] = 'G';
		nodoFin = new Nodo(posf, posc);				//nodo final
		
		for(int i=0; i<laberinto.length;i++) {
			for (int j=0; j<laberinto[i].length; j++) {
				if (laberinto[i][j] == 'I' || laberinto[i][j] == 'G') {		//si estoy apuntando a la pos inicial o final no hago nada
					continue;
				}
				if (numRandom.nextDouble() <= porcObs) {		//probabilidad del 30% de que una celda sea un obstaculo (REVISAR)
					laberinto[i][j] = simboloObs;				//en nuestro caso '#'
				} else {
					laberinto[i][j] = ' ';
				}
			}
		}
	}

	//nos dice si en una posicion 'x' e 'y' hay un obstaculo o esta dentro del propio laberinto
	public boolean esObsOVacio(int x, int y){
		if (x<0 || x>=filas || y<0 || y>=columnas) {
			return true;
		}
		return laberinto[x][y]==simboloObs;
	}

	public Nodo getNodoIni() {
		return nodoIni;
	}

	public Nodo getNodoFin() {
		return nodoFin;
	}

	
	
	public void mostrar() {
		for (char[] f : laberinto) {
			for (char c : f) {
				System.out.print(c);
			}
			System.out.println();
		}
	}


	public char[][] getLaberinto() {
		return laberinto;
	}

	public double getPorcObs() {
		return porcObs;
	}

	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public char getSimboloObs() {
		return simboloObs;
	}

	public char getSimboloCam() {
		return simboloCam;
	}
	
	public void establecerCamino(Nodo nodo) {
		laberinto[nodo.getX()][nodo.getY()]= simboloCam;	
	}
}
