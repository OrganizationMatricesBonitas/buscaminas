package modelo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import crontoller.Controlador;
import view.UI;

public class Botonera extends JPanel {

	Controlador controlador; // Tendra datos
	JPanel containerBotones; // Tiene los botones
	int lado;
	int minas;
	boolean inGame;
	ImageIcon minaIcon;
//	UI frame;
	
	public Botonera(int lado) {
//		controlador = new Controlador(lado);
		// Creamos juego (Tablero) una vez hayamos pulsado el primer boton
		inGame = false;
		minaIcon=new ImageIcon("/res/mine_icon_48x48.ico");
		this.lado = lado;
		setBounds(100, 100, 450, 300);
		containerBotones = new JPanel();
		containerBotones.setBorder(new EmptyBorder(5, 5, 5, 5));
		containerBotones.setLayout(new GridLayout(lado, lado, 0, 0));

		generarBotones();
//		renderTablero();
	}

	public Botonera(int lado, int minas) {
		inGame = false;
		minaIcon=new ImageIcon("./res/mine_icon_96x96.ico");
//		this.frame = frame;
		this.lado = lado;
		this.minas = minas;
		setBounds(100, 100, 450, 300);
		containerBotones = new JPanel();
		containerBotones.setBorder(new EmptyBorder(5, 5, 5, 5));
		containerBotones.setLayout(new GridLayout(lado, lado, 0, 0));

		generarBotones();
	}

	private void generarBotones() {
		for (int i = 0; i < lado; i++) {
			for (int j = 0; j < lado; j++) {
				MyButton boton = new MyButton(new Coordenada(i, j));
				boton.setBounds(new Rectangle(40, 40));
				boton.setMaximumSize(new Dimension(40, 40));
				boton.setBorder(new LineBorder(new Color(200, 196, 195)));
				// Al pasar el raton no brillara el boton
				boton.setRolloverEnabled(false);
				boton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						MyButton btn = (MyButton) e.getSource();
						if (inGame) {
//						revelarBoton(btn);
							// RENDERIZAR TABLERO
							controlador.getTablero().desvelarContiguas(btn.getCoordenada());
							
						} else {
							inGame = true;
							// Aleatorio
//							controlador = new Controlador(lado,minas, btn.getCoordenada());
							// No Aleatorio
//							List<Coordenada> posiciones = new ArrayList<Coordenada>();
//							posiciones.add(new Coordenada(2, 2));
//							posiciones.add(new Coordenada(2, 4));
//							posiciones.add(new Coordenada(3, 3));
							controlador = new Controlador(lado, minas, btn.getCoordenada());
//							controlador = new Controlador(lado, posiciones);
							controlador.getTablero().desvelarContiguas(btn.getCoordenada());
						}
						renderTablero();
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
		Casilla casilla = controlador.getTablero().getCasilla(btn.getCoordenada());
		if (casilla.isMina()) {
			btn.setBackground(Color.RED);
			// getScaledInstance(btn.getWidth(), btn.getHeight(), Image.SCALE_SMOOTH) -> (anchoBoton, AltoBoton, Escalado Suave)
//			btn.setIcon(new ImageIcon(minaIcon.getImage().getScaledInstance(btn.getWidth(), btn.getHeight(), Image.SCALE_SMOOTH)));
			btn.setIcon(minaIcon);
		} else {
			btn.setContentAreaFilled(false);
			if (!minasAlrededor.equals("0")) {
				btn.setText(minasAlrededor);
				btn.setForeground(color);
			}
		}

	}

	/*
	 * Metodo auxiliar apra desvelar botones Anterior
	 */
	private void revelarBoton(MyButton btn) {
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(true);
		btn.setBorder(new LineBorder(new Color(165, 170, 170)));
		btn.setText(String.valueOf(btn.getCoordenada().getPosX()) + String.valueOf(btn.getCoordenada().getPosY()));
		btn.setForeground(Color.BLUE);
	}

	public int getDimension() {
		return this.lado;
	}

	public boolean isInGame() {
		return inGame;
	}

	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}
}
