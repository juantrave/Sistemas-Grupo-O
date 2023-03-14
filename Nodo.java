package laberinto;

import java.util.Objects;

public class Nodo {
	private int x;
	private int y;
	private int g, h;
	private Nodo raiz;
	
	public Nodo(int x, int y) {
		this.x = x;
		this.y = y;
		g = 0;
		h = 0;
		raiz = null;
	}
	
	public void setG(int g) {
		this.g = g;
	}

	public void setH(int h) {
		this.h = h;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	public int getG() {
		return g;
	}

	public int getH() {
		return h;
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nodo other = (Nodo) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return "Nodo [x=" + x + ", y=" + y + "]";
	}
	
	
}
