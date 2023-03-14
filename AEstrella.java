package laberinto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class AEstrella {
	private Laberinto2 lab;
	private Set<Nodo> nodosCerrado = new HashSet<>();
	private PriorityQueue<Nodo> nodosAbiertos = new PriorityQueue<>(Comparator.comparingInt(nodo -> nodo.getH()+nodo.getG()));

	public AEstrella(Laberinto2 lab) {
		this.lab = lab;
	}
	
	
	public void buscar() {
		int gActual=0;
		lab.getNodoIni().setG(gActual);
		lab.getNodoIni().setH(0);
		nodosAbiertos.add(lab.getNodoIni());
		while(!nodosAbiertos.isEmpty()) {
			Nodo nodoActual= nodosAbiertos.peek();  //menor F=g+h
			if (nodoActual.equals(lab.getNodoFin())) {
				recorrerCamino(nodoActual);
				break;
			}else {
				nodosAbiertos.remove(nodoActual);
				nodosCerrado.add(nodoActual);
				for (Nodo nodoVec : vecinos(nodoActual)) {
					int tentative_g= nodoActual.getG()+1;
					if (nodosCerrado.contains(nodoVec)) {
						continue;
					}
					if (!nodosAbiertos.contains(nodoVec) || tentative_g<nodoVec.getG()) {
						nodoVec.setG(tentative_g);
						nodoVec.setRaiz(nodoActual);
						nodoVec.setH(heuristico(nodoVec));
						if (!nodosAbiertos.contains(nodoVec)) {
							nodosAbiertos.add(nodoVec);
						}
					}
				}
			}
		}
	}
	
	
	public int heuristico(Nodo n) {
		//restar distancia	
		return (Math.abs(lab.getNodoFin().getX()-n.getX())) + (Math.abs(lab.getNodoFin().getY()-n.getY()));
	}

	//los cuatro nodos alrededor del nodo al que estamos apuntando
	private List<Nodo> vecinos(Nodo nodo) {
		ArrayList<Nodo> lista = new ArrayList<>();
		if (!lab.esObsOVacio(nodo.getX()+1, nodo.getY())) {
			Nodo nuevo= new Nodo(nodo.getX()+1, nodo.getY());
			lista.add(nuevo);
		}
		
		if (!lab.esObsOVacio(nodo.getX(), nodo.getY()+1)) {
			Nodo nuevo= new Nodo(nodo.getX(), nodo.getY()+1);
			lista.add(nuevo);
		}
		
		if (!lab.esObsOVacio(nodo.getX()-1, nodo.getY())) {
			Nodo nuevo= new Nodo(nodo.getX()-1, nodo.getY());
			lista.add(nuevo);
		}
		
		if (!lab.esObsOVacio(nodo.getX(), nodo.getY()-1)) {
			Nodo nuevo= new Nodo(nodo.getX(), nodo.getY()-1);
			lista.add(nuevo);
		}
		return lista;
	}
	
	
	public void recorrerCamino(Nodo n) {
		Nodo padre = n.getRaiz();		
		while(!padre.equals(lab.getNodoIni())) {
			//cambiar simbolo de camino en padre
			lab.establecerCamino(padre);
			padre=padre.getRaiz();
			//System.out.println("x:"+ padre.getX() +" Y:" + padre.getY());	
		}
		lab.mostrar();	
	}
}
