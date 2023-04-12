package modelo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import crontoller.Controlador;

public class Botonera extends JPanel {

	Controlador controlador; // Tendra datos
	JPanel containerBotones; // Tiene los botones
	int dimension;
	boolean inGame;

	public Botonera(int lado) {
//		controlador = new Controlador(lado);
		// Creamos juego (Tablero) una vez hayamos pulsado el primer boton
		inGame = false;
		this.dimension = lado;
		setBounds(100, 100, 450, 300);
		containerBotones = new JPanel();
		containerBotones.setBorder(new EmptyBorder(5, 5, 5, 5));
		containerBotones.setLayout(new GridLayout(lado, lado, 0, 0));

		generarBotones(lado);
//		renderTablero();
	}

	private void generarBotones(int lado) {
		for (int i = 0; i < lado; i++) {
			for (int j = 0; j < lado; j++) {
				MyButton boton = new MyButton(new Coordenada(i, j));
				boton.setBounds(new Rectangle(40, 40));
				boton.setMaximumSize(new Dimension(40, 40));
				boton.setBorder(new LineBorder(new Color(200, 196, 195)));
				// Velada para que no se focuse
//				boton.setBorderPainted(false);
				boton.setRolloverEnabled(false);
				boton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						MyButton btn = (MyButton) e.getSource();
						if (inGame) {
//						revelarBoton(btn);
							// RENDERIZAR TABLERO
							controlador.getTablero().desvelarContiguas(btn.getCoordenada());
							renderTablero();
						} else {
							inGame = true;
							//Aleatorio
//							controlador = new Controlador(dimension, btn.getCoordenada());
							//No Aleatorio
							List<Coordenada> posiciones = new ArrayList<Coordenada>();
							controlador = new Controlador(dimension, btn.getCoordenada());
							controlador.getTablero().desvelarContiguas(btn.getCoordenada());
						}
					}
				});
				containerBotones.add(boton);
			}
		}
	}

	protected void renderTablero() {
		Component[] componentes = containerBotones.getComponents();

		for (Component componente : componentes) {
			Coordenada coordenada = ((MyButton) componente).getCoordenada();
			if (!controlador.isVelada(coordenada)) {
				Integer minasAlrededor = controlador.getMinasAlrededor(coordenada);
				desvelarBoton((MyButton) componente, String.valueOf(minasAlrededor),
						controlador.getColor(minasAlrededor));
			}

		}
	}

	// Para recuperar el JPanel con Botones
	public JPanel getPanel() {
		return containerBotones;
	}

	/*
	 * Metodod final Para revelar Botones (Aun no implementado)
	 */
	private void desvelarBoton(MyButton btn, String minasAlrededor, Color color) {
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(true);
		btn.setBorder(new LineBorder(color));
		if (!minasAlrededor.equals("0")) {
			btn.setText(minasAlrededor);
			btn.setForeground(color);
		}
//		else if(){
//			
//		}
	}

	/*
	 * Metodo auxiliar apra desvelar botones ACTUAL
	 */
	private void revelarBoton(MyButton btn) {
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(true);
		btn.setBorder(new LineBorder(new Color(165, 170, 170)));
		btn.setText(String.valueOf(btn.getCoordenada().getPosX()) + String.valueOf(btn.getCoordenada().getPosY()));
		btn.setForeground(Color.BLUE);
	}

	public int getDimension() {
		return this.dimension;
	}

	public boolean isInGame() {
		return inGame;
	}

	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}
}
