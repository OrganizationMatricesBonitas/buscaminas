package crontoller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;

import modelo.Coordenada;
import modelo.MyButton;
import modelo.TableroAleatorio;

public class Controlador {

	private TableroAleatorio tablero;

	
	public Controlador(Coordenada coordenada) {
		super();
		this.tablero.revelarCasilla(coordenada);
	}

	public TableroAleatorio getTablero() {
		return tablero;
	}

	public void setTablero(TableroAleatorio tablero) {
		this.tablero = tablero;
	}
	
	/*
	 * Comporbara si la casilla en el tablero esta velada
	 * @param coordenada es la coordenada a verificar en el tablero
	 * return True si la casilla esta Velada
	 * 		  False: si la casilla esta desvelada
	 */
	public boolean isVelada(Coordenada coordenada) {
		
		return tablero.getCasilla(coordenada).isVelada();
	}

	public String getMinasAlrededor(Coordenada coordenada) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Color getColor(String minasAlrededor) {
		// TODO Auto-generated method stub
		return Color.blue;
	}

	
	
	
}
