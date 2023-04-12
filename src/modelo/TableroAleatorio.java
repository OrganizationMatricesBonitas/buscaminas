package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utiles.Utiles;

public class TableroAleatorio extends Tablero {
	private boolean terminado = false;
	boolean[][] casillasDesveladas;
//	List<Coordenada> posicionesMinas;
	// Constructor aleatorio

	public TableroAleatorio(int lado, int minas) {
		super(lado);
		minas = (int) Math.round(lado * 0.20); // TODO Quitar esto cuando se implemente la densidad
		casillasDesveladas = new boolean[lado][lado];
		List<Coordenada> posicionesMinas = generaAleatorio(minas, lado);
		// Vienen los atributos de casilla ya iniciados por defecto
//		iniciartablero();
		ponerMinas(posicionesMinas);
		contarMinasAlrededor(posicionesMinas);
	}

	/*
	 * Funcion que establecera los atributos de las casillas
	 */
	private void iniciartablero() {
		for (int i = 0; i < this.getAlto(); i++) {
			for (int j = 0; j < this.getAncho(); j++) {
				Coordenada coor = new Coordenada(i, j);
				Casilla casilla = this.getCasilla(coor);
				casilla.setMinasAlrededor(0);// Iniciamos con 0
			}
		}

	}

	// constructor no aleatorio
	public TableroAleatorio(int lado, List<Coordenada> posiciones) {
		super(lado);
		contarMinasAlrededor(posiciones);
	}

	public TableroAleatorio(int lado, int minas, Coordenada coordenada) {
		super(lado);
		minas = (int) Math.round(lado * 0.20); // TODO Quitar esto cuando se implemente la densidad
		casillasDesveladas = new boolean[lado][lado];
		List<Coordenada> posicionesMinas = generaAleatorio(minas, lado,coordenada);
		
//		iniciartablero();
		ponerMinas(posicionesMinas);
		contarMinasAlrededor(posicionesMinas);
	}
	
	private List<Coordenada> generaAleatorio(int minas, int longitud, Coordenada coordenada) {
		List<Coordenada> minasRnd = new ArrayList<Coordenada>();
		Random rnd = new Random();
		while (minasRnd.size() < minas) {
			Coordenada xy = new Coordenada(rnd.nextInt(longitud), rnd.nextInt(longitud));
			if (minasRnd.indexOf(xy) == -1 && !coordenada.equals(xy)) {
				minasRnd.add(xy);
			}
		}
		return minasRnd;
	}

	private void ponerMinas(List<Coordenada> posiciones) {
		for (Coordenada coordenada : posiciones) {
			this.getCasilla(coordenada).setMina(true);
		}
	}

	public void contarMinasAlrededor(List<Coordenada> posiciones) {
		for (Coordenada coordenada : posiciones) {

			for (int i = coordenada.getPosX() - 1; i <= coordenada.getPosX() + 1; i++) {
				for (int j = coordenada.getPosY() - 1; j <= coordenada.getPosY() + 1; j++) {
					Coordenada nuevaCoordenada = new Coordenada(i, j);
					if (isInToBounds(nuevaCoordenada)) {
						Casilla casilla = this.getCasilla(nuevaCoordenada);
						casilla.setMinasAlrededor(casilla.getMinasAlrededor() + 1);
					}
				}
			}
		}
	}

	public boolean[][] getCasillasDesveladas() {

		return casillasDesveladas;
	}

	public void desvelarContiguas(Coordenada lugar) {
		// tablero, lugar
		Casilla casilla = getCasilla(lugar);
		if (casilla.isVelada() && !casilla.isMarcada()) {
			revelarCasilla(lugar);
			if (!casilla.isMina()) {
				if (casilla.getMinasAlrededor() == 0) {
					// desde el punto -1,-1 con respecto a casilla hasta +1,+1
					for (int i = lugar.getPosX() - 1; i <= lugar.getPosX() + 1; i++) {
						for (int j = lugar.getPosY() - 1; j <= lugar.getPosY() + 1; j++) {
							Coordenada coordenada = new Coordenada(i, j);
							if (isInToBounds(coordenada)) {
								desvelarContiguas(coordenada);
							}
						}

					}
				}
			} else {
				desvelarTablero();
			}

		}
	}

	/*
	 * Desvela todo el tablero
	 */
	private void desvelarTablero() {
		for (int i = 0; i < casillasDesveladas.length; i++) {
			for (int j = 0; j < casillasDesveladas[0].length; j++) {
				casillasDesveladas[i][j] = true;
			}
		}

	}

	private boolean isInToBounds(Coordenada coordenada) {
		int posX = coordenada.getPosX();
		int posY = coordenada.getPosY();

		boolean ladoSuperior = posX >= 0;
		boolean ladoInferior = posX < getAlto();
		boolean ladoIzquierdo = posY >= 0;
		boolean ladoDerecho = posY < getAncho();

		return ladoSuperior && ladoInferior && ladoIzquierdo && ladoDerecho;
		// Se que hay en coordenada un Metodo isInToLimit(ancho, alto) y es lo mismo que
		// esto
	}

	public List<Coordenada> generaAleatorio(int minas, int longitud) {
		List<Coordenada> minasRnd = new ArrayList<Coordenada>();
		Random rnd = new Random();
		while (minasRnd.size() < minas) {
			Coordenada xy = new Coordenada(rnd.nextInt(longitud), rnd.nextInt(longitud));
			if (minasRnd.indexOf(xy) != -1) {
				minasRnd.add(xy);
			}
		}
		return minasRnd;

	}

	/*
	 * Metodo que desvelara una casilla Actualizando asi tanto la matriz Boolean
	 * desveladas como la el atributo boolean (velada) de la casilla
	 */
	public void revelarCasilla(Coordenada coordenada) {
		casillasDesveladas[coordenada.getPosX()][coordenada.getPosY()] = true;
		this.getCasilla(coordenada).setVelada(false);
	}

}
