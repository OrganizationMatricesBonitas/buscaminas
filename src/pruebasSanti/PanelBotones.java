package pruebasSanti;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modelo.Coordenada;
import modelo.MyButton;

import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;

public class PanelBotones extends JPanel {

	JPanel panelBotones;

	public PanelBotones(int numero) {

		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(numero, numero, 0, 0));

		generatorButtons(numero);

	}

	public void generatorButtons(int numero) {

		for (int i = 0; i < numero; i++) {

			for (int j = 0; j < numero; j++) {
				MyButton boton = new MyButton(new Coordenada(i, j));
				boton.setBounds(new Rectangle(40, 40));
				boton.setMaximumSize(new Dimension(40,40));
//				boton.setContentAreaFilled(false);
//				boton.setFocusable(false);
//				boton.setVerifyInputWhenFocusTarget(false);
//				boton.setMargin(new Insets(2, 2, 2, 2));
				boton.setBorder(new LineBorder(new Color(200, 196, 195)));
				// Velada para que no se focuse
//				boton.setBorderPainted(false);
				boton.setRolloverEnabled(false);
				
				//LOGICA
				boton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						MyButton btn = (MyButton) e.getSource();
						btn.setContentAreaFilled(false);
						btn.setBorderPainted(true);
						btn.setBorder(new LineBorder(new Color(165, 170, 170)));
						btn.setText(String.valueOf(btn.getCoordenada().getPosX())+String.valueOf(btn.getCoordenada().getPosY()));
						btn.setForeground(Color.BLUE);
					}
				});
				panelBotones.add(boton);
			}

		}

	}

	public JPanel getPanelBotones() {
		return panelBotones;
	}

}
